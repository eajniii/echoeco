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
    if (auth.isPostSuccess) {
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
