import React, { useState, useContext, useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import AuthContext from '../../common/authRelated/AuthContext';

const Login = () => {
  const [emailInput, setEmailInput] = useState('');
  const [emailMsg, setEmailMsg] = useState('');
  const [passwordInput, setPasswordInput] = useState('');
  let nevigate = useNavigate();
  const [passwordMsg, setPasswordMsg] = useState('');
  const [isLoading, setIsLodeaing] = useState(false);
  const auth = useContext(AuthContext);

  const onChangeEmail = useCallback(e => {
    setEmailInput(e.target.value);
  });
  const onChangePassword = useCallback(e => {
    setPasswordInput(e.target.value);
  });

  const submitHandler = async e => {
    e.preventDefault();
    setIsLodeaing(true);
    auth.login(emailInput, passwordInput);
    setIsLodeaing(false);
    if (auth.isWellDone) {
      nevigate('/', { replace: true });
    }
  };

  return (
    <>
      <form className="row g-3" onSubmit={submitHandler} name="loginForm">
        <div className="col-md-6">
          <label htmlFor="inputEmail4" className="form-label" name="emailLabel">
            Email
            <input
              type="email"
              className="form-control"
              id="inputEmail4 inEmail"
              name="inEmail"
              onChange={onChangeEmail}
              required
            />
          </label>
          <div id="msg"> {emailMsg} </div>
        </div>
        <div className="col-md-6">
          <label htmlFor="inputPassword4" className="form-label">
            Password
            <input
              type="password"
              className="form-control"
              id="inputPassword4 inPassword"
              name="inPassword"
              onChange={onChangePassword}
              required
            />
          </label>
          <div id="msg"> {passwordMsg} </div>
        </div>
        <div className="col-12">
          <button type="submit" className="btn btn-warning" id="btnSubmit">
            Login
          </button>
          {isLoading && <p>Loding...</p>}
        </div>
      </form>
    </>
  );
};
export default Login;
// import axios from 'axios';

// const JWT_EXPIRY_TIME = 60 * 60 * 1000;

// onLogin = (email, password) => {
//   const data = {
//     email,
//     password
//   };
//   axios
//     .post('/login', data)
//     .then(response => {
//       const { accessToken } = response.data;

//       axios.defaults.headers.common['Authorization'] = `Bearer ${accessToken}`;
//     })
//     .catch(error => {});
// };

// onSilentRefresh = () => {
//   axios
//     .post('/silent-refresh', data)
//     .then(onLoginSuccess)
//     .catch(error => {});
// };

// onLoginSuccess = response => {
//   const { accessToken } = response.data;
//   // accessToken 설정
//   axios.defaults.headers.common['Authorization'] = `Bearer ${accessToken}`;

//   // accessToken 만료하기 1분 전에 로그인 연장
//   setTimeout(onSilentRefresh, JWT_EXPIRRY_TIME - 60000);
// };
