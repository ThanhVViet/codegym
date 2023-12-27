import axios from "axios";

const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/employees';

// export const findAll = async (nameSearch) => {
//     try {
//         let temp = await axios.get("http://localhost:8080/api/employees?=" + nameSearch)
//         return temp.data;
//     } catch (e) {
//         console.log(e)
//     }
//
// };

export const findAll = () => {
    return axios.get(EMPLOYEE_BASE_REST_API_URL)
};

export const createEmployee = (employee) => {
    return axios.post(EMPLOYEE_BASE_REST_API_URL, employee)
};