package cn.zhou.ajax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VlidateUsernameServlet
 */
public class ValidateUsernameServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");

		if (username.equalsIgnoreCase("zhou")) {
			response.getWriter().println(1);
		} else {
			response.getWriter().println(0);
		}

		System.out.println(username);

	}

}
