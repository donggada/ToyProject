<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toy Project Main</title>
</head>
<body>
<form action="Login.jsp" method="post">
아이디: <input type="text" name="id">
비밀번호: <input type="password" name="pass">
<input type="button" value="회원가입하기" onclick="Membership.jsp">
<input type="submit" value="로그인하기">
</form>
</body>
</html>