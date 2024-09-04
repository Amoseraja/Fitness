import React, { useState, useEffect, useContext } from "react";
import axios from "axios";
import './Caloricintake.css';
import Footer from "./Footer";
import NavComponent from "./NavCompontent";
import { MyContext } from '../App'; // Adjust the path as necessary
  
import { useParams } from 'react-router-dom'; 
const Caloricintake = () => {
   // const { userId } = useParams();
   const { userId } = useParams(); // Retrieve userId from URL
   const { setcontextState } = useContext(MyContext);
    const [caloricFood, setCaloricFood] = useState({
        name: "",
        quality: 0,
        mealType: "",
        consumedDate: ""
    });
    const [response, setResponse] = useState(null);
    const [intakes, setIntakes] = useState([]);

    // Fetch existing caloric intake records for the user
    useEffect(() => {
        const fetchIntakes = async () => {
            try {
                const res = await axios.get(`http://localhost:8081/myfitness/getcaloricintake/${userId}`);
                setIntakes(res.data);
            } catch (err) {
                console.error("Error fetching caloric intake data", err.response?.data || err.message);
            }
        };

        fetchIntakes();
    }, [userId]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCaloricFood({
            ...caloricFood,
            [name]: value,
        });
    };

    const isValid = () => {
        // Basic validation to ensure fields are filled correctly
        return caloricFood.name && caloricFood.quality > 0 && caloricFood.mealType && caloricFood.consumedDate;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (!isValid()) {
            alert("Please fill in all fields correctly.");
            return;
        }
        try {
            const res = await axios.post(`http://localhost:8081/myfitness/createcaloirintake/${userId}`, caloricFood);
            setResponse(res.data);
            // Add the new intake to the list using functional state update to avoid stale state issues
            setIntakes((prevIntakes) => [...prevIntakes, res.data]);
            // Reset the form
            setCaloricFood({
                name: "",
                quality: 0,
                mealType: "",
                consumedDate: ""
            });
        } catch (err) {
            console.error("Error creating caloric intake", err.response?.data || err.message);
        }
    };

    // Grouping intakes by date
    const groupedIntakes = intakes.reduce((acc, intake) => {
        if (!acc[intake.consumedDate]) {
            acc[intake.consumedDate] = [];
        }
        acc[intake.consumedDate].push(intake);
        return acc;
    }, {});

    return (
        <>
         <NavComponent userId={userId}/>  
        <div className="container12">
            <h2>Create Caloric Intake</h2>
            <form onSubmit={handleSubmit} className="caloric-form">
                <label>
                    Food Name:
                    <input
                        type="text"
                        name="name"
                        value={caloricFood.name}
                        onChange={handleChange}
                    />
                </label>
                <label>
                    Quality:
                    <input
                        type="number"
                        name="quality"
                        value={caloricFood.quality}
                        onChange={handleChange}
                    />
                </label>
                <div>
                    <span>Meal Type:</span>
                    {["Breakfast", "Lunch", "Dinner", "Snack"].map((type) => (
                        <label key={type}>
                            <input
                                type="radio"
                                name="mealType"
                                value={type}
                                checked={caloricFood.mealType === type}
                                onChange={handleChange}
                            />
                            {type}
                        </label>
                    ))}
                </div>
                <label>
                    Consumed Date:
                    <input
                        type="date"
                        name="consumedDate"
                        value={caloricFood.consumedDate}
                        onChange={handleChange}
                    />
                </label>
                <button type="submit">Submit</button>
            </form>
            {response && <div className="response">Caloric Intake Created Successfully!</div>}
            {/* {intakes.length === 0 ? (
                <div>No caloric intake records found.</div>
            ) : (
                <div>
                    <h3>Your Caloric Intakes:</h3>
                    {Object.entries(groupedIntakes).map(([date, intakes]) => (
                        <div key={date}>
                            <h4>{date}</h4>
                            <ul>
                                {intakes.map((intake, index) => (
                                    <li key={index}>{`${intake.name} - ${intake.quality}g (${intake.mealType})`}</li>
                                ))}
                            </ul> */}
                        {/* </div>
                    ))} */}
                </div>
            )
        {/* </div> */}
        <Footer/>
        </>
    );
   
};

export default Caloricintake;
