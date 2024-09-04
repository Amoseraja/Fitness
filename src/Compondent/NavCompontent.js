import React from 'react';
import './Nav.css';
import { Link } from 'react-router-dom';

const NavComponent = ({ userId }) => {
  return (
    <nav className="navbar1">
      <div className="navbar-logo1">
        <h1>healthy<span>grow</span></h1>
      </div>
      <ul className="navbar-links1">
        <li>
          <Link to={`/home/${userId}`}>Home</Link>
        </li>
        <li>
          <Link to={`/DAYFOOD/${userId}`}>Calorieintakeday</Link>
        </li>
        <li>
          <Link to={`/DAYWorkout/${userId}`}> calories burning</Link>
        </li>
        <li>
          <Link to={`/userfoodworkout/${userId}`}>food and workout</Link>
        </li>
      </ul>
    </nav>
  );
};

export default NavComponent;
