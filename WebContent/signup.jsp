<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
</head>
<body>
<form action="signupServlet" method="post">

First Name :  <input type="text" name="firstname">
<br>

Last Name :  <input type="text" name="lastname">
<br>
Location :  <input type="text" name="location">
<br>
Mobile No :  <input type="text" name="mobile">
<br>
Username :<input type="text" name="username">
<br>
Password:  <input type="text" name="password">
<br>
<input type="submit" name="submit" value="submit">
</form>
</body>
</html>