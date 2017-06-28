<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="mystyle.css">
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color:#f3f3f3;
}

li {
    float: left;
    border-right:1px solid #bbb;
}

li a, .dropbtn {
    display: block;
    color: blue;
    text-align: center;
    padding: 20px 20px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: #111;
}
li.dropdown {
    display: inline-block;
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
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>


</head>
<body>
<ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="#updates">Updates</a></li>
  <li><a href="contact.html">Contact us</a></li>
  <li><a href="send.html">Submit Feedback</a></li>
  <li class="dropdown" style="float:right"><a class="active" href="#about">SIGNUP PORTAL</a>
  <div class="dropdown-content">
      <a href="signup.jsp">User Signup</a>
      <a href="signup.jsp">Service center employee </a>
      <a href="signup.jsp">Call center operators</a>
  
    </div>
    </li>
  <li class="dropdown" style="float:right"><a class="active" >LOGIN PORTAL</a>
  <div class="dropdown-content">
      <a href="login.jsp">ITAdministrator</a>
      <a href="login.jsp">Service center employee</a>
      <a href="login.jsp">Call center operators</a>
  
    </div>
    </li>
  
</ul>


<title>SERVICE CALL MANAGEMENT PORTAL </title>
<h1 align="center">WELCOME TO CMS </h1><br><br>


<h1 align="center">WE ARE HERE TO PROVIDE FOR YOUR CALL SERVICE NEEDS</h1>
<footer >
  <p>Posted by: Prateek Kumar and Adarsh Singh</p>
  <p>Contact information: <a href="https://gmail.com">prateeekkumar10@gmail.com</a><br>
  <a href="https://gmail.com">adarshsingh@gmail.com</a></p>
</footer>

</body>
</html>