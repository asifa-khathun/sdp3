<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>My Profile</title>
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

.drop-down {
  float: left;
  overflow: hidden;
}
.dropdown {
  float: left;
  overflow: hidden;
}
.drop-down .drop-btn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
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

.navbar a:hover, .drop-down:hover .drop-btn {

  background-color: #ddd;
  color:black;
}
.navbar a:hover, .dropdown:hover .dropbtn {

  background-color: #ddd;
  color:black;
}
.dropdown-content {
right: 0;
    left: auto;
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
.dropdowncontent {
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
.dropdowncontent a {
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

.drop-down:hover .dropdown-content {
  display: block;
}
.dropdowncontent a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdowncontent {
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
  border-spacing: 1;
  margin-left:450px;
  width: 50%;
}

th, td {
  text-align: left;
  padding: 16px;
  width: 25%;
}

input[type=submit]:hover {
  color:yellow;
}

.abutton {
  background-color: navy;
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
.abutton:hover {
  color:yellow;
}


</style>

</head>



<body>


<div class="navbar">
  <a href="/jobseekerhome">Home</a>
  <a href="/jobseekerviewjobs">Jobs Offers</a>
  <a href="/jobseekerjobstatus/${jsemail}">Job Status</a>
	<div class="topnav-right">
			<div class="drop-down">
			    <button class="drop-btn">${jsname}&nbsp;
			      <i class="fa fa-caret-down"></i>
			    </button>
			    <div class="dropdown-content">
			      <a href="/jobseekerprofile">My Profile</a>
			      <a href="/jobseekerlogout">Logout</a>
			    </div>
			  </div> 
		
		</div>	  
	
</div>
<br>

<table align="center" id="myTable">

<c:forEach var="js" items="${jobseekers}">

<tr>
<th>Name</th>
<td>${js.fullName}</td>
<tr>
<tr>
<th>E-mail</th>
<td>${js.email}</td>
</tr>
<tr>
<th>Gender</th>
<td>${js.gender}</td>
<tr>
<tr>
<th>Age</th>
<td>${js.age}</td>
<tr>
<tr>
<th>Mobile Number</th>
<td>${js.mobile}</td>
<tr>
<tr>
<th>Address</th>
<td>${js.address}</td>
<tr>
<tr>
<th>Date of Birth</th>
<td>${js.dob}</td>
<tr>

<tr>
<th>10th Pass Year</th>
<td>${js.tenthpassyr}</td>
<tr>
<tr>
<th>10th Pass Percentage</th>
<td>${js.tenthpassper}</td>
<tr>
<tr>
<th>12th Pass Year</th>
<td>${js.twelfthpassyr}</td>
<tr>
<tr>
<th>12th Pass Percentage</th>
<td>${js.twelfthpassper}</td>
<tr>
<tr>
<th>Graduation Pass Year</th>
<td>${js.gradpassyr}</td>
<tr>
<tr>
<th>Graduation Pass Percentage</th>
<td>${js.gradpassper}</td>
<tr>
<tr>
<th>Number of Backlogs</th>
<td>${js.backlogs}</td>
<tr>

<tr>
<th>University/College Name</th>
<td>${js.uniname}</td>
<tr>
<tr>
<th>Branch</th>
<td>${js.branch}</td>
<tr>
<tr>
<th>MOOCS</th>
<td>${js.moocs}</td>
<tr>
<tr>
<th>Projects</th>
<td>${js.projects}</td>
<tr>
<tr>
<th>Skills</th>
<td>${js.skills}</td>
<tr>
<tr>
<th>LinkedIn profile link</th>
<td>${js.linkedin}</td>
<tr>
<tr>
<th>GIT profile link</th>
<td>${js.gitlink}</td>
<tr>


<tr>
<th>Global Certifications</th>
<td>${js.glob_certi}</td>
<tr>
<tr>
<th>Reference</th>
<td>${js.reference}</td>
<tr>
<tr>
<th>Extension Activities</th>
<td>${js.extn_activities}</td>
<tr>
<tr>
<th>Work Status</th>
<td>${js.workStatus}</td>
<tr>
<tr>
<th>Company Name</th>
<td>${js.companyName}</td>
<tr>
<tr>
<th>Experience</th>
<td>${js.exp}</td>
<tr>
</c:forEach>

</table>

<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<a href="/jobseekerprofileupdate"><button class="abutton">Edit Profile</button></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/jobseekerchangepassword"><button class="abutton">Change Password</button></a>

</body>
</html> 
