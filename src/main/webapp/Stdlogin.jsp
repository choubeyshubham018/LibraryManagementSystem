<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#2EF638s">
<jsp:include page="header.jsp"/>
<form action="./controller/std/login" method="post">
<table align="center" style="margin-top: 5%;">

<tr><th>Student Id</th><td><input type="text" name="stdid"></td></tr>
<tr><th>Password</th><td><input type="password" name="stdpass"></td></tr>
<tr><td></td><td><input type="submit" value="login"></td></tr>
</table>



</form>

<jsp:include page="footer.jsp"/>
</body>
</html>