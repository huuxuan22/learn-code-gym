import {Modal,Button} from "react-bootstrap"

function ModalDelete ({show,setShow,product}) {

    const handleClose = () => {
        setShow(false);
    }

    const handleSubmit = () => {
        
    }

    return (
        <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Modal heading</Modal.Title>
        </Modal.Header>
        <Modal.Body>Banj co muon xoa san pham {product.ten}</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSubmit}>
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>
    )
}

export default ModalDelete;