import React from "react";
import AddProductForm from "../../components/Product/AddProductForm";
import { useGetProduct } from "../../hooks/useFetch";
import { Link } from "react-router-dom";
import { Button } from "@mui/material";
import ProductListTable from "../../components/Product/ProductListTable";

function ProductList() {
  const { data: products, status } = useGetProduct();
  if (status == "loading") {
    return <p>Loading...</p>;
  }
  if (status == "error") {
    return <p>Error...</p>;
  }
  return (
    <>
      {" "}
      <Button variant="outlined">
        <Link to={"/product/add"}>Add</Link>
      </Button>
      <ProductListTable products={products}></ProductListTable>
    </>
  );
}

export default ProductList;
