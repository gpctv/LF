package com.lifung.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.dao.DeviceProfile;
import com.lifung.dao.Facility;
import com.lifung.dao.FacilityDAO;
@Transactional
public class FacilityBO {
	private Facility facility;
	private FacilityDAO facilityDAO;
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	public FacilityDAO getFacilityDAO() {
		return facilityDAO;
	}
	public void setFacilityDAO(FacilityDAO facilityDAO) {
		this.facilityDAO = facilityDAO;
	}
	
	public List<Facility> queryFacilityList(){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Facility.queryFacility");
		List<Facility> facilityList=query.list();
		 
		return facilityList;
	}
	 

}
