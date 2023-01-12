import axios from "axios";
// https://www.npoint.io/docs/609e00c752b319664cad
const HOST = "http://localhost:3000";
const getProductCategory = () =>
  axios.get(HOST + "/products/category").then((res) => {
    return res.data;
  });
const postProductCategory = (data) =>
  axios.post(HOST+ "/products/category", data).then((res) => {
    console.log(res);
    return res.data;
  });
  export { getProductCategory, postProductCategory };