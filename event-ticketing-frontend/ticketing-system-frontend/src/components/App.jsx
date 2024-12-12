import React from 'react';
import TicketList from './components/TicketList/TicketList';
import AddTicketForm from './components/AddTicketForm/AddTicketForm';
import PurchaseTicketForm from './components/PurchaseTicketForm/PurchaseTicketForm';
import './styles/index.css';

const App = () => {
  return (
    <div className="app-container">
      <h1>Event Ticketing System</h1>
      <div className="content-grid">
        <TicketList />
        <AddTicketForm />
        <PurchaseTicketForm />
      </div>
    </div>
  );
};

export default App;