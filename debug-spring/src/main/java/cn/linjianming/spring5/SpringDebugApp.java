package cn.linjianming.spring5;

import cn.linjianming.spring5.service.annotation.AnnotationDemoService;
import cn.linjianming.spring5.service.xml.ILoginService;
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

		AnnotationDemoService annotationDemoService = applicationContext.getBean(AnnotationDemoService.class);
		annotationDemoService.sayHello();

		System.out.println("============================运行结束============================");
	}
}
