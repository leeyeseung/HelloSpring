package com.sample.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


public class HelloController {
	@Autowired
	IHelloService helloService;
		
	public void hello(String name) {
		System.out.println("HelloController :"+ helloService.sayHello(name) );
	}
	
}
