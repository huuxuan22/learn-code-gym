import axios from "axios";

const URL_STUDENT = "http://localhost:8080/students";

export const getAllStudents = async (name) => {
    try {
        const response = await axios.get(URL_STUDENT+"?name_like="+ name);
        return response.data;
    } catch (error) {
        console.error(error);
    }
}

export const addStudent = async (student) => {
    try {
        await axios.post(URL_STUDENT, student);
    } catch (e) {
        console.log(e)
    }
}