import * as studentService from "../../services/StudentService"
export const getAllStudent = (name) => async (dispatch) => {
    console.log(1)
    const res = await studentService.findAll(name);
    console.log(res)
    dispatch({
        type: "LIST",
        payload: res
    })
}

export const createNewStudent = (values) => async (dispatch) => {
    await studentService.saveStudent(values);
    dispatch({
        type: "SAVE",
        payload: values
    })
}