

import AddWorkout from './Compondent/AddWorkout';
import Bmi from './Compondent/Appcompondent/Bmi';
import Caloriscard from './Compondent/Appcompondent/Caloriscard';
import Caloricburing from './Compondent/Caloricburing';
import CaloricCalculator from './Compondent/CaloricCalculator';
import Caloricintake from './Compondent/Caloricintake';
import Calorisfood from './Compondent/Calorisfood';
import Displaytable from './Compondent/Displaytable';
import Displayworkout from './Compondent/Displayworkout';
import Fortendview1 from './Fortendview1';
import Home from './Home';
import Login from './Login';
 import Signup from './Signup';
 
 import { createContext ,useState} from 'react';
 
 import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
export const MyContext =createContext();

  

function App() {
  //const [contextstate, setcontextstate] = useState(null);
  const [contextstate, setcontextState] = useState({
    username:""
  });


  return (
   // <Fortendview1/>
    //<Signup/>
   // <Login/>
    // <Home/>
    <MyContext.Provider value={{contextstate, setcontextState}}>
     <Router>
          <Routes>
            <Route path="/" element={<Fortendview1/>} />
            <Route path="/login" element={<Login/>} />
            <Route path="/signup" element={<Signup/>} />
            <Route path="/Bmi" element={<Bmi/>} />
            {/* <Route path="/Bmi" element={<Bmi/>} /> */}
            <Route path="/ccaloris" element={<CaloricCalculator/>} />
            {/* <Route path="/home" element={<Home/>} /> */}
            <Route path="/home/:userId" element={<Home />} />
            <Route path="/DAYFOOD/:userId" element={<Displaytable />} />
            <Route path="/DAYWorkout/:userId" element={<Displayworkout />} />
            {/* <Route path="/calorisintake/:userId" element={<Caloricintake />} /> */}
            <Route path="/calorisintake/:userId" element={<Caloricintake />} />
            <Route path="/calorisfood/:userId" element={<Calorisfood />} />
            <Route path="/workoutburing/:userId" element={<AddWorkout/>} />
            <Route path="/dayofburing/:userId" element={<Caloricburing/>} />
            <Route path="/userfoodworkout/:userId" element={<Caloriscard/>} />
            <Route/>
          </Routes>
        </Router> 
        </MyContext.Provider>

        
        
  );
 
  };


export default App;
