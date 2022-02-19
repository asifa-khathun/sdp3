<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Job Seekers</title>
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

input[type=text], input[type=password],input[type=number],select, textarea {
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
  height: 650px;
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 50px;
}
.bg-img {
/* The image used */
  background: url(images/job.jpg) no-repeat;
  background-size: 100%;
  min-height: 900px;
  /* Center and scale the image nicely */
  background-position: left top;
  background-repeat: no-repeat;
  background-size: 600px 500px;
  position: relative;
  margin-left: auto;
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
		<a href="/index">Logout</a>
    </div>
</div>

<br>
<h2 align=center>Job Seekers</h2><br/>

<!--<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Enter recruiter request status" title="Type in a name">-->
<br>
<!--<caption>Requests from Recruiters</caption><br>-->
<table align=center border=1 id="myTable">
<tr>
<th>Name</th>
<th>E-mail</th>
<th>Gender</th>
<th>Age</th>
<th>Work Status</th>
<th>Company Name</th>
<th>Experience</th>
<th>Mobile Number</th>
<th>Salary</th>
<th>Status</th>
<th>View</th>
<th>Actions</th>
</tr>

<c:forEach var="j" items="${js}">

<tr>
<td>${j.fullName}</td>
<td>${j.email}</td>
<td>${j.gender}</td>
<td>${j.age}</td>
<td>${j.workStatus}</td>
<td>${j.companyName}</td>
<td>${j.exp}</td>
<td>${j.mobile}</td>
<td>${j.prevsalary}</td>
<td>${j.access}</td>
<td><a href="/superadminviewjobseeker/${j.email}"><button class="button">View</button></a>
<td><a href="/deletejobseeker/${j.email}"><button class="rbutton">Block</button></a>
<a href="/unblockjobseeker/${j.email}"><button class="abutton">Unblock</button></a>
</td>
</tr>

</c:forEach>

</table>
<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[8];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
</body>
</html>
