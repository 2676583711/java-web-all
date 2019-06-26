package cn.zhou.mail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

import cn.zhou.mailutils.MailUtils;

public class Demo01 {

	// 普通邮件（不带附件的邮件）
	@Test
	public void test1() throws AddressException, MessagingException {

		// 连接邮箱第一步 得到 session
		Properties properties = new Properties();

		properties.setProperty("mail.host", "smtp.163.com");
		properties.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("15171683953", "zhou123456");
			}
		};

		Session session = Session.getInstance(properties, auth);

		// 创建ｍｉｍｅｍｅｓｓａｇｅ

		MimeMessage mimeMessage = new MimeMessage(session);
		mimeMessage.setFrom(new InternetAddress("15171683953@163.com")); // 设置发件人
		mimeMessage.setRecipients(RecipientType.TO, "15171683953@163.com"); // 设置收件人
		mimeMessage.setRecipients(RecipientType.BCC, "15171683953@163.com"); // 设置暗送
		mimeMessage.setRecipients(RecipientType.CC, "15171683953@163.com"); // 设置抄送

		mimeMessage.setSubject("测试邮件"); // 邮件标题

		// 邮件内容
		mimeMessage.setContent("good monring/afternoon,1351" + "the god is a gril.....", "text/html;charset=utf-8");

		Transport.send(mimeMessage); // 发送邮件

	}

	// 带附件的邮件
	@Test
	public void test3() throws AddressException, MessagingException, IOException {

		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("15171683953", "zhou123456");
			}
		};

		Session session = Session.getInstance(prop, auth);

		// 设置邮件的发送信息
		MimeMessage mm = new MimeMessage(session);
		mm.setFrom(new InternetAddress("15171683953@163.com"));
		mm.setRecipients(RecipientType.TO, "15171683953@163.com");
		mm.setSubject("垃圾邮件的主题．．．．．．．．");

		// 邮件的内容
		MimeMultipart list = new MimeMultipart();

		MimeBodyPart mbp1 = new MimeBodyPart();
		mbp1.setContent("这个垃圾邮件", "text/html;charset=utf-8");
		list.addBodyPart(mbp1);

		MimeBodyPart mbp2 = new MimeBodyPart();
		// mbp2.setContent("这个垃圾邮件", "text/html;charset=utf-8");
		mbp2.attachFile(new File("/home/zhou/gril.jpg"));
		mbp2.setFileName("gril_gril_god.jpg");
		list.addBodyPart(mbp2);

		MimeBodyPart mbp3 = new MimeBodyPart();
		// mbp2.setContent("这个垃圾邮件", "text/html;charset=utf-8");
		mbp3.attachFile(new File("/home/zhou/流光飞舞.mp3"));
		// mbp3.setFileName("流光.mp3"); // MimeUtility.encodeText
		mbp3.setFileName(MimeUtility.encodeText("流光飞舞.mp3"));

		list.addBodyPart(mbp3);

		mm.setContent(list);

		Transport.send(mm);
	}

	@Test
	public void test2() {

		// 收件人电子邮箱
		String to = "15171683953@163.com";

		// 发件人电子邮箱
		String from = "15171683953@163.com";

		// 指定发送邮件的主机为 localhost
		String host = "localhost";

		// 获取系统属性
		Properties properties = System.getProperties();

		// 设置邮件服务器
		properties.setProperty("mail.smtp.host", host);

		// 获取默认session对象
		Session session = Session.getDefaultInstance(properties);

		try {
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);

			// Set From: 头部头字段
			message.setFrom(new InternetAddress(from));

			// Set To: 头部头字段
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: 头部头字段
			message.setSubject("This is the Subject Line!");

			// 设置消息体
			message.setText("This is actual message");

			// 发送消息
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

	@Test
	public void test4() throws MessagingException {
		Properties p = new Properties();

		p.setProperty("mail.host", "smtp.163.com");
		p.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("15171683953@163.com", "zhou123456");
			}

		};

		Session s = Session.getInstance(p, auth);

		MimeMessage mm = new MimeMessage(s);

		mm.setFrom(new InternetAddress("15171683953@163.com"));
		mm.setRecipients(RecipientType.TO, "15171683953@163.com");

		mm.setSubject("yi si zhu ti???????????");
		mm.setHeader("la ji you jian....", "text/html;charset=utf-8");
		mm.setContent("this jiu shi yi ge la ji you jian.....", "text/html;charset=utf8");

		Transport.send(mm);
	}

	@Test
	public void test5() {
		MailUtils mu = new MailUtils("smtp.163.com", "15171683953@163.com", "zhou123456", "15171683953@163.com",
				"15171683953@163.com", "这是一个测试邮件.....", "ce shi .com", "/home/zhou/gril.jpg", "gril.jpg");

		// mu.setCommonMail();
		mu.setSpecialMail();
	}

	@Test
	public void test6() {

	}

	@Test
	public void fun1() throws IOException {

		InputStream is = Demo01.class.getResourceAsStream("test.properties");
		Properties p = new Properties();
		p.load(is);

		String username = "zs123456";
		p.setProperty("username", username);

		System.out.println(p.getProperty("username"));

		String path = this.getClass().getResource("/").getPath();
		String path2 = Demo01.class.getResource("/").getPath();

		System.out.println(path);
		System.out.println(path2);

		File f = new File(path + "test.properties");
		OutputStream os = new FileOutputStream(f);
		p.store(os, username);

		os.write(123456);
	}
}
