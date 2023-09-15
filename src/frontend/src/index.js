import React from 'react';

import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import App from './app/App';
import './index.css';
import axios from 'axios';

const root = ReactDOM.createRoot(document.getElementById('root'));
axios.defaults.baseURL = 'http://localhost:8080';
root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);
