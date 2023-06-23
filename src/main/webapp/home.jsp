<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>

<link rel="stylesheet" href="./css/homePageStyle.css" type="text/css">
</head>
<body >
<div class="head" >
<!-- <h1> Library Management System</h1> -->
<h3><label><a href="./book.html">BOOKS</a></label><label><a href="./student.html">STUDENT DETAILS</a></label>
<label><a href="./issue/ibooklist">ISSUED BOOKS</a></label>
<label><a href="./home.html">LOG OUT</a></label></h3>
</div>


 
<div style="size: 40px;"><jsp:include page="footer.jsp" />
</div>

</body>
</html>