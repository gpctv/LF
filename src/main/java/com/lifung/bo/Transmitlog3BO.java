package com.lifung.bo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.bean.PageBean;
import com.lifung.dao.Transmitlog3;
import com.lifung.dao.Transmitlog3DAO;
@Transactional
public class Transmitlog3BO {
	private SessionFactory sessionFactory;
	private Transmitlog3DAO transmitlog3DAO;
	
	public void setTransmitlog3DAO(Transmitlog3DAO transmitlog3dao) {
		transmitlog3DAO = transmitlog3dao;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	/**
	 * 
	 * @param key3 storerkey
	 * @param key1 order or receipt key
	 * @return
	 */
	public List<Transmitlog3> queryTransmitlog3(String key3,String key1,PageBean page){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Transmitlog3.query");
		query.setString("storer", key3);
		query.setString("key1", "%"+key1+"%");
		query.setInteger("start", page.getStart());
		query.setInteger("end", page.getEnd());
		
		List<Transmitlog3> logList3=query.list();
		return logList3;
	}
	
	public Integer queryTransmitlog3Size(String key3,String key1) {
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Transmitlog3.querySize");
		query.setString("storer", key3);
		query.setString("key1", "%"+key1+"%");
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		return size ;
	}
	
	public Transmitlog3 updateTransmitlog3(Transmitlog3 transmitlog3) {
		Transmitlog3 transmitlog3_1=this.transmitlog3DAO.merge(transmitlog3);
		return transmitlog3_1;
	}

}
