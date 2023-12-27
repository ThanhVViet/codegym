import axios from "axios";

export const findAll = async (nameSearch) => {
    try {
        let temp = await axios.get("http://localhost:8080/students?name_like=" + nameSearch)
        return temp.data;
    } catch (e) {
        console.log(e)
    }

}

export const saveStudent = async (value) => {
    try {
        await axios.post("http://localhost:8080/students", value)
    }catch (e) {
        console.log(e)
    }
}