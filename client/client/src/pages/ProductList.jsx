import React from "react";
import AddProductForm from "../components/AddProductForm";
import ProductListTable from "../components/ProductListTable";
import { useGetProduct } from "../hooks/useFetch";

function ProductList() {
  const { data: products, status } = useGetProduct();
  console.log(products)
  if (status == "loading") {
    return <p>Loading...</p>;
  }
  if (status == "error") {
    return <p>Error...</p>;
  }
  return (
    <>
      {" "}
      <AddProductForm></AddProductForm>
      <ProductListTable products={products}></ProductListTable>
    </>
  );
}

export default ProductList;
