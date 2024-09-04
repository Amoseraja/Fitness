import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import jumping from './image/BMI.png';
import wegithloss from './image/images.png';
import './Doslay.css';
const Display = ({ userId }) => {
    const [profile, setProfile] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        if (userId) {
            // Fetch profile data from the API
            fetch(`http://localhost:8081/myfitness/profile/${userId}`)
                .then((response) => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then((data) => {
                    setProfile(data);
                    setLoading(false);
                })
                .catch((error) => {
                    setError(error);
                    setLoading(false);
                });
        }
    }, [userId]);

    if (loading) {
        return <p>Loading...</p>;
    }

    if (error) {
        return <p>Error: {error.message}</p>;
    }

    if (!profile) {
        return <p>No profile data available.</p>;
    }

    return (
        <div className="profile-container">
            <h1>USER PROFIT</h1>
            <h1 className="profile-title">{profile.username}</h1>
            <p className="profile-detail">Gender: {profile.gender}</p>
            <p className="profile-detail">Email: {profile.email}</p>
            <p className="profile-detail">Age: {profile.age}</p>
            <p className="profile-detail">Weight: {profile.weight} kg</p>
            <p className="profile-detail">Height: {profile.height} cm</p>
            <div className="card-container">
                <div className="card">
                    <img className="card-img-top" src={jumping} alt="BMI" />
                    <div className="card-body">
                        <h5 className="card-title">BMI</h5>
                        <p className="card-text">The BMI is calculated by dividing an adult's weight in kilograms by their height in metres squared.</p>
                        <Link to="/Bmi" className="btn btn-primary">Learn More</Link>
                    </div>
                </div>
               
    <ol>
    <h3>10 Tips for Weight Loss</h3>
        <li><strong>Set Realistic Goals:</strong> Start with small, achievable goals. Losing 1-2 pounds per week is a healthy and sustainable rate.</li>
        <li><strong>Balanced Diet:</strong> Focus on a balanced diet rich in fruits, vegetables, lean proteins, and whole grains. Avoid highly processed foods and sugary snacks.</li>
        <li><strong>Portion Control:</strong> Pay attention to portion sizes. Using smaller plates and bowls can help control portions and reduce calorie intake.</li>
        <li><strong>Stay Hydrated:</strong> Drink plenty of water throughout the day. Sometimes thirst is mistaken for hunger, leading to overeating.</li>
        <li><strong>Regular Exercise:</strong> Incorporate both cardio and strength training exercises. Aim for at least 150 minutes of moderate aerobic activity or 75 minutes of vigorous activity per week, plus strength training exercises on two or more days a week.</li>
        <li><strong>Mindful Eating:</strong> Be mindful of what you eat, savor your food, and avoid distractions like watching TV while eating. This can prevent overeating.</li>
        <li><strong>Sleep Well:</strong> Ensure you get 7-9 hours of sleep per night. Poor sleep can disrupt hormones that regulate hunger, leading to increased appetite.</li>
        <li><strong>Reduce Stress:</strong> Chronic stress can lead to emotional eating and weight gain. Practice stress-relieving activities like meditation, yoga, or deep breathing exercises.</li>
        <li><strong>Consistency Over Perfection:</strong> Focus on making consistent, healthy choices rather than being perfect. It’s okay to indulge occasionally, just make sure it doesn’t become a habit.</li>
        <li><strong>Track Progress:</strong> Keep track of your food intake, exercise, and weight loss progress. Apps or journals can help you stay accountable and motivated.</li>
    </ol>
    <p>Adopting these tips into your daily routine can help support a healthy weight loss journey.</p>
                <div className="card">
                    <img className="card-img-top" src={wegithloss} alt="Caloric Calculator" />
                    <div className="card-body">
                        <h5 className="card-title">Caloric Calculator</h5>
                        <p className="card-text">Though it differs depending on age and activity level, adult males generally require 2,000-3,000 calories per day to maintain weight.</p>
                        <Link to="/ccaloris" className="btn btn-primary">Learn More</Link>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Display;
