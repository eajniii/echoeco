import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

const ActivityList = () => {
  const [activities, setActivity] = useState([
    {
      id: '',
      goalCnt: '',
      deadLine: '',
      title: '',
      currentCnt: '',
      createDate: '',
      imgUri: ''
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
  }, [keyword, state, page]);
  const onChangeInput = e => {
    setKeyWord(e.target.value);
  };
  const fetchActivity = () => {
    const url = `/api/activity/list/?keyWord=${keyword}&state=${state}&page=${page}`;
    axios
      .get(url)
      .then(response => {
        if (response.data === null) {
          console.log('실패');
        } else {
          const activitiesList = response.data.map(res => ({
            id: res.id,
            goalCnt: res.goalCnt,
            deadLine: res.deadLine,
            title: res.title,
            currentCnt: res.curruntCnt,
            createDate: res.createAt,
            imgUri: res.imgUri
          }));
          setActivity(activitiesList);
        }
      })
      .catch(error => {
        console.error('활동 가져오기 오류:', error);
      });
  };
  const handleprePageChange = () => {
    if (page <= 0) {
      alert('이전페이지가 없습니다.');
    } else {
      setPage(page - 1);
    }
  };
  const handlenextPageChange = () => {
    setPage(page + 1);
  };
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
      <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        {activities.map(activity => (
          <Link to={`/activity/detail/${activity.id}`} key={activity.id}>
            <div className="col">
              <div className="card shadow-sm">
                <svg
                  className="bd-placeholder-img card-img-top"
                  width="100%"
                  height="225"
                  xmlns={activity.imgUri}
                  role="img"
                  aria-label="Placeholder: Thumbnail"
                  preserveAspectRatio="xMidYMid slice"
                  focusable="false"
                >
                  <title>Placeholder</title>
                  <rect width="100%" height="100%" fill="#55595c" />
                  <text x="50%" y="50%" fill="#eceeef" dy=".3em">
                    Thumbnail
                  </text>
                </svg>
                <div className="card-body">
                  <p className="card-text">{activity.title}</p>
                  <p className="card-text">{activity.createDate}</p>
                  <p className="card-text">
                    (현재원) {activity.currentCnt}/{activity.goalCnt} (마감인원)
                  </p>
                  <div className="d-flex justify-content-between align-items-center">
                    <small className="text-body-secondary">9 mins</small>
                  </div>
                </div>
              </div>
            </div>
          </Link>
        ))}
      </div>
      <ul>
        <li>
          <span onClick={handleprePageChange}>이전</span>
        </li>
        <li>
          <span>{page}</span>
        </li>
        <li>
          <span onClick={handlenextPageChange}>다음</span>
        </li>
      </ul>
    </div>
  );
};

export default ActivityList;
