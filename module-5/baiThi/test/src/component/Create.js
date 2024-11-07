import "./form.css"
import {Formik,Form,ErrorMessage,Field} from "formik"
import { useEffect, useState } from "react"
import * as yup  from "yup";
import * as typeService from "./service/type-service"
import * as productService from "./service/product-service"
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
const Create = () => {
    const [types,setTypes] = useState();
    const navigate = useNavigate()
    const validate = {
        maSanPham: yup.string().required("msp khong duoc der trong"),
        name: yup.string().required("ten khong duoc de trong"),
        gia: yup.number().required("gia khong duoc de trong"),
        soLuong: yup.number().required("soLuong Khong duoc de trong").integer("phia laso nguyen").min(0,"So luong phai lon hon 0"),
        ngayNhap: yup.string().required("hay chon ngay nhap"),
        moTa: yup.string().required("Khong duoc de trong")
    
    }
    
    useEffect(() => {
         typeService.getAllType().then((data) => {
            setTypes(data);
        })
    },[])
    
    if (!types) {
            return <div>.......</div>
    }
    

   
    return (
        <div>
            <Formik 
                        initialValues={{
                            maSanPham: "",
                            name: "",
                            gia: "",
                            soLuong: "",
                            theLoai:"",
                            ngayNhap:"",
                            moTa: ""
                        }}
                        validationSchema={yup.object(validate)}
                        onSubmit={(value) => {
                            
                            const prd = { ...value, type: JSON.parse(value) };
                            console.log(prd);
                            
                                // productService.createProduct(prd).then((data) => {
                                //     toast.success("Bạn đã thêm mới thành công")
                                //     navigate("/")
                                // })
                          }}
                    >
                        {() => (
                            <Form>
                                    ma San Pham
                                    <Field className='input-field' name="maSanPham" />
                                    <ErrorMessage name="maSanPham" component='p'></ErrorMessage>
                                    Ten San Pham 
                                    <Field className=' input-field' name="name"/>
                                    <ErrorMessage name="name" component='p'></ErrorMessage>

                                    Gia 
                                    <Field className=' input-field' name="gia"/>
                                    <ErrorMessage name="gia" component='p'></ErrorMessage>

                                    so Luong 
                                    <Field className=' input-field' name="soLuong"/>
                                    <ErrorMessage name="soLuong" component='p'></ErrorMessage>

                                    The Loai: 
                                    <Field as="select" className=' input-field'  name="theLoai">
                                            {types &&
                                                types?.map((type) => (
                                                <option key={type.id} value={type.id}>
                                                    {type.name}
                                                </option>
                                                ))}
                                    </Field>
                                            
                                                
                                    Ngay Nhap
                                    <Field className='input-field' type="date" name ="ngayNhap"/>
                                    <ErrorMessage name="ngayNhap" component='p'></ErrorMessage>

                                    <Field className='input-field' type="text" name ="moTa"/>
                                    <ErrorMessage name="moTa" component='p'></ErrorMessage>

                                    
                                    <button className='btn btn-outline-danger' type="submit">Create</button>
                        </Form>
                        )}
                    </Formik>
        </div>
    )
}

export default Create;