import axios from "axios";
const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
const getMO = () =>
  axios.get("/api/mo").then((res) => {
    return res.data;
  });
const postMO = (data) =>
  axios.post("/api/mo", data).then((res) => {
    console.log(res);
    return res.data;
  });
  export { getMO, postMO };