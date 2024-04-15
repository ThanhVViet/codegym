import React, {useEffect, useState} from 'react';
import AddPrescriptionModalComponent from "./AddPrescriptionModalComponent";
import * as prescriptionService from "../services/PrescriptionService";
import * as symptomService from "../services/SymptomService"
import * as detailPrescriptionService from "../services/DetailPrescriptionService";

import PropTypes from "prop-types";
import {UpdatePrescriptionComponent} from "./UpdatePrescriptionComponent";

AddPrescriptionModalComponent.propTypes = {
    show: PropTypes.bool.isRequired,
    onHide: PropTypes.func.isRequired,
    id: PropTypes.number.isRequired,
};

function ListPrescriptionComponent() {
    const [prescriptions, setPrescriptions] = useState([]);
    const [detailPrescriptions, setDetailPrescriptions] = useState([]);
    const [symptoms, setSymptoms] = useState([]);

    const [createModal, setCreateModal] = useState(false);
    const [updateModal, setUpdateModal] = useState(false);


    const [currentPage, setCurrentPage] = useState(1);
    const recordsPerPage = 5;
    const lastIndex = currentPage * recordsPerPage;
    const firstIndex = lastIndex - recordsPerPage;
    const records = symptoms.slice(firstIndex, lastIndex);
    const npage = Math.ceil(symptoms.length / recordsPerPage);
    const numbers = [...Array(npage + 1).keys()].slice(1);


    const [selectedPrescriptionId, setSelectedPrescriptionId] = useState(null);

    const openCreateModal = () => {
        setCreateModal(true);
    };

    useEffect(() => {
        fetchApi();
    }, []);

    const handleClick = (prescriptionId) => {
        console.log("id selected:", prescriptionId);
        setSelectedPrescriptionId(prescriptionId);
    }


    const fetchApi = async () => {
        try {
            const fetchedProducts = await prescriptionService.findAll();
            setPrescriptions(fetchedProducts);

            const fetchedPrescriptions = await detailPrescriptionService.findAll();
            setDetailPrescriptions(fetchedPrescriptions);

            const fetchedSymptoms = await symptomService.findAllSymptom();
            setSymptoms(fetchedSymptoms);

        } catch (error) {
            if (!error.response) {
                this.errorStatus = 'Error: Network Error';
            } else {
                this.errorStatus = error.response.data.message;
            }
        }
    };

    const display = (target) => {
        switch (target) {
            case '1':
                return 'Người lớn';
            case '2':
                return 'Trẻ em';
            case '3':
                return 'Phụ nữ mang thai';
            default:
                return 'Unknown Target';
        }
    };

    const loadData = async () => {
        try {
            await fetchApi();
            setCreateModal(false);
            setUpdateModal(false);

        } catch (error) {
            console.error(error);
        }
    };

    const openUpdateModal = (prescriptionId, check) => {
        console.log("open modal for prescription: ", prescriptionId);
        check = true;
        setSelectedPrescriptionId(prescriptionId);
        setUpdateModal(check);
    };


    return (
        <>

            <div className="main-right">
                <div className="container">
                    <fieldset className="border p-2">
                        <legend className="w-auto">Bộ lọc</legend>

                        <div className="alo">
                            <div className="select-filter form-group">
                                <label>Lọc theo</label>
                                <select style={{border: '1px solid', height: '40px'}} name="cars" id="medicals">
                                    <option value="code">Mã toa thuốc</option>
                                    <option value="saab">Tên toa thuốc</option>
                                    <option value="opel">Đối tượng</option>
                                    <option value="audi">Triệu chứng</option>
                                </select>
                            </div>

                            <div className="search-button">
                                <form action="">
                                    <input
                                        style={{border: '1px solid', height: '40px', width: '250px', marginLeft: '5px'}}
                                        type="search"
                                        name=""
                                        placeholder="search here..." id="search-box"/>
                                    <button style={{height: '40px', fontSize: '15px', marginBottom: '16px'}}
                                            type="submit"
                                            className="btn btn-primary">Lọc kết quả
                                    </button>
                                </form>
                            </div>

                            <div className="sort">
                                <label style={{marginLeft: '50px'}} htmlFor="sort">Sắp xếp</label>
                                <select style={{border: '1px solid', height: '40px'}} name="sort" id="sort">
                                    <option value="code">Mã toa thuốc</option>
                                    <option value="saab">Tên toa thuốc</option>
                                    <option value="opel">Đối tượng</option>
                                    <option value="audi">Triệu chứng</option>
                                </select>
                            </div>
                        </div>

                    </fieldset>
                    <br/>
                    <fieldset className="border p-2">
                        <legend className="w-auto">Danh sách toa thuốc</legend>
                        <table className="table table-bordered">
                            <thead>
                            <tr>
                                <th>Mã toa thuốc</th>
                                <th>Tên toa thuốc</th>
                                <th>Đối tượng</th>
                                <th>Triệu chứng</th>
                                <th>Ghi chú</th>
                            </tr>
                            </thead>
                            <tbody>
                            {/*@JsonBackReference dat o doi tuong*/}
                            {records?.map((symptom, symptomIndex) => (
                                symptom.prescriptions?.map((prescription, prescriptionIndex) => (
                                    prescription.detailPrescriptions?.map((detailPrescription, detailPrescriptionIndex) => (
                                        <tr
                                            key={`${symptom.id}-${prescription.id}-${detailPrescription.id}`}
                                            onClick={() => {
                                                handleClick(detailPrescription.id)
                                            }}
                                        >
                                            <td>{prescription.id}</td>
                                            <td>{prescription.name}</td>
                                            <td>{display(prescription.target)}</td>
                                            <td>{symptom.name}</td>
                                            <td>{prescription.note}</td>
                                        </tr>
                                    ))
                                ))
                            ))}

                            {/*{detailPrescriptions?.map((detailPrescription, detailPrescriptionIndex) => (*/}
                            {/*    <tr key={detailPrescription.id}*/}
                            {/*        onClick={() => handleClick(detailPrescription.id)}*/}
                            {/*    >*/}
                            {/*        {prescriptions.map((prescription, index) => {*/}
                            {/*            if (prescription.id === detailPrescription.prescription.id) {*/}
                            {/*                return (*/}
                            {/*                    // Render prescription data*/}
                            {/*                    <React.Fragment key={prescription.id}>*/}
                            {/*                        <td>{prescription.id}</td>*/}
                            {/*                        <td>{prescription.name}</td>*/}
                            {/*                        <td>{prescription.target}</td>*/}
                            {/*                        <td>{prescription.symptom.name}</td>*/}
                            {/*                        <td>{prescription.note}</td>*/}
                            {/*                    </React.Fragment>*/}
                            {/*                );*/}
                            {/*            }*/}
                            {/*            return null;*/}
                            {/*        })}*/}
                            {/*    </tr>*/}
                            {/*))}*/}


                            </tbody>

                        </table>
                    </fieldset>


                    <div className="action">
                        <button type="button" onClick={(evt) => openCreateModal()}
                                className="btn btn-primary"><span
                            className="em-1"><i className="bi bi-plus-circle"></i></span>Thêm
                        </button>
                        <button type="button" onClick={() => openUpdateModal(selectedPrescriptionId, updateModal)}
                                className="btn btn-info"><span
                            className="em-1"><i className="bi bi-pencil-square"></i></span> Sửa
                        </button>
                        <button type="button" data-bs-toggle="modal" data-bs-target="#delete"
                                className="btn btn-danger"><span
                            className="em-1"><i className="bi bi-x-circle"></i></span> Xoá
                        </button>
                    </div>
                </div>
            </div>

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

            <AddPrescriptionModalComponent
                show={createModal}
                onHide={(() => setCreateModal(false))}
                onLoad={loadData}
            />
            <UpdatePrescriptionComponent
                show={updateModal === true && selectedPrescriptionId !== null}
                uid={selectedPrescriptionId}
                onLoad={loadData}
                onHide={() => {
                    setUpdateModal(false);
                }}
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

export default ListPrescriptionComponent;
