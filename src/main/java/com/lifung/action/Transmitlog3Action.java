package com.lifung.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.lifung.bean.PageBean;
import com.lifung.bo.StorerBO;
import com.lifung.bo.Transmitlog3BO;
import com.lifung.dao.Transmitlog3;
import com.opensymphony.xwork2.ActionSupport;

public class Transmitlog3Action extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private   List<String> storer;
	private String storerkey;
	private List<Transmitlog3> transmitlog3List;
	private Transmitlog3BO transmitlog3BO;
	private StorerBO storerBO;
	private int total;
	private String key1;
	private int offset;
	private int limit;
	private Transmitlog3 transmitlog3;
	
	 
	
	

	public Transmitlog3 getTransmitlog3() {
		return transmitlog3;
	}



	public void setTransmitlog3(Transmitlog3 transmitlog3) {
		this.transmitlog3 = transmitlog3;
	}


 

	public int getLimit() {
		return limit;
	}



	public void setLimit(int limit) {
		this.limit = limit;
	}



	public int getOffset() {
		return offset;
	}



	public void setOffset(int offset) {
		this.offset = offset;
	}



	public String getKey1() {
		return key1;
	}



	public void setKey1(String key1) {
		this.key1 = key1;
	}



	public String getStorerkey() {
		return storerkey;
	}



	public void setStorerkey(String storerkey) {
		this.storerkey = storerkey;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public StorerBO getStorerBO() {
		return storerBO;
	}



	public void setStorerBO(StorerBO storerBO) {
		this.storerBO = storerBO;
	}


@JSON
	public List<String> getStorer() {
		return storer;
	}



	public void setStorer(List<String> storer) {
		this.storer = storer;
	}


	@JSON(name="rows")
	public List<Transmitlog3> getTransmitlog3List() {
		return transmitlog3List;
	}



	public void setTransmitlog3List(List<Transmitlog3> transmitlog3) {
		this.transmitlog3List = transmitlog3;
	}



	public Transmitlog3BO getTransmitlog3BO() {
		return transmitlog3BO;
	}



	public void setTransmitlog3BO(Transmitlog3BO transmitlog3bo) {
		transmitlog3BO = transmitlog3bo;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		clientIp();
		return "success";
	}
	
	public String queryStorer() {
		storer();
		return "success";
	}
	
	public String queryTransmitlog3() {
		clientIp();
		LOG.debug("test:#0", String.valueOf(this.offset));
		if(!"".equals(this.storerkey) && null!=this.storerkey) {
	    PageBean page=new PageBean();
	    page.setLimit(this.limit);
	    page.setOffset(this.offset);
	   if(key1==null) {
		   key1="";
	   }
		this.transmitlog3List=this.transmitlog3BO.queryTransmitlog3(this.storerkey, key1,page);
		this.total=this.transmitlog3BO.queryTransmitlog3Size(this.storerkey, key1);
		}
		return "success";
	}
	
	public String updateTransmitlog3() {
		clientIp();
		 if(!"".equals(this.transmitlog3.getTransmitlogkey())&& null!=this.transmitlog3.getTransmitlogkey()) {
			
			this.transmitlog3BO.updateTransmitlog3(transmitlog3);
			queryTransmitlog3();
		 }
		 return "success";
	}
	
	private void storer() {
		try {
		this.storer=storerBO.getStorer();
		}catch(Exception e) {
			LOG.error("error #0", e);
		}
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
