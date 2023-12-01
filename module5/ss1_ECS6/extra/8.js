


function sum(...c) {
    let newArr = c.reduce((previousValue, currentValue) => previousValue+currentValue);
    console.log(newArr);
}

let arr = [1,2,3,4,5,5,6,7,8,9];
sum(...arr);



