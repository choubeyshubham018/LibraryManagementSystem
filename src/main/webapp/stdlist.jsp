<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student List</title>
</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center;color: blue; margin: 3%;background-color: #ffcc00 ;">Student List</h2>
<table border="1" align="center" bgcolor="white">
<tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Mobile</th><th>Email</th></tr>
<c:forEach items="${students}" var="student">
<tr> <td> ${student.stdId} </td> <td>${student.stdName}</td> <td> ${student.stdAge} </td><td>${student.stdgen}</td>
<td>${student.mob}</td><td>${student.email}</td>
 
 <td>
 <c:url value="./controller/std/delete" var="delete">
<c:param name="stdId" value="${student.stdId}"/>
</c:url>
 
 <a  href="${delete}" >Delete</a></td>
 
 <td>
 <c:url value="../../issue/books" var="issueBooks">
<c:param name="stdId" value="${student.stdId}"/>
</c:url>
 <a href="${issueBooks}">Books</a>
 </td>
 </tr>

</c:forEach>
</table>
<h2 style="text-align: center; color: white;"> <a style="color: white;" href="./../../home.jsp">Home</a></h2>

</body>
</html>
<jsp:include page="footer.jsp" flush="true"/>