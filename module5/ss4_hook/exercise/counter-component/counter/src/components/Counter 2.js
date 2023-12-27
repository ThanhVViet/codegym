import useIncrement from "../hooks/useIncrement";


function Counter2(){
    const [count, setCount] = useIncrement(1);

    const inscrease = () => {
        setCount(2);
    };

    return(
        <div>
            <h2>Counter: {count}</h2>
            <button onClick={inscrease}>Add 2</button>
        </div>
    )

}

export default Counter2;