const studentReducer = (students= [], action) => {
    switch (action.type) {
        case "LIST": {
            console.log(action)
            return action.payload;
        }
        case "SAVE": {
            return [...students, action.payload]
        }

        default: return students;
    }
}

export default studentReducer;