<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Books Issued List</title>
</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center;color: green;background-color: #ffcc00 ;">Issue Books List</h2>
<table align="center" bgcolor="white" border="1">
 <c:if test="${!empty issueBooks}">
<tr><th>Student Id</th><th>Book Title</th><th>Book Author</th><th>Category</th><th>Issue Date</th><th>Fine</th></tr>
<c:forEach items="${issueBooks}" var="books">
<tr>
<td>${books.stdid}${stdid}</td>
<td>${books.bTitle}</td>
<td>${books.bAuthor}</td>
<td>${books.bCategory}</td>
<td>${books.issueDate}</td>
<td>${books.fine}</td>
<c:if test="${l1 ne 'std'}">
<td><a href="../issue/submit?stdid=${stdid}${books.stdid}&bTitle=${books.bTitle}&bAuthor=${books.bAuthor}&bCategory=${books.bCategory}">submit</a></td>
</c:if>
</tr>
</c:forEach>
</c:if>

</table>
<c:choose>

<c:when test="${l1 eq 'std'}">
<h4 style="text-align: center; margin-top: 1%"><a style="color: white;" href="../StudentHome.jsp">Home</a></h4>
</c:when>

<c:otherwise>
<h4 style="text-align: center; margin-top: 1%"><a style="color: white;" href="../home.jsp">Home</a></h4>
</c:otherwise>
</c:choose>
</body>
</html>
<jsp:include page="footer.jsp"/>