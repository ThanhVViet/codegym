import React from 'react';
import useIncrement from "../hooks/useIncrement";

function CounterOne() {
    const [c, setC] = useIncrement();

    return (
        <div>
            <div>
                <span>Count:</span>
                <React.Fragment>{String(c)}</React.Fragment>
            </div>
            <button onClick={e => {
                if (typeof setC === 'function') {
                    setC(1);
                }
            }}>Add 1</button>
        </div>
    );
}

export default CounterOne;
