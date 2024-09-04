import React, { useState } from "react";
import axios from "axios";
import { useParams } from "react-router-dom";
import Footer from "./Footer";
import NavComponent from "./NavCompontent";
import './Addworkout.css'; // Import the CSS file

const AddWorkout = () => {
  const { userId } = useParams(); // Retrieve userId from the URL
  const [workout, setWorkout] = useState({
    name: "",
    workPicture: "",
    minutes: 0,
    caloriesburning: 0,
    userId: userId // 
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setWorkout({ ...workout, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        `http://localhost:8081/workouts/save/${userId}`,
        workout
      );
      console.log('Workout added successfully:', response.data);
      if (response.status === 201) {
        alert("Workout added successfully!");
        setWorkout({ name: "", workPicture: "", minutes: 0, caloriesburning: 0 }); // Reset form after successful submission
      }
    } catch (error) {
      console.error("Error adding workout:", error);
      alert("Failed to add workout. Please try again.");
    }
  };

  return (
    <>
      <NavComponent userId={userId} />
      <div className="form-container">
        <h2>Add New Workout</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="workoutName">Workout Name</label>
            <input
              type="text"
              id="workoutName"
              name="name"
              value={workout.name}
              onChange={handleChange}
              placeholder="Enter workout name"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="workPicture">Workout Picture</label>
            <input
              type="text"
              id="workPicture"
              name="workPicture"
              value={workout.workPicture}
              onChange={handleChange}
              placeholder="Enter workout picture name"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="workoutMinutes">Minutes</label>
            <input
              type="number"
              id="workoutMinutes"
              name="minutes"
              value={workout.minutes}
              onChange={handleChange}
              placeholder="Enter minutes"
              required
            />
          </div>

          <div className="form-group">
            <label htmlFor="workoutCalories">Calories Burning</label>
            <input
              type="number"
              id="workoutCalories"
              name="caloriesburning"
              value={workout.caloriesburning}
              onChange={handleChange}
              placeholder="Enter calories burned"
              required
            />
          </div>

          <button type="submit" className="submit-button">
            Add Workout
          </button>
        </form>
      </div>
      <Footer />
    </>
  );
};

export default AddWorkout;
