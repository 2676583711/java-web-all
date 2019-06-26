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
					return new ActivieXObject("Msxml2.XMLHTTP");
				} catch (e) {
					try {
						return new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("你使用浏览器不支持本产品，若要使用请更换浏览器!!");
						throw (e);
					}
				}
			}
		}

		window.onload = function() {
			var b1 = document.getElementById("b1");
			b1.onclick = function() {

				var h1 = document.getElementById("h1");

				h1.innerHTML = "Button";
				h1.innerHTML = 123456;

				/*
				ajax（页面局部刷新技术）:
					第一步得到XMLHttpRequest对象
				 */
				var xmlHttpRequest = createXMLHttpRequest();

				//第二部调用Ｏｐｅｎ方法
				xmlHttpRequest.open("GET", "<c:url value=='/AServlet'/>", true);//true打开异步请求 
				//第三部调用ｓｅｎｄ方法
				xmlHttpRequest.send(null);//ｇｅｔ方法没有请求体，也必须给出ｎｕｌｌ参数，否则火狐有可能出错
				//第四步　给异步对象注册监听器　
				xmlHttpRequest.onreadystatechange = function() {
					if (xmlHttpRequest.readyState == 4
							&& xmlHttpRequest.status == 200) {
						var text = xmlHttpRequest.responseText;
						h1.innerHTML = text;
					}
				}
			}

		}
	</script>
</body>
</html>