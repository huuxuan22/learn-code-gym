import { useEffect, useState } from "react";
import {Table,Button} from "react-bootstrap"
import ModalDelete from "./ModalDelete";
import { Link, useNavigate } from "react-router-dom";
import "./form.css"
import * as productsService from "../component/service/product-service"
import * as typeService from "../component/service/type-service"
import { Field } from "formik";

const List = () => {
    const [show,setShow] = useState(false);
    const [products,setProducts] = useState();
    const [product,setProduct] = useState();
    const [types,setTypes] = useState();
    const [values,setValues] = useState('');
    const navigate = useNavigate();

    const getAllProduct = (name) => {
         productsService.getAllProduct(name).then((data) => {
            setProducts(data);
        })
    }


    useEffect(()=> {
        getAllProduct("")
    },[])


    // useEffect(() => {
    //     typeService.getAllType("").then((data) => {
    //         setTypes(data)
    //     })
    // },)

    
    const handleInputChange =  (event) => {
         setValues(event.target.value);
        console.log(event.target.value);
        
    }
    const handleSearch = () => {
        getAllProduct(values)
    }
    const handleSearchByType = () => {

    }
    return (
            <div>
                <input 
                    type="text"
                    className='input-field' 
                    placeholder="Search" 
                    onChange={handleInputChange}/>
                    <button className='btn btn-outline-dark' onClick={handleSearch}>timf kiem</button>
                    <Link to='/create' className='btn btn-outline-dark' >Thêm mới</Link>
                <Table striped bordered hover>
                        <thead>
                            <tr>
                            <th>STT</th>
                            <th>Max san pham</th>
                            <th>Ten san pham</th>
                            <th>The loai</th>
                            <th>So luong</th>
                            <th>Gia</th>
                            <th>Ngay nhap</th>
                            </tr>
                        </thead>
                        <tbody>
                                {products && products.map((product)=> (
                                    <tr key={product.id}>
                                        <td>{product.id}</td>
                                        <td>{product.maSanPham}</td>
                                        <td>{product.name}</td>
                                        <td>{product.type.name}</td>
                                        <td>{product.soLuong}</td>
                                        <td>{product.gia}</td>
                                        <td>{product.ngayNhap}</td>
                                    </tr>
                                ))}
                                
                        </tbody>
                </Table>
                
            </div>
    )
}

export default List;