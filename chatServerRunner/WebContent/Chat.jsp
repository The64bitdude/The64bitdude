<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat</title>
</head>
<body>
<h1>Chatbot</h1>

 <form action="<%= request.getContextPath() %>/ChatClientLogin" method="get">
  say this<input type="text" name="entry">
  START?<input type="submit" value="yes" name="yes">
 </form>
</body>
</html>