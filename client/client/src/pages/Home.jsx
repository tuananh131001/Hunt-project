import { Button, Stack } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";

function Home() {
  return (
    <Stack>
      {" "}
      <Button variant="outlined">
        <Link to={"/product"}>To Product</Link>
      </Button>
      <Button variant="outlined">
        <Link to={"/mo"}>To MO</Link>
      </Button>
    </Stack>
  );
}

export default Home;
