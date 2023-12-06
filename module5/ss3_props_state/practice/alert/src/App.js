import logo from './logo.svg';
import './App.css';
import {Component} from "react";
import Alert from "./components/Alert";

// class App extends Component{
//   constructor(props) {
//     super(props);
//     this.state = {
//
//     }
//   }
// }

function App (){
  return(
      <div>
        <Alert text="Cảnh báo! Tài nguyên bạn vừa truy cập không tồn tại."  />
      </div>
  )
}
export default App;
