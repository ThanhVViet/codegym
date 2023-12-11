import React from 'react';
import useIncrement from "../hooks/useIncrement";

function CounterTwo(props:any) {
    const [c, setC] = useIncrement();

    return (
        <div>
            <div>
                <span>Count:</span>
                <React.Fragment>{String(c)}</React.Fragment>
            </div>
            <button onClick={e => {
                if (typeof setC === 'function') {
                    setC(2);
                }
            }}>Add 2</button>
        </div>
    );
}

export default CounterTwo;
