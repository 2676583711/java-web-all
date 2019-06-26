package cn.zhou.mailutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;

public class MailUtilsProperties {
	private static String mailHost = null;

	private static String username = null;

	private static String password = null;

	private static String sendName = null;

	private static String receiveName = null;

	private static String subject = null;

	private static String text = null;

	public MailUtilsProperties() {

	}

	public MailUtilsProperties(String text) {

		this.mailHost = "smtp.163.com";
		this.username = "15171683953@163.com";
		this.password = "zhou123456";

		this.sendName = "15171683953@163.com";
		this.receiveName = "15171683953@163.com";

		this.subject = "15171683953@163.com.subject";
		this.text = text;
	}

	public MailUtilsProperties(String mailHost, String username, String password, String sendName, String receiveName,
			String subject, String text) {

		this.mailHost = mailHost;
		this.username = username;
		this.password = password;
		this.sendName = sendName;
		this.receiveName = receiveName;
		this.subject = subject;
		this.text = text;

	}

	private static Properties properties = null;

	static {
		InputStream is = MailUtilsProperties.class.getResourceAsStream("mail.properties");
		properties = new Properties();

		try {
			properties.load(is);

			mailHost = properties.getProperty("mailHost");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			sendName = properties.getProperty("sendName");
			receiveName = properties.getProperty("receiveName");
			subject = properties.getProperty("subject");
			text = properties.getProperty("text");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test
	public static void mail() throws AddressException, MessagingException {

		Properties p = new Properties();
		p.setProperty("mail.host", mailHost);
		p.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};

		Session s = Session.getInstance(p, auth);

		MimeMessage mm = new MimeMessage(s);

		mm.setFrom(new InternetAddress(sendName));

		mm.setRecipients(RecipientType.TO, receiveName);

		mm.setSubject(subject);
		mm.setContent(text, "text/html;charset=utf-8");

		Transport.send(mm);
	}

	public static void main(String[] args) throws AddressException, MessagingException {
//		MailUtilsProperties mup = new MailUtilsProperties("smtp.163.com", "15171683953@163.com", "zhou123456",
//				"15171683953@163.com", "15171683953@163.com", "15171683953@163.com", "mailHost123456");
		MailUtilsProperties mup = new MailUtilsProperties("zhe shi wo ziji de text wenjian ");
		
		mup.mail();
	}

}
