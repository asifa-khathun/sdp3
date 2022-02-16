<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>About Us</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: navy;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {

  background-color: #ddd;
  color:black;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
.topnav-right {
  float: right;
}




* {box-sizing: border-box}

.mySlides {display: none}
img {vertical-align: middle;}

/* Slideshow container */
.slideshow-container {
  max-width: 1000px;
  position: relative;
  margin: auto;
}

/* Next & previous buttons */
.prev, .next {
  cursor: pointer;
  position: absolute;
  top: 50%;
  width: auto;
  padding: 16px;
  margin-top: -22px;
  color: white;
  font-weight: bold;
  font-size: 18px;
  transition: 0.6s ease;
  border-radius: 0 3px 3px 0;
  user-select: none;
}

/* Position the "next button" to the right */
.next {
  right: 0;
  border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
  background-color: rgba(0,0,0,0.8);
}

/* Caption text */


/* Number text (1/3 etc) */


/* The dots/bullets/indicators */
.dot {
  cursor: pointer;
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}



/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
  .prev, .next,.text {font-size: 11px}
}


.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}




* {
  box-sizing: border-box;
}.column {
	margin: 25px 55px;
  float: left;
  width: 25%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {margin: 10x 10px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

</style>
</head>
<body>

<div class="navbar">
  <a href="/index">Home</a>
  <a href="/superadminlogin">SuperAdmin</a>
			  
			  
			  <div class="dropdown">
			    <button class="dropbtn">Recruiter
			      <i class="fa fa-caret-down"></i>
			    </button>
			    <div class="dropdown-content">
			      <a href="/recruiterregistration">Registration</a>
			      <a href="/recruiterlogin">Login</a>
			      
			    </div>
			  </div> 
			  
			  
			  <div class="dropdown">
			    <button class="dropbtn">Job Seeker
			      <i class="fa fa-caret-down"></i>
			    </button>
			    <div class="dropdown-content">
			      <a href="/jobseekerregistration">Registration</a>
			      <a href="/jobseekerlogin">Login</a>
			    </div>
			  </div> 
			  
			  
	<div class="topnav-right">
		<a href="/aboutus">About</a>
	    <a href="/contactus">Contact us</a>
    </div>
</div>
<br><br>



<div class="row">
  <div class="column">
    <div class="card">
	  <img src="${pageContext.request.contextPath}/images/siri.jpg" alt="siri" style="width:100%">
	  <h2>Kumari Sirivarshitha</h2>
	  <p>190030030</p>
	  <a><p class="title">sirivarshitha@gmail.com</p></a>
	  <div style="margin: 24px 0;">
	    <a href="#"><i class="fa fa-dribbble"></i></a> 
	    <a href="#"><i class="fa fa-twitter"></i></a>  
	    <a href="#"><i class="fa fa-linkedin"></i></a>  
	    <a href="#"><i class="fa fa-facebook"></i></a> 
	  </div>
	  <p><button></button></p>
	</div>
  </div>

  <div class="column">
    <div class="card">
	  <img src="${pageContext.request.contextPath}/images/asifa.jpg" alt="asifa" style="width:100%">
	  <h2>Asifa Khathun</h2>
	  <p>190031559</p>
	  <a><p class="title">asifakhathun@gmail.com</p></a>
	  <div style="margin: 24px 0;">
	    <a href="#"><i class="fa fa-dribbble"></i></a> 
	    <a href="#"><i class="fa fa-twitter"></i></a>  
	    <a href="#"><i class="fa fa-linkedin"></i></a>  
	    <a href="#"><i class="fa fa-facebook"></i></a> 
	  </div>
	  <p><button></button></p>
	</div>
  </div>
  
  <div class="column">
    <div class="card">
	  <img src="${pageContext.request.contextPath}/images/santhi.jpeg" alt="santhi" style="width:100%">
	  <h2>Santhi Priya</h2>
	  <p>190030877</p>
	  <a><p class="title">santhipriya@gmail.com</p></a>
	  <div style="margin: 24px 0;">
	    <a href="#"><i class="fa fa-dribbble"></i></a> 
	    <a href="#"><i class="fa fa-twitter"></i></a>  
	    <a href="#"><i class="fa fa-linkedin"></i></a>  
	    <a href="#"><i class="fa fa-facebook"></i></a> 
	  </div>
	  <p><button></button></p>
    </div>
  </div>
  
</div>




</body>
</html>
