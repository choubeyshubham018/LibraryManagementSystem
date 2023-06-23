<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddBookStatus</title>
</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center;color: white;"> Book Status</h2>
<c:choose>
<c:when test="${status eq 'Success'}">
<h2 style="text-align: center; color: white;">Book is Added Successfully</h2>
</c:when>
<c:otherwise>

<h2 style="text-align: center; color: white;">Book is Addition Failed</h2>
</c:otherwise>
</c:choose>
<h2 style=" text-align: center;"><a style="color: white;" href="../home.jsp">Home Page</a></h2>
</body>
</html>
<jsp:include page="footer.jsp"/>