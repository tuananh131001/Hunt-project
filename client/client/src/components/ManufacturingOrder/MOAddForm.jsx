import { Button, InputLabel, Stack, TextField } from "@mui/material";
import React, { useState } from "react";
import { Controller, useForm } from "react-hook-form";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { usePostMO } from "../../hooks/useFetch";

function MOAddForm() {
  const {
    register,
    control,
    handleSubmit,
    formState: { errors },
  } = useForm();
  const [selectedDate, setSelectedDate] = useState(new Date());
  const mutation = usePostMO();
  const handleDateChange = (date) => {
    setSelectedDate(date);
  };
  const onSubmit = (data) => {
    // Your form submission logic here
    console.log(data);
    mutation.mutate(data);

  };

  return (
    <form onSubmit={handleSubmit(onSubmit)} noValidate autoComplete="off">
      <InputLabel>Date Of MO</InputLabel>
      <Controller
        control={control}
        name="date"
        render={({ field }) => (
          <DatePicker
            placeholderText="Select date"
            onChange={(date) => field.onChange(date)}
            selected={field.value}
          />
        )}
      />
      <Stack spacing={2}>
        <TextField
          sx={{ "z-index": "0" }}
          name="clientName"
          label="Client Name"
          {...register("clientName", { required: true })}
          error={Boolean(errors.clientName)}
          helperText={errors.clientName ? "Client name is required" : ""}
        />

        <TextField
          sx={{ "z-index": "0" }}
          name="productName"
          label="Product Name"
          {...register("productName", { required: true })}
          error={Boolean(errors.productName)}
          helperText={errors.productName ? "Product name is required" : ""}
        />
        <TextField
          sx={{ "z-index": "0" }}
          name="quantity"
          label="Quantity"
          type="number"
          {...register("quantity", { required: true })}
          error={Boolean(errors.quantity)}
          helperText={errors.quantity ? "Quantity is required" : ""}
        />
        <InputLabel>Date of delivery</InputLabel>
        <Controller
          control={control}
          name="deliveryDate"
          render={({ field }) => (
            <DatePicker
              placeholderText="Select date"
              onChange={(date) => field.onChange(date)}
              selected={field.value}
            />
          )}
        />
        <InputLabel>Start Date</InputLabel>
        <Controller
          control={control}
          name="startDate"
          render={({ field }) => (
            <DatePicker
              placeholderText="Select date"
              onChange={(date) => field.onChange(date)}
              selected={field.value}
            />
          )}
        />
        <InputLabel>Date of expected completion</InputLabel>
        <Controller
          control={control}
          name="expectedCompletion"
          render={({ field }) => (
            <DatePicker
              placeholderText="Select date"
              onChange={(date) => field.onChange(date)}
              selected={field.value}
            />
          )}
        />
        <Button type="submit" variant="contained" color="primary">
          Submit
        </Button>
      </Stack>
    </form>
  );
}

export default MOAddForm;
