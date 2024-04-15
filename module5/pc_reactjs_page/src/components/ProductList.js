import React, {useEffect, useState} from "react";
import {NavLink, useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import * as productService from "../Product_service/productService";
import * as categoryService from "../Category_service/categoryService";
import {format, isValid, parseISO} from "date-fns";
import Modal from "react-modal";
import '../App.css';
import * as PropTypes from "prop-types";
import ModalComponent from "./ModalComponent";
import {Field} from "formik";
import axios from "axios";
import {DetailModalComponent} from "./DetailModalComponent";
import Button from 'react-bootstrap/Button';


ModalComponent.propTypes = {
    open: PropTypes.bool,
    onRequestClose: PropTypes.func,
    onClick: PropTypes.func
};

DetailModalComponent.propTypes = {
    show: PropTypes.bool.isRequired,
    onHide: PropTypes.func.isRequired,
    id: PropTypes.number.isRequired,
};

export function ProductList() {
    const navigate = useNavigate();
    const [search, setSearch] = useState("");
    const [productsSearch, setProductsSearch] = useState([]);
    const [products, setProducts] = useState([]);
    const [categories, setCategories] = useState([]);

    const [deleteItemId, setDeleteItemId] = useState(null);
    const [isConfirmModalOpen, setConfirmModalOpen] = useState(false);

    const [sortedProducts, setSortedProducts] = useState([]);

    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');

    const [date, setDate] = useState('');

    const [category, setCategory] = useState('');

    const [search2, setSearch2] = useState("");
    const [category2, setCategory2] = useState('');
    const [categories2, setCategories2] = useState([]);

    const [modalShow, setModalShow] = useState(false);
    const [modalId, setModalId] = useState(null);

    const [currentPage, setCurrentPage] = useState(1);
    const recordsPerPage = 5;
    const lastIndex = currentPage * recordsPerPage;
    const firstIndex = lastIndex - recordsPerPage;
    const records = productsSearch.slice(firstIndex, lastIndex);
    const npage = Math.ceil(productsSearch.length / recordsPerPage);
    const numbers = [...Array(npage + 1).keys()].slice(1);

    const openDetailModal = (productId) => {
        console.log('Opening detail modal for product ID:', productId);
        setModalId(productId);
        setModalShow(true);
    };
    const closeDetailModal = () => {
        setModalId(null);
        setModalShow(false);
    };

    const handleChange = (event) => {
        setDate(event?.target.value);
    };
    const handleChange2 = (event) => {
        setStartDate(event?.target.value);
    };
    const handleChange3 = (event) => {
        setEndDate(event?.target.value);
    };
    const openConfirmModal = (itemId) => {
        setDeleteItemId(itemId);
        setConfirmModalOpen(true);
    };
    const closeConfirmModal = () => {
        setDeleteItemId(null);
        setConfirmModalOpen(false);
    };
    useEffect(() => {
        fetchApi();
    }, []);

    useEffect(() => {
        handleSearch();
    }, [startDate, endDate]);

    useEffect(() => {
        handleSearch2();
    }, [date]);

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

    const handleSearch = async (evt) => {
        evt?.preventDefault();
        try {
            const results = await productService.searchByDate(startDate, endDate);
            setProductsSearch(results);
        } catch (error) {
            console.error('Error searching by date:', error);
        }
    };

    const handleSearch2 = async (event) => {
        try {
            let results;
            if (date) {
                results = await productService.searchByDate2(date);
            } else {
                results = await productService.findAll();
            }
            setProductsSearch(results);
        } catch (error) {
            console.error('Error searching by date:', error);
        }
        event?.preventDefault();
    };

    const fetchApi = async () => {
        try {
            const fetchedProducts = await productService.findAll();
            setProducts(fetchedProducts);
            const fetchedCategories = await categoryService.findAllCategory();
            setCategories(fetchedCategories);

            // const sortedProducts = fetchedProducts.sort((a, b) => new Date(b.date) - new Date(a.date));
            // setSortedProducts(sortedProducts);

        } catch (error) {
            if (!error.response) {
                this.errorStatus = 'Error: Network Error';
            } else {
                this.errorStatus = error.response.data.message;
            }
        }
    };

    const deleteProduct = async (id) => {
        try {
            await productService.deleteProduct(id);
            fetchApi();
            toast.success('Product deleted successfully!');
        } catch (error) {
            console.error('Error deleting product:', error);
            toast.error('Error deleting product');
        }
        closeConfirmModal();
    };

    useEffect(() => {
        searchAll();
    }, [search, products]);

    const searchAll = () => {
        if (Array.isArray(products)) {
            const result = products.filter(
                (product) =>
                    product.name.toLowerCase().includes(search.toLowerCase()) ||
                    product.quantity.includes(search)
            );
            setProductsSearch(result);
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

    const handleSearch3 = async () => {
        try {
            let results;
            if (category2 && search2) {
                results = await productService.searchByCategoryAndName(category2, search2);
            } else if (category2) {
                results = await productService.findByCategory(category2);
            } else if (search2) {
                results = await productService.searchByName(search2);
            } else {
                results = await productService.findAll();
            }
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
            <form className="search-form">
                <label htmlFor="searchInput">Search</label>
                <div className="search-input-container">
                    <input
                        type="text"
                        id="searchInput"
                        placeholder="Search"
                        value={search}
                        onChange={(e) => setSearch(e.target.value)}
                    />
                </div>
            </form>

            <br/>
            <form className="date-range-form" onSubmit={handleSearch}>
                <div className="date-input-container">
                    <div>
                        <label>Start Date:</label>
                        <input type="date" value={startDate} onChange={(e) => handleChange2(e)}/>
                    </div>
                    <div>
                        <label>End Date:</label>
                        <input type="date" value={endDate} onChange={(e) => handleChange3(e)}/>
                    </div>
                </div>
                {/*<button className="search-button" onClick={(evt) => handleSearch()}>*/}
                {/*    Search*/}
                {/*</button>*/}
            </form>
            <br/>

            <form className="single-date-form" onSubmit={handleSearch2}>
                <div className="date-input-container">
                    <div>
                        <label>Date:</label>
                        <input type="date" value={date} onChange={(evt) => handleChange(evt)}/>
                    </div>
                </div>
                {/*<button type="button" className="search-button" onClick={(evt) => handleSearch2(evt)}>*/}
                {/*    Search*/}
                {/*</button>*/}
            </form>
            <br/>

            <form>
                <div className="select">
                    <label htmlFor="category">Category</label>
                    <select
                        name="category"
                        className="form-select"
                        value={category}
                        onChange={(evt) => setCategory(evt.target.value)}
                    >
                        <option value="">Select a category</option>
                        {categories?.map((category) => (
                            <option key={category.id} value={category.id}>
                                {category.nameCategory}
                            </option>
                        ))}
                    </select>
                </div>
            </form>

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
                    <th>From</th>
                    <th>To</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {/*{sortedProducts.map((product) => (*/}
                {productsSearch?.length === 0 ? (
                        <tr style={{backgroundColor: '#f2f2f2', textAlign: 'center'}}>
                            <td colSpan="9" style={{padding: '10px', fontSize: '30px', fontStyle: 'italic', color: 'red'}}>
                                No matching products found.
                            </td>
                        </tr>

                    ) :

                    (records?.map((product, index) => (
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
                                    {product.from && isValid(parseISO(product.from))
                                        ? format(parseISO(product.from), 'dd/MM/yyyy')
                                        : 'Invalid Date'}
                                </td>
                                <td>
                                    {product.to && isValid(parseISO(product.to))
                                        ? format(parseISO(product.to), 'dd/MM/yyyy')
                                        : 'Invalid Date'}
                                </td>
                                <td>{product.status === "1" ? 'Con hang' : 'Het hang'}</td>
                                <td>
                                    <NavLink to={`/edit/${product.id}`} className="btn btn-primary">
                                        Edit
                                    </NavLink>
                                    <button onClick={(evt) => openConfirmModal(product.id)} className="btn btn-danger">
                                        Delete
                                    </button>
                                    <NavLink to={`/detail/${product.id}`} className="btn btn-outline-info">
                                        Detail
                                    </NavLink>

                                    <Button variant="primary" onClick={(evt) => openDetailModal(product.id)}>
                                        Detail 2
                                    </Button>
                                </td>
                            </tr>
                        ))
                    )}
                </tbody>
            </table>
            <nav className="pagination">
                <li className="page-item">
                    <a className="page-link" href="#" onClick={prePage}>Prev</a>

                </li>
                {
                    numbers.map((n, i) => (
                        <li className={`page-item ${currentPage === n ? 'active' : ''}`} key={i}>
                            <a href="#" className="page-link"
                               onClick={() => changeCPage(n)}>
                                {n}
                            </a>
                        </li>

                    ))
                }
                <li className="page-item">
                    <a className="page-link" href="#" onClick={nextPage}>Next</a>

                </li>

            </nav>
            <ModalComponent open={isConfirmModalOpen} onRequestClose={closeConfirmModal}
                            onClick={() => deleteProduct(deleteItemId)}/>
            <DetailModalComponent
                show={modalShow}
                onHide={(() => setModalShow(false))}
                id={modalId}
            />

        </>

    );

    function nextPage() {
        if (currentPage !== npage) {
            setCurrentPage(currentPage + 1);
        }

    }

    function changeCPage(id) {
        setCurrentPage(id);

    }

    function prePage() {

        if (currentPage !== 1) {
            setCurrentPage(currentPage - 1);
        }
    }
}
