package cn.zhou.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import cn.zhou.verifycode.VerifyCode;

/**
 * Servlet implementation class VerifyCodeServlet
 */
@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;cahrset=utf-8");
		
		VerifyCode verifyCode=new VerifyCode();
		BufferedImage bi=verifyCode.getImage();
	
		//String text=verifyCode.getText();
		
//		HttpSession session=request.getSession();
//		session.setAttribute("vCode", text);
//		
		
		request.getSession().setAttribute("sessionVerifyCode", verifyCode.getText());
		verifyCode.output(bi, response.getOutputStream());
	}

	

}
