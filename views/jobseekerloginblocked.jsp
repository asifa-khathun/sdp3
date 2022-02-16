<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>JobSeeker Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

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

input[type=text], input[type=password],select, textarea {
  width: 50%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=submit] {
  background-color: navy;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  color:yellow;
}

.container {
	position: absolute;
  right: 120px;  
  width: 40%;
  height: 400px;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 50px;
}
.bg-img {
  /* The image used */
  background: url(images/l3.gif) no-repeat;
  background-size: 100%;
  min-height: 800px;
  /* Center and scale the image nicely */
  background-position: left top;
  background-repeat: no-repeat;
  background-size: 500px 500px;
  position: relative;
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
<h1 style="text-align:center;font-size:1.5em;font-weight: normal;color:red">Oops!! You have been blocked!</h1>
<h1 style="text-align:center;font-size:1.5em;font-weight: normal;color:red">For any queries reach us at <a href="/contactus">here</a></h1><br>
<div class="bg-img">
  		<form class="container" method="POST" action="/jobseekerlogincheck" modelAttribute="js">
  		<h1 style="text-align:center;font-size:1.5em;font-weight: normal">Job Seeker Login</h1>
    <br>
    <label for="email">Email</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="text" id="email" name="email" placeholder="">
			<br>
    <label for="password">Password</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="password" id="password" name="password" placeholder="">
	<br>
    <input type="checkbox" onclick="myFunction()">Show Password

<script>
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
<br><br>
    
    
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="Login" align="center">
    <br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    
    <a align="center" href="/jobseekerchangepwdbefore">Forgot Password??</a>
  </form>
</div>

</body>
</html>
