import { Button, Stack } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";

function Home() {
  return (
    <Stack spacing={2} sx={{"width":"10rem"}}>
      {" "}
      <Button variant="outlined">
        <Link to={"/product"}>To Product</Link>
      </Button>
      <Button variant="outlined">
        <Link to={"/mo"}>To MO</Link>
      </Button>
      <Button variant="outlined">
        <Link to={"/bom"}>To Bill Of Materials</Link>
      </Button>
    </Stack>
  );
}

export default Home;
