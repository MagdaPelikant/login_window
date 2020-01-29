<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
<form action="signin.do" method="post">
<h2>Login:</h2>
<input type="text" name="login" value="">
<hr>
<h2>Password:</h2>
<input type="password" name="password" value="">
<hr>
<input type="submit" value="Sign in">
</form>
<hr>
<form action="signup.jsp">
<input type="submit" value="Sign up">
</form>
<form action="changepassword.jsp">
<input type="submit" value="Change password">
</form>
</body>
</html>