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

function ajax(method, url, parameters) {
	/*
	 * ajax四步
	 */

	// 得到xmlhttprequest
	var xmlHttp = createXMLHttpRequest();

	// 第二部调用Ｏｐｅｎ方法
	xmlHttpRequest.open(method, url, true);// true打开异步请求

	if (method == "POST") {
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
	}

	// 第三部调用ｓｅｎｄ方法
	xmlHttpRequest.send(parameters);// ｇｅｔ方法没有请求体，也必须给出ｎｕｌｌ参数，否则火狐有可能出错

	// 第四步 给异步对象注册监听器
	xmlHttpRequest.onreadystatechange = function() {
		if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
			// var text = xmlHttpRequest.responseText;
			// h1.innerHTML = text;
			rollback();

		}
	}
}
