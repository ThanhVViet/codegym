import axios from "axios";
import {useEffect, useState} from "react";
import * as studentService from "../../services/StudentService"
import {findAll} from "../../services/StudentService";

function StudentList() {
    const [students, setStudents] = useState([]);
    const [nameSearch, setNameSearch] = useState("");

    useEffect( () => {
        getAllStudent();
    }, []);

    const getAllStudent = async () => {
        try {
            let temp = await studentService.findAll();
            setStudents(temp);
        } catch (e) {
            console.log(e);
        }
    }

    return (
        <>

            {/*<input onChange={(evt) => setNameSearch(evt.target.value)}/>*/}
            <h1>Danh sách học sinh </h1>
            <table width="500px">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Gender</th>
                    <th>Languages</th>
                </tr>
                </thead>
                <tbody>
                {students?.map((item, index) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td>{item.age}</td>
                            <td>{item.gender}</td>
                            <td>{item.languages}</td>
                        </tr>
                    )
                )}
                </tbody>
            </table>
        </>
    )
}

export default StudentList;
