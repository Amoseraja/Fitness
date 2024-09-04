import React, { useState } from 'react';
import NavComponent from '../NavCompontent';
import Footer from '../Footer';
import './Bmi.css'; // Import the CSS file

const Bmi = () => {
    const [weight, setWeight] = useState('');
    const [height, setHeight] = useState('');
    const [bmi, setBMI] = useState(null);
    const [message, setMessage] = useState('');
  
    const calculateBMI = () => {
      if (weight && height) {
        const heightInMeters = height / 100; // convert height to meters
        const calculatedBMI = (weight / (heightInMeters * heightInMeters)).toFixed(2);
  
        setBMI(calculatedBMI);
  
        if (calculatedBMI < 18.5) {
          setMessage('Underweight');
        } else if (calculatedBMI >= 18.5 && calculatedBMI < 24.9) {
          setMessage('Normal weight');
        } else if (calculatedBMI >= 25 && calculatedBMI < 29.9) {
          setMessage('Overweight');
        } else {
          setMessage('Obesity');
        }
      }
    };

    return (
      <>
        <NavComponent />
        <div className="bmi-container">
          <h1 className="bmi-title">BMI Calculator</h1>
          <div className="bmi-input-container">
            <input
              type="number"
              placeholder="Weight (kg)"
              value={weight}
              onChange={(e) => setWeight(e.target.value)}
              className="bmi-input"
            />
            <input
              type="number"
              placeholder="Height (cm)"
              value={height}
              onChange={(e) => setHeight(e.target.value)}
              className="bmi-input"
            />
          </div>
          <button onClick={calculateBMI} className="bmi-button">
            Calculate BMI
          </button>
          {bmi && (
            <div className="bmi-result">
              <h2>Your BMI: {bmi}</h2>
              <h3>{message}</h3>
            </div>
          )}
        </div>
        <Footer />
      </>
    );
}

export default Bmi;
