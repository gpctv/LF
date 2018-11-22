package com.lifung.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.dao.Forecast;
import com.lifung.dao.ForecastDAO;
import com.lifung.dao.ForecastId;

@Transactional
public class ForecastBO {
	private SessionFactory sessionFactory;
	private ForecastDAO forecastDAO;
	
	public ForecastDAO getForecastDAO() {
		return forecastDAO;
	}


	public void setForecastDAO(ForecastDAO forecastDAO) {
		this.forecastDAO = forecastDAO;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	 

public List<ForecastId> queryForecast(String storerkey) {
	Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Forecast.queryFore");
	query.setString("storerkey", storerkey);
	List<Forecast> forecast=query.list();
	List<ForecastId> forecastIdList=new ArrayList<ForecastId>();
	for(int i=0;i<forecast.size();i++) {
		ForecastId forecastid=new ForecastId();
		forecastid.setF_date(forecast.get(i).getId().getF_date());
		forecastid.setQty(forecast.get(i).getId().getQty()) ;
		forecastid.setStorerkey(forecast.get(i).getId().getStorerkey()) ;
		forecastIdList.add(forecastid);
	}
	
	
	return forecastIdList;
}

public List<String> queryStorer(){
	Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Forecast.storer");
	List<String> storer=query.list();
	
	return storer;
}

 public boolean isExist(String Storerkey,String date1) {
	 Query query=this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Forecast.isExis");
	 query.setString("date1", date1);
	 query.setString("storerkey", Storerkey);
	 String  forcast=String.valueOf(query.list().get(0));
	 int i=Integer.valueOf(forcast);
	 if(i<=0) {
		 return true;
	 }else {
		 return false;
	 }
 }
 
 public void createFore(ForecastId forecastId) {
	 Forecast forecast=new Forecast();
	 forecast.setId(forecastId);
	 this.forecastDAO.attachDirty(forecast);
 }
 
 public int modifyFore(String date,String storerkey,String qty) {
	 Query query=this.sessionFactory.getCurrentSession().createSQLQuery(modifySQL());
	 query.setString("storerkey", storerkey);
	 query.setString("date1", date);
	 query.setString("qty", qty);
	  int i=query.executeUpdate();
	  return i;
 }

 public int deleteFore(String date,String storerkey) {
	 Query query=this.sessionFactory.getCurrentSession().createSQLQuery(deleteSQL());
	 query.setString("storerkey", storerkey);
	 query.setString("date1", date);
	  int i=query.executeUpdate();
	  return i;
 }
 private String deleteSQL() {
		String cmd=" delete " + 
				" from TW_LOCAL..FORECAST   " + 
				" where   storerkey=:storerkey and f_date =CONVERT(datetime, :date1,111)" + 
				"";
		return cmd;
	}
 
 private String modifySQL() {
		String cmd="update TW_LOCAL..FORECAST " + 
				"			set qty=:qty " + 
				"			where f_date = CONVERT(datetime, :date1,111) and storerkey=:storerkey";
		return cmd;
	}
}
