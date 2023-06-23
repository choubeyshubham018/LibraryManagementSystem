<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="#2EF638s" style="color: red;">
<h2 style="text-align: center;color: green;background-color: #ffcc00; ">Librarian Login Page</h2>
<form action="./lib/login" method="post">
<table bgcolor="#033949" align="center" style="margin-top: 50px;">
<tr><th><label>User Id</label></th><td><input type="text" name="userid"/></td></tr>
<tr><th><label>Password</label></th><td><input type="password" name="pass"/></td></tr>
<tr align="center" style="text-align: center;"><th></th><td><input type="submit" value="SignIn" style="margin-top: 25px;"/>
</table>
</form>
</body>
</html>
<jsp:include page="footer.jsp"/>