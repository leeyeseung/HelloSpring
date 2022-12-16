package com.sample.myapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		//일반적인 xml파일로 설정하겠다
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("application-config.xml");
		//Config class로 빈을 생성하고 등등 하겠다
		//AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("------------------------------------------");
		HelloController helloController = context.getBean(HelloController.class);
		helloController.hello("홍길동");
		System.out.println();
		helloController.goodbye("이연희");
		System.out.println("===============================================");
		context.close();
	}

}
