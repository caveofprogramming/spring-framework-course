package com.caveofprogramming.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

public class App {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/caveofprogramming/spring/test/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");
		
		
		try {
			
			List<Offer> offersList = new ArrayList<Offer>();
			
			offersList.add(new Offer(3, "Steve", "steve@caveofprogramming.com", "Cash for software."));
			offersList.add(new Offer(2, "Joe", "joe@caveofprogramming.com", "Elegant web design"));
			
			int[] rvals = offersDao.create(offersList);
			
			for(int value: rvals) {
				System.out.println("Updated " + value + " rows.");
			}
			
		}
		catch(CannotGetJdbcConnectionException ex) {
			System.out.println("Unable to connect to database.");
		}
		catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}

}
