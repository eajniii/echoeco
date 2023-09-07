import React, { Component } from 'react';
import { Routes, Route } from 'react-router-dom';
import Header from '../common/Header';
import Footer from '../common/Footer';
import Main from '../pages/Main';
import NotFound from '../common/NotFound';
import FundingDetails from '../component/funding/FundingDetails';
import '../css/App.css';

const App = () => {
  return (
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Main />}></Route>
        <Route
          path="/project/funding/details/:fundingProjectId"
          element={<FundingDetails />}
        ></Route>
        {/* 없는 페이지 처리 */}
        <Route path="*" element={<NotFound />}></Route>
      </Routes>
      <Footer />
    </div>
  );
};

export default App;
