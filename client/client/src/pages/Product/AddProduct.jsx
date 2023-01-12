import { Button } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";
import AddProductForm from "../../components/Product/AddProductForm";
import { useGetProductCategory } from "../../hooks/useFetch";

function AddProduct() {
    const { data: productsCategory, status } = useGetProductCategory();
    if (status == "loading") {
      return <p>Loading...</p>;
    }
    if (status == "error") {
      return <p>Error...</p>;
    }
    console.log(productsCategory)
  return (
    <>
      <Button variant="outlined">
        <Link to={"/product"}>Discard</Link>
      </Button>
      <AddProductForm categories={productsCategory}/>
    </>
  );
}

export default AddProduct;
