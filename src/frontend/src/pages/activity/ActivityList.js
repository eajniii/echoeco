import axios from 'axios';
import React, { useEffect, useState } from 'react';

const ActivityList = () => {
  const [activities, setActivity] = useState([
    {
      id: '',
      goalCnt: '',
      deadLine: '',
      title: '',
      content: '',
      currentCnt: '',
      createDate: ''
    }
  ]);
  const [keyword, setKeyWord] = useState(``);
  const [page, setPage] = useState(0);
  const [areas, setArea] = useState([]);
  const [state, setState] = useState(``);
  const [selectCity, setSelectCity] = useState(``);

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
  const cityChange = e => {
    const selectedCity = e.target.value;
    setSelectCity(selectedCity);
    console.log(selectedCity);
    axios
      .get(`http://localhost:8080/api/city`, { params: { city: selectedCity } })
      .then(response => {
        const stateDTOList = response.data.map(state => {
          return { State: state };
        });
        setArea(stateDTOList);
      })
      .catch(error => {
        console.error('오류 발생:', error);
        alert('오류발생');
      });
  };
  function stateChange(e) {
    setState(e.target.value);
  }
  useEffect(() => {
    fetchActivity();
  }, [keyword, state]);
  const onChangeInput = e => {
    setKeyWord(e.target.value);
  };
  const fetchActivity = () => {
    const url = `/api/activity/?keyWord=${keyword}&state=${state}`;
    axios
      .get(url)
      .then(response => {
        const activitisList = response.data.map(res => {
          return {
            id: res.id,
            goalCnt: res.goalCnt,
            deadLine: res.deadLine,
            title: res.title,
            content: res.contents,
            currentCnt: res.currentCnt,
            createDate: res.createdAt
          };
        });
        setActivity(activitisList);
        console.log(activitisList);
      })
      .catch(error => {
        console.error('Error fetching activities:', error);
      });
  };
  // const handlePageChange = nextpage => {
  //   setPage(nextpage);
  // };
  return (
    <div>
      <input
        type="text"
        placeholder="검색어를 입력해주세요"
        value={keyword}
        onChange={onChangeInput}
      />
      <select value={selectCity} onChange={cityChange}>
        <option value="">지역선택1</option>
        {options.map(option => (
          <option key={option.id} value={option}>
            {option}
          </option>
        ))}
      </select>
      <select value={state} onChange={stateChange}>
        <option value="">지역선택</option>
        {areas.map(area => (
          <option key={area.id} value={area.State.state}>
            {area.State.state}
          </option>
        ))}
      </select>
      <div></div>
    </div>
  );
};

export default ActivityList;
