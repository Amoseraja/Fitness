import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Listtable.css';

const Lisrtable = ({ userId, locale = 'en-US', dateFormat = 'yyyy-MM-dd' }) => {
    const [foodData, setFoodData] = useState({});
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchFoodData = async () => {
            try {
                // Fetching grouped food intake data by day
                const response = await axios.get(`http://localhost:8081/fitness/food/user/${userId}`);
                setFoodData(response.data);
            } catch (err) {
                setError("Error fetching food data");
                console.error(err);
            }
        };

        fetchFoodData();
    }, [userId]);

    // Function to format dates for display
    const formatDate = (dateStr) => {
        return new Intl.DateTimeFormat(locale, { year: 'numeric', month: 'long', day: 'numeric' }).format(new Date(dateStr));
    };

    return (
        <div className="food-list-container">
            <h2>Daily Food Intake</h2>
            {error && <p className="error">{error}</p>}
            {Object.keys(foodData).length === 0 ? (
                <p>No food intake data available.</p>
            ) : (
                Object.entries(foodData).map(([date, foods]) => (
                    <div key={date} className="food-day">
                        <h3>{formatDate(date)}</h3>
                        <ul>
                            {Array.isArray(foods) ? (
                                foods.map((food) => (
                                    <li key={food.id} className="food-item">
                                        <span className="food-name">{food.name}</span> - 
                                        <span className="food-quality">{food.quality}</span> units - 
                                        <span className="meal-type">{food.mealType}</span>
                                    </li>
                                ))
                            ) : (
                                <li>No food data available for this date.</li>
                            )}
                        </ul>
                    </div>
                ))
            )}
        </div>
    );
};

export default Lisrtable;
