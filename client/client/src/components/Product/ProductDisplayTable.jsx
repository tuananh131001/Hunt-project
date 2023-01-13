import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
} from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import PaginationControls from "../PaginationControls";
const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
function ProductDisplayTable() {
  const [currentPage, setCurrentPage] = useState(0);
  const [itemsPerPage] = useState(10);
  const [products, setProducts] = useState();
  const [productsPage, setProductsPage] = useState();

  console.log(products);
  //  Get Data
  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get("/api/products?page=" + currentPage);
        console.log(response);
        setProductsPage(response.data);
        setProducts(response.data.content);
      } catch (error) {
        console.log(error);
      }
    }
    fetchData();
  }, [currentPage]);

  const handleDelete = async (id) => {
    try {
      await axios.delete(API_ORIGIN + `/products/${id}`);
    } catch (error) {
      console.log(error);
    }
  };

  const handlePageChange = (e, value) => {
    console.log(value - 1);
    setCurrentPage(value - 1);
  };

  return (
    <Paper sx={{ width: "100%", marginTop: 3, overflowX: "auto" }}>
      <Table sx={{ minWidth: 650 }}>
        <TableHead>
          <TableRow>
            <TableCell>ID</TableCell>
            <TableCell>Code</TableCell>
            <TableCell>Name</TableCell>
            <TableCell>Description</TableCell>
            <TableCell>Category</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {products &&
            products.map((product) => (
              <TableRow key={product._id}>
                <TableCell component="th" scope="row">
                  {product._id}
                </TableCell>
                <TableCell>{product.code}</TableCell>
                <TableCell>{product.name}</TableCell>
                <TableCell>{product.description}</TableCell>
                <TableCell>{product.category?.name}</TableCell>
                <TableCell>
                  <Link to={`/product/update/${product.id}`}>Edit</Link>
                </TableCell>
                <TableCell>
                  <Link to={`/product/delete/${product.id}`}>Delete</Link>
                </TableCell>
              </TableRow>
            ))}
        </TableBody>
        <PaginationControls
          totalPages={productsPage?.totalPages}
          onPageChange={handlePageChange}
        />
      </Table>
    </Paper>
  );
}

export default ProductDisplayTable;
