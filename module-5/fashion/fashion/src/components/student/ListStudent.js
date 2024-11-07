import {useEffect, useState} from "react"
import * as studentService from "../../service/student-service";
import {getAllClass} from "../../service/class-service"
import { Table } from 'react-bootstrap'
import { Button } from "react-bootstrap";
import ModalDelete from "./ModalDelete";
import { MdDelete } from "react-icons/md";
import { GiAutoRepair } from "react-icons/gi";
import { FormUpdate } from "./FormUpdate";
import { Link, Outlet, useNavigate } from "react-router-dom";
import { TERipple } from 'tw-elements-react';
import { data } from "autoprefixer";

 const ListStudent = () => {
    const [students,setStudents] = useState([]);
    const [student,setStudent] = useState(null);
    const [show,setShow] = useState(false);
    const [showUpdate,setShowUpdate] = useState(false);
    const [clazz,setClazz] = useState([]);
    const navigate = useNavigate();
    const [query,setQuery] = useState("");


    function getAllStudent(name) {
         studentService.getAllStudent(name).then((data) => {
             setStudents(data);// thằng  này là bất đồng bộ 
                                // nhưng thằng này chạy trước khi thay đổi giá trị 
                                // thì thằng useEffect sẽ bị gọi khi state thay đổi 
                                // và dẫn đến useEffect nó gọi lại và nó sẽ bị gọi liên tục liên tục 
                                // do đó nó sẽ dẫn đến trường hợp hấn load nhiều lần

         });
     }

    const getAllClazz = (name) => {
        getAllClass(name).then((data) => {
            setClazz(data);
        })
    }

    useEffect(() => {
        getAllStudent("");
    },[]);

    useEffect(() => {
        getAllClazz("");
    },[]);

    function handleShow(value) {
         setStudent(value);
         setShow(true);

     }

    const handleUpdateStudent = (value) => {
        setStudent(value);
        setShowUpdate(true);
    }
 
    const handleInputChange = (e) => {
        setQuery(e.target.value);
    }

    const handleSearch = async () => {
        try {
            console.log(query)
            const classSearchResult = await studentService.searcgByClassName(query);
            if (classSearchResult && classSearchResult.length > 0) {
                console.log("tìm kiếm theo tên lớp");
                setStudents(classSearchResult);
            }else {
            
                const result =await studentService.searchByName(query);
                setStudents(result);
                
                console.log("tìm kiếm theo tên học sinh")
            }
            
        }catch (error) {

        }
    }


    if (!students && students.length ===0) {
        return null;
    }

    return (
        <div>

            <div className="mb-3 md:w-96">
                <div className="relative mb-4 flex w-full flex-wrap items-stretch">
                    <input
                        type="search"
                        className="relative m-0 -mr-0.5 block w-[1px] min-w-0 flex-auto rounded-l border border-solid border-neutral-300 bg-transparent bg-clip-padding px-3 py-[0.25rem] text-base font-normal leading-[1.6] text-neutral-700 outline-none transition duration-200 ease-in-out focus:z-[3] focus:border-primary focus:text-neutral-700 focus:shadow-[inset_0_0_0_1px_rgb(59,113,202)] focus:outline-none dark:border-neutral-600 dark:text-neutral-200 dark:placeholder:text-neutral-200 dark:focus:border-primary"
                        placeholder="Search"
                        aria-label="Search"
                        aria-describedby="button-addon1" 
                        onChange={handleInputChange}
                    />

                    {/* <!--Search button--> */}
                    <TERipple color='light'>
                        <button
                            className="relative z-[2] flex items-center rounded-r bg-primary px-6 py-2.5 text-xs font-medium uppercase leading-tight text-white shadow-md transition duration-150 ease-in-out hover:bg-primary-700 hover:shadow-lg focus:bg-primary-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-primary-800 active:shadow-lg"
                            type="button"
                            id="button-addon1"
                            onClick={handleSearch}
                        >
                            <svg
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 20 20"
                                fill="currentColor"
                                className="h-5 w-5">
                                <path
                                    fillRule="evenodd"
                                    d="M9 3.5a5.5 5.5 0 100 11 5.5 5.5 0 000-11zM2 9a7 7 0 1112.452 4.391l3.328 3.329a.75.75 0 11-1.06 1.06l-3.329-3.328A7 7 0 012 9z"
                                    clipRule="evenodd" />
                            </svg>
                        </button>
                    </TERipple>
                </div>
            </div>







            <Link to="/add">Thêm mới đi nào </Link>
            <Table striped bordered hover size="sm">
                        <thead>
                            <tr>
                            <th>Name</th>
                            <th>age</th>
                            <th>point</th>
                            <th>Class Name</th>
                            <th>Delete</th>
                            <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                students?.map((item) => (
                                    <tr key={item.id}>
                                        <td>{item.name}</td>
                                        <td>{item.age}</td>
                                        <td>{item.point}</td>
                                        <td>{item.class.className}</td>
                                        <td>
                                        <div style={{ display: "flex", alignItems: "center" }}>
                                            <Button variant="outline-danger" onClick={() => handleShow(item)} style={{ display: "flex", alignItems: "center" }}>
                                                 
                                                <MdDelete style={{ marginLeft: "1px", fontSize: "20px" }} />
                                                Delete
                                            </Button>
                                        </div>

                                        </td>
                                        <td>
                                            <Button 
                                                variant="outline-success" 
                                                onClick={() => handleUpdateStudent(item)}
                                                style={{ display: "flex", alignItems: "center" }}>
                                                <GiAutoRepair style={{ marginLeft: "1px", fontSize: "20px" }} />
                                                    Update
                                             </Button>
                                        </td>
                                    </tr>
                                ))
                            }
                        </tbody>
                </Table>

                {student && (
                  <ModalDelete
                    show={show}
                    setShow = {setShow}
                    student={student}
                    getAllStudent = {getAllStudent}
                />
            )}


            {student && (<FormUpdate
                
                student={student}
                showUpdate={showUpdate}
                setShowUpdate={setShowUpdate}
            />)}
            <Outlet/>
        </div>
    )
}

export default ListStudent;