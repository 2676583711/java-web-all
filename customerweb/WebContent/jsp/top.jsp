<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<!-- 指定跳转页面　显示在ｍａｉｎ页面中-->
<base target="main">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Top:</h1>


	<center>
		<div>
			<h1>客户关系管理系统</h1>
			<a href="<c:url value='/jsp/welcome.jsp' />">回到welcome页面</a> <a
				href="<c:url value='/jsp/add.jsp' />"> 添加客户</a> <a
				href="<c:url value='/jsp/remove.jsp'/>">删除客户</a>
			<%--  <a
				href="<c:url value='/jsp/edit.jsp' />">修改客户信息</a> --%>
			<a href="<c:url value='/CustomerServlet?method=searchAll'/>">查询所有客户信息</a>
			<a href="<c:url value='/jsp/find.jsp'/>">高级搜索</a>
		</div>
	</center>

</body>
</html>