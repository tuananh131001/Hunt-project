import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { getMO } from "../api/MoAPI";
import { getProduct, postProduct } from "../api/productAPI";
import { getProductCategory, postProductCategory } from "../api/productCategoryAPI";

const useGetProduct = (onSuccess, onError) => {
  return useQuery(["product"], getProduct, {
    onSuccess: onSuccess,
    onError: onError,
  });
};
const useGetMO= (onSuccess, onError) => {
  return useQuery(["mo"], getMO, {
    onSuccess: onSuccess,
    onError: onError,
  });
};
const usePostProduct = (onSuccess, onError) => {
  const queryClient = useQueryClient();
  return useMutation((data) => postProduct(data), {
    onSuccess: (data) => {
      queryClient.invalidateQueries("product");
    },
    onError: onError,
  });
};

// Custom hook get hotel
const useGetProductCategory = (onSuccess, onError) => {
  return useQuery(["productCategory"], getProductCategory, {
    onSuccess: onSuccess,
    onError: onError,
  });
};

// post product
const usePostProductCategory = (onSuccess, onError) => {
  const queryClient = useQueryClient();
  return useMutation((data) => postProductCategory(data), {
    onSuccess: (data) => {
      queryClient.invalidateQueries("productCategory");
      onSuccess(data);
    },
    onError: onError,
  });
};

export {useGetMO, useGetProductCategory,usePostProductCategory,useGetProduct,usePostProduct };
