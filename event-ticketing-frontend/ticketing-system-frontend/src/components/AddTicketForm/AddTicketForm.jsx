import React, { useState } from 'react';
import TicketService from '../../services/TicketService';
import './AddTicketForm.css';

const AddTicketForm = () => {
  const [formData, setFormData] = useState({
    event_name: '',
    price: '',
    quantity: ''
  });
  const [message, setMessage] = useState('');
  const [error, setError] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const result = await TicketService.addTicket(formData);
      setMessage(`Ticket added successfully! ID: ${result.ticketId}`);
      setError(null);
      // Reset form
      setFormData({ event_name: '', price: '', quantity: '' });
    } catch (err) {
      setMessage('');
      setError(err.message);
    }
  };

  return (
    <div className="add-ticket-form">
      <h2>Add New Ticket</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="event_name"
          value={formData.event_name}
          onChange={handleChange}
          placeholder="Event Name"
          required
        />
        <input
          type="number"
          name="price"
          value={formData.price}
          onChange={handleChange}
          placeholder="Price"
          required
          min="0"
          step="0.01"
        />
        <input
          type="number"
          name="quantity"
          value={formData.quantity}
          onChange={handleChange}
          placeholder="Quantity"
          required
          min="1"
        />
        <button type="submit">Add Ticket</button>
        
        {message && <div className="success-message">{message}</div>}
        {error && <div className="error-message">{error}</div>}
      </form>
    </div>
  );
};

export default AddTicketForm;