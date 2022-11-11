import axios from "axios";
import { useState } from "react";
import "../components/login.css";
import Forgotpassword from "./forgotpassword";
import Button from "@mui/material/Button";
import { TextField } from "@mui/material";
import logo1 from "../logo1.png";
import { BrowserRouter, Router, Link, useNavigate } from "react-router-dom";


function Login() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  async function handleSubmit(event) {
    event.preventDefault();
    await axios
      .post("http://localhost:8080/api/users/login", {
        username: username,
        password: password,
      })
      .then((res) => {
        localStorage.setItem('user', JSON.stringify(res.data));
        console.log(res);
        navigate('/');
        setUsername("");
        setPassword("");
      })
      .catch((err) => {
        alert("User Registation Failed");
      });
  }

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 ">
      <div className="hidden sm:block bg-indigo-900 h-screen w-75 ">
        {" "}
        <div className="transform rotate-45 md:-rotate-45 ">
          <img src={logo1} alt="Logo1" width="800" height="10000" />
        </div>
      </div>
      <div className="bg-white justify-center flex flex-col h-screen my-auto items-center bgimg bg-cover ">
        <form
          className="register-form flex flex-col space-y-10 ... "
          onSubmit={handleSubmit}
        >
          <div className="flex flex-col space-y-20 ...">
            <div>
              <div className="text-align: center font-bold ... underline underline-offset-4 ... text-5xl ...flex flex-col italic ... font-weight: 300]">
                TO-DO LIST APP
              </div>
            </div>
            <div>
              <TextField
                name="username"
                placeholder="E-mail"
                onChange={(event) => {
                  setUsername(event.target.value);
                }}
                variant="standard"
                color="warning"
                focused
              />
            </div>
          </div>
          <div>
            <TextField
              name="password"
              type="password"
              placeholder="Password"
              onChange={(event) => {
                setPassword(event.target.value);
              }}
              variant="standard"
              color="warning"
              focused
              helperText="Password must be atleast 8 characters"
            />
          </div>

          <div>
            <Link to="/forgotpassword">Forgot password?</Link>
          </div>

          <div>
            <Button variant="contained" size="large" type="submit">
              Login
            </Button>
          </div>
          <div>
            <Link to="/register">New user?</Link>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
