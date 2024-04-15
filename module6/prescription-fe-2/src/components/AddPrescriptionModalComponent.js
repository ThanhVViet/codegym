import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import React, {useEffect, useState} from "react";
import * as medicineService from "../services/MedicineService"
import * as prescriptionService from "../services/PrescriptionService";
import * as detailPrescriptionService from "../services/DetailPrescriptionService";

import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";


export default function AddPrescriptionModalComponent(props) {
    const [medicines, setMedicines] = useState([])

    useEffect(() => {
        findAll();
    }, []);
    const findAll = async () => {
        const result = await medicineService.findAllMedicine();
        setMedicines(result);
    }

    const [formData, setFormData] = useState({
        medicineId: '',
        quantity5: '',
        times5: '',
        quantityPerTimes5: ''
    });

    const handleClearForm = () => {
        setFormData({
            medicineId: '',
            quantity5: '',
            times5: '',
            quantityPerTimes5: ''
        });
    };


    return (
        <>
            <Formik initialValues={{
                name: "",
                target: 1,
                treatmentPeriod: "",
                note: "",
                symptom: "",
                medicineId: "T00001",
                // times: "",
                // quantity: "",
                // quantityPerTimes: "",
                detailPrescription: [
                    {times: "", quantity: "", quantityPerTimes: ""},
                    {times2: "", quantity2: "", quantityPerTimes2: ""},
                    {times3: "", quantity3: "", quantityPerTimes3: ""},
                    {times4: "", quantity4: "", quantityPerTimes4: ""},
                    {times5: "", quantity5: "", quantityPerTimes5: ""},
                    {times6: "", quantity6: "", quantityPerTimes6: ""},
                    {times7: "", quantity7: "", quantityPerTimes7: ""}
                ]

            }}
                    validationSchema={Yup.object().shape({
                        name: Yup.string().required('Name is required'),
                        target: Yup.number().required('Target is required'),
                        symptom: Yup.string().required('Symptom is required'),
                        treatmentPeriod: Yup.string().required('Treatment period is required'),
                    })}
                    onSubmit={(values, {setSubmitting}) => {
                        const createPrescription = async () => {
                            try {

                                const detailPrescription = {
                                    prescription: {
                                        name: values.name,
                                        target: values.target,
                                        treatmentPeriod: values.treatmentPeriod,
                                        note: values.note,
                                        symptom: {
                                            name: values.symptom
                                        }
                                    },
                                    medicineId: values.medicineId,
                                    // times: values.times,
                                    // quantity: values.quantity,
                                    // quantityPerTimes: values.quantityPerTimes,
                                    detailPrescription: [
                                        {
                                            times: values.times,
                                            quantity: values.quantity,
                                            quantityPerTimes: values.quantityPerTimes
                                        },
                                        {
                                            times2: values.times2,
                                            quantity2: values.quantity2,
                                            quantityPerTimes2: values.quantityPerTimes2
                                        },
                                        {
                                            times3: values.times3,
                                            quantity3: values.quantity3,
                                            quantityPerTimes3: values.quantityPerTimes3
                                        },
                                        {
                                            times4: values.times4,
                                            quantity4: values.quantity4,
                                            quantityPerTimes4: values.quantityPerTimes4
                                        },
                                        {
                                            times5: values.times5,
                                            quantity5: values.quantity5,
                                            quantityPerTimes5: values.quantityPerTimes5
                                        },
                                        {
                                            times6: values.times6,
                                            quantity6: values.quantity6,
                                            quantityPerTimes6: values.quantityPerTimes6
                                        },
                                        {
                                            times7: values.times7,
                                            quantity7: values.quantity7,
                                            quantityPerTimes7: values.quantityPerTimes7
                                        }
                                    ]

                                };
                                console.log(detailPrescription)

                                await detailPrescriptionService.createDetailPrescription(detailPrescription);

                                toast.success('Create prescription successful!');
                            } catch (error) {
                                toast.error('Error creating prescription');
                            } finally {
                                setSubmitting(false);

                            }
                        };
                        createPrescription();
                    }}>

                <Modal
                    {...props}
                    size="lg"
                    aria-labelledby="contained-modal-title-vcenter"
                    centered
                >
                    <Form>
                        <Modal.Header closeButton className="bg-success text-white">
                            <Modal.Title id="contained-modal-title-vcenter">
                                Thêm Toa Thuốc
                            </Modal.Title>
                        </Modal.Header>
                        <Modal.Body>

                            <div className="mb-3">
                                <label htmlFor="name" className="form-label">
                                    Tên Toa Thuốc
                                </label>
                                <Field type="text" name="name" id="name" className="form-control" autoFocus/>
                                <ErrorMessage name="name" component="div" className="error-message"/>
                            </div>


                            <div className="mb-3">
                                <label htmlFor="category" className="form-label">
                                    Đối tượng
                                </label>
                                <Field
                                    name="target"
                                    as="select"
                                    className="form-select"
                                >
                                    <option value="1">Người lớn</option>
                                    <option value="2">Trẻ em</option>
                                    <option value="3">Phụ nữ mang thai</option>
                                </Field>
                            </div>

                            <div className="mb-3">
                                <label htmlFor="quantity" className="form-label">
                                    Triệu chứng
                                </label>
                                <Field type="text" name="symptom" className="form-control"/>
                                <ErrorMessage name="symptom" component="div" className="error-message"/>
                            </div>


                            <div className="mb-3">
                                <label htmlFor="treatment_period" className="form-label">
                                    Số ngày uống
                                </label>
                                <Field type="text" name="treatmentPeriod" className="form-control"/>
                                <ErrorMessage name="treatmentPeriod" component="div" className="error-message"/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="note" className="form-label">
                                    Ghi chú
                                </label>
                                <Field type="text" name="note" id="note" className="form-control"/>
                            </div>
                            <fieldset>
                                <legend className="w-auto">
                                    Chỉ định
                                </legend>

                                <div className="form-group slay">
                                    <div className="slay3">
                                        <label htmlFor="applicable-object" className="form-label">1.</label>
                                    </div>
                                    <div className="slay4">
                                        <select name="medicineId" className="form-select">
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option key={medicine.id} value={medicine.id}>
                                                    {medicine.name}
                                                </option>
                                            ))}
                                        </select>
                                    </div>

                                    <div className="slay5">
                                        <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                               id="quantity3"
                                               type="text"
                                               name="quantity"/>
                                        <label className="form-label" htmlFor="quantity3"
                                               style={{marginLeft: '2px'}}>viên</label>
                                    </div>

                                    <div className="slay6">
                                        <button><i className="bi bi-trash3-fill"></i></button>
                                    </div>

                                </div>
                                <div className="slay7">
                                    <p>Ngày uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="times"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="quantityPerTimes"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                </div>

                                {/*2*/}

                                <div className="form-group slay">
                                    <div className="slay3">
                                        <label htmlFor="applicable-object" className="form-label">2.</label>
                                    </div>
                                    <div className="slay4">
                                        <select name="medicineId" className="form-select">
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option key={medicine.id} value={medicine.id}>
                                                    {medicine.name}
                                                </option>
                                            ))}
                                        </select>
                                    </div>

                                    <div className="slay5">
                                        <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                               id="quantity2"
                                               type="text"
                                               name="quantity2"/>
                                        <label className="form-label" htmlFor="quantity3"
                                               style={{marginLeft: '2px'}}>viên</label>
                                    </div>

                                    <div className="slay6">
                                        <button><i className="bi bi-trash3-fill"></i></button>
                                    </div>

                                </div>
                                <div className="slay7">
                                    <p>Ngày uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="times2"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="quantityPerTimes2"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                </div>

                                {/*3*/}

                                <div className="form-group slay">
                                    <div className="slay3">
                                        <label htmlFor="applicable-object" className="form-label">3.</label>
                                    </div>
                                    <div className="slay4">
                                        <select name="medicineId" className="form-select">
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option key={medicine.id} value={medicine.id}>
                                                    {medicine.name}
                                                </option>
                                            ))}
                                        </select>
                                    </div>

                                    <div className="slay5">
                                        <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                               id="quantity3"
                                               type="text"
                                               name="quantity3"/>
                                        <label className="form-label" htmlFor="quantity3"
                                               style={{marginLeft: '2px'}}>viên</label>
                                    </div>

                                    <div className="slay6">
                                        <button><i className="bi bi-trash3-fill"></i></button>
                                    </div>

                                </div>
                                <div className="slay7">
                                    <p>Ngày uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="times3"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="quantityPerTimes3"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                </div>

                                {/*4*/}

                                <div className="form-group slay">
                                    <div className="slay3">
                                        <label htmlFor="applicable-object" className="form-label">4.</label>
                                    </div>
                                    <div className="slay4">
                                        <select name="medicineId" className="form-select">
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option key={medicine.id} value={medicine.id}>
                                                    {medicine.name}
                                                </option>
                                            ))}
                                        </select>
                                    </div>

                                    <div className="slay5">
                                        <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                               id="quantity3"
                                               type="text"
                                               name="quantity4"/>
                                        <label className="form-label" htmlFor="quantity3"
                                               style={{marginLeft: '2px'}}>viên</label>
                                    </div>

                                    <div className="slay6">
                                        <button><i className="bi bi-trash3-fill"></i></button>
                                    </div>

                                </div>
                                <div className="slay7">
                                    <p>Ngày uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="times4"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="quantityPerTimes4"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                </div>

                                {/*5*/}

                                <div className="form-group slay">
                                    <div className="slay3">
                                        <label htmlFor="applicable-object" className="form-label">5.</label>
                                    </div>
                                    <div className="slay4">
                                        <select name="medicineId" className="form-select"
                                                value={formData.medicineId}
                                                onChange={(e) => setFormData({ ...formData, medicineId: e.target.value })}
                                        >
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option key={medicine.id} value={medicine.id}>
                                                    {medicine.name}
                                                </option>
                                            ))}
                                        </select>
                                    </div>

                                    <div className="slay5">
                                        <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                               id="quantity3"
                                               type="text"
                                               name="quantity5"
                                               value={formData.quantity5}
                                               onChange={(e) => setFormData({ ...formData, quantity5: e.target.value })}
                                        />
                                        <label className="form-label" htmlFor="quantity3"
                                               style={{marginLeft: '2px'}}>viên</label>
                                    </div>

                                    <div className="slay6">
                                        <button onClick={handleClearForm}><i className="bi bi-trash3-fill"></i></button>
                                    </div>

                                </div>
                                <div className="slay7">
                                    <p>Ngày uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="times5"
                           value={formData.times5}
                           onChange={(e) => setFormData({ ...formData, times5: e.target.value })}
                    />
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="quantityPerTimes5"
                           value={formData.quantityPerTimes5}
                           onChange={(e) => setFormData({ ...formData, quantityPerTimes5: e.target.value })}
                    />
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                </div>


                                {/*6*/}

                                <div className="form-group slay">
                                    <div className="slay3">
                                        <label htmlFor="applicable-object" className="form-label">6.</label>
                                    </div>
                                    <div className="slay4">
                                        <select name="medicineId" className="form-select">
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option key={medicine.id} value={medicine.id}>
                                                    {medicine.name}
                                                </option>
                                            ))}
                                        </select>
                                    </div>

                                    <div className="slay5">
                                        <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                               id="quantity3"
                                               type="text"
                                               name="quantity6"/>
                                        <label className="form-label" htmlFor="quantity3"
                                               style={{marginLeft: '2px'}}>viên</label>
                                    </div>

                                    <div className="slay6">
                                        <button><i className="bi bi-trash3-fill"></i></button>
                                    </div>

                                </div>
                                <div className="slay7">
                                    <p>Ngày uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="times6"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="quantityPerTimes6"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                </div>

                                {/*7*/}

                                <div className="form-group slay">
                                    <div className="slay3">
                                        <label htmlFor="applicable-object" className="form-label">7.</label>
                                    </div>
                                    <div className="slay4">
                                        <select name="medicineId" className="form-select">
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option key={medicine.id} value={medicine.id}>
                                                    {medicine.name}
                                                </option>
                                            ))}
                                        </select>
                                    </div>

                                    <div className="slay5">
                                        <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                               id="quantity3"
                                               type="text"
                                               name="quantity7"/>
                                        <label className="form-label" htmlFor="quantity3"
                                               style={{marginLeft: '2px'}}>viên</label>
                                    </div>

                                    <div className="slay6">
                                        <button><i className="bi bi-trash3-fill"></i></button>
                                    </div>

                                </div>
                                <div className="slay7">
                                    <p>Ngày uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="times7"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="quantityPerTimes7"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                </div>
                            </fieldset>

                        </Modal.Body>
                        <Modal.Footer className="bg-light">
                            <div className="group-button">
                                <div className="mb-3 d-flex justify-content-center gr1 btn1">
                                    <Button onClick={props.onHide} className="btn btn-info custom-button">
                                        Back
                                    </Button>
                                </div>


                                <div className="mb-3 d-flex justify-content-center gr2">
                                    <button onClick={props.onLoad} type="submit" className="btn btn-primary">
                                        Submit
                                    </button>
                                </div>
                            </div>
                        </Modal.Footer>
                    </Form>
                </Modal>
            </Formik>
        </>
    );

}
