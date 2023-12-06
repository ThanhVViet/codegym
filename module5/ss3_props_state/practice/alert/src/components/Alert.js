import {Component} from "react";
import PropTypes from "prop-types";

class Alert extends Component{
    render() {
        return(
            <div className="alert alert-warning" role="alert">
                {this.props.text}
            </div>
        )

    }
}

export default Alert;



// const Alert = ({ text }) => {
//     return (
//         <div className="alert alert-primary" role="alert">
//             {text}
//         </div>
//     );
// };
//
//
// Alert.propTypes = {
//     text: PropTypes.string.isRequired,
// };