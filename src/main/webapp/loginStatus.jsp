<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Status</title>
</head>
<body bgcolor="#2EF638s">
<h3 style="text-align: center;color: green;background-color: #ffcc00 ;">Librarian Login Status</h3>
<c:choose>
<c:when test="${status}">
<h3 style="text-align: center ; color: red; margin-top: 3%;"> Login Successful </h3>
<h4 style="text-align: center; color: white;"><a style="color: white;" href="../home.jsp">Home</a></h4>
</c:when>
<c:otherwise>
<h3 style="text-align: center ; color: red;"> Login Failed  </h3>
<h4 style="text-align: center; color: white;"><a style="color: white; "href="../Liblogin.jsp">try again</a></h4>
<h4 style="text-align: center; color: white;"><a style="color: white;" href="../home.html">Home</a></h4>


</c:otherwise>
</c:choose>
</body>
</html>
<jsp:include page="footer.jsp"/>