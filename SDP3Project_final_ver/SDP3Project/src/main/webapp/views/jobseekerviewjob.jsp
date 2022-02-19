<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Job Offer</title>
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



.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  width: 1000px;
  height:auto;
  margin-left:100px;
  text-align: center;
  font-family: arial;
  background:#f6eabe;
  color:black;
  
}
.title {
  color: grey;
  font-size: 18px;
}
button1 {
  background-color:#1cac78;
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
button1:hover {
  background:#004c56;
  color:white;
}
button {
  background-color:#1cac78;
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
button:hover {
  background:#ddd;
  color:black;
}

* {
  box-sizing: border-box;
}.column {
	margin: 25px 55px;
  float: left;
  width: 70%;
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
 img{
   margin-top:50px;
    align:center;
  border-radius:50%;
}
p {
  display: block;
  margin-top: 1em;
  margin-bottom: 1em;
  margin-left: 150px;
  margin-right: 150px;
}
crad. h1{
margin-top: 10px;
}

#myInput {
  background-image: url('/images/searchicon.png');
  background-position: 10px 10px;
  background-repeat: no-repeat;
  width: 20%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
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
<c:forEach var="j" items="${jsjobs}">

<div class="row">
  <div class="column">
    <div class="card">
	  		<img   border-radius="50%" src="${pageContext.request.contextPath}/logo/${j.image}">
		      <h1>${j.role}</h1>
		      <p>${j.companyname} | ${j.location} (${j.type})</p>
		      <h3>Apply Before: ${j.deadline}  </h3>
		      <p >${j.descr}</p>
		      <h3>Qualifications:  </h3>
		      <p>ENGINEERING STREAM - ${j.branch}<br>
				BACKLOGS ALLOWED - ${j.backlog}<br>
				MINIMUM PERCENTAGE(Graduation) - ${j.cgpa}</p><br>
		      <a href="/jobseekerapplyjob/${j.refid}"><button1>Apply Now</button1></a>
		      <br><br><br><h1></h1>
		</div>
	</div>
</div>
<br>
  </c:forEach>
  
  
</body>
</html> 