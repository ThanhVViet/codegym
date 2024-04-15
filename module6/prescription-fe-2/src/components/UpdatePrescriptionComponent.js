import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import React, {useEffect, useState} from "react";
import * as medicineService from "../services/MedicineService"
import * as prescriptionService from "../services/PrescriptionService";
import * as detailPrescriptionService from "../services/DetailPrescriptionService";
import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";



export function UpdatePrescriptionComponent(props) {
    const {uid} = props;
    const [medicines, setMedicines] = useState([]);
    const [prescription, setPrescription] = useState([]);

    const [data, setData] = useState({
        id: "",
        times: "",
        quantity: "",
        quantityPerTimes: " ",
        medicineId: " ",
        prescription: {
            name: "",
            target: 1,
            treatmentPeriod: "",
            note: "",
            symptom: {
                name: " "
            }


        },
        medicine: {
            id: " ",
            name: " "
        }


    });


    useEffect(() => {
        fetchData();
    }, [uid]);

    const fetchData = async () => {
        try {
            const [detailPrescriptionResult, medicineResult, prescriptionResult] = await Promise.all([
                detailPrescriptionService.findDetailPrescriptionById(uid),
                medicineService.findAllMedicine(),
                prescriptionService.findAll()
            ]);
            setData(detailPrescriptionResult);
            setMedicines(medicineResult);
            setPrescription(prescriptionResult)

        } catch (e) {
            console.error(e);
        }
    };
    const handleUpdate = async (detailPrescriptionEdited) => {
        console.log(detailPrescriptionEdited);
        try {
            await detailPrescriptionService.updateDetailPrescription(uid, detailPrescriptionEdited);
            await fetchData();
            toast.success(`🦁 Prescription "${detailPrescriptionEdited.name}" updated successfully!`, {
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
    if (data != null) {
        return (
            <>
                <Modal  {...props}>
                    <Modal.Header closeButton>
                        <Modal.Title>Update Prescription</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Formik
                            initialValues={{

                                // @JsonBackReference dat o doi tuong
                                // symptom: data.name,
                                // name: data.prescriptions?.[0]?.name,
                                // target: data.prescriptions?.[0]?.target,
                                // treatmentPeriod: data.prescriptions?.[0]?.treatmentPeriod,
                                // note: data.prescriptions?.[0]?.note,
                                // times: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.times,
                                // quantity: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantity,
                                // quantityPerTimes: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantityPerTimes,
                                // medicineId: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.medicine?.id,


                                detailPrescription: [
                                    {
                                        times: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.times.substring(0, 1),
                                        quantity: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantity.substring(0, 1),
                                        quantityPerTimes: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantityPerTimes.substring(0, 1),
                                        medicineId: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.medicine?.id
                                    },
                                    {
                                        times2: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.times.substring(2, 3),
                                        quantity2: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantity.substring(2, 3),
                                        quantityPerTimes2: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantityPerTimes.substring(2, 3),
                                        medicineId2: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.medicine?.id
                                    },
                                    {
                                        times3: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.times.substring(4, 5),
                                        quantity3: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantity.substring(4, 5),
                                        quantityPerTimes3: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantityPerTimes.substring(4, 5),
                                        medicineId3: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.medicine?.id
                                    },
                                    {
                                        times4: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.times.substring(6, 7),
                                        quantity4: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantity.substring(6, 7),
                                        quantityPerTimes4: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantityPerTimes.substring(6, 7),
                                        medicineId4: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.medicine?.id
                                    },
                                    {
                                        times5: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.times.substring(8, 9),
                                        quantity5: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantity.substring(8, 9),
                                        quantityPerTimes5: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantityPerTimes.substring(8, 9),
                                        medicineId5: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.medicine?.id
                                    },
                                    {
                                        times6: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.times.substring(10, 11),
                                        quantity6: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantity.substring(10, 11),
                                        quantityPerTimes6: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantityPerTimes.substring(10, 11),
                                        medicineId6: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.medicine?.id
                                    },
                                    {
                                        times7: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.times.substring(12, 13),
                                        quantity7: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantity.substring(12, 13),
                                        quantityPerTimes7: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.quantityPerTimes.substring(12, 13),
                                        medicineId7: data.prescriptions?.[0]?.detailPrescriptions?.[0]?.medicine?.id
                                    },

                                ],
                                prescription: {
                                    id: data.prescriptions?.[0]?.id,
                                    name: data.prescriptions?.[0]?.name,
                                    target: data.prescriptions?.[0]?.target,
                                    treatmentPeriod: data.prescriptions?.[0]?.treatmentPeriod,
                                    note: data.prescriptions?.[0]?.note,
                                    symptom: {
                                        name: data.name
                                    }
                                }




                                // times: data.times,
                                // quantity: data.quantity,
                                // quantityPerTimes: data.quantityPerTimes,
                                // id: data.prescription.id,
                                // name: data.prescription.name,
                                // target: data.prescription.target,
                                // treatmentPeriod: data.prescription.treatmentPeriod,
                                // note: data.prescription.note,
                                // symptom: data.prescription.symptom?.name,
                                // medicineId: data.medicine?.id


                                // times: data.times,
                                // quantity: data.quantity,
                                // quantityPerTimes: data.quantityPerTimes,
                                // prescription:{
                                //     id: data.prescription.id,
                                //     name: data.name,
                                //     target: data.prescription.target,
                                //     treatmentPeriod: data.prescription.treatmentPeriod,
                                //     note: data.prescription.note,
                                //     symptom: {
                                //         name: data.prescription.symptom?.name
                                //     }
                                // },
                                // medicineId: data.medicine?.id

                                // times: data.times,
                                // quantity: data.quantity,
                                // quantityPerTimes: data.quantityPerTimes,
                                // medicineId: data.medicine?.id


                            }}
                            onSubmit={(values) => handleUpdate(values)}

                        >
                            <Form>
                                <Field type="hidden" name="id" id="id" className="form-control"/>
                                <div className="mb-3">
                                    <label htmlFor="name" className="form-label">
                                        Tên Toa Thuốc
                                    </label>
                                    <Field type="text" name="prescription.name" id="name" className="form-control"
                                           autoFocus/>
                                    <ErrorMessage name="name" component="div" className="error-message"/>
                                </div>


                                <div className="mb-3">
                                    <label htmlFor="category" className="form-label">
                                        Đối tượng
                                    </label>
                                    <Field
                                        name="prescription.target"
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
                                    <Field type="text" name="prescription.symptom.name" className="form-control"/>
                                    <ErrorMessage name="symptom" component="div" className="error-message"/>
                                </div>


                                <div className="mb-3">
                                    <label htmlFor="treatment_period" className="form-label">
                                        Số ngày uống
                                    </label>
                                    <Field type="text" name="prescription.treatmentPeriod" className="form-control"/>
                                    <ErrorMessage name="treatmentPeriod" component="div" className="error-message"/>
                                </div>
                                <div className="mb-3">
                                    <label htmlFor="note" className="form-label">
                                        Ghi chú
                                    </label>
                                    <Field type="text" name="prescription.note" id="note" className="form-control"/>
                                </div>
                                <fieldset>
                                    <legend className="w-auto">
                                        Chỉ định
                                    </legend>

                                    <div className="form-group slay">
                                        <div className="slay3">
                                            <label htmlFor="applicable-object" className="form-label">1.</label>
                                        </div>
                                        <Field name="medicineId" as="select" className="form-select slay4">
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option value={(medicine.id)}>{medicine.name}</option>
                                            ))}
                                        </Field>

                                        <div className="slay5">
                                            <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                                   id="quantity3"
                                                   type="text"
                                                   name="detailPrescription.[0].quantity"/>
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
                           name="detailPrescription.[0].times"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="detailPrescription.[0].quantityPerTimes"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                    </div>
                                    ={/*2*/}
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
                                                   name="detailPrescription.[1].quantity2"/>
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
                           name="detailPrescription.[1].times2"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="detailPrescription.[1].quantityPerTimes2"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                    </div>
                                    {/*3*/}
                                    <div className="form-group slay">
                                        <div className="slay3">
                                            <label htmlFor="applicable-object" className="form-label">3.</label>
                                        </div>
                                        <Field name="medicineId" as="select" className="form-select slay4">
                                            <option value=" ">chọn thuốc</option>
                                            {medicines?.map((medicine) => (
                                                <option value={(medicine.id)}>{medicine.name}</option>
                                            ))}
                                        </Field>

                                        <div className="slay5">
                                            <Field style={{height: '38px', width: '38px', textAlign: 'center'}}
                                                   id="quantity3"
                                                   type="text"
                                                   name="detailPrescription.[2].quantity3"/>
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
                           name="detailPrescription.[2].times3"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="detailPrescription.[2].quantityPerTimes3"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                    </div>

                                    {/*4*/}

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
                                                   name="detailPrescription.[3].quantity4"/>
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
                           name="detailPrescription.[3].times4"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="detailPrescription.[3].quantityPerTimes4"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                    </div>

                                    {/*5*/}

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
                                                   name="detailPrescription.[4].quantity5"/>
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
                           name="detailPrescription.[4].times5"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="detailPrescription.[4].quantityPerTimes5"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                    </div>

                                    {/*6*/}

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
                                                   name="detailPrescription.[5].quantity6"/>
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
                           name="detailPrescription.[5].times6"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="detailPrescription.[5].quantityPerTimes6"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                    </div>


                                    {/*7*/}

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
                                                   name="detailPrescription.[6].quantity7"/>
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
                           name="detailPrescription.[6].times7"/>
                    <label className="form-label" htmlFor="quantity1" style={{marginLeft: '2px'}}>lần</label>
                </span>, mỗi lần uống <span>
                    <Field style={{height: '38px', width: '38px', textAlign: 'center'}} type="text"
                           name="detailPrescription.[6].quantityPerTimes7"/>
                    <label className="form-label" htmlFor="quantity2" style={{marginLeft: '2px'}}>viên</label>
                </span></p>
                                    </div>


                                </fieldset>


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
        )
            ;
    }
}
