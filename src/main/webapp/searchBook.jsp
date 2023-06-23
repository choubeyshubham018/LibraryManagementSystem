<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Search Book</title>
<link rel="stylesheet" href=".\css\searchBook.css">
</head>
<body bgcolor="#2EF638s">
<jsp:include page="header.jsp"/>
<h2 class="head" style="background-color: #ffcc00 ;">Book Search Page</h2>

<form action="./controller/searchBook" method="post">
<div class="search">
<h3> Search by Book Title</h3>
<tr><td><label><b>Enter Book Title</b></label></td><td><input type="text" name="title" ></td></tr>
<tr><td></td><td><input type="submit" value="Search"></td></tr>
</div>
</form>

<form action="./controller/searchBook" method="post">
<div class="search">
<h3> Search by Author Name</h3>
<tr><td><label><b>Enter Author Name</b></label><td><input type="text" name="author"></td></tr>
<tr><td></td><td><input type="submit" value="Search"></td></tr>
</div>
</form>

<form action="./controller/searchBook" method="post">
<div class="search">
<h3> Search by Book Title</h3>
<tr><td><label><b>Enter Book Category</b></label><td><input type="text" name="category"></td></tr>
<tr><td></td><td><input type="submit" value="Search"></td></tr>
</div></form>



<h4 style="text-align: center; "><a style="color: white;" href="./home.jsp">Home Page </a></h4>

<jsp:include page="footer.jsp"/>
</body>
</html>