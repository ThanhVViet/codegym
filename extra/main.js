const intro = document.getElementById('intro');
const data = document.getElementById('data');
const string = document.getElementById('string');
const binary = document.getElementById('binary');
const text = document.getElementById('text');
const search = document.getElementById('search');
const nav = document.querySelector("body > main > nav");

function hideAll() {
    intro.style.display = "none";
    data.style.display = "none";
    string.style.display = "none";
    binary.style.display = "none";
    text.style.display = "none";
    search.style.display = "none";
    // intro.classList.add("hide");
    // data.classList.add("hide");
    // string.classList.add("hide");
}

nav.addEventListener("click", e => {
    hideAll();

    const ele = e.target;
    switch (ele.textContent){
        case "Introduction":
            return  intro.style.display = "block";
        case "Data structure":
            return  data.style.display = "block";
        case "String & regex":
            return string.style.display = "block";
        case "File Binary":
            return binary.style.display = "block";
        case "File Text":
            return text.style.display = "block";
        case "Search and sort":
            return search.style.display = "block";
    }
});

// function fIntro(){
//     hideAll();
//     intro.style.display= "block";
//
// }
//
// function fData(){
//     hideAll();
//     data.style.display= "block";
//
// }
//
// function fString(){
//     hideAll();
//     string.style.display= "block";
//
// }