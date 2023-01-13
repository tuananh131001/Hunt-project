import React from "react";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { usePostProduct } from "../../hooks/useFetch";

const AddProductForm = ({ categories }) => {
  const navigate = useNavigate();
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const mutation = usePostProduct();
  const onSubmit = (data) => {
    // Make API call to save product to the database here
    console.log(data);
    mutation.mutate(data);
    navigate(-1)
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <label>
        Code:
        <input type="number" name="code" {...register("code", { required: true })} />
        {errors.code && <span>This field is required</span>}
      </label>
      <br />
      <label>
        Name:
        <input name="name" {...register("name", { required: true })} />
        {errors.name && <span>This field is required</span>}
      </label>
      <br />
      <label>
        Description:
        <textarea name="description" {...register("description")} />
      </label>
      <br />
      <label>
        Category:
        <select
          name="category"
          {...register("category.id", { required: true })}
        >
          <option value="">Select a category</option>
          {categories.content?.map((category) => (
            <option
              key={category.id}
              //         //{
              //   "id": "1"
              // }
              value={category.id}
            >
              {category.name}
            </option>
          ))}{" "}
        </select>
        {errors.category && <span>This field is required</span>}
      </label>
      <br />
      <input type="submit" value="Add Product" />
    </form>
  );
};

export default AddProductForm;
