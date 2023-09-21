import React, { useCallback, useEffect, useState } from 'react';
import * as authAction from './authAction';

let logoutTimer;

export const AuthContext = React.createContext({
  token: '',
  userObject: { email: '', nickname: '' },
  isConnected: false,
  isPostSuccess: false,
  isGetSuccess: false,
  signup: (email, password, nickname) => {},
  checkEmail: () => {},
  checkNickname: () => {},
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

  const [isPostSuccess, setIsPostSuccess] = useState(false);
  const [isGetSuccess, setIsGetSuccess] = useState(false);
  const userIsConnected = !!token;
  const signupHandler = (email, password, nickname) => {
    const response = authAction.signupActionHandler(email, password, nickname);
    response.then(result => {
      if (result !== null) {
        setIsPostSuccess(true);
      }
    });
  };
  const checkEmailHandler = email => {
    const response = authAction.checkDupliatedEmailHandler(email);
    response.then(result => {
      if (result !== null) {
        setIsPostSuccess(true);
      }
    });
  };
  const checkNicknameHandler = nickname => {
    const response = authAction.checkDupliatedNicknameHandler(nickname);
    response.then(result => {
      if (result !== null) {
        setIsPostSuccess(true);
      }
    });
  };
  const loginHandler = (email, password) => {
    setIsPostSuccess(false);
    const data = authAction.loginActionHandler(email, password);
    data.then(result => {
      if (result !== null) {
        const loginData = result.data;
        console.log(loginData);
        setToken(loginData.accessToken);
        logoutTimer = setTimeout(
          logoutHandler,
          authAction.loginTokenHandler(
            loginData.accessToken,
            loginData.tokenExpiresIn
          )
        );
        setIsPostSuccess(true);
        console.log(isPostSuccess);
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
    setIsGetSuccess(false);
    const data = authAction.getUserActionHandler(token);
    data.then(result => {
      if (result !== null) {
        console.log('user on surfing');
        const userData = result.data;
        setUserObject(userData);
        setIsGetSuccess(true);
      }
    });
  };

  const changeNicknameHandler = nickname => {
    setIsPostSuccess(false);
    const data = authAction.changeNicknameActionHandler(nickname, token);
    data.then(result => {
      if (result !== null) {
        console.log('user on surfing');
        const userData = result.data;
        setUserObject(userData);
        setIsPostSuccess(true);
      }
    });
  };

  const changePasswordHandler = (exPassword, newPassword) => {
    setIsPostSuccess(false);
    const data = authAction.changePasswordActionHandler(
      exPassword,
      newPassword,
      token
    );
    data.then(result => {
      if (result !== null) {
        setIsPostSuccess(true);
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
    isGetSuccess,
    isPostSuccess,
    signup: signupHandler,
    checkEmail: checkEmailHandler,
    checkNickname: checkNicknameHandler,
    login: loginHandler,
    logout: logoutHandler,
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
