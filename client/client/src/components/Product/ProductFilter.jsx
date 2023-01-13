import axios from "axios";
import React, { useState, useEffect } from "react";
import { useGetProductCategory } from "../../hooks/useFetch";
import Header from "../Header";

const ProductFilter = () => {
  const [selectedCategory, setSelectedCategory] = useState("");
  const [products, setProducts] = useState([]);
  const { data: productsCategory, status } = useGetProductCategory();
  console.log(products)
  const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
  useEffect(() => {
    // Call the API to get the products
    getProducts();
  }, [selectedCategory]);

  const getProducts = async () => {
    try {
      const response = await axios.get(
         `/api/products/category?category=${selectedCategory}`
      );
      console.log(response);
      setProducts(response.data.content);
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <Header></Header>
      <div>
        <select
          value={selectedCategory}
          onChange={(event) => setSelectedCategory(event.target.value)}
        >
          <option value="">Select Category</option>
          {productsCategory?.content?.map((category) => (
            <option
              key={category.id}
              value={category.name}
            >
              {category.name}
            </option>
          ))}{" "}
        </select>
      </div>
      {products.map((product, index) => (
        <div key={index}>
          <h3>{product.name}</h3>
          {product.products.map( (product) => {
            return <p>{product.name}</p>
          } )}
          <p>{product.description}</p>
        </div>
      ))}
    </div>
  );
};

export default ProductFilter;
