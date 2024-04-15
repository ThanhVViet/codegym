import {NavLink, useNavigate, useParams} from "react-router-dom";
import React, {useEffect, useState} from "react";
import * as categoryService from "../Category Service/categoryService";
import * as productService from "../Product Service/productService";
import {ErrorMessage, Field, Form, Formik} from "formik";

export function DetailProduct() {
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
    useEffect(() => {
        findByid()
        findAll()
    }, [])


    return product.name !== " " ? (
        <>
            <Formik initialValues={{
                id: product.id,
                name: product.name,
                quantity: product.quantity,
                date: product.date,
                category: product.category,
                status: product.status
            }}
            >
                <div className="container mt-5">
                    <h1 style={{textAlign: 'center'}}>detail product</h1>
                    <Form>
                        <div className="mb-3">
                            <label htmlFor="name" className="form-label">
                                Name
                            </label>
                            <Field type="text" name="name" id="name" className="form-control" disabled/>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="quantity" className="form-label">
                                Quantity
                            </label>
                            <Field type="text" name="quantity" className="form-control" disabled/>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="date" className="form-label">
                                Date
                            </label>
                            <Field type="date" name="date" className="form-control" disabled/>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="category" className="form-label">
                                Category
                            </label>
                            <Field disabled name="category" as="select" className="form-select">
                                {categories?.map((category) => (
                                    <option value={(category.id)}>{category.nameCategory}</option>
                                ))}
                            </Field>
                        </div>

                        <div className="mb-3">
                            <label htmlFor="status" className="form-label">
                                Status
                            </label>
                            <Field disabled type="text" name="status" className="form-control"
                                   value={product.status === "1" ? "Con Hang" : "Het Hang"}

                            />
                        </div>

                        <div className="mb-3 d-flex justify-content-center gr1">
                            <NavLink to="/" className="btn btn-info custom-button">
                                Back
                            </NavLink>
                        </div>
                    </Form>
                </div>
            </Formik>
        </>
    ) : ""
}
