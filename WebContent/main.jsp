<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Main</title>
</head>
<body>
<jsp:scriptlet>
//request.setCharacterEncoding("UTF-8");
//String l=request.getParameter("login");
//String p=request.getParameter("password");
//out.print(l + "\n");
//out.print(p);
//Object loginout = request.getAttribute("loginout");
//out.print(loginout.toString());
//Object passwordout = request.getAttribute("passwordout");
//out.print(passwordout.toString());
</jsp:scriptlet>
	<c:set var="loginvar" value=""></c:set>
	 Hello ${loginout}
<hr>
	Log History
	<br>
	<c:forEach var="log" items="${loghistory}">
  	<br/>
  	<c:out value="${log.id}" />
  	<c:out value="${log.date}" />
	</c:forEach>
<hr>
	Wrong Log History
	<br>
	<c:forEach var="wronglog" items="${wrongloghistory}">
  	<br/>
  	<c:out value="${wronglog.id}" />
  	<c:out value="${wronglog.date}" />
	</c:forEach>
<hr>
<form action="login.jsp">
<input type="submit" value="Log out">
</form>
</body>
</html>