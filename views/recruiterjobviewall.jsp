<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Jobs</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</style>
</head>
<body>
<div class="navbar">
  <a href="/recruiterhome">Home</a>
  
			  <div class="dropdown">
			    <button class="dropbtn">Job
			      <i class="fa fa-caret-down"></i>
			    </button>
			    <div class="dropdowncontent">
			      <a href="/jobaddnew">New Job</a>
			      <a href="/jobviewall/${name}">View All</a>
			      
			    </div>
			  </div> 
			
	<a href="/jobseekersviewall">Job Seekers</a> 
			  
	<div class="topnav-right">
			<div class="drop-down">
			    <button class="drop-btn">${name}
			      <i class="fa fa-caret-down"></i>
			    </button>
			    <div class="dropdown-content">
			      <a href="/recruiterprofile">My Profile</a>
			      <a href="/recruiterlogout">Logout</a>
			    </div>
			  </div> 
		
		</div>

</div>

<br>
<h2 align=center>All Jobs</h2><br/>

<!--<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Enter recruiter request status" title="Type in a name">-->
<br>
<!--<caption>Requests from Recruiters</caption><br>-->
<table align=center border=1 id="myTable">
<tr>
<th>Logo</th>
<th>Id</th>
<th>Reference Id</th>
<th>Role</th>
<th>Company Name</th>
<th>Location</th>
<th>Job Type</th>
<th>Deadline</th>
<th>Description</th>
<th>Min. CGPA</th>
<th>Branch</th>
<th>Max. Backlogs allowed</th>
<th>Number of Applicants</th>
<th>Aptitude Round Qualified</th>
<th>HR & TR Round Qualified</th>
<th>Interview Round Qualified</th>
<th>Selected for Job</th>
<th>Action</th>
</tr>

<c:forEach var="j" items="${jobs}">

<tr>
<td><img src="${pageContext.request.contextPath}/logo/${j.image}" alt="Logo" style="width:100px;height:100px;"></img></td>
<td>${j.id}</td>
<td>${j.refid}</td>
<td>${j.role}</td>
<td>${j.companyname}</td>
<td>${j.location}</td>
<td>${j.type}</td>
<td>${j.deadline}</td>
<td>${j.descr}</td>
<td>${j.cgpa}</td>
<td>${j.branch}</td>
<td>${j.backlog}</td>
<td>${j.applicants}</td>
<td>${j.aptround}</td>
<td>${j.hrtrround}</td>
<td>${j.interview}</td>
<td>${j.selected}</td>
<td><a href="/recrujobupdate/${j.refid}"><button class="abutton">Edit</button></a>
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
