// src/index.js
import React from 'react';
import ReactDOM from 'react-dom/client'; // React 18 uses this method
import './index.css';
import App from './App';
import { BrowserRouter } from 'react-router-dom';

// React 18
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);
