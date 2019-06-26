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

import cn.zhou.commonsutils.CommonUtils;

/**
 * Servlet implementation class UploadServlet3
 */
public class UploadServlet3 extends HttpServlet {  //上传不能使用baseservlet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DiskFileItemFactory dfif = new DiskFileItemFactory(1024*20,new File("/home/zhou")); // 创建工厂

		// 创建解析器
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		
		
		//sfu.setFileSizeMax(1024*100);  //限制上传文件的大小　最大为　１００ｋ
		//sfu.setSizeMax(1024*1024*1);  //设置整个表单大小为 1M

		// 解析文件 得到ｌｉｓｔ集合
		try {
			List<FileItem> list = sfu.parseRequest(request);
			FileItem fi = list.get(1);

			String name = fi.getName(); // 得到上传文件名称
			System.out.println(name);

			// 处理上传文件的绝对路径 只去文件名称 不要前缀 文件路径名称
			int index = name.lastIndexOf("//");
			if (index != -1) {
				name = name.substring(index + 1);
			}

//			int index2 = name.lastIndexOf(".");
//			if (index2 != -1) {
//				name = name.substring(index2);
//			}

			int hashCode = name.hashCode(); // 得到哈希值
			System.out.println("hshCode:" + hashCode);
			// 把哈希值转换成十六进制
			String hex = Integer.toHexString(hashCode);
			System.out.println("hex:" + hex);

			// 给出文件路径
			String rootPath = this.getServletContext().getRealPath("/WEB-INF/pictures");

			String saveName = CommonUtils.getUuid() +"_"+ name;
			// + "_"

			File file1 = new File(rootPath, hex.charAt(0) + "/" + hex.charAt(1));

			file1.mkdirs();

			File file2 = new File(file1, saveName);

			fi.write(file2);

		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
