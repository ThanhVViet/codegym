import axios from "axios";

export const findAll = async () => {
    try {
        const result = await axios.get("http://localhost:8080/product")
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const createProduct = async (product) => {
    try {
        const result = await axios.post("http://localhost:8080/product/", product)
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const findById = async (id) => {
    try {
        const result = await axios.get("http://localhost:8080/product/" + id)
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const updateProduct = async (id, product) => {
    try {
        const result = await axios.put("http://localhost:8080/product/" + id, product)
        return result.data
    } catch (e) {
        console.log(e)
    }
}



export const searchByDate = async (startDate, endDate) => {
    try {
        const result = await axios.get(`http://localhost:8080/product?date_gte=${startDate}&date_lte=${endDate}`);
        return result.data;
    } catch (e) {
        console.log(e);
    }
};



export const searchByDate2 = async (date) => {
    try {
        const result = await axios.get(`http://localhost:8080/product?date=${date}`);
        return result.data
    } catch (e) {
        console.log(e)
    }
}
export const findByCategory = async (category) => {
    try {
        const result = await axios.get(`http://localhost:8080/product?category=${category}`);
        return result.data;
    } catch (e) {
        console.error(e);
    }
};

export const searchByCategoryAndName = async (category, search2) => {
    try {
        let search = search2.toString();
        const response = await axios.get(`http://localhost:8080/product?category=${category}&name_like=${search}`);
        return response.data;
    } catch (error) {
        console.error('Error searching by category and term:', error);
    }
};
export const searchByName = async (search2) => {
    try {
        const response = await axios.get(`http://localhost:8080/product?name = ${search2}`);
        return response.data;
    } catch (error) {
        console.error('Error searching by term:', error);
        throw error;
    }
};
