package cn.zhou.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.zhou.domain.User;
import cn.zhou.service.UserException;
import cn.zhou.service.UserService;
import cn.zhou.utils.CommonUtils;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private UserService userService = new UserService();
	private User user = new User();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("utf-8"); // 设置请求编码
		response.setContentType("text/html;charset=utf8"); // 设置响应编码

		// //把从请求页面得到数据封装到ｕｓｅｒ对象中
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setVerifyCode(request.getParameter("vCode"));
		user.setAge(request.getParameter("age"));
		user.setSex(request.getParameter("sex"));

		Map<String, String> map = new HashMap<String, String>();

		// User form = CommonUtils.toBean(request.getParameterMap(), User.class);

		String username = user.getUsername();
		if (username == null || username.trim().isEmpty()) {
			map.put("error2", "用户名不能为空!!");
		} else if (username.length() < 2 || username.length() > 15) {
			map.put("error2", "用户名必须为２～１５之间");
		}

		String password = user.getPassword();
		if (password == null || password.trim().isEmpty()) {
			map.put("error3", "密码不能为空!!!");
		} else if (password.length() < 3 || password.length() > 15) {
			map.put("error3", "密码必须为３～１５之间！！");
		}

		// String vc = (String) request.getSession().getAttribute("sessionVerifyCode");
		// String verifyCode = user.getVerifyCode();
		// if (verifyCode == null || verifyCode.trim().isEmpty()) {
		// map.put("error4", "验证码不能为空!!!");
		// } else if (verifyCode.length() != 4) {
		// map.put("error4", "验证码长度必须为４!!!");
		// } else if (!(verifyCode.equalsIgnoreCase(vc))) {
		// map.put("error4", "验证码错误!!!");
		// }


		try {
			
//			if (map != null || map.size() > 0) {
//				request.setAttribute("map", map);
//				request.setAttribute("user", user);
//				request.getRequestDispatcher("/jsp/Regist.jsp").forward(request, response);
//				return;
//			}

			
			userService.regist( user);
			// userService.regist(form);
			response.getWriter().print(
					"注册成功!!!" + "<br/>" + "<a href='" + request.getContextPath() + "/jsp/Login.jsp'>点击此处去登录</a>");
		} catch (UserException e) {
			request.setAttribute("error", e.getMessage()); // 向ｒｅｑｕｅｓｔ与保存粗偶信息
			request.setAttribute("username", username); //
			request.getRequestDispatcher("/jsp/Regist.jsp").forward(request, response);
		}

	}

}
