import ProductList from "./pages/Product/ProductList"
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import AddProduct from "./pages/Product/AddProduct";
import ManufacturingOrder from "./pages/MOPage/ManufacturingOrder";
import MOAddPage from "./pages/MOPage/MOAddPage";

function App() {

  return (
    <div className="App">
       <BrowserRouter>
        <Routes>
          <Route path="/" exact element={<Home />}></Route>
          <Route path="/product" element={<ProductList />}></Route>
          <Route path="/product/add" element={<AddProduct />}></Route>
          <Route path="/mo" element={<ManufacturingOrder />}></Route>
          <Route path="/mo/add" element={<MOAddPage />}></Route>

        </Routes>
      </BrowserRouter>
    </div>
  )
}

export default App
