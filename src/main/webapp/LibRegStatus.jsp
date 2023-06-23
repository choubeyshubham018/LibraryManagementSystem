<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Librarian Registration Status</title>
</head>
<body bgcolor="#2EF638s" style="margin-top: 10%;">
<h2 style="text-align: center; color: Red;background-color: #ffcc00 ">Librarian Registration Status</h2>
<c:choose>
<c:when test="${status eq 'success' }">
<h3 style="text-align: center;color: Oragnge;"> Registration Successful</h3>
<h4 style="text-align: center;  margin-top: 25px;"><a style="color: white;" href="../Liblogin.jsp" style="text-decoration: none;">login Page</a></h4>
</c:when>
<c:otherwise>

<h3 style="text-align: center;color: Oragnge;"> Registration Failed UserId Already Used</h3>
<h4 style="text-align: center; color green; margin-top: 25px;"><a style="color: white;" href="../LibRegister.html" style="text-decoration: none;">Try Again</a></h4>
</c:otherwise>
</c:choose>
</body>
</html>
<jsp:include page="footer.jsp"/>