import React from 'react';
import { Link } from 'react-router-dom';

function Main(props) {
  return (
    <>
      <Link to="/api/hello">
        <h1>Main: </h1>
      </Link>
    </>
  );
}
export default Main;
