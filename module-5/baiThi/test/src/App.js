import logo from './logo.svg';
import './App.css';
import { BrowserRouter,Routes,Route } from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.min.css';
import List from "./component/List"
import { ListGroup } from 'react-bootstrap';
import Create from './component/Create';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route path='/' element={<List/>}></Route>
          <Route path='/create' element={<Create/>}></Route>
      </Routes>
      <ToastContainer />
    </BrowserRouter>
  );
}

export default App;
