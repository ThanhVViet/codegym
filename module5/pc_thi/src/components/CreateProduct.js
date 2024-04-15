import {NavLink, useNavigate} from "react-router-dom"
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useEffect, useState} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';


import * as Yup from "yup"
import {toast} from "react-toastify";
import * as productService from "../Product Service/productService"
import * as categoryService from "../Category Service/categoryService"

export function CreateProduct() {
    const navigate = useNavigate();
    const [categories, setCategories] = useState([])
    useEffect(() => {
        findAll();
    }, []);
    const findAll = async () => {
        const result = await categoryService.findAllCategory();
        setCategories(result)
    }
    const getCurrentDate = () => {
        const currentDate = new Date();
        return currentDate.toISOString().split('T')[0];
    };
    return (
        <>
            <Formik
                initialValues={{
                    name: " ",
                    quantity: " ",
                    current: getCurrentDate(),
                    date: new Date().toISOString().split('T')[0],
                    category: 1,
                }}
                validationSchema={Yup.object({
                    name: Yup.string().required('Name is not empty')
                        .min(3, 'Name too short')
                        .max(100, 'Name too long'),
                    quantity: Yup.number().required('Quantity is required')
                        .integer('Please enter a number')
                        .min(1, 'Quantity must be greater than 0'),
                    date: Yup.date().required("date is required"),
                    current: Yup.date().required('date is required')
                        .when('date', (date, schema) => {
                            return schema.min(date, 'Ngay nhap san pham khong duoc lon hon ngay hien tai');
                        }),

                })}

                onSubmit={(values, {setSubmitting}) => {
                    const createProduct = async () => {
                        try {
                            console.log(values);
                            await productService.createProduct(values);
                            toast.success('Create successful!');
                            navigate('/');
                        } catch (error) {
                            console.error('Error creating product:', error);
                            toast.error('Error creating product');
                        } finally {
                            setSubmitting(false);
                        }
                    };

                    createProduct();
                }}
            >
                <div className="container mt-5">
                    <h1 style={{textAlign: 'center'}}>Create new product</h1>
                    <Form>
                        <div className="mb-3">
                            <label htmlFor="name" className="form-label">
                                Name
                            </label>
                            <Field type="text" name="name" id="name" className="form-control"/>
                            <ErrorMessage name="name" component="div" className="error-message"/>
                        </div>


                        <div className="mb-3">
                            <label htmlFor="quantity" className="form-label">
                                Quantity
                            </label>
                            <Field type="text" name="quantity" className="form-control"/>
                            <ErrorMessage name="quantity" component="div" className="error-message"/>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="date" className="form-label">
                                Date
                            </label>
                            <Field type="date" name="date" className="form-control"/>
                            <ErrorMessage name="current" component="div" className="error-message"/>
                        </div>


                        <div className="mb-3">
                            <label htmlFor="category" className="form-label">
                                Category
                            </label>
                            <Field
                                name="category"
                                as="select"
                                className="form-select"
                                defaultValue=""
                            >
                                <option value="" disabled>
                                    Choose a category
                                </option>
                                {categories?.map((category) => (
                                    <option key={category.id} value={category.id}>
                                        {category.nameCategory}
                                    </option>
                                ))}
                            </Field>
                        </div>

                        <div className="group-button">
                            <div className="mb-3 d-flex justify-content-center gr1">
                                <NavLink to="/" className="btn btn-info custom-button">
                                    Back
                                </NavLink>
                            </div>

                            <div className="mb-3 d-flex justify-content-center gr2">
                                <button type="submit" className="btn btn-primary">
                                    Submit
                                </button>
                            </div>
                        </div>

                    </Form>
                </div>
            </Formik>
        </>
    );
}