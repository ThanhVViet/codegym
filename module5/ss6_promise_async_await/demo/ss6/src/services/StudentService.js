import axios from "axios";

export const getAllStudent = async (nameSearch) => {
    try {
        let temp = await axios.get("http://localhost:8080/students?name_like=" + nameSearch)
        return temp.data;
    } catch (e) {
        console.log(e)
    }

}