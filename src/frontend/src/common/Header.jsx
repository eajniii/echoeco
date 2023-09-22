import { useContext, useEffect, useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import logo from '../img/로고.png';
import AuthContext from './authRelated/AuthContext';

const Header = () => {
  const auth = useContext(AuthContext);
  const [nickname, setNickname] = useState('');
  let isMember = auth.isConnected;
  let isSuccess = auth.isGetSuccess;
  const location = useLocation();
  const callback = str => {
    setNickname(str);
  };
  useEffect(() => {
    if (isMember) {
      console.log('start');
      auth.getUser();
    }
  }, [auth, isMember]);

  useEffect(() => {
    if (isSuccess) {
      callback(auth.userObject.nickname);
      console.log('get start');
    }
  }, [auth.userObject.nickname, isSuccess]);
  const toggleLogoutHandler = () => {
    auth.logout();
  };

  return (
    <>
      <header id="header">
        <nav
          className="navbar navbar-expand-lg"
          style={{ backgroundColor: `#88dba3` }}
        >
          <div className="container-fluid">
            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarTogglerDemo03"
              aria-controls="navbarTogglerDemo03"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <span> {isMember && `${nickname}님 반가워요!`} </span>
            <a className="logo" href="/">
              <img src={logo} alt="ECHO ECO" width={'70px;'} />
            </a>
            <div className="collapse navbar-collapse" id="navbarTogglerDemo03">
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                  <a className="nav-link active" aria-current="page" href="#">
                    ECHO Item ZONE
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link active" aria-current="page" href="#">
                    ECHO Action ZONE
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="#">
                    ECHO BOARD
                  </a>
                </li>
                <li className="nav-item">
                  {!isMember && <Link to="/login">Login</Link>}
                </li>
                <li className="nav-item">
                  {isMember && <Link to="/member/mypage">my page</Link>}
                </li>
                <li className="nav-item">
                  {isMember ? (
                    <button
                      onClick={toggleLogoutHandler}
                      className="btn btn-success"
                    >
                      Logout
                    </button>
                  ) : (
                    <button className="btn btn-success">Signup</button>
                  )}
                </li>
              </ul>
              <form className="d-flex" role="search">
                <input
                  className="form-control me-2"
                  type="search"
                  placeholder="Search"
                  aria-label="Search"
                />
                <button className="btn btn-outline-success" type="submit">
                  Search
                </button>
              </form>
            </div>
          </div>
        </nav>
      </header>
      <form action="search" method="post"></form>
    </>
  );
};
export default Header;
