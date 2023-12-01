

let V = 7;
let arr = [1,2,3,4,5,6,7,8];
let check = false;

arr.forEach(number => {
        if(number == V) {
            check = true;
        }

    }
)

if(check){
    console.log("found")
} else {
    console.log("404")
}