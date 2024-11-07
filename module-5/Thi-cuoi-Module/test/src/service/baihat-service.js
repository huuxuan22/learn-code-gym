import axios from "axios"

export const getAllBaiHat =async (name) => {
    const respone  =  await axios.get(`http://localhost:8080/baiHats?name_like=${name}`);
    return respone.data;
}


export const addNewBaiHat =async (baiHat) => {
    await axios.post(`http://localhost:8080/baiHats`,baiHat);
}

export const update = async (baiHat) => {
    await axios.put(`http://localhost:8080/baiHats/${baiHat.id}`,baiHat);
}