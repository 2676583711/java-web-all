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


	<button id="b1">点击这里</button>

	<h1 id="h1"></h1>

	<script type="text/javascript">
		function createXMLHttpRequest() {
			try {
				return new XMLHttpRequest();
			} catch (e) {
				try {
					return new ActivieXObject("Msxml2.XMLHTTP")
				} catch (e) {
					try {
						return new ActivieXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("你当前的浏览器不支持本产品...")
						throw (e);
					}
				}
			}
		}

		window.onload = function() {
			var b1 = document.getElementById("b1");
			var h1 = document.getElementById("h1");

			b1.onclick = function() {

				var xmlHttp = createXMLHttpRequest();

				xmlHttp.open("POST", "<c:url value='/AServlet'/>", true);

				xmlHttp.setRequestHeader("Content-Type",
						"application/x-www-form-urlencoded");
				xmlHttp.send("username=张三&ps=123456");

				xmlHttp.onreadystatechange() = function() { //给ｘｍｌｈｔｔｐｒｅｑｕｅｓｔ类注册监听器　

					if (xmlHttp.readyState == 4 || xmlHttp.status == 200) {
						var text = xmlHttp.responseText;
						//var text = xmlHttpRequest.responseText;

						h1.innerHTML = text;

					
				}

			}

		}
}
	</script>

</body>
</html>