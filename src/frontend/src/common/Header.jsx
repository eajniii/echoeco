import React from 'react';
import { Link, useLocation, useSearchParams } from 'react-router-dom';

function Header(props) {
  const location = useLocation;
  const keywords = useSearchParams;
  const keyword = useSearchParams.get('search');
  return (
    <>
      <h1>header</h1>
      <ul>
        <li>{location.fundingList}</li>
        <li>{location.activityList}</li>
        <li>{location.boardList}</li>
        <li>{location.notice}</li>
      </ul>
      <form action="search" method="post"></form>
    </>
  );
}
export default Header;
