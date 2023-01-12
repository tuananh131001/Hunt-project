import { TableBody, TableCell, TableHead, TableRow } from "@mui/material";
import React from "react";

function ProductDisplayTable({products}) {
    console.log(products)
  return (
    <>
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
        {products && products.map((product) => (
          <TableRow key={product._id}>
            <TableCell component="th" scope="row">
              {product._id}
            </TableCell>
            <TableCell>{product.code}</TableCell>
            <TableCell>{product.name}</TableCell>
            <TableCell>{product.description}</TableCell>
            <TableCell>{product.category.name}</TableCell>
          </TableRow>
        ))}
      </TableBody>
    </>
  );
}

export default ProductDisplayTable;
