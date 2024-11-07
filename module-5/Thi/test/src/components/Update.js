import "./form.css";
import { useNavigate, useParams} from "react-router-dom"
import * as Yup from "yup";
import * as productService from "./../service/product-service";
import * as typeService from "./../service/type-service";
import { toast } from "react-toastify";
import { useEffect, useState } from "react";
import { Formik, Field, Form } from 'formik';

const Update = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const [product,setProducts] = useState();
    const [types,setTypes] = useState();
    useEffect(() => {
        typeService.getAllType(id).then((data) => {
            setTypes(data);
        })
    })
    useEffect(() => {
        productService.findProductByID(id).then((data) => {
            setProducts(data);
        })
    },[]);

    const validationSchema = Yup.object({
        id: Yup.number(),
        name: Yup.string()
            .required("tên Không được để trống"),
        maSanPham: Yup.string()
            .required("Mã sản phẩm không được để trống")
            .matches(/^PROD-\d{4}$/,'mã phải có dạng PROD-0001'),
        gia: Yup.number()
            .required("giá không được để trống")
            .min(0,"giá phải lớn hơn 0"),
        soLuong: Yup.number()
            .required("số lượng không được để trống")
            .min(0,"số lượng phải lớn hơn 0"),
        ngayNhap: Yup.date()
            .required('Ngày tháng năm là bắt buộc')
            .max(new Date(), 'Ngày không thể trong tương lai'),
        type: Yup.string()
          .required('Vui lòng chọn một tùy chọn')
      });
      if (!product) {
            return  <div>.....</div>
      }
      return (
        <div>

                <Formik
                    initialValues={product}
                    validationSchema={validationSchema}
                    onSubmit={(values) => {
                        const prd = {...values,type: JSON.parse(values.type)}
                        console.log(prd);
                        
                        productService.updateProduct(prd).then(() => {
                            toast.success("Đã caapj nhaajt thành công 1 product");
                            navigate("/")
                        })
                    }}
                >
                    {({ errors, touched }) => (
                    <Form className='form-container'>
                        {/* Trường chọn (Select Option) */}
                        <div>
                            <label htmlFor="name">Tên:</label>
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
                            <label htmlFor="maSanPham">Mã sản phẩm:</label>
                            <Field
                                className='input-field'
                                type="text"
                                name="maSanPham"
                            />
                            {errors.maSanPham && touched.maSanPham ? (
                                <div className="error">{errors.maSanPham}</div>
                            ) : null}
                        </div>


                        <div>
                            <label htmlFor="soLuong">Số Lượng:</label>
                            <Field
                                className='input-field'
                                type="text"
                                name="soLuong"
                            />
                            {errors.soLuong && touched.soLuong ? (
                                <div className="error">{errors.soLuong}</div>
                            ) : null}
                        </div>

                        <div>
                            <label htmlFor="gia">giá:</label>
                            <Field
                                className='input-field'
                                type="text"
                                name="gia"
                            />
                            {errors.gia && touched.gia ? (
                                <div className="error">{errors.gia}</div>
                            ) : null}
                        </div>




                        <div>
                            <label htmlFor="type">Chọn tùy chọn:</label>
                            <Field as="select" className='input-field' name="type" id="type">
                                <option value="">Chọn loại vật liệu</option>
                                {types?.map((type) => (
                                <option key={type.id} value={JSON.stringify(type)}>
                                    {type.name}
                                </option>
                                ))}
                            </Field>
                            {errors.type && touched.type ? (
                                <div className="error">{errors.type}</div>
                            ) : null}
                            </div>

                        {/* Trường ngày tháng năm */}
                        <div>
                            <label htmlFor="date">Ngày tháng năm:</label>
                            <Field
                                type="date"
                                name="ngayNhap"
                                id="date"
                            />
                            {errors.date && touched.date ? (
                                <div className="error">{errors.ngayNhap}</div>
                            ) : null}
                        </div>

                        <button type="submit">Gửi</button>
                    </Form>
                    )}
                </Formik>
        </div>
      )
}

export default Update