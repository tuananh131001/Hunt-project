import { Box, Pagination } from "@mui/material";
import ReactPaginate from "react-paginate";

function PaginationControls({ totalPages, onPageChange }) {
  const pageCount = totalPages;

  return (
      <Pagination count={pageCount} onChange={onPageChange}  />

  );
}
export default PaginationControls;
