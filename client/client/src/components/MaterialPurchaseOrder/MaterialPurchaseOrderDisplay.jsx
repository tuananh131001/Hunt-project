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
function MaterialPurchaseOrderDisplay() {
  const [currentPage, setCurrentPage] = useState(0);
  const [itemsPerPage] = useState(10);
  const [productsPage, setProductsPage] = useState();
  console.log(productsPage);
  //  Get Data
  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get(
          API_ORIGIN + "/materials-purchase-orders?page=" + currentPage
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
            <TableCell>MPO ID</TableCell>
            <TableCell>Client Name</TableCell>
            <TableCell>Status</TableCell>
            <TableCell>Product</TableCell>
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
          {productsPage?.map((product) => (
            <TableRow key={product._id}>
              <TableCell>{product.id}</TableCell>
              <TableCell>{product.manufacturingOrder.clientName}</TableCell>
              <TableCell>{product.status}</TableCell>
              {product.manufacturingOrder.products.map((product) => (
                <h3>{product.product.name}</h3>
              ))}
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

export default MaterialPurchaseOrderDisplay;
