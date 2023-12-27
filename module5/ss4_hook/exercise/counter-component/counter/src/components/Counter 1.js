import {useState} from "react";
import useIncrement from "../hooks/useIncrement";


function Counter1(){
    const [count, setCount] = useIncrement(1);

    const inscrease = () => {
        setCount(1);
    };

    return(
        <div>
            <h2>Counter: {count}</h2>
            <button onClick={inscrease}>Add 1</button>
        </div>
    )

}

export default Counter1;