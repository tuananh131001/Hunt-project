import React, { useState } from "react";
import axios from "axios";
const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;

const ProductSearch = () => {
  const [searchTerm, setSearchTerm] = useState("");
  const [searchResults, setSearchResults] = useState();
  const handleSubmit = (e) => {
    e.preventDefault();
    // Call the search function and pass in the search term
    searchProducts(searchTerm);
  };
  const searchProducts = async (searchTerm) => {
    try {
      console.log(searchTerm);
      const response = await axios
        .get(API_ORIGIN + `/products/search?name=${searchTerm}`)
        .then((response) => {
          setSearchResults(response.data.content);
          console.log(searchResults);
        });
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={searchTerm}
        onChange={(e) => setSearchTerm(e.target.value)}
        placeholder="Search for products..."
      />
      <button type="submit">Search</button>
      {searchResults &&
        searchResults?.map((product, index) => (
          <div key={index}>
            <h3>{product.name}</h3>
            <p>{product.description}</p>
          </div>
        ))}
    </form>
  );
};

export default ProductSearch;
