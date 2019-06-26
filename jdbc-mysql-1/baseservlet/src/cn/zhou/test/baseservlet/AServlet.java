package cn.zhou.test.baseservlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

/**
 * Servlet implementation class AServlet
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");

		if (methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("你未输入方法名，找不到你要调用的方法!");
		}

		Class<? extends AServlet> c = this.getClass(); // 得到当前类
		try {
			Method method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class); // 得到方法名
			method.invoke(this, request, response);

		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (IllegalArgumentException e) {

			e.printStackTrace();
		} catch (InvocationTargetException e) {

			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void addUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("addUser().....");
	}

	public void deleteUser(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("deleteUser().....");

	}

	public void modifyUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("modifyUser().....");
	}

	public void searchUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("searchUser().....");
	}


	
}
