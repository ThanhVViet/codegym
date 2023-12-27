import './App.css';
import StudentCreate from "./components/students/StudentCreate";
import 'react-toastify/dist/ReactToastify.css';
import {ToastContainer} from "react-toastify";
import {BrowserRouter, Link, NavLink, Route, Routes} from "react-router-dom";
import StudentList from "./components/students/StudentList";
import StudentUpdate from "./components/students/StudentUpdate";
import {NotFound} from "./components/NotFound";

function App() {
  return (
      <>
        <BrowserRouter>
          <NavLink to="/students/list">Danh sách</NavLink>
          <NavLink to="/students/create">Thêm mới</NavLink>
          <Routes>
            <Route path="students/list" element={<StudentList/>}></Route>
            <Route path="students/create" element={<StudentCreate/>}></Route>
            <Route path="students/update" element={<StudentUpdate/>}></Route>
            {/*<Route path="*" element={<NotFound/>}></Route>*/}
          </Routes>

          <ToastContainer/>
        </BrowserRouter>
      </>
  );
}

export default App;
