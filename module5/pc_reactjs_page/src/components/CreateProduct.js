import {NavLink, useNavigate} from "react-router-dom"
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useEffect, useState} from "react";
import 'bootstrap/dist/css/bootstrap.min.css';


import * as Yup from "yup"
import {toast} from "react-toastify";
import * as productService from "../Product_service/productService"
import * as categoryService from "../Category_service/categoryService"

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
                    date: new Date().toISOString().split('T')[0], // Format date as 'YYYY-MM-DD'
                    from: new Date().toISOString().split('T')[0],
                    to: new Date().toISOString().split('T')[0],
                    // date: getCurrentDate(),
                    category: 1,
                    status: 0,
                }}
                validationSchema={Yup.object({
                    name: Yup.string().required('Name is not empty')
                        .min(3, 'Name too short')
                        .max(100, 'Name too long'),
                        // .matches(/^[0-9]*$/, 'Name must contain only numbers'),
                    quantity: Yup.number().required('Quantity is required')
                        .integer('Please enter a number')
                        .min(0, 'Quantity must be greater than or equal to 0'),
                    from: Yup.date().required('From date is required'),
                    to: Yup.date().required('To date is required')
                        .when('from', (from, schema) => {
                            return schema.min(from, 'End date must be greater than or equal to the start date');
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
                        </div>

                        <div className="mb-3">
                            <label htmlFor="date" className="form-label">
                                From
                            </label>
                            <Field type="date" name="from" className="form-control"/>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="date" className="form-label">
                                To
                            </label>
                            <Field type="date" name="to" className="form-control"/>
                            <ErrorMessage name="to" component="div" className="error-message"/>
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


                        <div className='mb-3'>
                            <div className="form-check form-check-inline">
                                <Field className="form-check-input" type="radio" name="status" id="inlineRadio1"
                                       value="1"/>
                                <label className="form-check-label" htmlFor="inlineRadio1">Con hang</label>
                            </div>
                            <div className="form-check form-check-inline">
                                <Field className="form-check-input" type="radio" name="status" id="inlineRadio2"
                                       value="0"/>
                                <label className="form-check-label" htmlFor="inlineRadio2">Het hang</label>
                            </div>
                        </div>


                        {/*<div>*/}
                        {/*    <label htmlFor='studentAge' className='form-label'>*/}
                        {/*        Languages*/}
                        {/*    </label>*/}
                        {/*    <div className='form-check'>*/}
                        {/*        <Field*/}
                        {/*            className='form-check-input'*/}
                        {/*            type='checkbox'*/}
                        {/*            value='C#'*/}
                        {/*            name='languages'*/}
                        {/*            id='flexCheckDefault'*/}
                        {/*        />*/}
                        {/*        <label className='form-check-label' htmlFor='flexCheckDefault'>*/}
                        {/*            C#*/}
                        {/*        </label>*/}
                        {/*    </div>*/}
                        {/*    <div className='form-check'>*/}
                        {/*        <Field*/}
                        {/*            className='form-check-input'*/}
                        {/*            type='checkbox'*/}
                        {/*            value='JAVA'*/}
                        {/*            name='languages'*/}
                        {/*            id='cb1'*/}
                        {/*        />*/}
                        {/*        <label className='form-check-label' htmlFor='cb1'>*/}
                        {/*            JAVA*/}
                        {/*        </label>*/}
                        {/*    </div>*/}
                        {/*    <div className='form-check'>*/}
                        {/*        <Field*/}
                        {/*            className='form-check-input'*/}
                        {/*            type='checkbox'*/}
                        {/*            value='ReactJS'*/}
                        {/*            name='languages'*/}
                        {/*            id='cb2'*/}
                        {/*        />*/}
                        {/*        <label className='form-check-label' htmlFor='cb2'>*/}
                        {/*            ReactJS*/}
                        {/*        </label>*/}
                        {/*    </div>*/}
                        {/*</div>*/}

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