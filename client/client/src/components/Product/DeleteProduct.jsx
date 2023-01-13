import axios from "axios";
import React from "react";
import { useNavigate, useParams } from "react-router-dom";

function DeleteProduct() {
  const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
  const navigate = useNavigate();
  const params = useParams();
  const handleDelete = async (id) => {
    try {
      await axios.delete(`/api/products/${params.id}`);
      // refresh the product list after delete
      navigate(-1);
    } catch (error) {
      console.log(error);
    }
  };
  const backButton = () => {
    navigate(-1);
  };
  return (
    <>
      <h1>Are you sure you want to delete this product?</h1>
      <button onClick={() => handleDelete(params.id)}>Delete</button>{" "}
      <button onClick={backButton}>Back</button>
    </>
  );
}

export default DeleteProduct;
