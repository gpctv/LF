package com.lifung.bo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class StorerBO {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<String> getStorer(){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.ItfConfig.storer");
		List<String> storer=query.list();
		
		return storer;
	}
}
