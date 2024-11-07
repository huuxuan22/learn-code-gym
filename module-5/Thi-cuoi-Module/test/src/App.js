import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-toastify/dist/ReactToastify.css';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import {BrowserRouter,Routes,Route} from "react-router-dom"
import List from './component/List';
import Add from './component/Add';
function App() {
  return (

      <BrowserRouter>
        <Routes>
          <Route path='/' element={<List/>}></Route>
          <Route path='/create' element= {<Add/>}></Route>
        </Routes>
        <ToastContainer />
      </BrowserRouter>
  );
}

export default App;
