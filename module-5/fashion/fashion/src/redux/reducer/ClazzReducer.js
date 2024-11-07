 const clazzReducer =   (clazz = [],action) => {
    switch (action.type) {
        case "GET_ALL_CLAZZ":
            return action.payload;

        default:
            return clazz;
    }
}

export default clazzReducer;