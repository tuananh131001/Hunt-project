import axios from "axios";
const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
const getMO = () =>
  axios.get(API_ORIGIN + "/mo").then((res) => {
    return res.data;
  });
const postMO = (data) =>
  axios.post(API_ORIGIN+ "/mo", data).then((res) => {
    console.log(res);
    return res.data;
  });
  export { getMO, postMO };