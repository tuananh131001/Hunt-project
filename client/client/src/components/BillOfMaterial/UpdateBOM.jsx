import axios from "axios";
import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { useGetProductCategory } from "../../hooks/useFetch";
const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
const UpdateBOM = (props) => {
  const [product, setProduct] = useState();
  const [bom, setBOM] = useState();

  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    name: "",
    product: "",
  });
  const params = useParams();
  const getProduct = async () => {
    try {
      const responseProduct = await axios.get(API_ORIGIN + `/products?size=100`);
      setProduct(responseProduct.data);
      console.log(product)
      const response = await axios.get(API_ORIGIN + `/bom/${params.id}`);
      setBOM(response.data);
      setFormData({
        name: response.data.name,
        product: {
          id: response.data.product.id
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
  const handleChange = (event) => {
    setFormData({
      ...formData,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      console.log(formData)
      await axios.put(
        API_ORIGIN + `/bom/${params.id}`,
        formData
      );
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
          <label>Name:</label>
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
          />
        </div>
        
        <div>
          <label>Product:</label>
          <select
            name="product"
            value={formData.product.id}
            onChange={handleChange}
          >
            {product?.content?.map((category) => (
              <option
                key={category.id}
                value={category.id}
              >
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
export default UpdateBOM;
