import axios from "axios"

export const getAllProduct = async (name) => {
    try {
        const respon = await axios.get(`http://localhost:8080/products?name_like=${name}&_sort=id&_order=esc`);
        console.log(respon.data);
        
        return respon.data;
    } catch (error) {
        
    }
}

export const createProduct = async (product) => {
    try {
        await axios.post(`http://localhost:8080/products`,product);
    } catch (error) {
        
    }
}

