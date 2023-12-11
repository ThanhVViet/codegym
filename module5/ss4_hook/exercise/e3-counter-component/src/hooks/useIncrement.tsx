import { useState } from 'react';

function useIncrement() {
    const [count, setCount] = useState(0);

    const increment = (amount:number) => {
        setCount(count + amount);
    };

    return [count, increment];
}

export default useIncrement;
