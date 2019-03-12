package com.lifung.qsv.action;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class NineOne extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ipAddress;
	 

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		clientIp();
				return "SUCCESS";
	}
	
	public String clientIpGet() {
		 clientIp();
 
		return "success";
	}
	
	public void clientIp() {
		HttpServletRequest httpServletRequest =  ServletActionContext.getRequest();;
		String userIpaddress=httpServletRequest.getHeader("X-Forwarded-For");
		if(null ==userIpaddress || "".equals(userIpaddress)) {
			ipAddress = httpServletRequest.getRemoteAddr();
			}
		LOG.info("ip address: #0", ipAddress);
	}
	
	  private static class DefaultTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			// TODO Auto-generated method stub
			
		}

		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
			// TODO Auto-generated method stub
			
		}

		public X509Certificate[] getAcceptedIssuers() {
			// TODO Auto-generated method stub
			return null;
		}

	       

	    }
}
