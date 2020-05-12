package cn.linjianming.spring5;

import cn.linjianming.spring5.service.ILoginService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: James Lin
 * @Date: 2020/05/01
 */
public class SpringDebugApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
		ILoginService loginService = applicationContext.getBean(ILoginService.class);
		loginService.login();
	}
}
