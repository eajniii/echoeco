import React, { useCallback, useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import AuthContext from '../../common/authRelated/AuthContext';
import '../../css/Form.css';
const Signup = () => {
  let navigate = useNavigate();
  const auth = useContext(AuthContext);

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [nickname, setNickname] = useState('');
  const [emailMsg, setEmailMsg] = useState('');
  const [passwordMsg, setPasswordMsg] = useState('');
  const [NicknameMsg, setNicknameMsg] = useState('');

  const validateEmail = email => {
    return email
      .toLowerCase()
      .match(
        /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/
      );
  };

  const validatePassword = password => {
    return password
      .toLowerCase()
      .match(/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/);
  };

  const validateNickname = nickname => {
    return nickname.toLowerCase().match(/^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|].{2,8}$/);
  };

  //이메일 유효성
  const onChangeEmail = useCallback(async e => {
    const typedEmail = e.target.value;
    setEmail(typedEmail);
    if (!validateEmail(typedEmail)) {
      setEmailMsg('이메일 형식이 올바르지 않습니다.');
    } else {
      setEmailMsg('올바른 이메일 형식입니다.');
    }
  }, []);
  //비밀번호 유효성
  const onChangePassword = useCallback(e => {
    const typedPassword = e.target.value;
    setPassword(typedPassword);
    if (!validatePassword(typedPassword)) {
      setPasswordMsg('영문, 숫자, 특수문자를 조합해 8자 이상 입력해주세요.');
    } else {
      setPasswordMsg('안전한 비밀번호입니다.');
    }
  }, []);

  //닉네임 유효성
  const onChangeNickname = useCallback(e => {
    const typedNickname = e.target.value;
    setNickname(typedNickname);
    if (!validateNickname(typedNickname)) {
      setNicknameMsg('2글자 이상 8글자 미만으로 입력해주세요.');
    } else {
      setNicknameMsg('올바른 닉네임 형식입니다.');
    }
  }, []);

  //이메일 중복 검사
  const onCheckEmail = async e => {
    e.preventDefault();
    auth.checkEmail(email);
    if (!auth.isWellDone) {
      setEmailMsg('이미 등록된 이메일입니다.');
    } else {
      setEmailMsg('사용할 수 있는 이메일입니다.');
    }
  };
  //이메일 중복 검사
  const onCheckNickname = async e => {
    e.preventDefault();
    auth.checkNickname(nickname);
    if (!auth.isWellDone) {
      setNicknameMsg('이미 등록된 닉네임입니다.');
    } else {
      setNicknameMsg('사용할 수 있는 닉네임입니다.');
    }
  };
  const submitHandler = e => {
    e.preventDefault();
    auth.signup(email, password, nickname);
    if (auth.isWellDone) {
      return navigate('/', { replace: true });
    }
  };
  return (
    <>
      <form className="row g-3" onSubmit={submitHandler} name="signupForm">
        <div className="col-md-6">
          <label htmlFor="inputEmail4" className="form-label" name="emailLabel">
            Email
            <input
              type="email"
              className="form-control"
              id="inputEmail4 inEmail"
              name="inEmail"
              onChange={onChangeEmail}
              required
            />
            <button className="btn btn-warning" onClick={onCheckEmail}>
              check
            </button>
          </label>
          <div id="msg"> {emailMsg} </div>
        </div>
        <div className="col-md-6">
          <label htmlFor="inputPassword4" className="form-label">
            Password
            <input
              type="password"
              className="form-control"
              id="inputPassword4 inPassword"
              name="inPassword"
              onChange={onChangePassword}
              required
            />
          </label>
          <div id="msg"> {passwordMsg} </div>
        </div>
        <div className="col-md-6">
          <label htmlFor="inName" className="form-label" name="nicknameLabel">
            Nickname
            <input
              type="text"
              className="form-control"
              id="inName"
              name="inName"
              onChange={onChangeNickname}
              required
            />
            <button className="btn btn-warning" onClick={onCheckNickname}>
              check
            </button>
          </label>
        </div>
        <div id="msg"> {NicknameMsg} </div>
        <div className="col-12">
          <button type="submit" className="btn btn-warning" id="btnSubmit">
            Sign in
          </button>
        </div>
      </form>
    </>
  );
};
export default Signup;
