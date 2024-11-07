import * as classService from "../../service/class-service"
export const getAllClazzByMiddleware = () => {
    return async (dispatch) => {
        const data = await classService.getAllClass("");
        dispatch({
            type: "GET_ALL_CLAZZ",
            payload:data
        })
    }
}