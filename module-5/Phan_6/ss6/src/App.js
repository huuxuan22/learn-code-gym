
import './App.css';
import React from "react";

import StudentCreate from "./component/student/StudentCreate";
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import {BrowserRouter, HashRouter, NavLink, Route, Routes} from "react-router-dom";
import StudentListFunc from "./component/student/StudentListFunc";

function App() {

    return (
        <>
           <BrowserRouter>
               <div>
                   <NavLink to="/Student">Danh sách  </NavLink>
                   <NavLink to="/create">Thêm mới</NavLink>
               </div>
               <Routes>
                   <Route path="/student" element={<StudentListFunc/>}></Route>
                   <Route path="/create" element={<StudentCreate/>}></Route>
                   {/*<Route path="/student/:id" element={<StudentUpdate/>}></Route>*/}
               </Routes>
           </BrowserRouter>
            <ToastContainer></ToastContainer>
        </>
    );
}

export default App;
