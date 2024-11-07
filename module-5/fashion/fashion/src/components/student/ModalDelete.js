import Modal from "react-bootstrap/Modal";
import { toast } from "react-toastify";
import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import * as studentService from "../../service/student-service"
import { ToastContainer } from 'react-toastify';


function ModalDelete({show,setShow,student,getAllStudent}) {
    
    const handleClose = () => setShow(false)
    const handleDeleteStudent = () => {

        studentService.deleteStudent(student.id).then(() => {
            handleClose();
            getAllStudent();
            toast.success(`Sinh viên ${student.name} đã bị xóa`);
        }) 
            
        
    }


    return(
        <div>
            <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
            <Modal.Title>Modal title</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                Bạn có muốn xóa học sinh {student.name}
            </Modal.Body>
            <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
                Close
            </Button>
            <Button variant="btn btn-outline-danger"
                    onClick = {handleDeleteStudent}
                >Delete
            </Button>
            </Modal.Footer>
            </Modal>
        </div>
    )
}

export default ModalDelete;