import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { getMO, postMO } from "../api/MoAPI";
import { filterProduct, getProduct, postProduct } from "../api/productAPI";
import { getProductCategory, postProductCategory } from "../api/productCategoryAPI";
// GET

const useFilterProduct = (onSuccess, onError) => {
  return useQuery(["product"], filterProduct, {
    onSuccess: onSuccess,
    onError: onError,
  });
  };
export {useFilterProduct };
