import axios from "axios";
import { number } from "yup";

export const getAllProduct = async (name) => {
    const respone = await axios.get(` http://localhost:8080/products?name_like=${name}&_sort=id&_order=desc`);
    // console.log(respone.data);
    return respone.data;
}


export const addNewProduct = async (product) => {
     try {
        console.log(product);
        
        const respone =    await axios.post("http://localhost:8080/products" ,product);
     } catch (error) {
        console.log("Lỗi bạn đang mắc phải: "+ error);
        
     }
};


export const findProductByID = async (id) => {
   const respone = await axios.get(`http://localhost:8080/products/${id}`);
   return respone.data;
}

export const updateProduct = async (product) => {
   console.log("Đã đi vào phần cập nhật");
   console.log(product);
   
   const respone = await axios.put(`http://localhost:8080/products/${product.id}`,product);
}
