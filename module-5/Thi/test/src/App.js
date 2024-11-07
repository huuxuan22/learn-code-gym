import logo from './logo.svg';
import './App.css';
import { Button } from 'react-bootstrap';
import  { BrowserRouter, Route, Routes } from "react-router-dom"
import List from './components/List';
import 'bootstrap/dist/css/bootstrap.min.css';
import Create from './components/Create';
import { ToastContainer, toast } from 'react-toastify';
  import 'react-toastify/dist/ReactToastify.css';
import Update from './components/Update';
function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<List/>}></Route>
            <Route path='/create' element={<Create/>}></Route>
            <Route path='/update/:id' element={<Update/>}></Route>
        </Routes>
        <ToastContainer />
    </BrowserRouter>
  );
}

export default App;
