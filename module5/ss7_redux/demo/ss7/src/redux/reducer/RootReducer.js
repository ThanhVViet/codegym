import {combineReducers} from "redux";
import studentReducer from "./StudentReducer";

export const rootReducer = combineReducers({
    students: studentReducer,
    // username: usernameReducer,
    // teachers: teacherReducers
})
