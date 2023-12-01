
function welcome(...name){
    let newString = "Welcome " + name.join(", ")
    console.log(newString);
}

let nameArr = ["viet","den","bevis"];

welcome(...nameArr);

