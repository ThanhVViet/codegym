import logo from './logo.svg';
import './App.css';
import ListEmployee from "./components/employee/ListEmployee";
import CreateEmployee from "./components/employee/CreateEmployee";
import 'react-toastify/dist/ReactToastify.css';
import {ToastContainer} from "react-toastify";
import {BrowserRouter, Link, NavLink, Route, Routes} from "react-router-dom";

function App() {
  return (
      <>
        <BrowserRouter>
          <NavLink to="/students/list">Danh sách</NavLink>
          <NavLink to="/students/create">Thêm mới</NavLink>
          <Routes>
            <Route path="employees/list" element={<ListEmployee/>}></Route>
            <Route path="employees/create" element={<CreateEmployee/>}></Route>
            {/*<Route path="students/update" element={<StudentUpdate/>}></Route>*/}
            {/*<Route path="*" element={<NotFound/>}></Route>*/}
          </Routes>

          <ToastContainer/>
        </BrowserRouter>
      </>
  );
}

export default App;
