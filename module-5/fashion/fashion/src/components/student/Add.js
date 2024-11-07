import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import { yupResolver } from '@hookform/resolvers/yup';
import * as yup from 'yup';
import Form from 'react-bootstrap/Form';
import { Controller, useForm } from 'react-hook-form';
import InputGroup from 'react-bootstrap/InputGroup';
import { useSelector } from 'react-redux';
import "./student-css/add.css";
import * as studentService from "../../service/student-service";
import { useNavigate } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const Add = () => {
    const navigate = useNavigate();
    const clazzes = useSelector(state => state.clazz);
    
    const studentValid = yup.object().shape({
        name: yup.string().required("Không được để trống"),
        age: yup.number().required("Không được để trống").min(1, "Tuổi phải lớn hơn 0"),
        point: yup.number().required("Điểm không được để trống"),
        class: yup.string().required("Bạn chưa chọn lớp cho riêng mình")
    });

    const { control, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(studentValid)
    });

    const onSubmit = (values) => {
        if (!values) {
            return;
        }

        const std = { ...values, class: JSON.parse(values.class) };
        studentService.addNewStudent(std).then(() => {
            toast.success(`Bạn đã thêm mới thành công sinh viên ${std.name}`);
            navigate("/");
        });
    }

    return (
        <div>
            <div className='body'>
                <div className='custom-form'>
                    <Form noValidate onSubmit={handleSubmit(onSubmit)}>
                        <Row className="mb-3">
                            <Form.Group as={Col} md="12" controlId="validationCustom03">
                                <Form.Label>Name</Form.Label>
                                <Controller
                                    name='name'
                                    control={control}
                                    render={({ field }) => (
                                        <Form.Control
                                            className='input'
                                            type="text"
                                            placeholder="Let's fill your name"
                                            required
                                            {...field}
                                        />
                                    )}
                                />
                                <Form.Control.Feedback type="invalid">
                                    {errors.name?.message}
                                </Form.Control.Feedback>
                            </Form.Group>
                        </Row>

                        <Row className="mb-3">
                            <Form.Group as={Col} md="12" controlId="validationCustom03">
                                <Form.Label>Age</Form.Label>
                                <Controller
                                    name='age'
                                    control={control}
                                    render={({ field }) => (
                                        <Form.Control
                                            className='input'
                                            type="number"
                                            placeholder="18"
                                            required
                                            {...field}
                                        />
                                    )}
                                />
                                <Form.Control.Feedback type="invalid">
                                    {errors.age?.message}
                                </Form.Control.Feedback>
                            </Form.Group>
                        </Row>

                        <Row className="mb-3">
                            <Form.Group
                                as={Col}
                                style={{ width: "150px" }}
                                md="8"
                                controlId="validationCustom03">
                                <Form.Label>Point</Form.Label>
                                <Controller
                                    name='point'
                                    control={control}
                                    render={({ field }) => (
                                        <Form.Select
                                            aria-label="Default select example"
                                            {...field}
                                        >
                                            <option value="10">10 {" điểm"}</option>
                                            <option value="1">1 {" điểm"}</option>
                                            <option value="2">2 {" điểm"}</option>
                                            <option value="3">3 {" điểm"}</option>
                                            <option value="4">4 {" điểm"}</option>
                                            <option value="5">5 {" điểm"}</option>
                                            <option value="6">6 {" điểm"}</option>
                                            <option value="7">7 {" điểm"}</option>
                                            <option value="8">8 {" điểm"}</option>
                                            <option value="9">9 {" điểm"}</option>
                                            <option value="0">0 {" điểm"}</option>
                                        </Form.Select>
                                    )}
                                />
                                <Form.Control.Feedback type="invalid">
                                    {errors.point?.message}
                                </Form.Control.Feedback>
                            </Form.Group>
                        </Row>

                        <Row className="mb-3">
                            <Form.Group
                                as={Col}
                                style={{ width: "200px" }}
                                md="8"
                                controlId="validationCustom03">
                                <Form.Label>Class</Form.Label>
                                <Controller
                                    name='class'
                                    control={control}
                                    render={({ field }) => (
                                        <Form.Select
                                            {...field}
                                            className={errors.class ? 'border-danger' : ''}
                                        >
                                            <option hidden>
                                                {errors.class ? "" : "Hãy chọn lớp"}
                                            </option>
                                            {clazzes?.map((clazz) => (
                                                <option
                                                    key={clazz.id}
                                                    value={JSON.stringify(clazz)}
                                                >
                                                    {clazz.className}
                                                </option>
                                            ))}
                                        </Form.Select>
                                    )}
                                />
                                <Form.Control.Feedback type="invalid">
                                    {errors.class?.message}
                                </Form.Control.Feedback>
                            </Form.Group>
                        </Row>
                        <Button type="submit">Submit form</Button>
                    </Form>
                </div>
            </div>
        </div>
    );
};

export default Add;
