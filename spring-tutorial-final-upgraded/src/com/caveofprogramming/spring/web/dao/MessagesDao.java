package com.caveofprogramming.spring.web.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("messagesDao")
public class MessagesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public List<Message> getMessages() {
		
		CriteriaBuilder builder = session().getCriteriaBuilder();
		CriteriaQuery<Message> query = builder.createQuery(Message.class);
		Root<Message> root = query.from(Message.class);
		CriteriaQuery<Message> all = query.select(root);
		TypedQuery<Message> typedQuery = session().createQuery(all);

		return typedQuery.getResultList();
	}

	public List<Message> getMessages(String username) {
		
		CriteriaBuilder builder = session().getCriteriaBuilder();
		CriteriaQuery<Message> query = builder.createQuery(Message.class);
		Root<Message> root = query.from(Message.class);
		CriteriaQuery<Message> all = query.select(root).where(builder.equal(root.get("username"), username));

		TypedQuery<Message> typedQuery = session().createQuery(all);
		
		List<Message> messages = typedQuery.getResultList();
		
		return typedQuery.getResultList();
	}

	public void saveOrUpdate(Message message) {
		System.out.println(message);
		session().saveOrUpdate(message);
	}

	public boolean delete(int id) {

		Message message = session().get(Message.class, id);

		if (message != null) {
			session().remove(message);
			return true;
		}

		return false;
	}

	public Message getMessage(int id) {
		
		CriteriaBuilder builder = session().getCriteriaBuilder();
		CriteriaQuery<Message> query = builder.createQuery(Message.class);
		Root<Message> root = query.from(Message.class);
		query.select(root).where(builder.equal(root.get("id"), id));

		CriteriaQuery<Message> all = query.select(root);
		TypedQuery<Message> typedQuery = session().createQuery(all);

		return typedQuery.getSingleResult();
	}

}
