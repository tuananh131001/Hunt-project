import { Paper, Table } from "@mui/material";
import React from "react";

import ProductDisplayTable from "./ProductDisplayTable";

function ProductListTable({ products }) {
  return (
    <Paper sx={{ width: "100%", marginTop: 3, overflowX: "auto" }}>
      <Table sx={{ minWidth: 650 }}>
        <ProductDisplayTable products={products}></ProductDisplayTable>
      </Table>
    </Paper>
  );
}

export default ProductListTable;
