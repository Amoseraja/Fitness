//import React from 'react'
import React, { useState } from "react";
import axios from "axios";
const GetTotalcaloris = ({ userId }) => {
    const [date, setDate] = useState("");
    const [totalFood, setTotalFood] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const res = await axios.get(`http://localhost:8081/myfitness/burning/total/${userId}`, {
                params: {
                    date: date,
                },
            });
            setTotalFood(res.data);
        } catch (err) {
            console.error("Error fetching total food of the day", err);
        }
    };
  return (
    <div className="get-total-food-container">
    <h2>Get Total calorieburiningday</h2>
    <form onSubmit={handleSubmit}>
        <label>
            Date:
            <input
                type="date"
                value={date}
                onChange={(e) => setDate(e.target.value)}
            />
        </label>
        <button type="submit">Get Total </button>
    </form>
    {totalFood !== null && (
        <div className="total-food-intake">Total burning Intake: {totalFood} calories</div>
    )}
</div>
);
};

export default GetTotalcaloris