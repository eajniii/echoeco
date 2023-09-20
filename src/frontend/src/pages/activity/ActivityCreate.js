import React, { useState } from 'react';
import './../../css/activityCreate.css';

const ActivityCreate = () => {
  const [dateValue, setDateValue] = useState(''); // 초기값을 빈 문자열로 설정
  const [imageFields, setImageFields] = useState([]); // 이미지 필드 목록을 관리하는 state
  const [Title, setTitle] = useState(``);

  const changeTitleValue = e => {
    setTitle(e.target.value);
  };
  const changeDateValue = e => {
    setDateValue(e.target.value);
    console.log(e.target.value);
  };

  const addImage = () => {
    setImageFields([...imageFields, { id: Date.now() }]);
  };

  const removeImage = id => {
    setImageFields(imageFields.filter(field => field.id !== id));
  };

  return (
    <div className="ActivityCreate">
      <div>
        <div>
          <label
            for="title"
            className="input-group-text"
            id="inputFroup-sizing-sm"
          >
            title
          </label>
          <input
            type="text"
            value={Title}
            name="title"
            className="form-control"
            onChange={changeTitleValue}
          />
        </div>
        <div>
          <label
            for="deaadLine"
            className="input-group-text"
            id="inputGroup-sizing-sm"
          >
            마감일자 등록
          </label>
          <input
            type="date"
            value={dateValue}
            onChange={changeDateValue}
            className="form-control"
            name="deadLine"
          />
        </div>
        <div id="plusImg" className="input-group">
          <input
            type="file"
            id="inputGroupFile04"
            name="imgfile"
            className="form-control"
            aria-describedby="inputGroupFileAddon04"
            aria-label="Upload"
          />
          <input
            type="button"
            name="plusImg"
            value="img+"
            onClick={addImage}
            id="inputGroupFileAddon04"
            className="btn btn-outline-secondary"
          />
        </div>
        {imageFields.map(field => (
          <div key={field.id} className="img-div">
            <label htmlFor="img"></label>
            <input
              style={{ width: '400px' }}
              type="file"
              id="inputGroupFile04"
              name="imgfile"
              accept="image/*"
              className="form-control"
              aria-describedby="inputGroupFileAddon04"
              aria-label="Upload"
            />
            <input
              type="button"
              value="Delete"
              onClick={() => removeImage(field.id)}
              className="btn btn-outline-danger"
            />
          </div>
        ))}
      </div>
    </div>
  );
};

export default ActivityCreate;
