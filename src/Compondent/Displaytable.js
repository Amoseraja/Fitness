import React, { useEffect, useState , useContext} from 'react';
import axios from 'axios';
import GetTotalFoodOfDay from './GetTotalFoodOfDay';
import './Displaytable.css'
import NavComponent from './NavCompontent';
import Footer from './Footer';
import { Link } from 'react-router-dom';
import { MyContext } from '../App'; // Adjust the path as necessary
  
import { useParams } from 'react-router-dom';
const Displaytable = () => {
  const { userId } = useParams(); // Retrieve userId from URL
   const { setcontextState } = useContext(MyContext);
    const [calorieData, setCalorieData] = useState([]);
    const [date, setDate] = useState('');
    const [error, setError] = useState(null);
  
    useEffect(() => {
      if (date) {
        fetchCalorieData();
      }
    }, [date]);
  
    const fetchCalorieData = async () => {
      try {
        const response = await axios.get(`http://localhost:8081/myfitness/calorieintakeday/${userId}`, {
          params: { date: date },
        });
        setCalorieData(response.data);
        setError(null); // Clear error if the fetch is successful
      } catch (error) {
        console.error('Error fetching calorie intake data:', error);
        setError('Failed to fetch calorie intake data. Please check the date format or try again later.');
        setCalorieData([]); // Clear data on error
      }
    };
  
    const handleDateChange = (e) => {
      setDate(e.target.value); // Update date state when user selects a new date
    };
  
    return (
        <>
       
         <NavComponent userId={userId}/>   
      <div className="table-container">
        <h2>Calorie Intake Data</h2>
        <input
          type="date"
          value={date}
          onChange={handleDateChange}
          placeholder="Select date"
        />
        {error && <div className="error">{error}</div>}
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Quality</th>
              <th>Calories</th>
              <th>Meal Type</th>
              <th>Consumed Date</th>
            </tr>
          </thead>
          <tbody>
            {calorieData.map((item) => (
              <tr key={item.id}>
                <td>{item.id}</td>
                <td>{item.name}</td>
                <td>{item.quality}</td>
                <td>{item.calories}</td>
                <td>{item.mealType}</td>
                <td>{item.consumedDate}</td>
              </tr>
            ))}
          </tbody>
        </table>
        <Link to={`/calorisintake/${userId}`}>
  <button>Add Food</button>
</Link>

      </div>
      <GetTotalFoodOfDay userId={userId}/>
      <Footer/>
      </>
    );
};

export default Displaytable;
