import axios from "axios";
export const getAllType = async () => {
    const respone = await axios.get(`http://localhost:8080/types`);
    console.log(respone.data);
    
    return {};
}