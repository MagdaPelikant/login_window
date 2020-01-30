<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sign up</title>
</head>
<body>
<%
	String signup_message = "brak";
	Object error = request.getAttribute("signup_message");
	if (error != null)
		signup_message = error.toString();
%>
<form action="signup.do" method="post">
<h2>Login:</h2>
<input type="text" name="login" value="">
<hr>
<h2>Password:</h2>
<input type="password" name="password" value="">
<hr>
<h2 style="color: red"><%=signup_message%></h2>
<hr>
<input type="submit" value="Sign up">
</form>
</body>
</html>