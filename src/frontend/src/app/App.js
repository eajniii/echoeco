import React, { useState, useEffect } from 'react';
import { Route, Routes } from 'react-router-dom';
import Footer from '../common/Footer';
import Header from '../common/Header';
import NotFound from '../common/NotFound';
import '../css/App.css';
import Main from '../pages/Main';
import FundingCreate from '../pages/funding/FundingCreate';
import FundingDetails from '../pages/funding/FundingDetails';
import FundingList from '../pages/funding/FundingList';
import axios from 'axios';

const App = () => {
  const [hello, setHello] = useState('');

  useEffect(() => {
    axios
      .get('/api/hello')
      .then(response => setHello(response.data))
      .catch(error => console.log(error));
  }, []);
  return (
    <div className="App">
      <Header />
      {hello}
      <Routes>
        <Route path="/" element={<Main />}></Route>
        <Route path="/project/funding/list" element={<FundingList />}></Route>
        <Route
          path="/project/funding/create"
          element={<FundingCreate />}
        ></Route>
        <Route
          path="/project/funding/details/:funding_id"
          element={<FundingDetails />}
        ></Route>
        <Route
          path="/project/funding/edit/:funding_id"
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
