import axios from "axios";
import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useGetProductCategory } from "../../hooks/useFetch";
const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
const UpdateProduct = (props) => {
  const [product, setProduct] = useState();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    code: "",
    name: "",
    description: "",
    category: "",
  });
  const params = useParams();
  const { data: productsCategory, status } = useGetProductCategory();
  const getProduct = async () => {
    try {
      const response = await axios.get(`/api/products/${params.id}`);
      setProduct(response.data);
      setFormData({
        code: response.data.code,
        name: response.data.name,
        description: response.data.description,
        category: {
          id: response.data.category.id,
        },
      });
    } catch (error) {
      console.log(error);
    }
  };
  useEffect(() => {
    // Call the API to get the product information
    getProduct();
  }, []);
  if (status == "loading") {
    return <p>Loading...</p>;
  }
  if (status == "error") {
    return <p>Error...</p>;
  }
  const handleChange = (event) => {
    if (event.target.name === "category") {
      setFormData({
        ...formData,
        [event.target.name]: {
          id: event.target.value,
        },
      });
      return;
    } else {
      setFormData({
        ...formData,
        [event.target.name]: event.target.value,
      });
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      console.log(formData);
      await axios.put( `/api/products/${params.id}`, formData);
      navigate(-1);
      // props.history.push("/products");
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <h1>Update Product</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Code:</label>
          <input
            type="number"
            name="code"
            value={formData.code}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Name:</label>
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Description:</label>
          <textarea
            name="description"
            value={formData.description}
            onChange={handleChange}
          />
        </div>
        <div>
          <label>Category:</label>
          <select
            name="category"
            value={formData.category.id}
            onChange={handleChange}
          >
            {productsCategory.content?.map((category) => (
              <option type="number" key={category.id} value={category.id}>
                {category.name}
              </option>
            ))}{" "}
            {/* add more options here based on your product categories */}
          </select>
        </div>
        <button type="submit">Update Product</button>
      </form>
    </div>
  );
};
export default UpdateProduct;
