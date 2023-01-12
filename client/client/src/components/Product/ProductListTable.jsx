import { Paper, Table } from "@mui/material";
import { Stack } from "@mui/system";
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import React, { useState } from "react";
import useDebounce from "../../hooks/useDebounce";
import { useFilterProduct } from "../../hooks/useMO";
import SearchBar from "../SearchBar";

import ProductDisplayTable from "./ProductDisplayTable";

function ProductListTable({ products }) {
  const API_ORIGIN = import.meta.env.VITE_REACT_APP_API_ORIGIN;
  const [searchValue, setSearchValue] = useState("");
  const debouncedSearchTerm = useDebounce(searchValue, 200);
  const { data, isLoading, error } = useQuery({
    queryKey: ["searchValue", debouncedSearchTerm],
    queryFn: () => {
      if (debouncedSearchTerm) {
        console.log(debouncedSearchTerm);
        return fetch(`localhost:3000/products/search?name=${searchValue}`).then(
          (res) => {
            console.log(res)
            res.json();
          }
        );
      }
    },
  });
  function handleSearch(e) {
    setSearchValue(e.target.value);
  }
  return (
    <>
      <Stack>
        <input
          type="text"
          placeholder="Search..."
          value={searchValue}
          onChange={handleSearch}
        />
        <Paper sx={{ width: "100%", marginTop: 3, overflowX: "auto" }}>
          <Table sx={{ minWidth: 650 }}>
            <ProductDisplayTable products={data}></ProductDisplayTable>
          </Table>
        </Paper>
      </Stack>
    </>
  );
}

export default ProductListTable;
