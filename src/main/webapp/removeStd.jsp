<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Student</title>
</head>
<body bgcolor="#2EF638s">
<h2 style="text-align: center;color: blue; margin: 3%;background-color: #ffcc00 ;">Deleting Student Status</h2>

<c:choose>
<c:when test="${status eq 'success' }">
<h3 style="text-align: center;color: white;">Student of Given Id is Removed</h3>
</c:when>
<c:otherwise>
<h3 style="text-align: center;color: white;">Removing Student is Failed </h3>
</c:otherwise>
</c:choose>
<h2 style="text-align: center; "> <a style="color: white;" href=../../../../../home.jsp>Home</a></h2>
</body>
</html>
<jsp:include page="footer.jsp"/>