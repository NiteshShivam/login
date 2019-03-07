<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
<%
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
response.setHeader("Pargma","no-cache");
response.setHeader("Expires","0");
if(session.getAttribute("username")==null)
{
	 response.sendRedirect("loginpage.jsp");
 }
  %>
  <br>
  hello<br>
  <form action="logout">
  <input type="submit" value="logout">
  </form>
</body>
</html>