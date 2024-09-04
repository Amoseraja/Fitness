//import React from 'react'
import React, { useState } from "react";
import "./CaloricCalculator.css"; 
import NavComponent from "./NavCompontent";
import Footer from "./Footer";
const CaloricCalculator = () => {
    const [age, setAge] = useState(0);
    const [weight, setWeight] = useState(0);
    const [height, setHeight] = useState(0);
    const [activityLevel, setActivityLevel] = useState("sedentary");
    const [calories, setCalories] = useState(null);

    const handleSubmit = (e) => {
        e.preventDefault();

        const requestData = { age, weight, height, activityLevel };

        fetch("http://localhost:8081/myfitness/calculate-calories", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(requestData),
        })
        .then((response) => response.json())
        .then((data) => setCalories(data))
        .catch((error) => console.error("Error:", error));
    };
  return (
    <>
    <NavComponent/>
    <div className="calculator-container">
            <h1>Caloric Calculator</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Age:</label>
                    <input type="number" value={age} onChange={(e) => setAge(e.target.value)} />
                </div>
                <div>
                    <label>Weight (kg):</label>
                    <input type="number" value={weight} onChange={(e) => setWeight(e.target.value)} />
                </div>
                <div>
                    <label>Height (cm):</label>
                    <input type="number" value={height} onChange={(e) => setHeight(e.target.value)} />
                </div>
                <div>
                    <label>Activity Level:</label>
                    <select value={activityLevel} onChange={(e) => setActivityLevel(e.target.value)}>
                        <option value="sedentary">Sedentary</option>
                        <option value="lightly active">Lightly Active</option>
                        <option value="moderately active">Moderately Active</option>
                        <option value="very active">Very Active</option>
                    </select>
                </div>
                <button type="submit">Calculate</button>
            </form>

            {calories && (
                <div className="calories-result">
                    <h2>Daily Caloric Needs: {calories} kcal</h2>
                </div>
            )}
        </div>
        <Footer/>
        </>
    );
  
}

export default CaloricCalculator