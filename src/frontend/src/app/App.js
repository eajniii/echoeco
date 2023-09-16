import React, { useContext } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import Footer from '../common/Footer';
import Header from '../common/Header';
import NotFound from '../common/NotFound';
import '../css/App.css';
import Main from '../pages/Main';
import Signup from '../pages/member/Signup';
import Login from '../pages/member/Login';
import Mypage from '../pages/member/Mypage';
import AuthContext from '../common/authRelated/AuthContext';

function App() {
  const auth = useContext(AuthContext);
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Main />}></Route>
        <Route
          path="/signup"
          element={auth.isConnected ? <Navigate to="/" /> : <Signup />}
        ></Route>
        <Route
          path="/login/*"
          element={auth.isConnected ? <Navigate to="/" /> : <Login />}
        ></Route>
        <Route
          path="/member/*"
          element={auth.isConnected ? <Navigate to="/" /> : <Mypage />}
        ></Route>

        {/* 없는 페이지 처리 */}
        <Route path="*" element={<NotFound />}></Route>
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
