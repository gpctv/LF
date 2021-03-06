// default package
// Generated 2018/8/10 ?? 11:32:26 by Hibernate Tools 3.4.0.CR1
package com.lifung.dao;
import java.util.Date;

/**
 * DeviceProfile generated by hbm2java
 */
public class DeviceProfile implements java.io.Serializable {

	private String deviceProfileKey;
	private String ipaddress;
	private String portNo;
	private String deviceType;
	private String deviceId;
	private String devicePosition;
	private String status;
	private Date addDate;
	private String addWho;
	private Date editDate;
	private String editWho;
	private String trafficCop;
	private String deviceProfileLogKey;
	private String priority;
	private String storerKey;
	private String loc;
	private String logicalPos;
	private String logicalName;

	public DeviceProfile() {
	}

	public DeviceProfile(String deviceProfileKey, String ipaddress, String portNo, String deviceType, String deviceId,
			String devicePosition, String status, Date addDate, String addWho, Date editDate, String editWho,
			String logicalPos, String logicalName) {
		this.deviceProfileKey = deviceProfileKey;
		this.ipaddress = ipaddress;
		this.portNo = portNo;
		this.deviceType = deviceType;
		this.deviceId = deviceId;
		this.devicePosition = devicePosition;
		this.status = status;
		this.addDate = addDate;
		this.addWho = addWho;
		this.editDate = editDate;
		this.editWho = editWho;
		this.logicalPos = logicalPos;
		this.logicalName = logicalName;
	}

	public DeviceProfile(String deviceProfileKey, String ipaddress, String portNo, String deviceType, String deviceId,
			String devicePosition, String status, Date addDate, String addWho, Date editDate, String editWho,
			String trafficCop, String deviceProfileLogKey, String priority, String storerKey, String loc,
			String logicalPos, String logicalName) {
		this.deviceProfileKey = deviceProfileKey;
		this.ipaddress = ipaddress;
		this.portNo = portNo;
		this.deviceType = deviceType;
		this.deviceId = deviceId;
		this.devicePosition = devicePosition;
		this.status = status;
		this.addDate = addDate;
		this.addWho = addWho;
		this.editDate = editDate;
		this.editWho = editWho;
		this.trafficCop = trafficCop;
		this.deviceProfileLogKey = deviceProfileLogKey;
		this.priority = priority;
		this.storerKey = storerKey;
		this.loc = loc;
		this.logicalPos = logicalPos;
		this.logicalName = logicalName;
	}

	public String getDeviceProfileKey() {
		return this.deviceProfileKey;
	}

	public void setDeviceProfileKey(String deviceProfileKey) {
		this.deviceProfileKey = deviceProfileKey;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getPortNo() {
		return this.portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
	}

	public String getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDevicePosition() {
		return this.devicePosition;
	}

	public void setDevicePosition(String devicePosition) {
		this.devicePosition = devicePosition;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getAddWho() {
		return this.addWho;
	}

	public void setAddWho(String addWho) {
		this.addWho = addWho;
	}

	public Date getEditDate() {
		return this.editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getEditWho() {
		return this.editWho;
	}

	public void setEditWho(String editWho) {
		this.editWho = editWho;
	}

	public String getTrafficCop() {
		return this.trafficCop;
	}

	public void setTrafficCop(String trafficCop) {
		this.trafficCop = trafficCop;
	}

	public String getDeviceProfileLogKey() {
		return this.deviceProfileLogKey;
	}

	public void setDeviceProfileLogKey(String deviceProfileLogKey) {
		this.deviceProfileLogKey = deviceProfileLogKey;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStorerKey() {
		return this.storerKey;
	}

	public void setStorerKey(String storerKey) {
		this.storerKey = storerKey;
	}

	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getLogicalPos() {
		return this.logicalPos;
	}

	public void setLogicalPos(String logicalPos) {
		this.logicalPos = logicalPos;
	}

	public String getLogicalName() {
		return this.logicalName;
	}

	public void setLogicalName(String logicalName) {
		this.logicalName = logicalName;
	}

}
