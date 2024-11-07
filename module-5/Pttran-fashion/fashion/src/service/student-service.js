import axios from "axios"

export const getAllStudent =async (name) => {
    const reponse = await axios.get(`http://localhost:8080/student?name_like=${name}`);
    return reponse.data;
}