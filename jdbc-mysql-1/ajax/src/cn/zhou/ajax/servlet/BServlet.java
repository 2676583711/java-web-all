package cn.zhou.ajax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BServlet
 */
public class BServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String xml = "<students>" + "<student>" + "<name>tom</name>" + "<age>16</age>" + "</student>" + "</students>";

		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().print(xml);

	}

}
