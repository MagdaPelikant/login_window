<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
	<c:set var="loginvar" value="adsds"></c:set>
	${loginout}
	<c:out value="${loginvar}"></c:out>
<hr>
	<c:set var="passwordvar" value="adsds"></c:set>
	${passwordout}
	<c:out value="${passwordvar}"></c:out>
<hr>
<form action="login.jsp">
<input type="submit" value="Log out">
</form>
</body>
</html>