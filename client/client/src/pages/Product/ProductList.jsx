import React from "react";

import { Link } from "react-router-dom";
import { Button } from "@mui/material";
import ProductDisplayTable from "../../components/Product/ProductDisplayTable";

function ProductList() {

  return (
    <>
      {" "}
      <Button variant="outlined">
        <Link to={"/product/add"}>Add</Link>
      </Button>
      <Button variant="outlined">
        <Link to={"/product/filter"}>Filter</Link>
      </Button>
      <Button variant="outlined">
        <Link to={"/product/search"}>Search</Link>
      </Button>


      <ProductDisplayTable></ProductDisplayTable>
    </>
  );
}

export default ProductList;
