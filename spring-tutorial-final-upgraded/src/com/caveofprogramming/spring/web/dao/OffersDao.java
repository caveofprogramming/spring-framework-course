package com.caveofprogramming.spring.web.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("offersDao")
public class OffersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public List<Offer> getOffers() {
		
		CriteriaBuilder builder = session().getCriteriaBuilder();
		CriteriaQuery<Offer> query = builder.createQuery(Offer.class);
		Root<Offer> root = query.from(Offer.class);
		CriteriaQuery<Offer> all = query.select(root);
		TypedQuery<Offer> typedQuery = session().createQuery(all);

		return typedQuery.getResultList();
	}

	public List<Offer> getOffers(String username) {
		
		CriteriaBuilder builder = session().getCriteriaBuilder();
		CriteriaQuery<Offer> query = builder.createQuery(Offer.class);
		Root<Offer> root = query.from(Offer.class);
		
		Join<Offer, User> userJoin = root.join("user");
		CriteriaQuery<Offer> all = query.select(root).where(builder.equal(userJoin.get("username"), username));
		
		TypedQuery<Offer> typedQuery = session().createQuery(all);

		return typedQuery.getResultList();

	}

	public void saveOrUpdate(Offer offer) {
		session().saveOrUpdate(offer);
	}

	public boolean delete(int id) {
		
		Offer offer=session().get(Offer.class, id);
		
		if(offer != null) {
			session().remove(offer);
			return true;
		}
		
		return false;
	}

	public Offer getOffer(int id) {
		
		
		CriteriaBuilder builder = session().getCriteriaBuilder();
		CriteriaQuery<Offer> query = builder.createQuery(Offer.class);
		Root<Offer> root = query.from(Offer.class);
		query.select(root).where(builder.and(builder.equal(root.get("id"), id)), 
				builder.equal(root.get("user").get("enabled"), true));

		CriteriaQuery<Offer> all = query.select(root);
		TypedQuery<Offer> typedQuery = session().createQuery(all);

		return typedQuery.getSingleResult();
	}

}
