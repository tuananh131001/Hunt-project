import axios from "axios";
// https://www.npoint.io/docs/609e00c752b319664cad
const HOST = "http://localhost:3000";
const getProduct = () =>
  axios.get("/api/products").then((res) => {
    return res.data;
  });
const postProduct = (data) =>
  axios.post( "/api/products", data).then((res) => {
    console.log(res);
    return res.data;
  });
const filterProduct = (filter) =>
  axios.get( `/api/products/search?name=${filter}`).then((res) => {
    return res.data;
  });
export { getProduct, postProduct, filterProduct };
