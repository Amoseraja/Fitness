import React, { useEffect, useState, useContext } from 'react';
import NavComponent from './Compondent/NavCompontent';
import Footer from './Compondent/Footer';
import Bmi from './Compondent/Appcompondent/Bmi';
import { MyContext } from './App';  
import Display from './Display';
import Calorisfood from './Compondent/Calorisfood';

import Caloriscard from './Compondent/Appcompondent/Caloriscard';
import CaloricCalculator from './Compondent/CaloricCalculator';
import Caloricintake from './Compondent/Caloricintake';
import GetTotalFoodOfDay from './Compondent/GetTotalFoodOfDay';
import Lisrtable from './Compondent/Lisrtable';
import Displaytable from './Compondent/Displaytable';

import { useParams } from 'react-router-dom'; 
import Displayworkout from './Compondent/Displayworkout';
const Home = () => {
  //const { setcontextState } = useContext(MyContext); 
  //const userId = 20;
  const { userId } = useParams(); // Retrieve userId from URL
  const { setcontextState } = useContext(MyContext); 

  useEffect(() => {
    // Optionally set context state or perform other actions with userId
    setcontextState(prevState => ({ ...prevState, userId })); 
  }, [userId, setcontextState]);
  return (
    <>
       <NavComponent userId={userId}/>  
      
      
        
       {/* <Caloriscard userId={userId} />   */}

   {/* <Caloriscard/>  */}
  <Display userId={userId}/> 
 {/* <Displaytable userId={userId}/>    */}

   {/* <Displayworkout userId={userId}/> */}
 
      {/* <Footer /> */}
     
       <Footer />  
    </>
  );
}

export default Home;
