package com.caveofprogramming.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/caveofprogramming/spring/aop/beans.xml");
		
		Object obj = context.getBean("camera");
		System.out.println("Class of camera bean: " + obj.getClass());
		System.out.println(obj instanceof Camera);
		
		ICamera camera = (ICamera) context.getBean("camera");
		
		try {
			camera.snap();
		} catch (Exception e) {
			System.out.println("Caught exception " + e.getMessage());
		}

		context.close();
	}

}
