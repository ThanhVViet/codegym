import axios from "axios";

export const findAllCategory=async ()=>{
    try{
        const result=await axios.get("http://localhost:8080/category");
        return result.data
    }catch (e) {
        console.log(e);
    }
}