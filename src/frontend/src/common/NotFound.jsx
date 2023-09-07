import React from 'react';
import { Link } from 'react-router-dom';

const NotFound = () => {
  return (
    <div className="NotFound">
      잘못된 페이지 입니다.
      <Link to="/"> 홈으로 돌아가기 </Link>
    </div>
  );
};

export default NotFound;
