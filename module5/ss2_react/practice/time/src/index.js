import ReactDOM from "react-dom/client";


const root = ReactDOM.createRoot(document.getElementById("root"));

root.render(
    <div>
        <h1>Hello, world!</h1>
        <h2>It is {new Date().toLocaleTimeString()}.</h2>
    </div>
);

const tick = () => {
    root.render(
        <div>
            <h1>Hello, world!</h1>
            <h2>It is {new Date().toLocaleTimeString()}.</h2>
            <h4>Browser's details: {navigator.userAgent}</h4>
        </div>
    );
};

setInterval(tick,1000);