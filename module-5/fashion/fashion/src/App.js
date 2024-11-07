import './App.css';
import {BrowserRouter,Route,Routes} from "react-router-dom"
import ListStudent from './components/student/ListStudent';
import 'react-toastify/dist/ReactToastify.css';
import { useDispatch } from 'react-redux';
import { useEffect } from 'react';
import { getAllClazzByMiddleware } from './redux/middleware/ClazzMiddleWare';
import Add from './components/student/Add';
import { ToastContainer } from 'react-toastify';

function App() {
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getAllClazzByMiddleware())
  },[]);
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<ListStudent/>}>
          {/* <Route path='/id' element={<FormUpdate/>}/> */}        </Route>
          <Route path='/add' element={<Add/>}/>
          
      </Routes>
      <ToastContainer />
    </BrowserRouter>
  );
}

export default App;
