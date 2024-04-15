import logo from './logo.svg';
import './App.css';
import {Route, Routes} from "react-router-dom"
import {ProductList} from "./components/ProductList";
import {CreateProduct} from "./components/CreateProduct";
import {EditProduct} from "./components/EditProduct";
import 'react-toastify/dist/ReactToastify.css'
import {ToastContainer} from "react-toastify";
import {DetailProduct} from "./components/DetailProduct";
function App() {
  return (
<div>
  <Routes>
    <Route path={'/'} element={<ProductList></ProductList>}></Route>
    <Route path={'/create'} element={<CreateProduct></CreateProduct>}></Route>
    <Route path={'/edit/:id'} element={<EditProduct></EditProduct>}></Route>
    <Route path={'/detail/:id'} element={<DetailProduct></DetailProduct>}></Route>
  </Routes>
  <ToastContainer/>
</div>
  );
}

export default App;
