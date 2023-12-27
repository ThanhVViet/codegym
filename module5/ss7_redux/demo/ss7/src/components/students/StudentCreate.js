import {ErrorMessage, Field, Form, Formik} from "formik";
import {toast} from "react-toastify";
import * as Yup from "yup";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import {useDispatch} from "react-redux";
import {createNewStudent} from "../../redux/middleware/StudentMiddleware";

function StudentCreate() {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const initValue = {
        name: "",
        gender: "0",
        age: 0,
        languages: []
    }
    const validateSchema = {
        name: Yup.string().required("Name is not empty")
            .min(3, "Name too short")
            .max(100, "name too long")
            .matches(/^[A-Za-z ]{3,100}$/, "name invalid"),
        age: Yup.number().min(18, "Age min is 18")
    }

   const createStudent = async (values) => {
        values.gender = +values.gender;
        try {
            dispatch(createNewStudent(values));
            toast("Thêm mới thành công");
            navigate("/students/list")
        } catch(e) {
            console.log(e);
        }
    }
    return (
        <>
            <div className='container'>
                <h1>Create Student</h1>
                <Formik initialValues={initValue}
                        onSubmit={(values, {setSubmitting}) => {
                           setSubmitting(false);
                            createStudent(values);

                        }}
                        validationSchema={Yup.object(validateSchema)}
                >
                    {
                        ({isSubmitting}) => (
                            <Form>
                                <div className='mb-3'>
                                    <label htmlFor='studentName' className='form-label'>Name</label>
                                    <Field type='text' className='form-control' id='studentName' name="name"/>
                                    <ErrorMessage name="name" component="span" style={{color: "red"}}></ErrorMessage>
                                </div>
                                <div className='mb-3'>
                                    <label htmlFor='studentAge' className='form-label'>Age</label>
                                    <Field type='number' className='form-control' id='studentAge' name="age"/>
                                    <ErrorMessage name="age" component="span" style={{color: "red"}}></ErrorMessage>
                                </div>
                                <div className='mb-3'>
                                    <div className="form-check form-check-inline">
                                        <Field className="form-check-input" type="radio" name="gender" id="inlineRadio1"
                                               value="1"/>
                                        <label className="form-check-label" htmlFor="inlineRadio1">Male</label>
                                    </div>
                                    <div className="form-check form-check-inline">
                                        <Field className="form-check-input" type="radio" name="gender" id="inlineRadio2"
                                               value="0"/>
                                        <label className="form-check-label" htmlFor="inlineRadio2">FeMale</label>
                                    </div>
                                </div>

                                <label htmlFor='studentAge' className='form-label'>Languages</label>
                                <div className="form-check">
                                    <Field className="form-check-input" type="checkbox" value="C#" name="languages"
                                           id="flexCheckDefault"/>
                                    <label className="form-check-label" htmlFor="flexCheckDefault">
                                        C#
                                    </label>
                                </div>
                                <div className="form-check">
                                    <Field className="form-check-input" type="checkbox" value="JAVA" name="languages"
                                           id="cb1"/>
                                    <label className="form-check-label" htmlFor="cb1">
                                        JAVA
                                    </label>
                                </div>
                                <div className="form-check">
                                    <Field className="form-check-input" type="checkbox" value="ReactJS" name="languages"
                                           id="cb2"/>
                                    <label className="form-check-label" htmlFor="cb2">
                                        ReactJS
                                    </label>
                                </div>
                                {
                                    isSubmitting ? <></> :
                                        <button type='submit' className='btn btn-primary'>Submit</button>
                                }
                            </Form>
                        )}

                </Formik>
            </div>
        </>
    )
}

export default StudentCreate;
