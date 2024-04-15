import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import React, {useEffect, useState} from "react";
import * as categoryService from "../Category Service/categoryService";
import * as productService from "../Product Service/productService";
import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";




export function CreateModalComponent(props) {
    const [categories, setCategories] = useState([])


    useEffect(() => {
        findAll();
    }, []);
    const findAll = async () => {
        const result = await categoryService.findAllCategory();
        setCategories(result)
    }


    return (
        <>
            <Formik initialValues={{
                name: " ",
                quantity: " ",
                date: new Date().toISOString().split('T')[0],
                from: new Date().toISOString().split('T')[0],
                to: new Date().toISOString().split('T')[0],
                category: 1,
                status: 0,
            }}
                    validationSchema={Yup.object({
                        name: Yup.string().required('Name is not empty')
                            .min(3, 'Name too short')
                            .max(100, 'Name too long'),
                        quantity: Yup.number().required('Quantity is required')
                            .integer('Please enter a number')
                            .min(0, 'Quantity must be greater than or equal to 0'),
                        from: Yup.date().required('From date is required'),
                        to: Yup.date().required('To date is required')
                            .when('from', (from, schema) => {
                                return schema.min(from, 'End date must be greater than or equal to the start date');
                            }),

                    })} onSubmit={(values, {setSubmitting}) => {
                const createProduct = async () => {
                    try {
                        console.log(values);
                        await productService.createProduct(values);
                        toast.success('Create successful!');
                    } catch (error) {
                        console.error('Error creating product:', error);
                        toast.error('Error creating product');
                    } finally {
                        setSubmitting(false);
                    }
                };

                createProduct();
            }}>

                <Modal
                    {...props}
                    size="lg"
                    aria-labelledby="contained-modal-title-vcenter"
                    centered
                >
                    <Form>
                        <Modal.Header closeButton className="bg-success text-white">
                            <Modal.Title id="contained-modal-title-vcenter">
                                Create New Product
                            </Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
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


                        </Modal.Body>
                        <Modal.Footer className="bg-light">
                            <div className="group-button">
                                <div className="mb-3 d-flex justify-content-center gr1">
                                    <Button onClick={props.onHide} className="btn btn-info custom-button">
                                        Back
                                    </Button>
                                </div>

                                <div className="mb-3 d-flex justify-content-center gr2">
                                    <button onClick={props.onLoad} type="submit" className="btn btn-primary">
                                        Submit
                                    </button>
                                </div>
                            </div>
                        </Modal.Footer>
                    </Form>
                </Modal>
            </Formik>
        </>
    );

}
