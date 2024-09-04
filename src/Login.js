import React, { useState, useContext } from 'react';
import './Login.css';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { MyContext } from './App';  // Import MyContext if you plan to use it

const Login = () => {
  const { setcontextState } = useContext(MyContext);  // Use context to set user data if necessary
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    if (password.length < 8) {
      setError('Password must be at least 8 characters long.');
      return;
    }
  
    try {
      const response = await axios.post('http://localhost:8081/myfitness/login', {
        username,
        password,
      });
  
      const userData = response.data; // Assuming the API returns an object containing userId
      const userId = userData.userId; // Extract userId from the response
  
      // Save user data to context if needed
      setcontextState({ username: userData.username, userId });  // Include userId in the context state
      console.log(setcontextState); 
  
      // Navigate to home page with the userId
      navigate(`/home/${userId}`);  // Include userId in the URL
    } catch (error) {
      setError(error.response?.data || 'An error occurred during login.');
    }
  };

  return (
    <div className="wrapper">
      <div className="title1">Login Form</div>
      <form onSubmit={handleSubmit}>
        <div className="field">
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
          <label>Email Address</label>
        </div>
        <div className="field">
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
          <label>Password</label>
        </div>
        <div className="content">
          <div className="checkbox">
            <input type="checkbox" id="remember-me" />
            <label htmlFor="remember-me">Remember me</label>
          </div>
          <div>Forgot password?</div>
        </div>
        <div className="field">
          <input type="submit" value="Login" />
        </div>
        <div className="signup-link">
          Not a member? <Link to="/signup">Signup now</Link>
        </div>
        {error && <p className="error">{error}</p>}
      </form>
    </div>
  );
};

export default Login;
