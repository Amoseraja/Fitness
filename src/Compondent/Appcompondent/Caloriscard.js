import React, { useEffect, useState, useContext } from "react";
import { Card as BootstrapCard, Button } from "react-bootstrap";
import axios from "axios";
import'./Caloris.css' // Import the CSS file
import { Link, useParams } from "react-router-dom";
import { MyContext } from '../../App'; // Adjust the path based on the actual location of App.js
import Footer from "../Footer";
import NavComponent from "../NavCompontent"; // Ensure NavComponent is imported

const Caloriscard = () => {
  const { userId } = useParams(); // Retrieve userId from URL
  const { setcontextState } = useContext(MyContext);
  const [foodItems, setFoodItems] = useState([]);
  const [workouts, setWorkouts] = useState([]);

  useEffect(() => {
    if (userId) {
      fetchProfileData();
    }
  }, [userId]);

  const fetchProfileData = async () => {
    try {
      const response = await axios.get(`http://localhost:8081/myfitness/profile/${userId}`);
      
      // Handle foodItems
      if (Array.isArray(response.data.foodItems)) {
        setFoodItems(response.data.foodItems);
      } else {
        console.error("Unexpected foodItems format:", response.data.foodItems);
        setFoodItems([]);
      }

      // Handle workouts
      if (Array.isArray(response.data.workouts)) {
        setWorkouts(response.data.workouts);
      } else {
        console.error("Unexpected workouts format:", response.data.workouts);
        setWorkouts([]);
      }
    } catch (error) {
      console.error("Error fetching profile data", error);
      setFoodItems([]);
      setWorkouts([]);
    }
  };

  const handleDelete = async (foodItemId) => {
    try {
      await axios.delete(`http://localhost:8081/fitness/food/delete/${foodItemId}`); // Include foodItemId in URL
      fetchProfileData(); // Refresh food items after deletion
    } catch (error) {
      console.error("Error deleting food item", error);
    }
  };

  return (
    <>
      {/* <NavComponent userId={userId}/>   */}
      <NavComponent userId={userId}/>
      <div className="container1">
        <h1>FOOD OF Calorics</h1>
        <div className="row">
          {foodItems.length > 0 ? (
            foodItems.map((foodItem) => (
              <div className="col-md-4 mb-4" key={foodItem.id}>
                <BootstrapCard className="custom-card1">
                  <BootstrapCard.Body className="custom-card-body1">
                    <BootstrapCard.Title className="custom-card-title1">
                      {foodItem.name}
                    </BootstrapCard.Title>
                    <BootstrapCard.Text className="custom-card-text1">
                      Quality: {foodItem.quality} <br />
                      Calories: {foodItem.calories} kcal <br />
                      Protein: {foodItem.protein} g <br />
                      Carbohydrates: {foodItem.carb} g <br />
                      Fat: {foodItem.fat} g
                    </BootstrapCard.Text>
                   
                  </BootstrapCard.Body>
                </BootstrapCard>
              </div>
            ))
          ) : (
            <p>No food items found.</p>
          )}
        </div>
<h1>----------------------------------------------------------------------</h1>
        <h1>Workouts</h1>
        <div className="row">
          {workouts.map((workout) => (
            <div className="col-md-4 mb-4" key={workout.id}>
              <BootstrapCard className="custom-card1">
                <BootstrapCard.Body className="custom-card-body1">
                  <BootstrapCard.Title className="custom-card-title1">
                    {workout.name}
                  </BootstrapCard.Title>
                  <BootstrapCard.Text className="custom-card-text1">
                    Minutes: {workout.minutes} <br />
                    Calories Burned: {workout.caloriesburning}
                  </BootstrapCard.Text>
                </BootstrapCard.Body>
              </BootstrapCard>
            </div>
          ))}
        </div>

        <Link to={`/calorisfood/${userId}`}>
          <Button variant="success" className="add-food-button">Add Food</Button>
        </Link>
        <Link to={`/workoutburing/${userId}`}>
          <Button variant="success" className="add-food-button">Add Workout</Button>
        </Link>
      </div>
      <Footer /> {/* Closing tag added */}
    </>
  );
};

export default Caloriscard;
