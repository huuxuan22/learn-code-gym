import React, { useEffect, useState } from 'react';
import { Formik, Field, Form } from 'formik';
import * as Yup from 'yup';
import { toast } from 'react-toastify';
import { useNavigate } from 'react-router-dom';
import "./form.css";
import * as baiHatService from "./../service/baihat-service"
const Add = () => {
    const navigate = useNavigate();
    const validationSchema = Yup.object({
        name: Yup.string()
            .required("tên Không được để trống"),
        caSi: Yup.string()
            .required("Mã sản phẩm không được để trống")
            .max(40,"Tên không quá tối đa 30 kí tự"),
        nhacSi: Yup.string()
            .required("giá không được để trống")
            .max(30,"Tên nhạc sĩ không được quá 30 kí tự"),
        thoiGianPhat: Yup.string()
            .required('Ngày tháng năm là bắt buộc')
            .matches(/\d{2}:\d{2}$/,'phải đúng định dạng hh:mm'),
      });
    return (
        <div>
            <Formik
                    initialValues={{ name: '',caSi: '',nhacSi:'',thoiGianPhat: ''}}
                    validationSchema={validationSchema}
                    onSubmit={(values) => {
                        const newBaiHat = {...values, soLuotYeuThich: 0};
                        const baiHat = {...newBaiHat,  trangThai: {id: 1, name: "Lưu Trữ"}}
                        baiHatService.addNewBaiHat(baiHat).then(() => {
                            navigate("/");
                            toast.success("Bạn đã thêm mới 1 bài hát");
                        })
                    }}
                >
                    {({ errors, touched }) => (
                    <Form className='form-container'>
                        {/* Trường chọn (Select Option) */}
                        <div>
                            <label htmlFor="name">Tên bài hát:</label>
                            <Field
                                className='input-field'
                                type="text"
                                name="name"
                                id="date"
                            />
                            {errors.name && touched.name ? (
                                <div className="error">{errors.name}</div>
                            ) : null}
                        </div>


                        <div>
                            <label htmlFor="caSi">Ca sĩ:</label>
                            <Field
                                className='input-field'
                                type="text"
                                name="caSi"
                            />
                            {errors.caSi && touched.caSi ? (
                                <div className="error">{errors.caSi}</div>
                            ) : null}
                        </div>


                        <div>
                            <label htmlFor="nhacSi">Nhạc sĩ:</label>
                            <Field
                                className='input-field'
                                type="text"
                                name="nhacSi"
                            />
                            {errors.nhacSi && touched.nhacSi ? (
                                <div className="error">{errors.nhacSi}</div>
                            ) : null}
                        </div>

                        <div>
                            <label htmlFor="thoiGianPhat">Thời gian phát:</label>
                            <Field
                                className='input-field'
                                type="text"
                                name="thoiGianPhat"
                            />
                            {errors.thoiGianPhat && touched.thoiGianPhat ? (
                                <div className="error">{errors.thoiGianPhat}</div>
                            ) : null}
                        </div>

                        <button type="submit">Đăng kí</button>
                    </Form>
                    )}
                </Formik>
        </div>
    )
}

export default Add;