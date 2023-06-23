<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Status</title>
</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center; color: Green;background-color: #ffcc00 ;">Book Issue Status</h2>
<c:choose>
<c:when test="${status eq 'success'}">
<h3 style="text-align: center; color: red; margin-top: 7%;">Book is Succesfully Issued</h3>
</c:when>
<c:when test="${status eq 'max limit reached'}">
<h3 style="text-align: center; color: red; margin-top: 7%;">Book Issue Limit is Already Reached </h3>
<h3 style="text-align: center; color: red; ;">Kindly Returned the Issued Books First for more books </h3>
</c:when>

<c:otherwise>
<h3 style="text-align: center; color: red; margin-top: 7%;">Issued Process Failed </h3>
<h4 style="text-align: center;"><a href="../book.html">Try Again</a></h4>
</c:otherwise>
</c:choose>
<h4 style="text-align: center;"><a style="color: white;" href="../home.jsp">Home</a></h4>
</body>
</html>
<jsp:include page="footer.jsp"/>