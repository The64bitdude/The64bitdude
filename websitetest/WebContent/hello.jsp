<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>

<h1> Login to the My Chatbot</h1>
 <form action="<%= request.getContextPath() %>/ChatSiteLogin" method="get">
  Username: <input type="text" name="username">
  <br> <br> 
  
  Last Name: <input type="text" name="lastName">
  <br> <br> 
  
  Email ID: <input type="email" name="emailId">
  <br> <br> 
  
  Password: <input type="password" name="password"><br>
  
  <br> 
  <input type="submit" value="register">
 </form>
</body>
</html>