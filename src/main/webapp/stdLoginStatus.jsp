<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
</head>
<body bgcolor="#2EF638s">
<jsp:include page="header.jsp"/>
<h2 style="text-align: center;color: white;">Student Login Status</h2>
<c:choose>
<c:when test="${status eq 'success'}">
<h3 style="margin-top: 3%;text-align: center;color: white;">
Login Successful 

</h3>
<c:url value="../../StudentHome.jsp" var="link">
<c:param name="stdid" value="${stdid}"/>
</c:url>
<h5 style="text-align: center; color: white;"><a  href="${link}">Home Page </a></h5>
</c:when>
<c:otherwise>
<h3 style="margin-top: 3%;text-align: center;color: white;">
Login Failed Invalid UserId And Password
</h3>
<h5 style="text-align: center;"><a style="text-align: center; color: white;" href="../../Stdlogin.jsp">Try Again</a></h5>

</c:otherwise>
</c:choose>


<jsp:include page="footer.jsp"/>

</body>
</html>