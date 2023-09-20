import React, { useCallback, useEffect, useState } from 'react';
import * as authAction from './authAction';

let logoutTimer;

export const AuthContext = React.createContext({
  token: '',
  userObject: { email: '', nickname: '' },
  isConnected: false,
  isWellDone: false,
  signup: (email, password, nickname) => {},
  login: (email, password) => {},
  logout: () => {},
  getUser: () => {},
  changeNicname: nickname => {},
  changePassword: (exPassword, newPassword) => {}
});

export const AuthContextProvider = props => {
  const tokenData = authAction.retriveStoredToken();
  let initialToken = '';
  if (tokenData) {
    initialToken = tokenData.token;
  }
  const [token, setToken] = useState(initialToken);
  const [userObject, setUserObject] = useState({
    email: '',
    nickname: ''
  });

  const [isWellDone, setIsWellDone] = useState(false);
  const userIsConnected = !!token;
  const signupHandler = (email, password, nickname) => {
    const response = authAction.signupActionHandler(email, password, nickname);
    response.then(result => {
      if (result !== null) {
        setIsWellDone(true);
      }
    });
  };

  const loginHandler = (email, password) => {
    setIsWellDone(false);
    const data = authAction.loginActionHandler(email, password);
    data.then(result => {
      if (result !== null) {
        const loginData = result.data;
        console.log(loginData);
        setToken(loginData.accessToken);
        if (logoutTimer) {
          clearTimeout(logoutTimer);
        }
        logoutTimer = setTimeout(
          logoutHandler,
          authAction.loginTokenHandler(
            loginData.accessToken,
            loginData.tokenExpiresIn
          )
        );
        setIsWellDone(true);
        console.log(isWellDone);
      }
    });
  };

  const logoutHandler = useCallback(() => {
    setToken(''); //토큰 초기화
    authAction.logoutActionHandler();
    if (logoutTimer) {
      clearTimeout(logoutTimer);
    }
  }, []);

  const getUserHandler = () => {
    setIsWellDone(false);
    const data = authAction.getUserActionHandler(token);
    data.then(result => {
      if (result !== null) {
        console.log('user on surfing');
        const userData = result.data;
        setUserObject(userData);
        setIsWellDone(true);
      }
    });
  };

  const changeNicknameHandler = nickname => {
    setIsWellDone(false);
    const data = authAction.changeNicknameActionHandler(nickname, token);
    data.then(result => {
      if (result !== null) {
        console.log('user on surfing');
        const userData = result.data;
        setUserObject(userData);
        setIsWellDone(true);
      }
    });
  };

  const changePasswordHandler = (exPassword, newPassword) => {
    setIsWellDone(false);
    const data = authAction.changePasswordActionHandler(
      exPassword,
      newPassword,
      token
    );
    data.then(result => {
      if (result !== null) {
        setIsWellDone(true);
        logoutHandler();
      }
    });
  };

  useEffect(() => {
    if (tokenData) {
      console.log(tokenData.duration);
      logoutTimer = setTimeout(logoutHandler, tokenData.duration);
    }
  }, [tokenData, logoutHandler]);

  const contextValue = {
    token,
    userObject,
    isConnected: userIsConnected,
    signup: signupHandler,
    login: loginHandler,
    getUser: getUserHandler,
    changeNicname: changeNicknameHandler,
    changePassword: changePasswordHandler
  };

  return (
    <AuthContext.Provider value={contextValue}>
      {props.children}
    </AuthContext.Provider>
  );
};
export default AuthContext;
