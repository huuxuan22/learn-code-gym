import axios from "axios"

export const getAllStudent =async (name) => {
    try {
        const reponse = await axios.get(`http://localhost:8080/student?name_like=${name}`);
        // console.log(reponse.data);
        // console.log(reponse.data)
        return reponse.data;
    } catch (error) {
        return []
    }
}

export const deleteStudent = async (id) => {
    try {
        const reponse = await axios.delete(`http://localhost:8080/student/${id}`);
        return reponse.data;
    } catch (error) {
        
    }
}

export const updateStudent = async (student) => {
    try {
        const reponse = await axios.put(`http://localhost:8080/student/${student.id}`,student);
        return reponse.data;
    } catch (error) {
        return error;
    }
}

export const findStudentById = async (id) => {
    const reponse = await axios.get(`http://localhost:8080/student/${id}`);
    return reponse.data;
}

export const addNewStudent = async (student) => {
     await axios.post(`http://localhost:8080/student/`,student);
}


export const searchByName = async (value) => {
    try {
        const response = await axios.get(`http://localhost:8080/student?name_like=%${value}%`)

        return response.data;
    } catch (error) {
        console.error('Error fetching data:', error);
        // Có thể trả về một giá trị mặc định hoặc thông báo lỗi tùy theo nhu cầu của bạn
        return [];
    }
}

export const searcgByClassName = async (value) => {
    try {
        const respone = await axios.get(`http://localhost:8080/student?`, {
            params: {
                'class.className': 
                // `%${value}%` // cái này là tìm kiếm gần đúng
                value // cái này là tìm kiếm chính xác
            }
        });
        return  respone.data;
    } catch (error) {
        console.log("Lỗi tìm kiếm: "+ error);
        
    }
}