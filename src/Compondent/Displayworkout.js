import React, { useEffect, useState, useContext } from 'react';
import axios from 'axios';
import { useParams, Link } from 'react-router-dom';
import { MyContext } from '../App'; 
import GetTotalcaloris from './GetTotalcaloris';
import NavComponent from './NavCompontent';
import Footer from './Footer';

const Displayworkout = () => {
    const { userId } = useParams();
    const { setcontextState } = useContext(MyContext);
    const [calorieData, setCalorieData] = useState([]);
    const [date, setDate] = useState('');
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        if (date) {
            fetchCalorieData();
        }
    }, [date]);

    const fetchCalorieData = async () => {
        setLoading(true);
        try {
            const response = await axios.get(`http://localhost:8081/myfitness/calorieburiningday/${userId}`, {
                params: { date: date },
            });
            setCalorieData(response.data);
            setError(null);
        } catch (error) {
            console.error('Error fetching calorie intake data:', error);
            setError('Failed to fetch calorie intake data. Please check the date format or try again later.');
            setCalorieData([]);
        } finally {
            setLoading(false);
        }
    };

    const handleDateChange = (event) => {
        setDate(event.target.value);
    };

    return (
        <>
            <NavComponent userId={userId} />
            <div className="table-container">
                <h2>Calorie Intake Data</h2>
                <input
                    type="date"
                    value={date}
                    onChange={handleDateChange}
                    placeholder="Select date"
                />
                {loading && <div>Loading...</div>}
                {error && <div className="error">{error}</div>}
                {!loading && calorieData.length === 0 && !error && (
                    <div>No data available for the selected date.</div>
                )}
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Calories Burning</th>
                            <th>Minutes</th>
                            <th>Consumed Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {calorieData.map((item) => (
                            <tr key={item.id}>
                                <td>{item.id}</td>
                                <td>{item.name}</td>
                                <td>{item.caloriesBurning}</td>
                                <td>{item.minutes}</td>
                                <td>{item.consumedDate}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
                <Link to={`/dayofburing/${userId}`}>
                    <button>Add workout</button>
                </Link>
            </div>
            <GetTotalcaloris userId={userId} />
            <Footer />
        </>
    );
};

export default Displayworkout;
