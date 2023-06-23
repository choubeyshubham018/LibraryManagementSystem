<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fine</title>
</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center;color: red;background-color: #ffcc00 ;">Fine on the Book</h2>
<table align="center" border="1" bgcolor="white">
<tr><th>Student Id</th><th>Book Title</th><th>Book Author</th><th>Category</th><th>Fine</th></tr>
<tr>
<td>${stdid}</td>
<td>${book.bTitle}</td>
<td>${book.bAuthor}</td>
<td>${book.bCategory}</td>
<td>${fine}</td>

</table>
<h4 style="text-align: center; margin-top: 1%"><a style="color: white;" href="../home.jsp">Home</a></h4>
</body>
</html>
<jsp:include page="footer.jsp"/>