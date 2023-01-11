import axios from "axios";
// https://www.npoint.io/docs/609e00c752b319664cad
const HOST = "http://localhost:3000";
const getProduct = () =>
  axios.get(HOST + "/products").then((res) => {
    return res.data;
  });
const postProduct = (data) =>
  axios.post(HOST+ "/products", data).then((res) => {
    console.log(res);
    return res.data;
  });
  export { getProduct, postProduct };