import React, {useEffect, useState} from "react";
import {NavLink, useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import * as productService from "../Product Service/productService";
import * as categoryService from "../Category Service/categoryService";
import {format, isValid, parse, parseISO} from "date-fns";
import '../App.css';
import * as PropTypes from "prop-types";
import {Field} from "formik";
import axios from "axios";


export function ProductList() {
    const navigate = useNavigate();
    const [productsSearch, setProductsSearch] = useState([]);
    const [products, setProducts] = useState([]);
    const [categories, setCategories] = useState([]);

    const [category, setCategory] = useState('');

    const [search2, setSearch2] = useState("");
    const [category2, setCategory2] = useState('');
    const [categories2, setCategories2] = useState([]);


    useEffect(() => {
        sortByQuantity();
    }, [products]);

    const sortByQuantity = () => {
        const sortedProducts = products.sort((a, b) => b.quantity - a.quantity);
        setProductsSearch(sortedProducts);
    }


    useEffect(() => {
        fetchApi();
    }, []);


    useEffect(() => {
        handleSearchByCategory();
    }, [category]);

    const handleSearchByCategory = async () => {
        try {
            let results;
            if (category === '') {
                results = await productService.findAll();
            } else {
                results = await productService.findByCategory(category);
            }
            setProductsSearch(results);
        } catch (error) {
            console.error('Error searching by category', error);
        }
    };


    const fetchApi = async () => {
        try {
            const fetchedProducts = await productService.findAll();
            setProducts(fetchedProducts);
            setProductsSearch(fetchedProducts)
            const fetchedCategories = await categoryService.findAllCategory();
            setCategories(fetchedCategories);

            const sortedProducts = fetchedProducts.sort((a, b) => a.quantity - b.quantity);
            setProductsSearch(sortedProducts);

        } catch (error) {
            if (!error.response) {
                this.errorStatus = 'Error: Network Error';
            } else {
                this.errorStatus = error.response.data.message;
            }
        }
    };


    useEffect(() => {
        fetchCategories();
    }, []);
    const fetchCategories = async () => {
        try {
            const response = await axios.get('http://localhost:8080/category');
            setCategories(response.data);
        } catch (error) {
            console.error('Error fetching categories:', error);
        }
    };

    useEffect(() => {
        fetchCategories2();
    }, []);
    const fetchCategories2 = async () => {
        try {
            const response = await axios.get('http://localhost:8080/category');
            setCategories2(response.data);
        } catch (error) {
            console.error('Error fetching categories:', error);
        }
    };

    useEffect(() => {
        handleSearch3();
    }, [category2, search2]);

    const Fuse = require('fuse');


    const handleSearch3 = async () => {
        try {
            let results;
            if (category2 && search2) {
                results = await productService.searchByCategoryAndName(category2, search2);
            } else if (category2) {
                results = await productService.findByCategory(category2);
            } else if (search2) {
                results = products.filter(
                    (product) =>
                        product.name.toLowerCase().includes(search2.toLowerCase()) ||
                        product.quantity.includes(search2)
                );
            } else {
                results = await productService.findAll();
            }
            const sortedProducts = results.sort((a, b) => a.quantity - b.quantity);
            setProductsSearch(sortedProducts);
            setProductsSearch(results);
        } catch (error) {
            console.error('Error searching products:', error);
        }
    };

    return (
        <>
            <h1 style={{textAlign: 'center'}}>
                Product List
            </h1>
            <div>
                   <span>
          <NavLink to="/create" className="btn btn-success">
            Create
          </NavLink>
        </span>
            </div>

            <br/>

            <form className="search-combine">
                <div className="input-group">
                    <label htmlFor="category">Category</label>
                    <select
                        name="category"
                        className="select-name"
                        value={category2}
                        onChange={(evt) => setCategory2(evt.target.value)}
                    >
                        <option value="">Select a category</option>
                        {categories2?.map((cat) => (
                            <option key={cat.id} value={cat.id}>
                                {cat.nameCategory}
                            </option>
                        ))}
                    </select>
                </div>

                <div className="input-group">
                    <label htmlFor="searchInput">Search</label>
                    <input
                        className="input-name"
                        type="text"
                        id="searchInput"
                        placeholder="Search"
                        value={search2}
                        onChange={(e) => setSearch2(e.target.value)}
                    />
                </div>
            </form>

            <br/>


            <table className="table">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Date</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {productsSearch?.length === 0 ? (
                        <tr style={{backgroundColor: '#f2f2f2', textAlign: 'center'}}>
                            <td colSpan="9" style={{padding: '10px', fontSize: '30px', fontStyle: 'italic', color: 'red'}}>
                                No matching products found.
                            </td>
                        </tr>

                    ) :
                    (productsSearch?.map((product, index) => (
                            <tr key={product.id}>
                                <td>{index + 1}</td>
                                <td>{product.name}</td>
                                <td>{product.quantity}</td>
                                <td>
                                    {product.date && isValid(parseISO(product.date))
                                        ? format(parseISO(product.date), 'dd/MM/yyyy')
                                        : 'Invalid Date'}
                                </td>
                                <td>
                                    {
                                        categories.find(
                                            (category) =>
                                                String(category.id) === String(product.category)
                                        )?.nameCategory
                                    }
                                </td>

                                <td>
                                    <NavLink to={`/edit/${product.id}`} className="btn btn-primary">
                                        Update
                                    </NavLink>


                                </td>
                            </tr>
                        ))
                    )}
                </tbody>
            </table>


        </>

    );
}
