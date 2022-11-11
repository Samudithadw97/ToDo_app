import axios from "axios";
import { useState } from "react";
import "../components/registration.css";
import Button from "@mui/material/Button";
import { TextField } from "@mui/material";
import logo1 from "../logo1.png";
import { useNavigate } from "react-router-dom";

function Register() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [contactno, setContactno] = useState("");
  const [name, setName] = useState("");
  const navigate = useNavigate();

  async function handleSubmit(event) {
    event.preventDefault();

    await axios
      .post("http://localhost:8080/api/users/register", {
        username: username,
        password: password,
        contactno: contactno,
        name: name,
      })
      .then((res) => {
        alert("User Registation Successfully");
        console.log(res);
        setUsername("");
        setPassword("");
        setContactno("");
        setName("");
        navigate('/login');
      })
      .catch((err) => {
        alert("User Registation Failed");
      });
  }

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2">
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
                placeholder="Email"
                type={'email'}
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
              helperText="Password must be atleast 8 characters, Uppercase and A number"
            />
          </div>
          <div>
            <TextField
              name="contactno"
              placeholder="Contact No"
              onChange={(event) => {
                setContactno(event.target.value);
              }}
              variant="standard"
              color="warning"
              focused
            />
          </div>

          <div>
            <TextField
              name="name"
              placeholder="Name"
              onChange={(event) => {
                setName(event.target.value);
              }}
              variant="standard"
              color="warning"
              focused
            />
          </div>

          <div>
            <Button variant="contained" size="large" type="submit">
              Register
            </Button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Register;
