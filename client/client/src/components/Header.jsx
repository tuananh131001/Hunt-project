import { Button } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";

function Header() {
  return (
    <Link to={"/"}>
      <Button variant="contained">Go Back Home</Button>
    </Link>
  );
}

export default Header;
