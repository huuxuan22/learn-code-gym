import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import * as baiHatService from "./../service/baihat-service"
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';
function Update({show,setShow,baiHat,getAllBaiHats}) {

  const handleClose = () => setShow(false);
  const navigate = useNavigate()
  const handleUpdate = () => {
    console.log(baiHat);
    
    const newBaiHat = {...baiHat,trangThai: {id: 2, name: "Công khai"}} ;
    console.log("đây là trạng thái mới");
    
    console.log(newBaiHat);
    
    baiHatService.update(newBaiHat).then(() => {
        
        toast.success("Cảm ơn anh chánh đã chia sẻ bài hát");
        getAllBaiHats("")
        setShow(false);
    })
  }
  
    return (
        <div>
            <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Modal heading</Modal.Title>
        </Modal.Header>
        <Modal.Body>Bạn có muốn mở công khai {baiHat.name} cho mọi người cùng nge ???</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            nâu nâu
          </Button>
          <Button variant="success" onClick={() => handleUpdate()}>
            chắc chắn
          </Button>
        </Modal.Footer>
      </Modal>
        </div>
    )
}

export default Update;