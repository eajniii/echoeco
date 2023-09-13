import axios from 'axios';
import React, { useState, useEffect } from 'react';

const ActivityList = () => {
  const [keyword, setKeyword] = useState('');
  const [page, setPage] = useState(0);
  const [area, setArea] = useState([]);
  const [state, setState] = useState('');
  const [selectCity, setSelectCity] = useState('');

  const options = [
    '서울',
    '경기',
    '인천',
    '강원',
    '충북',
    '충남',
    '대전',
    '전북',
    '전남',
    '경북',
    '경남',
    '제주'
  ];

  const cityChange = (e) => {
    setSelectCity(e.target.value);
    console.log(e.target.value);
    axios
      .get(`http://localhost:8080/city`, { params: { city: e.target.value } })
      .then((response) => {
        console.log(response.data);
        setArea(response.data.content);
      });
  };

  const stateChange = (e) => {
    console.log(e.target.value);
    setState(e.target.value);
  };

  const onChangeInput = (e) => {
    setKeyword(e.target.value);
  };

  const handlePageChange = (nextpage) => {
    setPage(nextpage);
  };

  return (
    <div>
      <form>
        <input
          type="text"
          placeholder="검색어를 입력해주세요"
          value={keyword}
          onChange={onChangeInput}
        />
        <select value={selectCity} onChange={cityChange}>
          <option value=""></option>
          {options.map((option) => (
            <option key={option} value={option}>
              {option}
            </option>
          ))}
        </select>
        <select value={state} onChange={stateChange}>
          <option value=""></option>
          {area.map((areaItem) => (
            <option key={areaItem.state} value={areaItem.state}>
              {areaItem.state}
            </option>
          ))}
        </select>
        <input type="submit" value="제출하기" />
      </form>
      <div>
        {/* {activities.map(activity => (
          <Link to={`activity/detail/${activity.idx}`}></Link>
        ))} */}
      </div>
    </div>
  );
};

export default ActivityList;
