package cn.zhou.mailutils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

public class MailUtils {

	private static Session session = null;

	private static MimeMessage mm = null;

	private static String receiveName = null;;
	private static String sendName = null;

	private static String subject = null;
	private static String text = null;
	private static String filePath = null;
	private static File file = null;
	private static String fileName = null;

	private static String mailHost = null;
	private static String username = null;
	private static String password = null;

	

	public MailUtils(String text) {

		this.mailHost = "smtp.163.com";
		this.username = "15171683953@163.com";
		this.password = "zhou123456";

		this.sendName = "15171683953@163.com";
		this.receiveName = "15171683953@163.com";

		this.subject = "15171683953@163.com.subject";
		this.text = text;
	}

	public MailUtils(String mailHost, String username, String password, String sendName, String receiveName,
			String subject, String text) {
		this.mailHost = mailHost;
		this.username = username;
		this.password = password;

		this.sendName = sendName;
		this.receiveName = receiveName;

		this.subject = subject;
		this.text = text;

	}

	public MailUtils(String mailHost, String username, String password, String sendName, String receiveName,
			String subject, String text, String filePath, String fileName) {
		this.mailHost = mailHost;
		this.username = username;
		this.password = password;
		this.sendName = sendName;
		this.receiveName = receiveName;

		this.subject = subject;

		this.text = text;
		this.filePath = filePath;
		this.fileName = fileName;

	}

	public static void getSession() {

		Properties p = new Properties();
		p.setProperty("mail.host", mailHost);
		p.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username, password);
			}
		};

		session = Session.getInstance(p, auth);
	}

	public static void getFile() {
		file = new File(filePath);
	}

	public static void setCommonMail() {
		getSession();

		mm = new MimeMessage(session);

		try {
			mm.setFrom(new InternetAddress(sendName));

			mm.setRecipients(RecipientType.TO, receiveName);

			mm.setSubject(subject);
			mm.setContent(text, "text/html;charset=utf-8");

			Transport.send(mm);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public static void setSpecialMail() {
		getSession();
		getFile();

		mm = new MimeMessage(session);

		try {
			mm.setFrom(new InternetAddress(sendName));
			mm.setRecipients(RecipientType.TO, receiveName);

			mm.setSubject(subject);

			MimeMultipart list = new MimeMultipart();

			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setContent(text, "text/html;charset=utf-8");

			list.addBodyPart(mbp1);

			MimeBodyPart mbp2 = new MimeBodyPart();
			mbp2.attachFile(file);
			mbp2.setFileName(fileName);

			list.addBodyPart(mbp2);

			mm.setContent(list);

			Transport.send(mm);

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void test1() {
		MailUtils mu = new MailUtils("wo ziji she zhi de text wen jian nei rong.........233333");
		mu.setCommonMail();
	}

}
