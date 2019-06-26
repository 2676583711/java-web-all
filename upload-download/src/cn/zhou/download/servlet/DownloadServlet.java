package cn.zhou.download.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * 下载 两个头 一个流
		 */

		String file = "/home/zhou/流光飞舞.mp3"; // 得到下载文件的路径
		String fileType = this.getServletContext().getMimeType(file); // 得到文件的ｍｉｍｅ类型

		InputStream is = new FileInputStream(file); // 读取下载文件

		String contentType = fileType; // 设置文件类型响应头
		// String contentDisposition = "attachment;filename=liu.mp3"; // 设置响应头

		String fn = filenameEncoding("流光飞舞.mp3", request);
		String contentDisposition = "attachment;filename=" + fn; // 设置响应头

		System.out.println(fn);

		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);

		OutputStream output = response.getOutputStream();
		IOUtils.copy(is, output);
		is.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// 对下载的文件的中文名称进行编码，用来解决中文乱码问题
	public static String filenameEncoding(String filename, HttpServletRequest request)
			throws UnsupportedEncodingException {

		String agent = request.getHeader("User-Agent");
		if (agent.contains("firefox")) {
			// Base64.Encoder base64Encoder = Base64.getEncoder();
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filename = "=?utf-8 ?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else if (agent.contains("MSIE")) {
			filename = URLEncoder.encode(filename, "utf-8");
		} else {
			filename = URLEncoder.encode(filename, "utf-8");
		}

		return filename;

	}

}
