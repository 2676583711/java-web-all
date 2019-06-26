package cn.zhou.servlet;

import java.io.IOException;
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
 * Servlet implementation class LoginServlet
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private UserService userService = new UserService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		User user=new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setVerifyCode(request.getParameter("verifyCode"));

		try {
			
			

			User u= userService.Login(user);
			request.getSession().setAttribute("user", u);
			response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
		} catch (UserException e) {

			request.setAttribute("message",e.getMessage());
			request.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
			
		}

	}

}
