<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Book</title>

</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center; color: green; margin-top: 2%;background-color: #ffcc00 ;"> Book Delete Status</h2>
<c:choose>
<c:when test="${status eq 'Success'}">
<h3 style="text-align: center; color: white; margin-top:30px "> The Book is Deleted Succesfully</h3>
<h4 style="text-align: center; color: white; margin-top:10px "> Book List <a href="../../controller/bookList" style="text-decoration: none;">Book List</a></h4>

</c:when>
<c:otherwise>
<h3 style="text-align: center; color: white; margin-top:30px "> Book Deletion Failed </h3>
<h4 style="text-align: center; color: white; margin-top:10px "> Want to Try Again  click on the Link 
<a href="../../controller/deleteBook" style="color: white; text-decoration: none;"> click here</a> </h4>

</c:otherwise>
</c:choose>
<h4 style="text-align: center; color: black; margin-top:10px ">  <a style="color: white;" href="../../home.jsp" style="text-decoration: none;">Home Page</a></h4>

</body>
</html>
<jsp:include page="footer.jsp"/>