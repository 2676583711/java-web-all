package cn.zhou.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);

		System.out.println("ｓｅｒｖｌｅｔ之死。。。。。。。。");

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("servlet之出生。。。。。。。。。");

	}

}
