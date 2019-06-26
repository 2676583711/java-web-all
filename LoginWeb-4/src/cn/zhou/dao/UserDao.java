package cn.zhou.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.zhou.domain.User;

public class UserDao {
	private String path = "/home/zhou/workspace/program/java/java-EE/LoginWeb-1/WebContent/xml/user.xml";

	public User findByUsername(String username) {

		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(path);
			Element ele = (Element) document.selectSingleNode("//user[@username='" + username + "']");

			if (ele == null)
				return null;

			User user = new User();
			String un = ele.attributeValue("username");
			String ps = ele.attributeValue("password");
			user.setUsername(un);
			user.setPassword(ps);
			return user;

		} catch (DocumentException e) {

			throw new RuntimeException(e);
			// e.printStackTrace();
		}

	}

	public void addUser(User user) {

		SAXReader saxReader = new SAXReader(); // 得到ｘｍｌ解析器
		try {

			Document document = saxReader.read(path); // 解析ｘｍｌ文件得到ｄｏｃｕｍｅｎｔ
			Element root = document.getRootElement(); // 得到根元素
			Element uele = root.addElement("user"); // 创建一个新的ｕｓｅｒ元素

			String username = user.getUsername(); // 设置ｕｓｅｒ元素的uername属性
			String password = user.getPassword(); // 设置ｕｓｅｒ元素的ｐａｓｓｗｏｒｄ属性

			uele.addAttribute("username", username);
			uele.addAttribute("password", password);

			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"), format);
			xmlWriter.write(document);
			xmlWriter.close();

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

}
