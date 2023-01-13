import ProductList from "./pages/Product/ProductList";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import AddProduct from "./pages/Product/AddProduct";
import ManufacturingOrder from "./pages/MOPage/ManufacturingOrder";
import MOAddPage from "./pages/MOPage/MOAddPage";
import ProductSearch from "./components/Product/ProductSearch";
import ProductFilter from "./components/Product/ProductFilter";
import UpdateProduct from "./components/Product/UpdateProduct";
import DeleteProduct from "./components/Product/DeleteProduct";
import BOMDisplayAll from "./components/BillOfMaterial/BOMDisplayAll";
import BOMDetail from "./components/BillOfMaterial/BOMDetail";
import DeleteBOM from "./components/BillOfMaterial/DeleteBOM";
import UpdateBOM from "./components/BillOfMaterial/UpdateBOM";
import AddBOM from "./components/BillOfMaterial/AddBOM";
import PrintProduct from "./components/Product/PrintProduct";
import Header from "./components/Header";
import MaterialPurchaseOrderDisplay from "./components/MaterialPurchaseOrder/MaterialPurchaseOrderDisplay";
import MaterialPurchaseOrderDelete from "./components/MaterialPurchaseOrder/MaterialPurchaseOrderDelete";

function App() {
  return (
    <div className="App">
      
      <BrowserRouter>
        <Routes>
        
          <Route path="/" exact element={<Home />}></Route>
          <Route path="/product" element={<ProductList />}></Route>
          <Route path="/product/search" element={<ProductSearch />}></Route>
          <Route path="/product/add" element={<AddProduct />}></Route>
          <Route path="/product/filter" element={<ProductFilter />}></Route>
          <Route path="/product/print" element={<PrintProduct />}></Route>

          {/* <Route path="/product/update" element={<UpdateProduct />}></Route> */}
          <Route path="/product/update/:id" element={<UpdateProduct />} />
          <Route path="/product/delete/:id" element={<DeleteProduct />} />

          <Route path="/mo" element={<ManufacturingOrder />}></Route>
          <Route path="/mo/add" element={<MOAddPage />}></Route>
          {/* BOM */}
          <Route path="/bom" element={<BOMDisplayAll />}></Route>
          <Route path="/bom/add" element={<AddBOM />}></Route>
          <Route path="/bom/:id" element={<BOMDetail />}></Route>
          <Route path="/bom/delete/:id" element={<DeleteBOM />}></Route>
          <Route path="/bom/edit/:id" element={<UpdateBOM />}></Route>
          {/* MaterialPurchaseOrderDisplay */}
          <Route path="/mpo" element={<MaterialPurchaseOrderDisplay/>}></Route>
          <Route path="/mpo/delete/:id" element={<MaterialPurchaseOrderDelete/>}></Route>

        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
