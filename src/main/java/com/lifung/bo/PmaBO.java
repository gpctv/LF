package com.lifung.bo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.bean.PageBean;
import com.lifung.dao.PmaRtnQty;
import com.lifung.dao.PmaRtnQtyDAO; 
@Transactional
public class PmaBO {
	private SessionFactory sessionFactory;
	private PmaRtnQtyDAO pmaRtnQtyDAO;
	
	public PmaRtnQtyDAO getPmaRtnQtyDAO() {
		return pmaRtnQtyDAO;
	}
	public void setPmaRtnQtyDAO(PmaRtnQtyDAO pmaRtnQtyDAO) {
		this.pmaRtnQtyDAO = pmaRtnQtyDAO;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Integer querySize(String carrierRef ) {
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.PmaRtnQty.querySize");
		query.setString("carrierRef", "%"+carrierRef+"%");
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		return size ;
	}
	public List<PmaRtnQty> queryTable(String  carrierRef ,PageBean page){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.PmaRtnQty.queryTable");
		if(null ==carrierRef) {
			carrierRef="";
		}
		query.setString("carrierRef", "%"+ carrierRef+"%");
		query.setInteger("start", page.getStart());
		query.setInteger("end", page.getEnd());
		
		List<PmaRtnQty> logList3=query.list();
		return logList3;
	}
	
	public void insertTable(PmaRtnQty pmaRtnQty) {
		 this.pmaRtnQtyDAO.persist(pmaRtnQty);
	}
	public void modifyTable(PmaRtnQty pmaRtnQty) {
		this.getPmaRtnQtyDAO().merge(pmaRtnQty);
	}
	public void deleteTable(PmaRtnQty pmaRtnQty) {
		this.getPmaRtnQtyDAO().delete(pmaRtnQty);
	}
	
	public String isExist(String  carrierRef ) {
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.PmaRtnQty.isExis");
		query.setString("carrierRef", carrierRef );
		Integer i= Integer.valueOf(query.list().get(0).toString()) ;
		String validation="false";
		if(i>=1) {
			validation="false";
		}else {
			validation="true";
		}
	    return validation;
	}
}
