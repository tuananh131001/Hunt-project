import React from "react";
import { useForm } from "react-hook-form";
import { usePostProduct } from "../../hooks/useFetch";

const AddProductForm = ({ categories }) => {
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
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <label>
        Code:
        <input name="code" {...register("code", { required: true })} />
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
          {categories.map((category) => (
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
