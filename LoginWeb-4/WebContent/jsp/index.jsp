<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
	%>

	<c:choose>
		<c:when test="${empty sessionScope.user }">请你去登录之后，再来访问! </c:when>
		<c:otherwise>
			<h1>index</h1>

			<h2>欢迎你的到来：${user.username }</h2>

		</c:otherwise>
	</c:choose>

</body>
</html>