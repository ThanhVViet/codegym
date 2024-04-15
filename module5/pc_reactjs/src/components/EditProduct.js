import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {useNavigate} from "react-router-dom"
import * as productService from "../Product Service/productService"
import * as categoryService from "../Category Service/categoryService"
import {ErrorMessage, Field, Form, Formik} from "formik";
import {toast} from "react-toastify";

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
                quantity: product.quantity,
                date:product.date,
                category: product.category,
                status: product.status
            }} onSubmit={(productEdited) => {
                const update = async () => {
                    try {
                        const result = productService.updateProduct(id, productEdited);
                        toast(`🦁 Edit student ${productEdited.name} successful!!!`)
                        navigate("/");
                    }catch (e) {
                        console.log(e);
                    }
                }
                update();
            }}>
                <div className="container mt-5">
                    <h1>edit product</h1>
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


                        <div className="mb-3 d-flex justify-content-center">
                            <button type="submit" className="btn btn-primary">
                                Submit
                            </button>
                        </div>
                    </Form>
                </div>
            </Formik>
        </>
    ) : ""
}
