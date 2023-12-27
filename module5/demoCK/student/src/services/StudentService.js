import axios from "axios";

export const findAll = async () => {
    try {
        // let temp = await axios.get("http://localhost:3000/students?name_like=" + nameSearch)
        let temp = await axios.get("http://localhost:3000/students/list")
        return temp.data;
    } catch (e) {
        console.log(e)
    }

}
