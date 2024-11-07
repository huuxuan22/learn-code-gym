import { useEffect, useState } from 'react';
import Table from 'react-bootstrap/Table';
import * as baiHatService from "../service/baihat-service"
import { Link } from 'react-router-dom';
import "./form.css"
import Update from './Update';
const List = () => {
    const [showMusic,setShowMusic] = useState();
    const [showTitle,setShowTitle] = useState(false);
    const [show,setShow] = useState(false);
    const [baiHats,setBaiHats] = useState();
    const [baiHat,setBaihat] = useState({});
    const getAllBaiHats = (name) => {
        baiHatService.getAllBaiHat(name).then((data) => {
            setBaiHats(data)
        })
    }
    useEffect(() => {
        getAllBaiHats("");
    },[])
    if (!baiHats) {
        return <div>.....loading</div>
    }

    const handleUpdate = (values) => {
        setBaihat(values)
        setShow(true);
    }
    const handleShow = (values) => {
        setShowTitle(true)
        setShowMusic(values);
    }
    return (
        <div>
            {(showMusic && showTitle) ? <div className='show-music'>{showMusic.name}<br/> {showMusic.caSi}</div>  : <div></div>}
            <Link to='/create' className='btn btn-outline-info'>Đăng ký bài hát</Link>
            <Table striped bordered hover>
                <thead>
                    <tr>
                    <th>stt</th>
                    <th>Tên bài hát</th>
                    <th>Ca sĩ</th>
                    <th>thời gian phát</th>
                    <th>Số lượt yêu thích</th>
                    <th>Trạng thái</th>
                    <th>Chức năng</th>
                    </tr>
                </thead>
                <tbody>
                    {baiHats?.map((item) => (
                        <tr key={item.id} onClick={() => handleShow(item)}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td>{item.caSi}</td>
                            <td>{item.thoiGianPhat}</td>
                            <td>{item.soLuotYeuThich}</td>
                            <td>{item.trangThai.name}</td>
                            <td><button className='btn btn-outline-info' onClick={() => handleUpdate(item)}>Công khai</button></td>
                        </tr>
                    ))}
                </tbody>
                </Table>

                <Update
                    show={show}
                    setShow={setShow}
                    baiHat={baiHat}
                    getAllBaiHats={getAllBaiHats}
                />
        </div>
    )
}
export default List;