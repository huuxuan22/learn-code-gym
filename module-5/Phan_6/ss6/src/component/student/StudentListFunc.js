import {useEffect, useState} from "react";
import {Link, NavLink} from "react-router-dom";
import * as studentService from "../../service/StudentService"

function StudentListFunc() {
    const [students, setStudents] = useState([])
    const [name, setName] = useState("")

    useEffect(() => {
        getStudents();

    }, [name]);

    const getStudents = async () => {
        let temp = await studentService.getAllStudents(name)
        setStudents(temp)
    }
    return (
        <>
            <Link to="/create">Thêm mới</Link>
            <input value={name} onChange={(e) => setName(e.target.value)} />

            <h1>Danh sach hoc sinh</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                {
                    students.map((item) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td>{item.address}</td>
                            <td>{5 < 6 ? 5 : 6}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
    )
}

export default StudentListFunc;