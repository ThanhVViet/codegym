import React, {useState} from 'react';
import * as yup from 'yup';
import {useFormik} from "formik";
import "bootstrap/dist/css/bootstrap.css"
import book from "./model/book";
import "./App.css";

const formSchema = yup.object().shape({
    title: yup.string().required('Required'),
    quantity: yup.number().required('Required').positive().integer()
});

function App() {
    const initBooks: book[] = [
        {
            title: 'C# concept',
            quantity: 5
        },
        {
            title: 'Java introduction',
            quantity: 2
        }
    ];

    const [books, setBooks] = useState(initBooks);

    const formik = useFormik({
        initialValues: {
            title: '',
            quantity: 0
        },
        validationSchema: formSchema,
        onSubmit: (values) => {
            setBooks((prevState) => [...prevState, values])
        }
    });

    const handleDelete = (index: number) => {
        const updatedBooks = [...books];
        updatedBooks.splice(index, 1);
        setBooks(updatedBooks);
    }

    const handleEdit = (b: book, i: number) => {
        formik.values.title = 'a';
        formik.values.quantity =1;
        alert('111')
    }

    return (
        <div>
            <h1>Library Form</h1>
            <form onSubmit={formik.handleSubmit}>
                <div className="form-group">
                    <label>Title</label>
                    <input name="title" value={formik.values.title} onChange={formik.handleChange} className={
                        'form-control' +
                        (formik.errors.title && formik.touched.title
                            ? ' is-invalid'
                            : '')
                    }
                    />
                    <div className="invalid-feedback">
                        {formik.errors.title && formik.touched.title
                            ? formik.errors.title
                            : null}
                    </div>
                </div>

                <div className="form-group">
                    <div>Quantity</div>
                    <input name="quantity" value={formik.values.quantity} onChange={formik.handleChange} className={
                        'form-control' +
                        (formik.errors.quantity && formik.touched.quantity
                            ? ' is-invalid'
                            : '')
                    }
                    />
                    <div className="invalid-feedback">
                        {formik.errors.quantity && formik.touched.quantity
                            ? formik.errors.quantity
                            : null}
                    </div>
                </div>

                <div className="mt-3">
                    <button type="submit" className="btn btn-primary">Submit</button>
                </div>
            </form>
            <table className="table table-hover">
                <thead>
                <tr>
                    <td className="w-50">TITLE</td>
                    <td>QUANTITY</td>
                    <td className="action1">ACTION</td>
                </tr>
                </thead>
                <tbody className='table-group-divider'>
                {
                    books.map((b, i) => (
                        <tr key={b.title}>
                            <td>{b.title}</td>
                            <td>{b.quantity}</td>
                            <td className="action">
                                <button onClick={() => handleEdit(b,i)}>Edit</button>
                                <button onClick={() => handleDelete(i)}>Delete</button>
                            </td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </div>
    );
}

export default App;
