import {useEffect, useState} from "react";

export function StudentList(props) {
    const [students, setStudents] = useState([]);
    const [nameSearch, setNameSearch] = useState("");

    useEffect(() => {
        //call api
       let temp = [
            {
                "id": 1,
                "name": "haiTT"
            },
            {
                "id": 2,
                "name": "TrungDP"
            },
            {
                "id": 3,
                "name": "PhuongTD"
            }
        ];
        const result = temp.filter(value => value.name.includes(nameSearch));
        setStudents(result);
        //clean up
        return () => {
            alert("Bye bye")
        }
    }, [nameSearch])

    // useEffect(() => {
    //     //call api search
    //     console.log("1")
    // }, [nameSearch])

    return (
        <>
            <input onChange={(evt) => props.changeName(evt.target.value)}/>
            <input onChange={(evt) => setNameSearch(evt.target.value)}/>
            <h1>Danh sách học sinh lớp {props.name}</h1>
            <table width="500px">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                {students?.map((item, index) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                        </tr>
                    )
                )}
                </tbody>
            </table>
        </>
    )
}