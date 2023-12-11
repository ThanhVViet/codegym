import './App.css';
import {Component} from "react";
import PropTypes from "prop-types";

class App extends Component {
    render() {
        return (
            <div>
                <ul>
                    <li>
                        {this.props.name}
                    </li>
                    <li>
                        {this.props.type}
                    </li>
                    <li>
                        {this.props.public_year}
                    </li>
                    <li>
                        {this.props.storage}
                    </li>
                </ul>
            </div>
        );
    }
}
App.propTypes = {
    name: PropTypes.string,
    type: PropTypes.oneOf(["iPhone", "iPad", "Mac", "SmartWatch"]),
    public_year: PropTypes.oneOfType([
        PropTypes.string,
        PropTypes.number,
    ])
}
App.defaultProps = {
    name: "IPhone 15 pm",
    type: "IPhone",
    public_year: 2023
}

export default App;
