package com.sample.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomerMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		System.out.println("--------------------------------------------");
		Customer cust = context.getBean(Customer.class);
		Person person1 = context.getBean(Person.class);
		Person person2 = context.getBean(Person.class);
		System.out.println(person1 == person2);
		System.out.println(cust);

	}

}
