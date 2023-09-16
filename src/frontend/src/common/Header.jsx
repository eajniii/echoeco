import React from 'react';
import { Link, useLocation } from 'react-router-dom';

function Header(props) {
  const location = useLocation;
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
            <a className="logo" href="#">
              <img src="/img/로고.png}" alt="logo"></img>
            </a>
            <div className="collapse navbar-collapse" id="navbarTogglerDemo03">
              <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                <li className="nav-item">
                  <a className="nav-link active" aria-current="page" href="#">
                    Projects
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="#">
                    Board
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" aria-disabled="true">
                    Login
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" aria-disabled="true">
                    MyPage
                  </a>
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
      <ul>
        <li>{location.fundingList} crowd funding</li>
        <li>{location.activityList} crowd activity</li>
        <li>{location.boardList} 게시판 </li>
        <li>{location.notice} 공지 </li>
      </ul>
      <form action="search" method="post"></form>
    </>
  );
}
export default Header;
