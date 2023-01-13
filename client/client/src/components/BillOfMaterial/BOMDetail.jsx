import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Typography,
} from "@mui/material";
import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
const BOMDetail = () => {
  const [component, setComponent] = useState({ name: "" });

  const [bomData, setBomData] = useState();
  const params = useParams();
  const getProduct = async () => {
    try {
      const response = await axios.get(`/api/bom/${params.id}`);
      console.log(response);
      setBomData(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setComponent({ ...component, [name]: value });
    console.log(component);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // check if the name field is not empty
    if(component.name === "") {
        alert("Please enter a name");
        return;
      }
      // check if the name field is at least 3 characters long
      if (component.name.length < 3) {
        alert("Name must be at least 3 characters long");
        return;
      }
      // check if the name field is at most 20 characters long
      if (component.name.length > 20) {
        alert("Name must be at most 20 characters long");
        return;
      }
    await axios
      .put(
          `/api/products/component/add?parentId=${bomData?.product.id}&childName=${component.name}`
      )
      .then((response) => {
        console.log(response);
        getProduct();
      });
    setComponent({ name: "", id: "" });
  };
  useEffect(() => {
    // Call the API to get the product information
    getProduct();
  }, []);

  return (
    <>
      {" "}
      <h1 variant="h3">Bom Detail</h1>
      <h2>{bomData?.name}</h2>
      {/* // table MUI  */}
      <h3>Product Name: {bomData?.product.name}</h3>
      <Typography variant="h6">Components List: </Typography>
      <Paper sx={{ width: "100%", marginTop: 3, overflowX: "auto" }}>
        <Table sx={{ minWidth: 650 }}>
          <TableHead>
            <TableRow>
              <TableCell>ID</TableCell>
              <TableCell>Name</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            
            {bomData?.product.components.map((component) => (
              <TableRow key={component.id}>
                <TableCell>{component.id}</TableCell>
                <TableCell>{component.name}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </Paper>
      <Typography variant="h6">Add a component: </Typography>
      <form onSubmit={handleSubmit} required>
        <label>
          Name:
          <input
            type="text"

            name="name"
            value={component.name}
            onChange={handleChange}
          />
        </label>
        <br />
        <button type="submit">Add</button>
      </form>
    </>
  );
};

export default BOMDetail;
