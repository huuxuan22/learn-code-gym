import axios from "axios"

export const getAllClass =async (name) => {
    const reponse = await axios.get(`http://localhost:8080/class?name_like=${name}`);
    console.log(reponse.data);
    return reponse.data;
}

