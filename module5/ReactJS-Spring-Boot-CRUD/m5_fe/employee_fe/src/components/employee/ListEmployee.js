import axios from "axios";
import {useEffect, useState} from "react";
import * as employeeService from "../../services/EmployeeService"

function ListEmployee() {
    const [employees, setEmployees] = useState([]);
    const [nameSearch, setNameSearch] = useState("");

    useEffect( () => {
        findAllEmployee();
    }, [nameSearch]);

    const findAllEmployee = async (nameSearch) => {
        try {
            let temp = await employeeService.findAll();
            setEmployees(temp);
        } catch (e) {
            console.log(e);
        }
    }

    return (
        <>

            <input onChange={(evt) => setNameSearch(evt.target.value)}/>
            <h1>Danh sách nhân viên </h1>
            <table width="500px">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                </tr>
                </thead>
                <tbody>
                {employees?.map((item, index) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.firstName}</td>
                            <td>{item.lastName}</td>
                            <td>{item.email}</td>
                        </tr>
                    )
                )}
                </tbody>
            </table>
        </>
    )
}

export default ListEmployee;
