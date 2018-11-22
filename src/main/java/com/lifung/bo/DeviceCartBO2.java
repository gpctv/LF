package com.lifung.bo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.bean.DeviceProfileKey;
import com.lifung.dao.DeviceProfile;
import com.lifung.dao.DeviceProfileDAO;

@Transactional
public class DeviceCartBO2 {
private DeviceProfileDAO deviceProfileDAO;
private SessionFactory sessionFactory;
	public DeviceProfileDAO getDeviceProfileDAO() {
		return deviceProfileDAO;
	}
	public void setDeviceProfileDAO(DeviceProfileDAO deviceProfileDAO) {
		this.deviceProfileDAO = deviceProfileDAO;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public List<DeviceProfile> queryDeviceProfile(String storerKey) {
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.DeviceProfile.deviceQuery2");
		query.setString("storerKey", storerKey);
		
		List<DeviceProfile> table=query.list();
		 
		return table;
	}
	
	public List<String> getStorer(){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.DeviceProfile.Storer2");
		List<String> storer=query.list();
		
		return storer;
	}
	/**
	 * check profilekey exist
	 * @param deviceProfileKey
	 * @return
	 */
	public String queryDeviceProfileKey(String deviceProfileKey) throws Exception {
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.DeviceProfile.queryDeviceProfileKey2");
		query.setString("deviceProfileKey", deviceProfileKey) ;
		Integer i= Integer.valueOf(query.list().get(0).toString()) ;
		String validation="false";
		if(i>=1) {
			validation="false";
		}else {
			validation="true";
		}
	    return validation;
	}
	/**
	 * check deviceId exist
	 * @param deviceId
	 * @return
	 */
	public String queryDeviceId(String deviceId) throws Exception{
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.DeviceProfile.deviceId2");
		query.setString("deviceId", deviceId) ;
		Integer i= Integer.valueOf(query.list().get(0).toString()) ;
		String validation="false";
		if(i>=1) {
			validation="false";
		}else {
			validation="true";
		}
	    return validation;
	}
	/**
	 * insert deviceProfile
	 * @param deviceProfileKey
	 * @param ipAddress
	 * @param portNo
	 * @param deviceId
	 * @param position
	 */
	public void create(String deviceProfileKey,String ipAddress,String portNo,String deviceId,int position) {
		DeviceProfileKey key=splitNum(deviceProfileKey) ;
	
	   for(int i=0;i<position;i++) {
		   DeviceProfile deviceProfile=new DeviceProfile();
		   deviceProfile.setDeviceProfileKey(key.getKey()+numFormat(key.getNum()));
		   deviceProfile.setIpaddress(ipAddress);
		   deviceProfile.setPortNo(portNo);
		   deviceProfile.setDeviceId(deviceId);
		   deviceProfile.setDeviceType("Station");
		   deviceProfile.setStatus("0");
		   int p=i+1;
		   deviceProfile.setDevicePosition(String.valueOf(p));
		   
		   key.setNum(key.getNum()+1);
		   this.insertDeviceSQL(deviceProfile);
	   }
		
		
		 
		
	}
	/**
	 * KEY 文字數字分離
	 * @param v
	 * @return
	 */
	private DeviceProfileKey splitNum(String v) {
		DeviceProfileKey deviceProfielkey=new DeviceProfileKey();
		String[] part = v.split("(?<=\\D)(?=\\d)");
		for(int i=0;i<part.length;i++) {
			if (part[i].matches("[0-9]+")) {
				deviceProfielkey.setNum(Integer.valueOf(part[i]));
			}else {
				deviceProfielkey.setKey(part[i]);
			}
		}
		return deviceProfielkey;
	}
	/**
	 * 數字轉文字 000
	 * @param num
	 * @return
	 */
	private String numFormat(int num) {
		if(num<10) {
			return "00"+ num ;
		}else if(num<99){
			return "0"+num;
		}else {
			return String.valueOf(num);
		}
	}
	
	private int insertDeviceSQL(DeviceProfile deviceProfile) {
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(" insert into DeviceProfile  " + 
				"(DeviceProfileKey,IPAddress,PortNo,DeviceType,DeviceID,DevicePosition,Status) " + 
				"values(:DeviceProfileKey,:IPAddress,:PortNo,:DeviceType,:DeviceID,:DevicePosition,'0') " + 
				" ");
		query.setString("DeviceProfileKey", deviceProfile.getDeviceProfileKey());
		query.setString("IPAddress", deviceProfile.getIpaddress());
		query.setString("PortNo", deviceProfile.getPortNo());
		query.setString("DeviceType", deviceProfile.getDeviceType());
		query.setString("DeviceID", deviceProfile.getDeviceId());
		query.setString("DevicePosition", deviceProfile.getDevicePosition());
	  int i=query.executeUpdate();
	  return i;
	}
	
}
