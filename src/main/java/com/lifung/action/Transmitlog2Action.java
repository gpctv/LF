package com.lifung.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.lifung.bean.PageBean;
import com.lifung.bo.StorerBO;
import com.lifung.bo.Transmitlog2BO;
import com.lifung.bo.Transmitlog3BO;
import com.lifung.dao.Transmitlog2;
import com.lifung.dao.Transmitlog3;
import com.opensymphony.xwork2.ActionSupport;

public class Transmitlog2Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private   List<String> storer;
	private String storerkey;
	private List<Transmitlog2> transmitlog2List;
	private Transmitlog2BO transmitlog2BO;
	private StorerBO storerBO;
	private int total;
	private String key1;
	private int offset;
	private int limit;
	private Transmitlog2 transmitlog2;
	@JSON
	public List<String> getStorer() {
		return storer;
	}
	public void setStorer(List<String> storer) {
		this.storer = storer;
	}
	public String getStorerkey() {
		return storerkey;
	}
	public void setStorerkey(String storerkey) {
		this.storerkey = storerkey;
	}
	@JSON(name="rows")
	public List<Transmitlog2> getTransmitlog2List() {
		return transmitlog2List;
	}
	public void setTransmitlog2List(List<Transmitlog2> transmitlog2List) {
		this.transmitlog2List = transmitlog2List;
	}
	public Transmitlog2BO getTransmitlog2BO() {
		return transmitlog2BO;
	}
	public void setTransmitlog2BO(Transmitlog2BO transmitlog2bo) {
		transmitlog2BO = transmitlog2bo;
	}
	public StorerBO getStorerBO() {
		return storerBO;
	}
	public void setStorerBO(StorerBO storerBO) {
		this.storerBO = storerBO;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Transmitlog2 getTransmitlog2() {
		return transmitlog2;
	}
	public void setTransmitlog2(Transmitlog2 transmitlog2) {
		this.transmitlog2 = transmitlog2;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		clientIp();
		return "success";
	}
	public String queryTransmitlog2() {
		clientIp();
		LOG.debug("test:#0", String.valueOf(this.offset));
		if(!"".equals(this.storerkey) && null!=this.storerkey) {
	    PageBean page=new PageBean();
	    page.setLimit(this.limit);
	    page.setOffset(this.offset);
	   if(key1==null) {
		   key1="";
	   }
		this.transmitlog2List=this.transmitlog2BO.queryTransmitlog2(this.storerkey, key1,page);
		this.total=this.transmitlog2BO.queryTransmitlog2Size(this.storerkey, key1);
		}
		return "success";
	}

	public String updateTransmitlog2() {
		clientIp();
		 if(!"".equals(this.transmitlog2.getTransmitlogkey())&& null!=this.transmitlog2.getTransmitlogkey()) {
			
			this.transmitlog2BO.updateTransmitlog2(transmitlog2);
			queryTransmitlog2();
		 }
		 return "success";
	}
	private void clientIp() {
		String ipAddress="";
		HttpServletRequest httpServletRequest =  ServletActionContext.getRequest();;
		String userIpaddress=httpServletRequest.getHeader("X-Forwarded-For");
		if(null ==userIpaddress || "".equals(userIpaddress)) {
			ipAddress = httpServletRequest.getRemoteAddr();
			}
		LOG.info("ip address: #0", ipAddress);
	}

}
