import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import React, {useEffect, useState} from "react";
import * as categoryService from "../Category Service/categoryService";
import * as productService from "../Product Service/productService";
import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";


export function UpdateModalComponent(props) {
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
                <Formik initialValues={{
                    id: product.id,
                    name: product.name,
                    quantity: product.quantity,
                    date: product.date,
                    from: product.from,
                    to: product.to,
                    category: product.category,
                    status: product.status
                }} onSubmit={(values) => handleUpdate(values)}>

                    {(formik) => (<Modal
                        {...props}
                        size="lg"
                        aria-labelledby="contained-modal-title-vcenter"
                        centered
                    >
                        <Form onSubmit={formik.handleSubmit}>
                            <Modal.Header closeButton className="bg-primary text-white">
                                <Modal.Title id="contained-modal-title-vcenter">
                                    Update Product
                                </Modal.Title>
                            </Modal.Header>
                            <Modal.Body>
                                <div className="mb-3">
                                    <label htmlFor="name" className="form-label">
                                        Name
                                    </label>
                                    <input
                                        className="form-control"
                                        type="text"
                                        name="name"
                                        value={formik.values.name}
                                        onChange={formik.handleChange}
                                    />
                                    <ErrorMessage name="name" component="span" className="text-danger"/>
                                </div>

                                <div className="mb-3">
                                    <label htmlFor="quantity" className="form-label">
                                        Quantity
                                    </label>
                                    <input
                                        type="text"
                                        name="quantity"
                                        value={formik.values.quantity}
                                        onChange={formik.handleChange}
                                        onBlur={formik.handleBlur}
                                        className={`form-control ${formik.touched.quantity && formik.errors.quantity ? 'is-invalid' : ''}`}
                                    />
                                    <ErrorMessage name="quantity" component="span" className="text-danger"/>
                                </div>

                                <div className="mb-3">
                                    <label htmlFor="date" className="form-label">
                                        Date
                                    </label>
                                    <input
                                        type="date"
                                        name="date"
                                        value={formik.values.date}
                                        onChange={formik.handleChange}
                                        onBlur={formik.handleBlur}
                                        className={`form-control ${formik.touched.date && formik.errors.date ? 'is-invalid' : ''}`}
                                    />
                                    <ErrorMessage name="date" component="span" className="text-danger"/>
                                </div>

                                <div className="mb-3">
                                    <label htmlFor="category" className="form-label">
                                        Category
                                    </label>
                                    <select
                                        name="category"
                                        value={formik.values.category}
                                        onChange={formik.handleChange}
                                        onBlur={formik.handleBlur}
                                        className={`form-select ${formik.touched.category && formik.errors.category ? 'is-invalid' : ''}`}
                                    >
                                        {categories?.map((category) => (
                                            <option key={category.id} value={category.id}>
                                                {category.nameCategory}
                                            </option>
                                        ))}
                                    </select>
                                    <ErrorMessage name="category" component="span" className="text-danger"/>
                                </div>

                                <div className='mb-3'>
                                    <div className="form-check form-check-inline">
                                        <input
                                            className="form-check-input"
                                            type="radio"
                                            name="status"
                                            id="inlineRadio1"
                                            value="1"
                                            checked={formik.values.status === "1"}
                                            onChange={formik.handleChange}
                                        />
                                        <label className="form-check-label" htmlFor="inlineRadio1">Con hang</label>
                                    </div>
                                    <div className="form-check form-check-inline">
                                        <input
                                            className="form-check-input"
                                            type="radio"
                                            name="status"
                                            id="inlineRadio2"
                                            value="0"
                                            checked={formik.values.status === "0"}
                                            onChange={formik.handleChange}
                                        />
                                        <label className="form-check-label" htmlFor="inlineRadio2">Het hang</label>
                                    </div>
                                </div>


                            </Modal.Body>
                            <Modal.Footer className="bg-light">
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

                            </Modal.Footer>
                        </Form>
                    </Modal>)}
                </Formik>
            </>
        );
    }
}
