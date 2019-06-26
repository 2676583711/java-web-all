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

	<script type="text/javascript">

	function c(){
		var img=document.getElementById("img");
		img.src="<c:url value='/VerifyCodeServlet?' />"+new Date().getTime();
	}
	</script>
	<h1>注册</h1>
	<p style="width: 500; height: 100; color: red;">${error }</p>
<form action="<c:url value='/RegistServlet'/>" method="post">
	用户名：<input type="text" name="username" value="${username }"/> ${map.error2 } <br/>
	密　码：<input type="password" name="password"/> ${map.error3 } <br/>
	验证码：<input type="text" name="vCode" value="${user.verifyCode }"  size="10"/> 
	  <img id="img" src= "<c:url value='/VerifyCodeServlet'/> " border="1" />  
	  <a href="javascript:c() ">看不清，换一张</a> ${map.error4 } <br>
	年　龄：<input type="text" name="age"/><br/>
	性　别：<input type="text" name="gender"/><br/>
	<input type="submit"/><br/>
	</form>

	

</body>
</html>