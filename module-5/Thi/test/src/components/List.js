import { useEffect, useState } from "react";
import * as typeService from "./../service/type-service"
import * as productService from "./../service/product-service";
import Table from 'react-bootstrap/Table';
import { Link, useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";

const List = () => {
    const [products,setProducts] = useState();
    const [types,setTypes] = useState();
    const [valueSearch,setValueSearch] = useState();
    const [value,setValue] = useState();
    const navigate = useNavigate();
    const getAllProduct = (name) => {
        productService.getAllProduct(name).then((data) => {
            setProducts(data);
        })
    }
    useEffect(() => {
        getAllProduct("");
    },[])

    useEffect(() => {
        typeService.getAllType().then((data) => {
            setTypes(data);
        })
    }, []);
    
    if (!products && !types) {
        return <div>...loading</div>
    }   

    const handleSearch = (event) => {
        // console.log(event.target.value);
        setValueSearch(event.target.value);
    }

    const findProductByTypeName = (name) => {
        if (value) {
            console.log("đã đi vào đây: ");
            const newProducts = products.filter((item) => {
                return item.type.id == value;
            });
            setProducts(newProducts);
            // console.log(newProducts);
            
        }
    }

    const handleClick = () => {
        console.log(valueSearch,value);
        
        if (!valueSearch && !value) {
            getAllProduct("");
        } else if (valueSearch && !value) {
            getAllProduct(valueSearch);
        } else if (!valueSearch && value) {
            findProductByTypeName();
        } else if (valueSearch && value) {
            console.log("Cả valueSearch và value đều có giá trị.");
        }
    }

    const handleSearchDouble = (event) => {
        console.log(event.target.value);
        setValue(event.target.value);
    }

    const handleUpdate = (id) => {
        navigate(`/update/${id}`);
    }

    return (
        <div>
            <Link to='/create' className="btn btn-outline-danger">Thêm mới</Link>
            <input type="text"  placeholder="search" onChange={handleSearch}/>
            <select onClick={handleSearchDouble}>
                {types && types.map((item) => (
                    <option key={item.id} value={item.id} >{item.name}</option>
                ))}
            </select>
            <Button className="btn btn-outline-info" onClick={handleClick}>Tìm kiếm</Button>
            <Link to='/create'></Link>
            <Table striped bordered >
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Mã sản phẩm </th>
                        <th>Tên sản  phẩm</th>
                        <th>ngày Nhập</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>The loai</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    {products?.map((item) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.maSanPham}</td>
                            <td>{item.name}</td>
                            <td>{item.ngayNhap}</td>
                            <td>{item.soLuong}</td>
                            <td>{item.gia}</td>
                            <td>{item.type.name}</td>
                            <td><button className="btn btn-outline-info" onClick={() => handleUpdate(item.id)}>Update</button></td>
                            <td></td>
                        </tr>
                    ))}
                </tbody>
            </Table>

        </div>
    )

}

export default List 