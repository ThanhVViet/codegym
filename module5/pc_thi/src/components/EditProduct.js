import React, {useEffect, useState} from "react";
import {NavLink, useParams} from "react-router-dom";
import {useNavigate} from "react-router-dom"
import * as productService from "../Product Service/productService"
import * as categoryService from "../Category Service/categoryService"
import {ErrorMessage, Field, Form, Formik} from "formik";
import {toast} from "react-toastify";
import * as Yup from "yup";

export function EditProduct() {
    const navigate = useNavigate();
    const {id} = useParams();
    const [categories, setCategories] = useState([]);
    const getCurrentDate = () => {
        const currentDate = new Date();
        return currentDate.toISOString().split('T')[0];
    };
    const [product, setProduct] = useState({
        name: " ",
        quantity: " ",
        date: new Date().toISOString().split('T')[0], // Format date as 'YYYY-MM-DD'
        category: 1,
        status: "0"
    })

    const findAll = async () => {
        const result = await categoryService.findAllCategory();
        setCategories(result)
    }
    useEffect(() => {
        const findByid = async () => {
            try {
                console.log(id)
                const result = await productService.findById(id);
                console.log(result)
                setProduct(result);
            } catch (e) {
                console.log(e)
            }
        }
        findByid()
        findAll()
    }, [])
    return product.name !== " " ? (
        <>
            <Formik initialValues={{
                id: product.id,
                name: product.name,
                current: getCurrentDate(),
                quantity: product.quantity,
                date: product.date,
                category: product.category,
            }}
                    validationSchema={Yup.object({
                        name: Yup.string().required('Name is not empty')
                            .min(3, 'Name too short')
                            .max(100, 'Name too long'),
                        quantity: Yup.number().required('Quantity is required')
                            .integer('Please enter a integer number')
                            .min(1, 'Quantity must be greater than 0'),
                        date: Yup.date().required("date is required"),
                        current: Yup.date().required('date is required')
                            .when('date', (date, schema) => {
                                return schema.min(date, 'Ngay nhap san pham khong duoc lon hon ngay hien tai');
                            }),

                    })}

                    onSubmit={(productEdited) => {
                        const update = async () => {
                            try {
                                const result = productService.updateProduct(id, productEdited);
                                toast(`Update information of product ${productEdited.name} successful!!!`)
                                navigate("/");
                            } catch (e) {
                                console.log(e);
                            }
                        }
                        update();
                    }}>
                <div className="container mt-5">
                    <h1>update product</h1>
                    <Form>
                        <div className="mb-3">
                            <label htmlFor="name" className="form-label">
                                Name
                            </label>
                            <Field type="text" name="name" id="name" className="form-control"/>
                            <ErrorMessage name="name" component="span" className="text-danger"/>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="quantity" className="form-label">
                                Quantity
                            </label>
                            <Field type="text" name="quantity" className="form-control"/>
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
                            <Field name="category" as="select" className="form-select">
                                {categories?.map((category) => (
                                    <option value={(category.id)}>{category.nameCategory}</option>
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
                                    Update Information
                                </button>
                            </div>
                        </div>
                    </Form>
                </div>
            </Formik>
        </>
    ) : ""
}
