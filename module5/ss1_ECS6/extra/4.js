


let arr = [0,2,3,4,5,6,7,8];
let check = false;

arr.forEach(number => {
        if(number > 0) {
            check = true;
        } 

    }
)

if(!check){
    console.log("all greater than 0")
} else {
    console.log("nope")
}