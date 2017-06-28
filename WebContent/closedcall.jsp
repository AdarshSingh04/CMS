<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<h1> Status Categories:</h1>
 <ul>
      <li class="active">Pending</li><br>
      <li class="active">Recieved</li><br>
      <li class="active">Closed</li><br>
      <li class="active">Operator wise</li><br>
      
    </ul>
<h1> Enter the status type to view the call details :</h1>

<form action="Retrive" method="get">

Status: <input type="text" name="status">
 <input type="submit" value="search">
</form>
</body>
</html>