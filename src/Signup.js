import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Signup.css'; 
const Signup = () => {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        gender: '',
        age: '',
        email: '',
        phone: '',
        weight: '',
        height: '',
        goals: ''
    });

    const [responseMessage, setResponseMessage] = useState('');
    const navigate = useNavigate(); // Initialize navigate

    // Handle input changes
    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    // Handle form submission
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8081/myfitness/signup', formData);
            setResponseMessage(response.data); // Show success message
            navigate("/login"); // Redirect to homepage on success
        } catch (error) {
            setResponseMessage(error.response?.data || 'An error occurred'); // Show error message
        }
    };

    return (
        <div>
            <h2>Sign Up</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" name="username" placeholder="Username" value={formData.username} onChange={handleChange} required />
                <input type="password" name="password" placeholder="Password" value={formData.password} onChange={handleChange} required />
                <select name="gender" value={formData.gender} onChange={handleChange} required>
                    <option value="">Select Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                </select>
                <input type="number" name="age" placeholder="Age" value={formData.age} onChange={handleChange} required />
                <input type="email" name="email" placeholder="Email" value={formData.email} onChange={handleChange} required />
                <input type="text" name="phone" placeholder="Phone" value={formData.phone} onChange={handleChange} required />
                <input type="number" name="weight" placeholder="Weight" value={formData.weight} onChange={handleChange} required />
                <input type="number" name="height" placeholder="Height" value={formData.height} onChange={handleChange} required />
                <textarea name="goals" placeholder="Your Goals" value={formData.goals} onChange={handleChange} required />
                <button type="submit">Register</button>
            </form>
            {responseMessage && <p>{responseMessage}</p>}
        </div>
    );
};

export default Signup;
