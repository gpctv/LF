package com.lifung.bo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.dao.ItfConfig2;
import com.lifung.dao.ItfGtwatcherConfig;
import com.lifung.dao.ItfGtwatcherConfigDAO;
@Transactional
public class EdiBo {

	private SessionFactory sessionFactory;
	private ItfGtwatcherConfigDAO itfGtwatcherConfigDAO;
	
	public void setItfGtwatcherConfigDAO(ItfGtwatcherConfigDAO itfGtwatcherConfigDAO) {
		this.itfGtwatcherConfigDAO=itfGtwatcherConfigDAO;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<String> getStorer(){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.ItfConfig.storer");
		List<String> storer=query.list();
		
		return storer;
	}
	
	public List<String> getEdiStorer(){
		Query query=this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.ItfConfig.ediStorer");
		List<String> storer=query.list();
		return storer;
	}
	
	public List<Object[]> getTable(String storerkey){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.ItfConfig.edi");
		query.setString("storerkey", storerkey);
		
		List<Object[]> table=query.list();
		 
		return table;
	}
	
	public void updateItfgtwatcherconfig(List<ItfConfig2> table) {
		for(ItfConfig2 itfconfig2:table) {
		 
		ItfGtwatcherConfig watcher=this.itfGtwatcherConfigDAO.findById(Integer.valueOf(itfconfig2.getWatcherConfigKey()));
		System.out.println("test 2 :"+watcher.getDatastream());
		watcher.setActiveFlag(itfconfig2.getActiveflag());
		this.itfGtwatcherConfigDAO.merge(watcher);
		}
	}
	
}
