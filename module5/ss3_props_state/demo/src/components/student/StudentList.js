import {Component} from "react";

class StudentList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            students: [
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
            ],
            nameSearch: ""
        }
    }

    render() {
        return (
            <>
                <input onChange={(evt) => this.props.changeName(evt.target.value)}/>
                <h1>Danh sách học sinh lớp {this.props.name}</h1>
                <table width="500px">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.students.map((item, index) => (
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
}

export default StudentList;