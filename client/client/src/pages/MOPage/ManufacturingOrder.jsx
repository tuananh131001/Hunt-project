import React from 'react'
import MOInfo from '../../components/ManufacturingOrder/MOInfo';
import { useGetMO } from '../../hooks/useFetch';

function ManufacturingOrder() {
  const { data: moData, status } = useGetMO();
  if (status == "loading") {
    return <p>Loading...</p>;
  }
  if (status == "error") {
    return <p>Error...</p>;
  }
  return (
    <MOInfo moData={moData}>ManufacturingOrder</MOInfo>
  )
}

export default ManufacturingOrder