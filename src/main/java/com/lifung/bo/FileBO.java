package com.lifung.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.bean.FileBean;
import com.lifung.bean.PageBean;
import com.lifung.bean.Times;
import com.lifung.dao.ItfConfig;

@Transactional
public class FileBO {
 

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<ItfConfig> queryItConfig(String storerkey){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.ItfConfig.query");
		query.setString("storerkey", storerkey);
		List<ItfConfig> table=query.list();
		 
		return table;
		 
	}
	
	
	public List<FileBean> queryOut(String datastream,String adddate,PageBean page,String times,String status){
		 Times timeObject=new Times();
		 timeObject.isNoon(times);
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.OutLine.query");
		query.setString("datastream", datastream); 
		query.setInteger("start", page.getStart());
		query.setInteger("end", page.getEnd());
		query.setString("time1", adddate+" "+timeObject.getTime1());
		query.setString("time2", adddate+" "+timeObject.getTime2());
		query.setString("status", status);
		List<FileBean> listFileBean=new ArrayList<FileBean>();
		List<Object[]> table=query.list();
		for(Object o[]:table) {
			FileBean fileBean=new FileBean();
			fileBean.setFileKey(o[0].toString());
			fileBean.setDatastream(o[1].toString());
			fileBean.setFilename(o[2].toString());
			fileBean.setStatus(o[3].toString());
			fileBean.setTry_(o[4].toString());
			fileBean.setAdddate(o[5].toString());
			fileBean.setLineText(o[6].toString());
			if(null!=o[7]) {
			fileBean.setErrMsg(o[7].toString());
			}else {
				fileBean.setErrMsg("");
			}
			fileBean.setLineTextUnicode(o[8].toString());
			fileBean.setRowNum(o[9].toString());
			listFileBean.add(fileBean);
		}
		return listFileBean;
	}
	
	public int queryOutSize(String datastream,String adddate,String times,String status) {
		 Times timeObject=new Times();
		 timeObject.isNoon(times);
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.OutLine.querySize");
		query.setString("datastream", datastream); 
		query.setString("time1", adddate+" "+timeObject.getTime1());
		query.setString("time2", adddate+" "+timeObject.getTime2());
		query.setString("status", status);
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		return size ;
	}
	
	public List<FileBean> queryIn(String datastream,String adddate,PageBean page,String times,String status){
		 Times timeObject=new Times();
		 timeObject.isNoon(times);
		
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.InLine.query");
		query.setString("datastream", datastream); 
		query.setInteger("start", page.getStart());
		query.setInteger("end", page.getEnd());
		query.setString("time1", adddate+" "+timeObject.getTime1());
		query.setString("time2", adddate+" "+timeObject.getTime2());
		query.setString("status", status);
		List<FileBean> listFileBean=new ArrayList<FileBean>();
		List<Object[]> table=query.list();
		for(Object o[]:table) {
			FileBean fileBean=new FileBean();
			fileBean.setFileKey(o[0].toString());
			fileBean.setDatastream(o[1].toString());
			fileBean.setFilename(o[2].toString());
			fileBean.setStatus(o[3].toString());
			fileBean.setTry_(o[4].toString());
			fileBean.setAdddate(o[5].toString());
			fileBean.setLineText(o[6].toString());
			if(null!=o[7]) {
			fileBean.setErrMsg(o[7].toString());
			}else {
				fileBean.setErrMsg("");
			}
			fileBean.setLineTextUnicode(o[8].toString());
			fileBean.setRowNum(o[9].toString());
			listFileBean.add(fileBean);
		}
		return listFileBean;
	}
	
	public int queryInSize(String datastream,String adddate,String times,String status) {
		 Times timeObject=new Times();
		 timeObject.isNoon(times);
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.InLine.querySize");
		query.setString("datastream", datastream); 
		query.setString("time1", adddate+" "+timeObject.getTime1());
		query.setString("time2", adddate+" "+timeObject.getTime2());
		query.setString("status", status);
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		return size ;
	}
}
