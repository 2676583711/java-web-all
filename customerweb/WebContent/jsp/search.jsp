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


	<h1>Search</h1>

	<center>

		<table>
			<tr>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
				<td>电话</td>
				<td>邮箱</td>
				<td>描述</td>
			</tr>
			<c:forEach items="${list }" var="l">

				<tr>
					<td>${l.name}</td>
					<td>${l.gender }</td>
					<td>${l.birthday }</td>
					<td>${l.phonebumber }</td>
					<td>${l.email }</td>
					<td>${l.description }</td>
					<td><a
						href=" <c:url value='/CustomerServlet?method=edit&id=${l.id }'" />编辑</a></td>
					<td><a href="<c:url value=''" />删除</a></td>
				</tr>

			</c:forEach>
		</table>
	</center>

</body>
</html>