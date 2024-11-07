import { combineReducers } from "redux";
import clazzReducer from "./ClazzReducer"


const rootReducer = combineReducers({
    clazz: clazzReducer
})

export default rootReducer;