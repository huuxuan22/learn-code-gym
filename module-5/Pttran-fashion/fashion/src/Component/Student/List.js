import {useEffect, useState} from "react"
import * as studentService from "../../service/student-service"

const List = () => {
    const [students,setStudents] = useState([]);

    const getAllStudent = (name) => {
        studentService.getAllStudent(name).then((data) => {
            setStudents(data);
        })
    }

    useEffect(() => {
        getAllStudent();
    })

    if (!students && students.length ===0) {
        return <div>
            don't have student in class
        </div>
    }

    retrun (
        <div>
            <Table striped bordered hover size="sm">
      <thead>
        <tr>
          <th>Name</th>
          <th>age</th>
          <th>point</th>
          <th>Class Name</th>
        </tr>
      </thead>
      <tbody>
        {
            students?.map((item) => (
                <tr>
                    <td>{item.name}</td>
                    <td>{item.age}</td>
                    <td>{item.point}</td>
                    <td>{item.class.name}</td>
                </tr>
            ))
        }
      </tbody>
    </Table>
        </div>
    )
}