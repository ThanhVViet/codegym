import React, {useEffect, useState} from "react";
import {NavLink, useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import * as productService from "../Product Service/productService";
import * as categoryService from "../Category Service/categoryService";
import {format, isValid, parse, parseISO} from "date-fns";
import '../App.css';
import * as PropTypes from "prop-types";
import ModalComponent from "./ModalComponent";
import {Field} from "formik";
import axios from "axios";
import {DetailModalComponent} from "./DetailModalComponent";
import Button from 'react-bootstrap/Button';
import {UpdateModalComponent} from "./UpdateModalComponent";
import {CreateModalComponent} from "./CreateModalComponent";
import {UpdateComponentTwo} from "./UpdateComponentTwo";


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
UpdateModalComponent.propTypes = {
    show: PropTypes.bool.isRequired,
    onHide: PropTypes.func.isRequired,
    id: PropTypes.number.isRequired,
};

CreateModalComponent.propTypes = {
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
    //detail
    const [modalShow, setModalShow] = useState(false);
    const [modalId, setModalId] = useState(null);

    //update
    const [updateModal, setUpdateModal] = useState(false);
    const [updateId, setUpdateId] = useState(null);

    //create
    const [createModal, setCreateModal] = useState(false);

    const [selectedProductId, setSelectedProductId] = useState(null);


    const handleTableRowClick = (productId) => {
        console.log("selected row with id:", productId)
        setSelectedProductId(productId);
    };

    const openUpdateModal2 = (productId, check) => {
        console.log("open modal for product: ", productId);
        check = true;
        setSelectedProductId(productId);
        setUpdateModal(check);
    };

    const deleteProduct2 = async (id) => {
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

    const openCreateModal = () => {
        setCreateModal(true);
    };

    const openUpdateModal = (productId) => {
        console.log('Opening update modal for product ID:', productId);
        setUpdateId(productId);
        setUpdateModal(true);
    };

    useEffect(() => {
        loadData();
    }, []);

    const loadData = async () => {
        try {
            await fetchApi();
            loadData2();
            setUpdateModal(false);
            setCreateModal(false);

        } catch (error) {
            console.error(error);
        }
    };

    const loadData2 = async () => {
        try {
            await fetchApi();
        } catch (error) {
            console.error(error);
        }
    };


    const openDetailModal = (productId) => {
        console.log('Opening detail modal for product ID:', productId);
        setModalId(productId);
        setModalShow(true);
    };

    const handleChange = (event) => {
        setDate(event?.target.value);
    };
    const handleChange2 = (event) => {
        setStartDate(event.target.value);
    };

    const handleChange3 = (event) => {
        setEndDate(event.target.value);
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
            setProductsSearch(fetchedProducts)
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
                {/*<input type="date" value={startDate} onChange={(e) => handleChange2(e)}/>*/}
                {/*<input type="date" value={endDate} onChange={(e) => handleChange3(e)}/>*/}

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
            <Button variant="outline-info" onClick={(evt) => openCreateModal()}>
                Create 2
            </Button>


            <Button variant="btn btn-danger" onClick={(evt) => openConfirmModal(selectedProductId)}>
                Delete
            </Button>


            <Button variant="outline-success" onClick={(evt) => openUpdateModal2(selectedProductId, updateModal)}>
                Update 2
            </Button>


            <table className="table product-table">
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
                <tbody  className={"selected-row"}>
                {/*{sortedProducts.map((product) => (*/}
                {productsSearch?.length === 0 ? (
                        <tr style={{backgroundColor: '#f2f2f2', textAlign: 'center'}}>
                            <td colSpan="9" style={{padding: '10px', fontSize: '30px', fontStyle: 'italic', color: 'red'}}>
                                No matching products found.
                            </td>
                        </tr>

                    ) :

                    (productsSearch?.map((product, index) => (
                            <tr
                                key={product.id}
                                onClick={() => handleTableRowClick(product.id)}
                            >

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
                                    {product.from && isValid(parse(product.from, 'yyyy-MM-dd', new Date()))
                                        ? format(parse(product.from, 'yyyy-MM-dd', new Date()), 'dd/MM/yyyy')
                                        : 'Invalid Date'}
                                </td>
                                <td>
                                    {product.to && isValid(parse(product.to, 'yyyy-MM-dd', new Date()))
                                        ? format(parse(product.to, 'yyyy-MM-dd', new Date()), 'dd/MM/yyyy')
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

                                    <Button variant="outline-success" onClick={(evt) => openUpdateModal(product.id)}>
                                        Update 2
                                    </Button>
                                </td>
                            </tr>
                        ))
                    )}
                </tbody>
            </table>
            <ModalComponent open={isConfirmModalOpen} onRequestClose={closeConfirmModal}
                            onClick={() => deleteProduct(deleteItemId)}/>

            <DetailModalComponent
                show={modalShow}
                onHide={(() => setModalShow(false))}
                id={modalId}
            />


            {/*<UpdateModalComponent*/}
            {/*    show={updateModal}*/}
            {/*    uid={updateId}*/}
            {/*    onLoad={loadData}*/}
            {/*    onHide={() => setUpdateModal(false)}*/}
            {/*/>*/}

            {/*<UpdateComponentTwo*/}
            {/*    show={selectedProductId !== null}*/}
            {/*    uid={selectedProductId}*/}
            {/*    onLoad={loadData}*/}
            {/*    onHide={() => setSelectedProductId(null)}*/}
            {/*/>*/}

            <UpdateComponentTwo
                show={updateModal == true && selectedProductId !== null}
                uid={selectedProductId}
                onLoad={loadData}
                onHide={() => { setSelectedProductId(null); setUpdateModal(false); }}
            />


            <CreateModalComponent
                show={createModal}
                onHide={(() => setCreateModal(false))}
                onLoad={loadData}
            />

            <ModalComponent open={isConfirmModalOpen} onRequestClose={closeConfirmModal}
                            onClick={() => deleteProduct2(selectedProductId)}/>


        </>

    );
}
