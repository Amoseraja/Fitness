import React from 'react';
import './Fortendview.css'; // Ensure the path is correct
import fitnessImage from './image/edgar-chaparro-sHfo3WOgGTU-unsplash.jpg'; // Ensure paths are correct
import running from './image/running.jpeg'; 
import yoga from './image/yoga.jpeg';
import jumping from './image/jumping.jpeg';
import weightLoss from './image/weigthloss.jpeg';
import { Link } from 'react-router-dom'; // Ensure Link is correctly imported

const Fortendview1 = () => {
  return (
    <>
      <div className="header">
        <div className="container">
          <div className="navbar">
            <div className="logo">
              <h1>healthy <span>grow</span></h1>
            </div>
            <nav>
              <ul>
                <li><Link to="/login">Login</Link></li>
              </ul>
            </nav>
          </div>
          <div className="row">
            <div className="col-1">
              <h1>Healthy Life<br />A New Style!</h1>
              <p>Are you planning to start a new journey or initiative in 90 days? <br />Could you please provide more details about the new offer? I'm happy to assist!</p>
              <Link to="/login" className="btn">Login now</Link>
            </div>
            <div className="col-2">
              <img src={fitnessImage} alt="Fitness" style={{ width: '1000px', height: '400px' }} />
            </div>
          </div>
        </div>
      </div>

      <div className="categories">
        <div className="small-container">
          <h1>Exercise</h1>
          <p>Improved Physical Health: Regular exercise strengthens your heart, muscles, and bones, enhances flexibility, and helps maintain a healthy weight.</p>
          <div className="row">
            <div className="col">
              <img src={running} alt="Running" />
              <h3>Running</h3>
            </div>
            <div className="col">
              <img src={yoga} alt="Yoga" />
              <h3>Yoga</h3>
            </div>
            <div className="col">
              <img src={jumping} alt="Jumping Rope" />
              <h3>Jumping Rope</h3>
            </div>
          </div>
        </div>
      </div>

      <div className="offer">
        <div className="small-container">
          <div className="row">
            <div className="col-2">
              <img src={weightLoss} alt="Weight Loss Journey" width="1200px" height="300px" />
            </div>
            <div className="col-2">
              <p>Join our 90-day weight loss journey.</p>
              <h1>Naveen</h1>
              <small>Naveen, who currently weighs 120 kg, aims to reduce 20 kg in 90 days through consistent exercise and a balanced diet. Stay committed, and you'll see great results!</small>
              <Link to="/login" className="btn">Login now</Link>
            </div>
          </div>
        </div>
      </div>

      <div className="testimonial">
        <div className="small-container">
          <div className="row">
            <div className="col-3">
              <i className="fa fa-quote-left"></i>
              <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Iusto distinctio suscipit reprehenderit nisi, enim architecto beatae error voluptatem sunt voluptas!</p>
              <div className="rating">
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
              </div>
              <h3>Amose <span>Kanagaraj</span></h3>
            </div>
            <div className="col-3">
              <i className="fa fa-quote-left"></i>
              <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Iusto distinctio suscipit reprehenderit nisi, enim architecto beatae error voluptatem sunt voluptas!</p>
              <div className="rating">
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
              </div>
              <h3>Naveen <span>Kumar</span></h3>
            </div>
            <div className="col-3">
              <i className="fa fa-quote-left"></i>
              <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Iusto distinctio suscipit reprehenderit nisi, enim architecto beatae error voluptatem sunt voluptas!</p>
              <div className="rating">
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
                <i className="fa fa-star"></i>
              </div>
              <h3>Logamithrran <span>Kumari</span></h3>
            </div>
          </div>
        </div>
      </div>

      <div className="footer">
        <div className="container">
          <div className="row">
            <div className="col-6 footer-col-1">
              <h3>Download Our App</h3>
              <p>Download the app for Android and iOS mobile phones.</p>
            </div>
            <div className="col-6 footer-col-2">
              <Link to="#" className="f-logo">
                <h1>healthy<span>grow</span></h1>
              </Link>
              <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Nobis, reiciendis.</p>
            </div>
            <div className="col-6 footer-col-3">
              <h3>Useful Links</h3>
              <ul>
                <li>Coupons</li>
                <li>Blog Post</li>
                <li>Return Policy</li>
                <li>Join Affiliates</li>
              </ul>
            </div>
            <div className="col-6 footer-col-4">
              <h3>Follow Us</h3>
              <ul>
                <li>Facebook</li>
                <li>Twitter</li>
                <li>Instagram</li>
                <li>YouTube</li>
              </ul>
            </div>
          </div>
          <hr />
          <p className="copyright">Copyright © healthy grow</p>
        </div>
      </div>
    </>
  );
}

export default Fortendview1;
