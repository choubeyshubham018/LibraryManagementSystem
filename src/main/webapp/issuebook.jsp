<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Book</title>
</head>
<body bgcolor="#2EF638s">
   <h2 style="text-align: center; color: blue;background-color: #ffcc00 ;">Book Issue Details</h2>
   <c:choose>
   <c:when test="${link eq 's1'}">
   <form action="./issuebook" method="post">
  <table align="center" border="1" style="margin-top: 5%;">
  <tr><td></td></tr>
  
  <tr><th>Enter Student Id</th><td><input type="text"  name="stdid"></td><td>${error}</td></tr>

  <tr><th>Book Title</th><td><input type="text" value="${title}" name="bTitle"  readonly="readonly"></td></tr>
  <tr><th>Book Title</th><td><input type="text" value="${author}" name="bAuthor" readonly="readonly"></td></tr>
  <tr><th>Book Title</th><td><input type="text" value="${category}" name="bCategory" readonly="readonly"></td></tr>
  
  
 
  <tr><td></td><td><input type="submit" value="Submit"></td></tr>
  </table>
  
  </form>
   </c:when>
   <c:otherwise>
  <form action="./issue/issuebook" method="post">
  <table align="center" border="1" style="margin-top: 5%;">
  <tr><td></td></tr>
  
  <tr><th>Enter Student Id</th><td><input type="text"  name="stdid"></td><td>${error}</td></tr>

  <tr><th>Book Title</th><td><input type="text" value="<%= request.getParameter("title") %>" name="bTitle"  readonly="readonly"></td></tr>
  <tr><th>Book Title</th><td><input type="text" value="<%= request.getParameter("author") %>" name="bAuthor" readonly="readonly"></td></tr>
  <tr><th>Book Title</th><td><input type="text" value="<%= request.getParameter("category") %>" name="bCategory" readonly="readonly"></td></tr>
  
  
 
  <tr><td></td><td><input type="submit" value="Submit"></td></tr>
  </table>
  
  </form>
  </c:otherwise>
  </c:choose>
<h3 style="text-align: center;"><a style="color: white;" href="./home.jsp">Home</a></h3>
</body>
</html>
<jsp:include page="footer.jsp"/>