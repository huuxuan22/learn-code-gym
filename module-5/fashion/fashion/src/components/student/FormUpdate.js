import { Modal } from "react-bootstrap";
import InputGroup from 'react-bootstrap/InputGroup';
import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import { Form , Field, Formik } from "formik"; // Sử dụng FormikForm thay cho react-bootstrap Form
import * as studentService from "../../service/student-service";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import * as classService from "../../service/class-service"
import { data } from "autoprefixer";

function FormUpdate({  student,showUpdate,setShowUpdate }) {
    const navigate = useNavigate();
    const [studentUpdate,setStudentUpdate] = useState({
        id: student.id,
        name: student.name,
        age:student.age,
        point:student.point,
        class: student.class
    })
    const [clazzes,setClazzes] = useState();

    const getAllClass = (name) => {
         classService.getAllClass(name).then((data) => {
            setClazzes(data);
        })
    } 
    
    useEffect(()=> {
        getAllClass("");
        
    },[])

    
    

    const handleClose = () => {
        setShowUpdate(false);
    }


    const handleSubmit =async (values) => {
        console.log(values)
        // const updatedStudent = {
        //     ...values,
        //     class: clazzes.find(c => c.id === parseInt(values.class)) // Tìm lớp học từ ID
        // };
        // await studentService.updateStudent(updatedStudent).then(() => {
        //     toast.success("Bạn đã cập nhật thành công");
        //     navigate("/");
        // });
    }

    return (
        <div >
            <Formik
                initialValues={studentUpdate}
                onSubmit={handleSubmit}
            >
                <Form>
                         <Modal show={showUpdate} onHide={handleClose}>
                            <Modal.Header closeButton>
                            <Modal.Title>Modal heading</Modal.Title>
                            </Modal.Header>
                            <Modal.Body>
                                    <div>
                                        Tên sinh viên:
                                        <Field name="name"></Field>
                                    </div>
                                    <div>
                                        Tuổi
                                        <Field name="age"></Field>
                                    </div>
                                    <div>
                                        Point
                                    
                                        <Field name="point" as="select">
                                            <option value="1"> 1</option>
                                            <option value="1"> 2</option>
                                            <option value="3"> 3</option>
                                            <option value="4"> 4</option>
                                            <option value="5"> 5</option>
                                            <option value="6"> 6</option>
                                            <option value="7"> 7</option>
                                            <option value="8"> 8</option>
                                            <option value="9"> 9</option>
                                            <option value="10"> 10</option>

                                        </Field>
                                    </div>
                                    <div>
                                        Class:
                                        <Field name="class" as="select">
                                            {clazzes &&clazzes.map(clazz => (
                                                <option key={clazz.id} value={clazz.id}>
                                                    {clazz.name}
                                                </option>
                                            ))}
                                        </Field>
                                    </div>
                                   

                            </Modal.Body>
                            <Modal.Footer>
                            <Button variant="outline-secondary" onClick={handleClose}>
                                Close
                            </Button>
                            <Button variant="outline-primary" >
                                Save Changes
                            </Button>
                            </Modal.Footer>
                        </Modal>
                </Form>
            </Formik>
        </div>
    );
}

export { FormUpdate };
