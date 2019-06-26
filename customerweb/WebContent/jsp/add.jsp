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

	<h1>添加客户</h1>

	<center>
		<div>
			<form action=" <c:url value='/CustomerServlet'/>  " method="post">
				<input type="hidden" name="method" value="addCustomer" />
				<table>
					<tr>
						<td>客户姓名：</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>客户性别：</td>
						<td><input type="radio" name="gender" value="男">男<input
							type="radio" name="gender" value="女">女</td>
					</tr>
					<tr>
						<td>客户生日：</td>
						<td><input type="date" name="birthday"></td>
					</tr>
					<tr>
						<td>联系电话：</td>
						<td><input type="text" name="phonenumber"></td>
					</tr>
					<tr>
						<td>邮 &nbsp;&nbsp; &nbsp;&nbsp; 箱：</td>
						<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>描 &nbsp;&nbsp; &nbsp;&nbsp; 述：</td>
						<td><input type="text" name="description"></td>
					</tr>
					<tr>

						<td>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input
							type="submit" value="提交" /></td>
						<td>&nbsp;&nbsp; &nbsp;&nbsp;<input type="reset" value="重置" /></td>

					</tr>
				</table>

			</form>

		</div>
	</center>

</body>
</html>