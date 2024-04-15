import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import React, {useEffect, useState} from "react";
import * as categoryService from "../Category_service/categoryService";
import * as productService from "../Product_service/productService";
import {useParams} from "react-router-dom";


export function DetailModalComponent(props) {
    const {id} = props;
    const [categories, setCategories] = useState([]);
    const [product, setProduct] = useState({
        name: " ",
        quantity: " ",
        date: new Date().toISOString().split('T')[0],
        category: 1,
        status: "0"
    });


    useEffect(() => {
        fetchData();
    }, [id]);

    const fetchData = async () => {
        try {
            const [productResult, categoriesResult] = await Promise.all([
                productService.findById(id),
                categoryService.findAllCategory()
            ]);
            setProduct(productResult);
            setCategories(categoriesResult);
        } catch (e) {
            console.error(e);
        }
    };

    // const findAll = async () => {
    //     const result = await categoryService.findAllCategory();
    //     setCategories(result);
    // };

    const findByid = async () => {
        try {
            console.log(id);
            console.log('Fetching product details for ID:', id);
            const result = await productService.findById(id);
            console.log(result);
            setProduct(result);
        } catch (e) {
            console.log(e);
        }
    };

    if (product?.id != null) {
        return (
            <Modal
                {...props}
                size="lg"
                aria-labelledby="contained-modal-title-vcenter"
                centered
            >
                <Modal.Header closeButton>
                    <Modal.Title id="contained-modal-title-vcenter">
                        Detail Product
                    </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <p>{product?.name}</p>
                    <p>
                        {product?.quantity}
                    </p>
                    <p>{product?.status === "1" ? "con hang" : "het"}</p>
                </Modal.Body>
                <Modal.Footer>
                    <Button onClick={props.onHide}>Close</Button>
                </Modal.Footer>
            </Modal>
        );
    }
}
