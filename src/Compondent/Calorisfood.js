import React, { useState, useContext } from 'react';
import axios from 'axios';
import './Calorisfood.css';
import { MyContext } from '../App'; // Adjust the path as necessary
import { useParams } from 'react-router-dom';
import NavComponent from './NavCompontent';
import Footer from './Footer';

const Calorisfood = () => {
    const { userId } = useParams(); // Retrieve userId from URL
    const { setcontextState } = useContext(MyContext); // Ensure this is necessary
    const [name, setName] = useState('');
    const [quality, setQuality] = useState('');
    const [calories, setCalories] = useState('');
    const [protein, setProtein] = useState('');
    const [carb, setCarb] = useState('');
    const [fat, setFat] = useState('');
    const [footpicture, setFootpicture] = useState('');
    const [success, setSuccess] = useState(false); // State to track successful submission
    const [error, setError] = useState(''); // State to track error messages

    const handleSubmit = async (e) => {
        e.preventDefault();

        const foodItem = {
            name,
            quality: parseInt(quality),
            calories: parseInt(calories),
            protein: parseInt(protein),
            carb: parseInt(carb),
            fat: parseInt(fat),
            footpicture,
        };

        try {
            const response = await axios.post(`http://localhost:8081/fitness/food/add/${userId}`, foodItem, {
                headers: {
                    'Content-Type': 'application/json',
                },
            });
            console.log('Food item created:', response.data);
            setSuccess(true); // Set success to true on successful submission
            setError(''); // Clear any previous error
            // Reset form fields after successful submission
            setName('');
            setQuality('');
            setCalories('');
            setProtein('');
            setCarb('');
            setFat('');
            setFootpicture('');
        } catch (error) {
            console.error('There was an error creating the food item!', error);
            setSuccess(false); // Ensure success is false on error
            setError('There was an error creating the food item!'); // Set an error message
        }
    };

    return (
        <>
        <NavComponent userId={userId}/>
        <form onSubmit={handleSubmit} className="calorisfood-form">
            <h2>Add Food Item</h2>
            {success && <div className="success-message">Food item added successfully!</div>}
            {error && <div className="error-message">{error}</div>}
            <label>
                Name:
                <input type="text" value={name} onChange={(e) => setName(e.target.value)} />
            </label>
            <label>
                Quality:
                <input type="number" value={quality} onChange={(e) => setQuality(e.target.value)} />
            </label>
            <label>
                Calories:
                <input type="number" value={calories} onChange={(e) => setCalories(e.target.value)} />
            </label>
            <label>
                Protein:
                <input type="number" value={protein} onChange={(e) => setProtein(e.target.value)} />
            </label>
            <label>
                Carb:
                <input type="number" value={carb} onChange={(e) => setCarb(e.target.value)} />
            </label>
            <label>
                Fat:
                <input type="number" value={fat} onChange={(e) => setFat(e.target.value)} />
            </label>
            <label>
                Footpicture URL:
                <input type="text" value={footpicture} onChange={(e) => setFootpicture(e.target.value)} />
            </label>
            <button type="submit">Add Food Item</button>
        </form>
        <Footer/>
        </>
    );
};

export default Calorisfood;
