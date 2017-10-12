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
		
		Offer updateOffer = new Offer(90, "Claire", "claire@caveofprogramming.com", "Web design to fit any budget");
		if(offersDao.update(updateOffer)) {
			System.out.println("Object updated.");
		}
		else {
			System.out.println("Cannot update object.");
		}
		
		try {
			/*
			if(offersDao.create(new Offer("Albert", "albert@caveofprogramming.com", "Will write whatever software you want."))) {
				System.out.println("Creation successful");
			}
			else {
				System.out.println("Unable to create object.");
			}
			*/
			List<Offer> offersList = new ArrayList<Offer>();
			
			offersList.add(new Offer("Dave", "dave@caveofprogramming.com", "Cash for software."));
			offersList.add(new Offer("Karen", "karen@caveofprogramming.com", "Elegant web design"));
			
			int[] rvals = offersDao.create(offersList);
			
			for(int value: rvals) {
				System.out.println("Updated " + value + " rows.");
			}
			
			offersDao.delete(80);
			
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
			
			Offer offer = offersDao.getOffer(2);
			
			System.out.println("Should be Mike: " + offer);
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
