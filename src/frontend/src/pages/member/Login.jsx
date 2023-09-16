import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import AuthContext from '../../common/authRelated/AuthContext';

const Login = () => {
  const [emailInput, setEmailInput] = useState('');
  const [passwordInput, setPasswordInput] = useState('');
  let navigate = useNavigate();
  const [isLoading, setIsLodeaing] = useState(false);
  const auth = useContext(AuthContext);

  return;
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
