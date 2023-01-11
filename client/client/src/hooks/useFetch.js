import { useMutation, useQuery, useQueryClient } from "@tanstack/react-query";
import { getProduct, postProduct } from "../api/productAPI";

// Custom hook get hotel
const useGetProduct = (onSuccess, onError) => {
  return useQuery(["product"], getProduct, {
    onSuccess: onSuccess,
    onError: onError,
  });
};
// post product
const usePostProduct = (onSuccess, onError) => {
  const queryClient = useQueryClient();
  return useMutation((data) => postProduct(data), {
    onSuccess: (data) => {
      queryClient.invalidateQueries("product");
      onSuccess(data);
    },
    onError: onError,
  });
};

export { useGetProduct,usePostProduct };
