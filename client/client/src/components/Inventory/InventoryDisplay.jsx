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
function InventoryDisplay() {
  const [currentPage, setCurrentPage] = useState(0);
  const [itemsPerPage] = useState(10);
  const [productsPage, setProductsPage] = useState();
  console.log(productsPage);
  //  Get Data
  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get(
          "/api/inventory?page=" + currentPage
        );
        console.log(response);
        setProductsPage(response.data);
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
    <Paper sx={{ width: "100%", marginTop: 3, overflowX: "auto" }}>
      <Header></Header>
      <Table sx={{ minWidth: 650 }}>
        <TableHead>
          <TableRow>
            <TableCell>MPO ID</TableCell>
            <TableCell>Name</TableCell>
            <TableCell>First QTY</TableCell>
            <TableCell>Total In</TableCell>
            <TableCell>Total Out</TableCell>
            <TableCell>Avaliable</TableCell>


          </TableRow>
        </TableHead>
        <TableBody>
          {/* {products &&
            products.map((product) => (
              <TableRow key={product._id}>
                <TableCell component="th" scope="row">
                  {product.id}
                </TableCell>
                <TableCell>{product.name}</TableCell>
                <TableCell>{product.product.name}</TableCell>
                <TableCell>
                  <Link to={`/bom/${product.id}`}>View</Link>
                </TableCell>
                <TableCell>
                  <Link to={`/bom/delete/${product.id}`}>Delete</Link>
                </TableCell>
                <TableCell>
                  <Link to={`/bom/edit/${product.id}`}>Edit</Link>
                </TableCell>
              </TableRow>
            ))} */}
          {productsPage?.content.map((product) => (
            <TableRow key={product._id}>
              <TableCell>{product.id}</TableCell>
              <TableCell>{product.billOfMaterial.name}</TableCell>
              <TableCell>{product.beginningQuantity}</TableCell>

              <TableCell>{product.totalIn}</TableCell>
              <TableCell>{product.totalOut}</TableCell>
              <TableCell>{product.available}</TableCell>

              {/* {product.manufacturingOrder.products.map((product) => (
                <h3>{product.product.name}</h3>
              ))} */}
              <TableCell>
                  <Link to={`/mpo/delete/${product.id}`}>Delete</Link>
                </TableCell>
            </TableRow>
          ))}
        </TableBody>
        {/* <PaginationControls
          totalPages={productsPage?.totalPages}
          onPageChange={handlePageChange}
        /> */}
      </Table>
    </Paper>
  );
}

export default InventoryDisplay;
