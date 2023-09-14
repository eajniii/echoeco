import { GET, POST } from './FetchRequests';

const createTokenHeader = token => {
  return {
    Headers: {
      Authorization: 'bearer ' + token
    }
  };
};

const calculateRemainingTime = expirationTime => {
  const currentTime = new Date.getTime();
  const adjExpirationTime = new Date(expirationTime).getTime();
  const remainingDuration = adjExpirationTime - currentTime;
  return remainingDuration;
};

export const loginTokenHandler = (token, expirationTime) => {
  localStorage.setItem('token', token);
  localStorage.setItem('expirationTime', expirationTime);

  const remainingTime = calculateRemainingTime(expirationTime);
  return remainingTime;
};

export const retriveStoredToken = () => {
  const storedToken = localStorage.getItem('token');
  const storedExpirationDate = localStorage.getItem('expirationTime') || '0';

  const remainingTime = calculateRemainingTime(+storedExpirationDate);

  if (remainingTime <= 1000) {
    localStorage.removeItem('token');
    localStorage.removeItem('expirationTime');
    return null;
  }

  return {
    token: storedToken,
    duration: remainingTime
  };
};
export const signupActuinHandler = (email, password, nickname) => {
  const URL = '/auth/signup';
  const signupObject = { email, password, nickname };
  const response = POST(URL, signupObject, {});

  return response;
};
export const loginActionHandler = (email, password) => {
  const URL = '/auth/login';
  const loginObject = { email, password };
  const response = POST(URL, loginObject, {});

  return response;
};
export const logoutActionHandler = () => {
  localStorage.removeItem('token');
  localStorage.removeItem('expirationTime');
};
export const getUserActionHandler = token => {
  const URL = '/member/mypage';
  const response = GET(URL, createTokenHeader(token));

  return response;
};
export const changeNicknameActionHandler = (nickname, token) => {
  const URL = '/member/modify/nickname';
  const changeNicknameObject = { nickname };
  const response = POST(URL, changeNicknameObject, createTokenHeader(token));

  return response;
};
export const changePasswordActionHandler = (exPassword, newPassword, token) => {
  const URL = '/member/modify/nickname';
  const changePasswordObject = { exPassword, newPassword };
  const response = POST(URL, changePasswordObject, createTokenHeader(token));

  return response;
};
