import axios from "axios";
import React from "react";
import { useNavigate, useParams } from "react-router-dom";

function MaterialPurchaseOrderDelete() {
  const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
  const navigate = useNavigate();
  const params = useParams();
  const handleDelete = async (id) => {
    try {
      await axios.delete(`/api/materials-purchase-orders/${params.id}`);
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
      <h1>Are you sure you want to delete this BOM?</h1>
      <button onClick={() => handleDelete(params.id)}>Delete</button>{" "}
      <button onClick={backButton}>Back</button>
    </>
  );
}

export default MaterialPurchaseOrderDelete;
