<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Book</title>
<link rel="stylesheet" href=".\css\searchBook.css">
</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center;background-color: #ffcc00 ;">Search Book List</h2>


<table bgcolor="white" align="center" border="1">
<tr><th>Title</th><th>Author</th><th>Category</th></tr>
<c:forEach items="${ bookList}" var="book">
 <tr><td> ${book.bTitle} </td>
 <td> ${book.bAuthor}</td>
  <td>${book.bCategory}</td>
  <c:url value="../issuebook.jsp" var="issue">
<c:param name="title" value="${book.bTitle}"/>
<c:param name="author" value="${book.bAuthor}"/>
<c:param name="category" value="${book.bCategory}"/>

</c:url>
 <c:if test="${l1 ne 'std' }">
  <td><a href="${issue}" style="text-decoration: none;">Issue</a></td>
</c:if>
</tr>
</c:forEach>

</table>

<div style="text-align: center;text-decoration: none;">

<c:choose>
<c:when test="${l1 eq 'std'}">
<a href="../StudentHome.jsp" style="color: white;">Home</a>
</c:when>
<c:otherwise>
<a href="../home.jsp" style="color: white;">Home Page</a>
</c:otherwise>
</c:choose>

</div>
</body>
</html>
<jsp:include page="footer.jsp" flush="true"/>