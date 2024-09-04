//import React from 'react'
import React, { useEffect, useState, useContext } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { MyContext } from '../App'; // Adjust the path as necessary
import NavComponent from './NavCompontent';
import Footer from './Footer';
import './Caloricburing.css';
const Caloricburing = () => {
    const { userId } = useParams(); // Retrieve userId from URL
    const { setcontextState } = useContext(MyContext);
    const [workName, setWorkName] = useState('');
    const [userMinutes, setUserMinutes] = useState('');
    const [consumedDate, setConsumedDate] = useState('');
    const [error, setError] = useState(null);
    const [success, setSuccess] = useState(null);

   // const userId = 20; // This should be dynamically set based on your application's logic

    const handleSubmit = async (event) => {
        event.preventDefault();

        const calorieBurningDTO = {
            workName,
            userMinutes: parseInt(userMinutes),
            consumedDate,
        };

        try {
            const response = await axios.post(`http://localhost:8081/myfitness/burning/${userId}`, calorieBurningDTO);
            setSuccess('Calorie intake created successfully!');
            setError(null); // Clear error if the post is successful
        } catch (error) {
            console.error('Error creating calorie intake:', error);
            setError('Failed to create calorie intake. Please try again later.');
            setSuccess(null); // Clear success message on error
        }}
  return (
    <>
    <NavComponent userId={userId} />
    <div className="form-container">
        
    <h2>Create Calorie Burning</h2>
    <form onSubmit={handleSubmit}>
    <div className="form-group">
            <label>Work Name:</label>
            <input
                type="text"
                value={workName}
                onChange={(e) => setWorkName(e.target.value)}
                required
            />
        </div>
        <div>
            <label>User Minutes:</label>
            <input
                type="number"
                value={userMinutes}
                onChange={(e) => setUserMinutes(e.target.value)}
                required
            />
        </div>
        <div>
            <label>Consumed Date:</label>
            <input
                type="date"
                value={consumedDate}
                onChange={(e) => setConsumedDate(e.target.value)}
                required
            />
        </div>
        <button type="submit" className="submit-button">Create</button>
    </form>
    {error && <div className="error">{error}</div>}
    {success && <div className="success">{success}</div>}
    
</div>
<Footer/>
</>
);
};
  


export default Caloricburing