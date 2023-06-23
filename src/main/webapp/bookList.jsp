<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center;color: blue;background-color: #ffcc00 ;">Issue Book List</h2>
<table align="center" bgcolor="white" border="1" style=" text-align: center; size: auto; border: solid 2px;">
<tr><th>BookTitle</th><th>BookAuthor</th><th>Category</th></tr>
<c:forEach var="book" items="${bookList }">
<tr><td>${book.bTitle}</td>
<td>${book.bAuthor}</td>
<td>${book.bCategory}</td>



<c:if test="${l1 ne 'std'}">

<c:url value="./controller/deleteBook" var="delete">
<c:param name="title" value="${book.bTitle}"/>
</c:url>

<td><a  href="${delete}"  style="text-decoration: none;">Delete</a></td>
<c:if test="${book.status eq 'available'}">

<c:url value="../issuebook.jsp" var="issue">
<c:param name="title" value="${book.bTitle}"/>
<c:param name="author" value="${book.bAuthor}"/>
<c:param name="category" value="${book.bCategory}"/>
<c:param name="link" value="s2"/>
</c:url>

<td><a  href="${issue}" style="text-decoration: none;">Issue</a></td>
</c:if>
</c:if>
</tr>

</c:forEach>

</table>
<c:choose>
<c:when test="${l1 eq 'std'}">
<h4 style="text-align: center; color: Red; margin-top:10px ">  <a style="color: white;" href="../StudentHome.jsp" >Home Page</a></h4>

</c:when>
<c:otherwise>
<h4 style="text-align: center; color: Red; margin-top:10px ">  <a style="color: white;" href="../home.jsp" >Home Page</a></h4>
</c:otherwise>
</c:choose>
</body>
</html>
<jsp:include page="footer.jsp"/>