package com.sample.myapp;

public class HelloController {
	IHelloService helloService;
	

	public void hello(String name) {
		System.out.println("HelloController :"+ helloService.sayHello(name) );
	}
	
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}
	

	
	
}
