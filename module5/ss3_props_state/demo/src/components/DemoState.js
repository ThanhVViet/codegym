import {Component} from "react";

class DemoState extends Component {
    constructor() {
        super();
        this.state = {
            numberValue: 0,
            nameSeach: "A02"
        }
    }

    changeValue(value) {
        // this.setState((prve) => {
        //     return {
        //         numberValue: prve.numberValue + 1
        //     }
        // })
        // this.setState((prve) => {
        //     return {
        //         numberValue: prve.numberValue + 1
        //     }
        // })
        // this.setState((prve) => {
        //     return {
        //         numberValue: prve.numberValue + 1
        //     }
        // })
        this.setState({
            numberValue: value
        })
    }

    render() {
        return (
            <>
                <h1>{this.state.nameSeach}</h1>
                <input onChange={(evt) => this.changeValue(evt.target.value)}/>
                <h1>{this.state.numberValue}</h1>
            </>
        )
    }
}

export default DemoState;