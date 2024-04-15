import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import React, {useEffect, useState} from "react";
import * as categoryService from "../Category Service/categoryService";
import * as productService from "../Product Service/productService";
import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";


export function UpdateComponentTwo(props) {
    const {uid} = props;
    const [categories, setCategories] = useState([]);
    const [product, setProduct] = useState({
        name: " ",
        quantity: " ",
        date: new Date().toISOString().split('T')[0],
        from: new Date().toISOString().split('T')[0],
        to: new Date().toISOString().split('T')[0],
        category: 1,
        status: "0"
    });

    useEffect(() => {
        fetchData();
    }, [uid]);

    const fetchData = async () => {
        try {
            const [productResult, categoriesResult] = await Promise.all([
                productService.findById(uid),
                categoryService.findAllCategory()
            ]);
            setProduct(productResult);
            setCategories(categoriesResult);
        } catch (e) {
            console.error(e);
        }
    };
    const handleUpdate = async (productEdited) => {
        try {
            await productService.updateProduct(uid, productEdited);
            await fetchData();
            toast.success(`🦁 Product "${productEdited.name}" updated successfully!`, {
                autoClose: 1000,
                hideProgressBar: false,
                closeOnClick: true,
                pauseOnHover: true,
                draggable: true,
            });
        } catch (e) {
            console.error(e);
        }
    };
    if (product != null) {
        return (
            <>
                <Modal  {...props}>
                    <Modal.Header closeButton>
                        <Modal.Title>Update Product</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Formik
                            initialValues={{
                                id: product.id,
                                name: product.name,
                                quantity: product.quantity,
                                date: product.date,
                                from: product.from,
                                to: product.to,
                                category: product.category,
                                status: product.status
                            }}
                            onSubmit={(values) => handleUpdate(values)}

                        >
                            {/* Form inside the modal */}
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


                                <Button variant="outline-success" onClick={props.onHide}>Close</Button>
                                <Button
                                    type="submit"
                                    variant="outline-primary"
                                    onClick={
                                        props.onLoad
                                    }
                                >
                                    Update
                                </Button>
                            </Form>
                        </Formik>
                    </Modal.Body>
                </Modal>
            </>
        );
    }
}
