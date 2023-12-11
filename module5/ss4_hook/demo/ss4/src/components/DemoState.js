import {useState} from "react";

export function DemoState() {
    const [numberValue, setNumberValue] = useState(0);
    const [nameSearch, setNameSearch] = useState("");

    const changeValue = (value) => {
        setNumberValue(prevState => prevState +1)
        setNumberValue(prevState => prevState +1)
        setNumberValue(prevState => prevState +1)
    }
    return (
        <>
            <h1>{nameSearch}</h1>
            <input onChange={(evt) => changeValue(evt.target.value)}/>
            <h1>{numberValue}</h1>
        </>
    )
}