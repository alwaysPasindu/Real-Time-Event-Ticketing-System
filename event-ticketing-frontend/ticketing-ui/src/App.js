// src/App.js
import React from 'react';
import './App.css';
import EventList from './components/EventList';
import EventDetails from './components/EventDetails';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

const App = () => {
  return (
    <Router>
      <div className="App">
        <h1>Event Ticket Management System</h1>
        <Routes>
          <Route path="/" element={<EventList />} />
          <Route path="/event/:eventId" element={<EventDetails />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
