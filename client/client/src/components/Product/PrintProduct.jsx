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
import Header from "../Header";
import PaginationControls from "../PaginationControls";
const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
function PrintProduct() {
  const [currentPage, setCurrentPage] = useState(0);
  const [itemsPerPage] = useState(10);
  const [products, setProducts] = useState();
  const [productsPage, setProductsPage] = useState();

  console.log(products);
  //  Get Data
  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get("/api/products?size=" + 100);
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
      await axios.delete(`/api/products/${id}`);
    } catch (error) {
      console.log(error);
    }
  };

  const handlePageChange = (e, value) => {
    console.log(value - 1);
    setCurrentPage(value - 1);
  };

  return (
    <>
      <Header></Header>
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
                
                </TableRow>
              ))}
          </TableBody>
        </Table>
      </Paper>
    </>
  );
}

export default PrintProduct;
