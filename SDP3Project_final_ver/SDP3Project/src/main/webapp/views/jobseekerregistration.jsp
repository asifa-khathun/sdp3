<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>JobSeeker Registration</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
* {
  box-sizing: border-box;
}

body {
  background-color: #ffffff;
}

#regForm {
  background-color: #f1f1f1;
  position: absolute;
  right: 120px;  
  width: 45%;
  border-radius: 5px;
  padding: 50px;
  /*right: 120px;  
  margin: 100px auto;
  font-family: Raleway;
  padding: 40px;
  width: 50%;
  min-width: 300px;*/
}

h1 {
  text-align: center;  
}

input {
  padding: 10px;
  width: 100%;
  font-size: 17px;
  font-family: Arial, Helvetica, sans-serif;
  border: 1px solid #aaaaaa;
}

/* Mark input boxes that gets an error on validation: */
input.invalid {
  background-color: #FF6347;
}

/* Hide all steps by default: */
.tab {
  display: none;
}

button {
  background-color: navy;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  opacity: 0.8;
}

#prevBtn {
  background-color: #bbbbbb;
}

/* Make circles that indicate the steps of the form: */
.step {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbbbbb;
  border: none;  
  border-radius: 50%;
  display: inline-block;
  opacity: 0.5;
}

.step.active {
  opacity: 1;
}

/* Mark the steps that are finished and valid: */
.step.finish {
  background-color: navy;
}
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

input[type=text],input[type=number],select, textarea {
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
  width: 45%;
  height: 800px;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 50px;
}
.bg-img {
  /* The image used */
  background: url(images/r2.gif) no-repeat;
  background-size: 100%;
  min-height: 800px;
  /* Center and scale the image nicely */
  background-position: left top;
  background-repeat: no-repeat;
  background-size: 600px 600px;
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
<br><br><br>
<div class="bg-img">
<form id="regForm" method="POST" action="/addjobseekersubmit" modelAttribute="js">
   <!--<h1 style="text-align:center;font-size:1.5em;font-weight: normal" >Register:</h1>-->
  <!-- One "tab" for each step in the form: -->
  <div class="tab"><!-- <h1 style="text-align:center;font-size:1.5em;font-weight: normal" >Personal Details</h1><br>-->
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;
  PERSONAL DETAILS<br><br>
    Full Name:<p><input placeholder="Full name..." oninput="this.className = ''" name="fullName"></p>
    Email:<p><input placeholder="Email..." oninput="this.className = ''" name="email"></p>
    Age:<p><input placeholder="Age in number..." oninput="this.className = ''" name="age"></p>
    Gender:<p><input placeholder="Male/Female/Other..." oninput="this.className = ''" name="gender"></p>
    Mobile Number:<p><input placeholder="10 digit Mobile Number..." oninput="this.className = ''" name="mobile"></p>
    Address:<p><input placeholder="Address..." oninput="this.className = ''" name="address"></p>
    Date of Birth:<p><input placeholder="Month date,Year..." oninput="this.className = ''" name="dob"></p>
  </div>
  <div class="tab">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;
  EDUCATION DETAILS<br><br>
    10th Pass Year:<p><input placeholder="10th Pass Year..." oninput="this.className = ''" name="tenthpassyr"></p>
    10th Pass Percentage:<p><input placeholder="10th Pass Percentage..." oninput="this.className = ''" name="tenthpassper"></p>
    12th Pass Year:<p><input placeholder="12th Pass Year..." oninput="this.className = ''" name="twelfthpassyr"></p>
    12th Pass Percentage:<p><input placeholder="12th Pass Percentage..." oninput="this.className = ''" name="twelfthpassper"></p>
    Graduation Pass Year:<p><input placeholder="Graduation Pass Year..." oninput="this.className = ''" name="gradpassyr"></p>
    Graduation Percentage:<p><input placeholder="Graduation Percentage as 00.00" oninput="this.className = ''" name="gradpassper"></p>
    Number of Backlogs:<p><input placeholder="If none enter 0" oninput="this.className = ''" name="backlogs"></p>
  </div>
  <div class="tab">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  WORKS<br><br>
  	University/College Name:<p><input placeholder="university/college name" oninput="this.className = ''" name="uniname"></p>
  	Branch:<p><input placeholder="branch or specialization" oninput="this.className = ''" name="branch"></p>
    MOOCS:<p><input placeholder="MOOCS seperated by , " oninput="this.className = ''" name="moocs"></p>
    Projects:<p><input placeholder="Projects seperated by , " oninput="this.className = ''" name="projects"></p>
    Skills:<p><input placeholder="Skills seperated by , " oninput="this.className = ''" name="skills"></p>
    LinkedIn profile link:<p><input placeholder="If not there enter NA" oninput="this.className = ''" name="linkedin"></p>
    GIT profile link:<p><input placeholder="If not there enter NA" oninput="this.className = ''" name="gitlink"></p>
  </div>
  <div class="tab">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  OTHER DETAILS<br><br>
    Global Certifications<p><input placeholder="Global Certifications seperated by , " oninput="this.className = ''" name="glob_certi"></p>
    Reference:<p><input placeholder="Refernce" oninput="this.className = ''" name="reference"></p>
    Extension Activities:<p><input placeholder="Extension Activities seperated by , " oninput="this.className = ''" name="extn_activities"></p>
    Work Status:<p><input placeholder="Are you an employee or student?" oninput="this.className = ''" name="workStatus"></p>
    Recently Worked Company:<p><input placeholder="If you're student enter NA" oninput="this.className = ''" name="companyName"></p>
    Previous Salary:<p><input placeholder="If you're student enter NA" oninput="this.className = ''" name="prevsalary"></p>
    Experience:<p><input placeholder="If you're student enter NA" oninput="this.className = ''" name="exp"></p>
    Password:<p><input  oninput="this.className = ''" name="password" type="password"></p>
  </div>
  <div style="overflow:auto;">
    <div style="float:right;">
      <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
      <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
    </div>
  </div>
  <!-- Circles which indicates the steps of the form: -->
  <div style="text-align:center;margin-top:40px;">
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
    <span class="step"></span>
  </div>
</form>
</div>
<script>
var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
  // This function will display the specified tab of the form...
  var x = document.getElementsByClassName("tab");
  x[n].style.display = "block";
  //... and fix the Previous/Next buttons:
  if (n == 0) {
    document.getElementById("prevBtn").style.display = "none";
  } else {
    document.getElementById("prevBtn").style.display = "inline";
  }
  if (n == (x.length - 1)) {
    document.getElementById("nextBtn").innerHTML = "Submit";
  } else {
    document.getElementById("nextBtn").innerHTML = "Next";
  }
  //... and run a function that will display the correct step indicator:
  fixStepIndicator(n)
}

