import React, {Component} from 'react';
import "./App.css"

interface frm {
  name: string,
  phone: number,
  email: string
}

interface AppState {
  studentList: frm[],
  form: frm,
  isValid: boolean,
  indexSelected: number
}

class App extends Component<{}, AppState> {
  constructor(props: any) {
    super(props);
    this.state = {
      studentList: [],
      form: {name: '', email: '', phone: 0},
      isValid: false,
      indexSelected: -1
    }
  }

  handleChange = (event: any) => {
    this.setState((state) => {
      const form = state.form
      // @ts-ignore
      form[event.target.name] = event.target.value
      return {form}
    }, () => this.checkInvalidForm())
  }


  checkInvalidForm = () => {
    const {name, phone, email} = this.state.form
    const value = !!name && !!phone && !!email
    this.setState({
      isValid: value
    })
  }

  handleSelect = (studentSelected: frm, index: number) => {
    this.setState({
      form: JSON.parse(JSON.stringify(studentSelected)),
      indexSelected: index
    })
  }

  handleSubmit = () => {
    if (this.state.isValid) {
      const newList = this.state.studentList
      if (this.state.indexSelected > -1) {
        newList[this.state.indexSelected] = this.state.form;
      } else {
        newList.push(this.state.form);
      }

      this.setState({
        studentList: newList,
        form: {name: '', email: '', phone: 0},
        isValid: false,
        indexSelected: -1
      })
    }
  }

  handleDelete = (index: number) => {
    const list = this.state.studentList;
    list.splice(index, 1);
    this.setState({
      studentList: list
    })
  }

  render() {
    const {studentList, form} = this.state

    return (
        <div>
          <div>
            <h1>Student List</h1>
            <div>
              <label>Name: </label>
              <input name="name" value={form.name} onChange={this.handleChange}/>
            </div>
            <div>
              <label>Phone: </label>
              <input type="number" name="phone" value={form.phone} onChange={this.handleChange}/>
            </div>
            <div>
              <label>Email: </label>
              <input name="email" value={form.email} onChange={this.handleChange}/>
            </div>
            <button onClick={this.handleSubmit}>Submit</button>
            <table>
              <thead>
              <tr>
                <td>NAME</td>
                <td>PHONE</td>
                <td>EMAIL</td>
                <td>ACTION</td>
              </tr>
              </thead>
              <tbody>
              {
                studentList.map((s, index) => (
                    <tr key={s.email}>
                      <td>{s.name}</td>
                      <td>{s.phone}</td>
                      <td>{s.email}</td>
                      <td>
                        <button onClick={() => this.handleSelect(s, index)}>Edit</button>
                        <button onClick={() => this.handleDelete(index)}>Delete</button>
                      </td>
                    </tr>
                ))
              }
              </tbody>
            </table>
          </div>
        </div>
    )
  }
}

export default App;
