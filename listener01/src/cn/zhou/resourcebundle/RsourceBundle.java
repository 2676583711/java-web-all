package cn.zhou.resourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class RsourceBundle {

	@Test
	public void test1() {
		Locale l = Locale.US;
		ResourceBundle rb = ResourceBundle.getBundle("zhou", l);
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("login"));
	}

}
