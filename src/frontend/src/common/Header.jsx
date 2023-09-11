import React from 'react';
import { Link, useLocation } from 'react-router-dom';

function Header(props) {
  const location = useLocation;
  return (
    <>
      <header id="header">
        <nav
          class="navbar navbar-expand-lg"
          style={{ backgroundColor: `#88dba3` }}
        >
          <div class="container-fluid">
            <button
              class="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarTogglerDemo03"
              aria-controls="navbarTogglerDemo03"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
            <a class="logo" href="#">
              <img src="/img/로고.png}" alt="logo"></img>
            </a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <a class="nav-link active" aria-current="page" href="#">
                    Projects
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">
                    Board
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" aria-disabled="true">
                    Login
                  </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" aria-disabled="true">
                    MyPage
                  </a>
                </li>
              </ul>
              <form class="d-flex" role="search">
                <input
                  class="form-control me-2"
                  type="search"
                  placeholder="Search"
                  aria-label="Search"
                />
                <button class="btn btn-outline-success" type="submit">
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
