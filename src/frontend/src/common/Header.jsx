import React from 'react';
import { Link, useLocation } from 'react-router-dom';

function Header(props) {
  const location = useLocation;
  return (
    <>
      <h1>header</h1>
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
