<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>欢迎登录：</h1>
	
	<form action=" <c:url value='/LoginServlet'/> " method="post">
	
	<p style="color:red;">  ${message } </p>
	
	用户名：<input type="text" name="username" value="${user.username }"/> <br/> 
	密　码：<input type="password" name="password"/><br/>
	验证码：<input type="text" name="varifyCode" size="11"/>
	<img alt="验证码" src="<c:url value='/VerifyCodeServlet'/> ">
	<a href="">看不清，换一个</a>
	<br/>
	<input type="submit"/><br/>
	</form>


</body>
</html>