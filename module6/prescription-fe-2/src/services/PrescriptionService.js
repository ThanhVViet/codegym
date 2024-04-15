import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/prescriptions";


export const findAll = async () => {
    try {
        const result = await axios.get(REST_API_BASE_URL)
        return result.data
    } catch (e) {
        console.log(e)
    }
}

export const findById = async (id) => {
    try {
        const result = await axios.get("http://localhost:8080/prescriptions/" + id)
        return result.data
    } catch (e) {
        console.log(e)
    }
}


