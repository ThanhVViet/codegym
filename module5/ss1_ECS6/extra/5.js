
let arr = [0,2,3,4,5,6,7,8];
let stop;


arr.forEach(number => {
    if(number > 3 && stop === undefined){
        console.log(number)
        stop = number;
    }
})
