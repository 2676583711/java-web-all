package cn.zhou.baseservlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		if (methodName == null || methodName.trim().isEmpty()) {
			throw new RuntimeException("请输入你需要调用的方法的名称,否则无法调用方法");
		}

		Class c = this.getClass();
		try {

			// method.invoke() 调用所需要调用的方法
			Method method = c.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			String result = (String) method.invoke(this, request, response); // 获得调用方法之后的所返回的字符串

			if (result == null || result.trim().isEmpty()) { // 判断所返回的字符串使否为空
				return;
			}

			if (result.contains(":")) {
				int index = result.indexOf(":");
				String q = result.substring(0, index);
				String h = result.substring(index + 1);
				if (q.equalsIgnoreCase("f")) { // 如果前缀包含ｆ是转发
					request.getRequestDispatcher(h).forward(request, response);
				} else if (q.equalsIgnoreCase("r")) { // 如果前缀包含ｒ是重定向
					response.sendRedirect(request.getContextPath() + h);
				} else {
					throw new RuntimeException("本产品目前不支持：" + q + "这个操作");
				}
			} else {
				request.getRequestDispatcher(result).forward(request, response);
			}

		} catch (NoSuchMethodException | SecurityException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
