package com.lifung.action;

import com.opensymphony.xwork2.ActionSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.lifung.bo.ForecastBO;
import com.lifung.dao.Forecast;
import com.lifung.dao.ForecastId;
public class ForecastAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private  ForecastId forecastId;
    private String storerkey;
    private ForecastBO forecastBo;
    private List<String> storerkeyList;
    private List<Forecast> forecast;
    private List<ForecastId> forecastIdList;
    private String date1;
    private String qty;
    private String valid;
    private String msg;
    

   

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	@JSON(name="table")
	public List<ForecastId> getForecastIdList() {
		return forecastIdList;
	}

	public void setForecastIdList(List<ForecastId> forecastIdList) {
		this.forecastIdList = forecastIdList;
	}

	public List<Forecast> getForecast() {
		return forecast;
	}

	public void setForecast(List<Forecast> forecast) {
		this.forecast = forecast;
	}

	public ForecastBO getForecastBo() {
		return forecastBo;
	}

	public void setForecastBo(ForecastBO forecastBo) {
		this.forecastBo = forecastBo;
	}

	public List<String> getStorerkeyList() {
		return storerkeyList;
	}

	public void setStorerkeyList(List<String> storerkeyList) {
		this.storerkeyList = storerkeyList;
	}

	public String getStorerkey() {
		return storerkey;
	}

	public void setStorerkey(String storerkey) {
		this.storerkey = storerkey;
	}

	 

	public ForecastId getForecastId() {
		return forecastId;
	}

	public void setForecastId(ForecastId forecastId) {
		this.forecastId = forecastId;
	}

	@Override
    public String execute() throws Exception {
    	// TODO Auto-generated method stub
		clientIp();
    	return super.execute();
    }
    
	public String storerkey() {
		try {
		this.storerkeyList=forecastBo.queryStorer();
		}catch(Exception e) {
			LOG.error("error storerkey #0", e);
		}
		
		return "success";
		 
	}
	
	public String queryFore(){
		try {
			clientIp();
		this.forecastIdList=this.forecastBo.queryForecast(this.storerkey);
		
		}catch(Exception e) {
			LOG.error("error queryFore #0", e);
		}
		return "success";
	}
	
 
	
	public String insertForecast() {
		try {
			clientIp();
			if(this.forecastBo.isExist(this.storerkey, this.date1)) {
				
			
			 ForecastId forecastId1=new ForecastId();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date  =sdf.parse(this.date1);
			forecastId1.setF_date(date);
			forecastId1.setQty(Long.valueOf(this.qty));
			forecastId1.setStorerkey(this.storerkey);
			
			this.forecastBo.createFore( forecastId1);
			}else {
				this.msg="error";
			}
		}catch(Exception e) {
			LOG.error("#0", e);
		}
		return "success";
	}
	
	public String deleteForecast() {
		try {
		  
			clientIp();
			this.forecastBo.deleteFore(this.date1, this.storerkey);
			
		}catch(Exception e) {
			LOG.error("#0", e);
		}
		return "success";
	}
	public String modifyForecast() {
		try {
		  
			clientIp();
			this.forecastBo.modifyFore(this.date1, this.storerkey, this.qty);
			
		}catch(Exception e) {
			LOG.error("#0", e);
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
