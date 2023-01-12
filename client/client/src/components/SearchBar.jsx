import React , { useState } from 'react'

function SearchBar({searchValue,handleSearch}) {
  return (
    <div>
      <input
        type="text"
        placeholder="Search..."
        value={searchValue}
        onChange={handleSearch}
      />
    </div>
  )
}

export default SearchBar