function nextPrev(n) {
  // This function will figure out which tab to display
  var x = document.getElementsByClassName("tab");
  // Exit the function if any field in the current tab is invalid:
  if (n == 1 && !validateForm()) return false;
  // Hide the current tab:
  x[currentTab].style.display = "none";
  // Increase or decrease the current tab by 1:
  currentTab = currentTab + n;
  // if you have reached the end of the form...
  if (currentTab >= x.length) {
    // ... the form gets submitted:
    document.getElementById("regForm").submit();
    return false;
  }
  // Otherwise, display the correct tab:
  showTab(currentTab);
}

function validateForm() {
  // This function deals with validation of the form fields
  var x, y, i, valid = true;
  x = document.getElementsByClassName("tab");
  y = x[currentTab].getElementsByTagName("input");
  // A loop that checks every input field in the current tab:
  for (i = 0; i < y.length; i++) {
    // If a field is empty...
    if (y[i].value == "") {
      // add an "invalid" class to the field:
      y[i].className += " invalid";
      // and set the current valid status to false
      valid = false;
    }
  }
  // If the valid status is true, mark the step as finished and valid:
  if (valid) {
    document.getElementsByClassName("step")[currentTab].className += " finish";
  }
  return valid; // return the valid status
}

function fixStepIndicator(n) {
  // This function removes the "active" class of all steps...
  var i, x = document.getElementsByClassName("step");
  for (i = 0; i < x.length; i++) {
    x[i].className = x[i].className.replace(" active", "");
  }
  //... and adds the "active" class on the current step:
  x[n].className += " active";
}
</script>

</body>
</html>
