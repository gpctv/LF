package com.lifung.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.lifung.bo.DeviceCartBO;
import com.lifung.dao.DeviceProfile;
import com.opensymphony.xwork2.ActionSupport;

public class DeviceCartAction extends ActionSupport {

	/**
	 * cart 
	 */
	private static final long serialVersionUID = 1L;
    private List<DeviceProfile> deviceProfile;
    private DeviceCartBO deviceCartBO;
	private String storerkey;
	private List<String> deviceId;
	private int total;
	private String deviceProfileKey;
	private String valid;
	
	private String deviceID;
	private int devicePosition;
	private String ipAddress;
	private String port;
	 
	
	
	
	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public int getDevicePosition() {
		return devicePosition;
	}

	public void setDevicePosition(int devicePosition) {
		this.devicePosition = devicePosition;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDeviceProfileKey() {
		return deviceProfileKey;
	}

	public void setDeviceProfileKey(String deviceProfileKey) {
		this.deviceProfileKey = deviceProfileKey;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	@JSON(name="total")
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	@JSON(name="deviceId")
	public List<String> getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(List<String> deviceId) {
		this.deviceId = deviceId;
	}

	public String getStorerkey() {
		return storerkey;
	}

	public void setStorerkey(String storerkey) {
		this.storerkey = storerkey;
	}

	public DeviceCartBO getDeviceCartBO() {
		return deviceCartBO;
	}

	public void setDeviceCartBO(DeviceCartBO deviceCartBO) {
		this.deviceCartBO = deviceCartBO;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
    @JSON(name="table")
	public List<DeviceProfile> getDeviceProfile() {
		return  deviceProfile ;
	}

	public void setDeviceProfile(List<DeviceProfile> deviceProfile) {
		this.deviceProfile = deviceProfile;
	}
	
	public String queryDevice() {
		try {
		this.deviceProfile=	this.deviceCartBO.queryDeviceProfile(this.storerkey);
			this.total=this.deviceProfile.size();
		}catch(Exception e) {
			LOG.error("error #0", e);
		}
		return "success";
	}
	
	public String queryDeviceId(){
		
		this.deviceId=this.deviceCartBO.getStorer();
		return "success";
	}
	public String queryDeviceProfileKey() {
		this.valid="";
		try {
		this.valid=this.deviceCartBO.queryDeviceProfileKey(this.deviceProfileKey);
		}catch(Exception e) {
			LOG.error("error #0", e);
		}
		return "success";
	}
	public String isExistDeviceId() {
		try {
			this.valid="";
		this.valid=this.deviceCartBO.queryDeviceId(this.deviceID);
		}catch(Exception e) {
			LOG.error("error #0", e);
		}
		return "success";
	}
	
	public String createDeviceProfile() {
		try {
			this.deviceCartBO.create(this.deviceProfileKey, this.ipAddress, this.port, this.deviceID, this.devicePosition);
			LOG.info("error #0 #1 #2 #3 #4 #5", this.deviceProfileKey, this.ipAddress, this.port, this.deviceID,String.valueOf(this.devicePosition) );
			LOG.info("createDeviceProfile success");
			return "success";
		}catch(Exception e) {
			LOG.error("error #0", e);
			return "success";
		}
	}
	
}
