package com.lifung.qsv.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class NineOne extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ipAddress;
	 

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		clientIp();
				return "SUCCESS";
	}
	
	public void clientIp() {
		HttpServletRequest httpServletRequest =  ServletActionContext.getRequest();;
		String userIpaddress=httpServletRequest.getHeader("X-Forwarded-For");
		if(null ==userIpaddress || "".equals(userIpaddress)) {
			ipAddress = httpServletRequest.getRemoteAddr();
			}
		LOG.info("ip address: #0", ipAddress);
	}
	
 
}
