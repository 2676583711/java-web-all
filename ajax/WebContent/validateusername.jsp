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



	<h1>ValidateUsername</h1>
	<form action="<c:url value='/ValidateUsernameServlet'/> " method="post">
		用户名:<input type="text" name="username" id="i1" /> <span id="s1"></span>
		<br /> 密 码：<input type="password" /><br /> <input type="submit"
			value="注册" />
	</form>


	<script type="text/javascript">
		function createXMLHttpRequest() {
			try {
				return new XMLHttpRequest();
			} catch (e) {
				try {
					return new ActivieXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						return new ActivieXObject("Microsoft.XMLHTTP");
					} catch (e) {
						throw (e);
					}
				}
			}
		}

		window.onload = function() {
			var i1 = document.getElementByid("i1");
			i1.onblur = function() {

				var xmlHttp = createXMLHttpRequest();
				

				xmlHttp.open("POST",
						"<c:url value='/ValidateUsernameServlet'/> ", true);

				xmlHttp.setRequestHeader("Content-Type",
						"applications/x-www-form-urlencoded");
				xmlHttp.send("username=" + i1.value);

				var s1 = document.getElementById("s1");

				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

						var text = xmlHttp.responseText;
						if (text == 1) {
							s1.innerHTML = "该用户已被注册..";
						} else {
							s1.innerHTML = "";
						}

					}
				};

			};
		};
	</script>

</body>
</html>