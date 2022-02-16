<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>Recruiter Requests</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body {
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

table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid black;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

.abutton {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.rbutton {
  background-color: #f44336;;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button {
  background-color: #FAFA33;
  border: none;
  color: black;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>

</head>



<body>


<div class="navbar">
  <a href="/superadminhome">Home</a> 
  			  
			  <div class="dropdown">
			    <button class="dropbtn">Recruiter
			      <i class="fa fa-caret-down"></i>
			    </button>
			    <div class="dropdown-content">
			      <a href="/recruiterrequests">Requests</a>
			      <a href="/recruitersall">View All</a>
			      
			    </div>
			  </div> 
			
	<a href="/jobseekersviewalladmin">Job Seekers</a>  
			  
			 
	<div class="topnav-right">
		<a href="/superadminchangepwd">Change Password</a>
		<a href="/superadminlogout">Logout</a>
    </div>
</div>
<br>
<h2 align=center>Pending Requests from Recruiters</h2><br/>
<!--<caption>Requests from Recruiters</caption><br>-->
<table align=center border=1>
<tr>
<th>Name</th>
<th>E-mail</th>
<th>Employer ID</th>
<th>Gender</th>
<th>Age</th>
<th>Mobile Number</th>
<th>Company Name</th>
<th>Company Location</th>
<th>Company Location</th>
<th>View Proof</th>
<th>Reject Request</th>
</tr>

<c:forEach var="rec" items="${recdata}">

<tr>
<td>${rec.fullName}</td>
<td>${rec.email}</td>
<td>${rec.empid}</td>
<td>${rec.gender}</td>
<td>${rec.age}</td>
<td>${rec.mobile}</td>
<td>${rec.companyName}</td>
<td>${rec.companyLoc}</td>
<td><a href="/recruiterproof/${rec.proof}"><button class="button">View Proof</button></a>
</td>
<td><a href="/acceptrecruiter/${rec.email}"><button class="abutton">Accept</button></a>
</td>
<td><a href="/rejectrecruiter/${rec.email}"><button class="rbutton">Reject</button></a>
</td>
</tr>

</c:forEach>

</table>

</body>
</html> 
