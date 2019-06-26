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
						return new ActivieXObject("Microsoft.XMLHTTP");
					} catch (e) {
						alert("你使用浏览器不支持本产品，若要使用请更换浏览器!!");
						throw (e);
					}
				}
			}
		}

		window.onload = function() {

			var xmlHttp = createXMLHttpRequest();

			xmlHttp.open("GET", "<c:url value='/BServlet'/>", true);

			xmlHttp.send(null);

			xmlHttp.onreadystatechange = function() {
				if(xmlHttp.readyState==4 && xmlHttp.status==200){
					var document = xmlHttp.responseXML;
					var ele = document.getElementsByTagName("student")[0];
					
					var name=ele.getElementsByTagName("name")[0];
					var age=ele.getElementsByTagName("age")[0];
					
					if(window.addEventListener){
						nt=name.textContent;  //支持其他浏览器
						gt=age.textContent;  
						
						var text=nt+","+gt;
						
						var h1=document.getElementById("h1");
						h1.innerHTML=text;
						
					}else{   //支持ＩＥ浏览器
						nt=name.text;
					
					//............
					}

					
				}
			};

		};
	</script>

</body>
</html>