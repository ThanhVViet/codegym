
import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import ListPrescriptionComponent from "./components/ListPrescriptionComponent";

function App() {
  return (
      <>
        <BrowserRouter>

          <Routes>
            <Route path="/" element={<ListPrescriptionComponent />}></Route>
            <Route path="/prescriptions" element={<ListPrescriptionComponent />}></Route>
          </Routes>

        </BrowserRouter>
      </>
  );
}

export default App;
