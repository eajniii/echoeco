import React, { useEffect, useState, useCallback } from 'react';
import * as authAction from './AuthAction';

function AuthContext({ children }) {


const loginToken = {
    grantType,
    accessToken,
    tokenExpiresIn
}

const AuthContext = React.createContext({
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

 const AuthContextProvider = props => {
  const tokenData = authAction.retriveStoredToken();
  let initialToken = '';
  if (tokenData) {
    initialToken = tokenData.token;
  }
  const [token, SetToken] = useState(initialToken);
  const [userObject, setUserObect] = useState({
    email: '',
    nickname: ''
  });

  const [isWellDone, setIsWellDone] = useState<boolean>(false);
  const userIsConnected = !!token;
  const signupHandler = (email, password, nickname) =>{
    const response = authAction.signupActuinHandler(email, password, nickname);
    response.then(result => {
      if(result !== null){
        setIsWellDone(true);
      }
    })
  }

  const loginHandler = (email, password) =>{
    setIsWellDone(false);
    console.log(isWellDone);

    const data = authAction.loginActionHandler(email, password);
    data.then((result)=>{
      if(result !== null){
        const loginData = result.data;
        SetToken(loginData.accessToken);
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
    })
  }

  const logoutHandler = useCallback(() => {
    setToken('');
    authAction.logoutActionHandler();
    if(logoutTimer){
      clearTimeout(logoutTimer);
    }
  },[]);

  const getUserHandler = () => {
    setIsWellDone(false);
    const data = authAction.getUserActionHandler(token);
    data.then((result)=>{
      if(result !==null){
        console.log('user on surfing');
        const userData =result.data;
        setUserObect(userData);
        setIsWellDone(true);
      }
    })
  }

  const changeNicknameHandler = (nickname) => {
    setIsWellDone(false);
    const data = authAction.changeNicknameActionHandler(nickname, token);
    data.then((result)=>{
      if(result !==null){
        console.log('user on surfing');
        const userData =result.data;
        setUserObect(userData);
        setIsWellDone(true);
      }
    })
  }

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
      isConnected: signupHandler,
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
}
export default AuthContext;
