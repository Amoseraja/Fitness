import React from 'react'
import'./Footer.css'
import { Link } from 'react-router-dom';
const Footer = () => {
  return (
    <div className="footer1">
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
  )
}

export default Footer