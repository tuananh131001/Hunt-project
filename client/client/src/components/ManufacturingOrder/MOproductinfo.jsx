import { TableCell } from "@mui/material";
import React from "react";

function MOproductinfo({ productChild }) {
    console.log(productChild)
  return (
    <>
        <TableCell component="th" scope="row">
          {productChild.name}
        </TableCell>
    </>
  );
}

export default MOproductinfo;
