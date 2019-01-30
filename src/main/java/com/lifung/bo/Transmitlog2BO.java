package com.lifung.bo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.bean.PageBean;
import com.lifung.dao.Transmitlog2;
import com.lifung.dao.Transmitlog2DAO;
import com.lifung.dao.Transmitlog3;
 
@Transactional
public class Transmitlog2BO {
	private SessionFactory sessionFactory;
	private Transmitlog2DAO transmitlog2DAO;
	
	public void setTransmitlog2DAO(Transmitlog2DAO transmitlog2DAO) {
		this.transmitlog2DAO = transmitlog2DAO;
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
	public List<Transmitlog2> queryTransmitlog2(String key3,String key1,PageBean page){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Transmitlog2.query");
		query.setString("storer", key3);
		query.setString("key1", "%"+key1+"%");
		query.setInteger("start", page.getStart());
		query.setInteger("end", page.getEnd());
		
		List<Transmitlog2> logList2=query.list();
		return logList2;
	}
	public Transmitlog2 updateTransmitlog2(Transmitlog2 transmitlog2) {
		Transmitlog2 transmitlog2_1=this.transmitlog2DAO.merge(transmitlog2);
		return transmitlog2_1;
	}
	public Integer queryTransmitlog2Size(String key3,String key1) {
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Transmitlog2.querySize");
		query.setString("storer", key3);
		query.setString("key1", "%"+key1+"%");
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		return size ;
	}
}
