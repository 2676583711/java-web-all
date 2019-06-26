package cn.zhou.upload.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet2
 */
public class UploadServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 上传三步 第一步创建 ＤｉｓｋＦｉｌｅＩｔｅｍＦａｃｔｏｒｙ工厂 第二步 通过工厂创建 解析器 ＳｅｒｖｌｅｔＦｉｌｅＵｐｌｏａｄ 第三部 使用解析器解析
		 * ｒｑｕｅｓｔ 得到ＦｉｌＩｔｅｍ集合
		 * 
		 */

		DiskFileItemFactory dfif = new DiskFileItemFactory(); // 创建工厂

		ServletFileUpload sfu = new ServletFileUpload(dfif);

		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi1 = list.get(0);
			FileItem fi2 = list.get(1);
			
			System.out.println(fi1.getName() + ":" + fi1.getFieldName() + ":" + fi1.getString());
			System.out.println(fi2.getContentType());
			System.out.println(fi2.getSize());
			System.out.println(fi2.getName() + ":" + fi2.getFieldName());

			File file = new File("/home/zhou/gril.jpg");
			fi2.write(file); // 把获取到的文件写入硬盘文件

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
