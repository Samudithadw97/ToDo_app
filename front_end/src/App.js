import Register from "./pages/registration";
import Login from "./pages/login";
import Todo from "./pages/todo";

import "./App.css";
import { BrowserRouter, Route, Routes, Link } from "react-router-dom";
import { render } from "react-dom";
import Forgotpassword from "./pages/forgotpassword";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/register" element={<Register/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/forgotpassword" element={<Forgotpassword/>} />
          <Route path="/" exact element={<Todo/>} />
          
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
