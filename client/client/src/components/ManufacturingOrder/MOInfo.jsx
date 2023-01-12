import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import React from "react";
import MOproductinfo from "./MOproductinfo";

function MOInfo({ moData }) {
  console.log(moData);
  return (
    <>
      {moData.map(
        ({
          id,
          deliveryDate,
          startDate,
          expectedCompletion,
          clientName,
          products,
        }) => (
          <>
            <Typography variant="h5" gutterBottom>
              Date of MO: {id ? id : ""}
            </Typography>
            <Typography variant="h5" gutterBottom>
              Client Name: {clientName ? clientName : ""}
            </Typography>
            <Typography variant="h5" gutterBottom>
              Date of Delivery: {deliveryDate}
            </Typography>
            <TableContainer>
              <Table stickyHeader aria-label="sticky table">
                <TableHead>
                  <TableRow>
                    <TableCell>Product</TableCell>
                    <TableCell align="right">Quantity</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {products.map((productChild) => (
                    <TableRow key={productChild.name}>
                        <MOproductinfo productChild={productChild?.product}></MOproductinfo>
                      <TableCell align="right">
                        {productChild.quantity}
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
            <Typography variant="h5" gutterBottom>
              Date of Start: {startDate}
            </Typography>
            <Typography variant="h5" gutterBottom>
              Date of Expected Completion:{" "}
              {expectedCompletion}
            </Typography>
          </>
        )
      )}
    </>
  );
}

export default MOInfo;
