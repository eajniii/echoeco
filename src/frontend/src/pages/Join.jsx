import { useState } from "react";

const validateEmail = (email) => {
  return email
    .toLowerCase()
    .match(
      /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/
    );
};

const validatePassword = (password) => {
  return password
    .toLowerCase()
    .match(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/);
};

const validateNickname = (nickname) => {
  return nickname.toLowerCase().match(/^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|].{2,8}$/);
}
const signup = () => {
 const [email, setEmail] = useState("");
 const [password, setPassword] = useState("");
 const [nickname, setNickname] = useState("");

 
 const isValiedEmail = validateEmail(email);
 const isValiedPW = validatePassword(password);
 const isValiedNickname = validateNickname(nickname);

  return (
    <>
      <form class="row g-3">
        <div class="col-md-6">
          <label for="inputEmail4" class="form-label">
            Email 
          </label>
          <input type="email" class="form-control" id="inputEmail4" />
        </div>
        <div class="col-md-6">
          <label for="inputPassword4" class="form-label">
            Password
          </label>
          <input type="password" class="form-control" id="inputPassword4" />
        </div>
        <div class="col-12">
          <label for="inputAddress" class="form-label">
            Name
          </label>
          <input type="text" class="form-control" id="inputName" />
        </div>
        <div class="col-12">
          <label for="inputAddress2" class="form-label">
            Tel
          </label>
          <input type="text" class="form-control" id="inputTel" />
        </div>
        <div class="col-12">
          <div class="form-check">
            <input class="form-check-input" type="checkbox" id="gridCheck" />
            <label class="form-check-label" for="gridCheck">
              Check me out
            </label>
          </div>
        </div>
        <div class="col-12">
          <button type="submit" class="btn btn-primary">
            Sign in
          </button>
        </div>
      </form>
    </>
  );
}
export default signup;
