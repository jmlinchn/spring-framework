package cn.linjianming.spring5.service.annotation;

import org.springframework.stereotype.Service;

@Service
public class AnnotationDemoService {

	public void sayHello() {
		System.out.println("AnnotationDemoService -- Hello");
	}
}
