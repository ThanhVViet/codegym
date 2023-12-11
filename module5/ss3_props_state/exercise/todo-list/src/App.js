import React, {Component, createRef, RefObject} from 'react';
import "./App.css"

interface AppComponentState {
  list: string[]
}

class App extends Component<{}, AppComponentState> {
  inputRef: RefObject<HTMLInputElement> = createRef();

  constructor(props: any) {
    super(props);
    this.state = {
      list: []
    }
  }

  addNote = () => {
    const inputValue = this.inputRef.current?.value; // lấy giá trị đầu vào nếu có thì gán vào inputValue ko thì về undefined mà ko gay ra loi
    if (inputValue) {
      this.setState(preState => {
            const newList = [...preState.list, inputValue];
            return {list: newList}
          }, () => {
            if (this.inputRef.current) {
              this.inputRef.current.value = '';
            }
          }
      )
    }
  }

  render() {
    return (
        <div className="todo">
          <div>
            <h1>TO DO LIST</h1>
            <input required type="text" ref={this.inputRef}/>
            <button onClick={this.addNote}>Add</button>
            <ul>
              {
                this.state.list.map(e => (
                    <li key={e}>{e}</li>
                ))
              }
            </ul>
          </div>
        </div>
    );
  }
}

export default App;
