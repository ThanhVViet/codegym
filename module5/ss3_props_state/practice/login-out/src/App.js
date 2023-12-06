import logo from './logo.svg';
import './App.css';
import {Component} from "react";
import Home from "./components/Home";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLogIn: false
        };
    }

    handleLogIn = () => {
        this.setState({isLogIn: true})
    }

    handleLogOut = () => {
        this.setState({isLogIn: true})
    }

    render() {
        const {isLogIn} = this.state;
        if(isLogIn) return (<Home onLogout={this.handleLogOut} />)
        return (
            <div style={{textAlign: 'center'}}>
                <div>
                    <h1>Please Log in</h1>
                    <button onClick={this.handleLogIn}>Log in</button>
                </div>
            </div>
        )

    }

}

export default App;
