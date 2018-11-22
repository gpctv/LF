package com.lifung.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.lifung.api.ENVApi;
import com.lifung.bo.FacilityBO;
import com.lifung.dao.Facility;
import com.opensymphony.xwork2.ActionSupport;

public class TCatEdiAction  extends ActionSupport{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String USER_AGENT = "Mozilla/5.0";
	private String address;
	private String result1;
	private FacilityBO facilityBO;
	private List<Facility> facilityList;
	private String facilityZip;
	private String areaZip;
	private String result2;
 
	
	final private String url="http://172.23.8.215:8800/";
    final private String uatUrl="http://172.22.16.70:8800/" ;
	 
	public String getResult2() {
		return result2;
	}

	public void setResult2(String result2) {
		this.result2 = result2;
	}

	public String getFacilityZip() {
		return facilityZip;
	}

	public void setFacilityZip(String facilityZip) {
		this.facilityZip = facilityZip;
	}

	public String getAreaZip() {
		return areaZip;
	}

	public void setAreaZip(String areaZip) {
		this.areaZip = areaZip;
	}

	@JSON(name="facilityList")
	public List<Facility> getFacilityList() {
		return facilityList;
	}

	public void setFacilityList(List<Facility> facilityList) {
		this.facilityList = facilityList;
	}

	public FacilityBO getFacilityBO() {
		return facilityBO;
	}

	public void setFacilityBO(FacilityBO facilityBO) {
		this.facilityBO = facilityBO;
	}

	@JSON(name="result")
      public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
     public String execute() throws Exception {
	// TODO Auto-generated method stub
		 
	      return "success";
        }
	
	
	public  String queryFacility(){
		this.facilityList=  this.facilityBO.queryFacilityList();
		return "success";
	}
      
      public   String sendGet() {
    	   
    	  try {
    		 
    		  String encodedURL = URLEncoder.encode(this.address, "UTF-8");
			this.result1=address(condition()+"egs?cmd=query_suda7_dash&address_1="+encodedURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("error #0", e);
		}
    		return "success";
  	}
      
      public String sendAreaCode() {
    	  try {
    		 
			this.result2=address(condition()+"egs?cmd=query_distance&suda5_senderpostcode_1="+this.facilityZip+"&suda5_customerpostcode_1="+this.areaZip+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("error #0", e);
		}
    		return "success";
      }
      
     
      private String address(String url) throws Exception{
    	  
    		URL obj = new URL(url);
    		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    		// optional default is GET
    		con.setRequestMethod("GET");

    		//add request header
    		con.setRequestProperty("User-Agent", USER_AGENT);

    		int responseCode = con.getResponseCode();
    		System.out.println("\nSending 'GET' request to URL : " + url);
    		System.out.println("Response Code : " + responseCode);

    		BufferedReader in = new BufferedReader(
    		        new InputStreamReader(con.getInputStream()));
    		String inputLine;
    		StringBuffer response = new StringBuffer();

    		while ((inputLine = in.readLine()) != null) {
    			response.append(inputLine);
    		}
    		in.close();

    		//print result
    		System.out.println(response.toString());
    		
    	return response.toString();
      }
      
      private String condition() {
    	  ENVApi env =new ENVApi();
    	  boolean isPro=false;
    	  try {
    		  isPro=env.condition(ServletActionContext.getServletContext());
    		   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error("error #0", e);
			isPro= false;
		}
    	  
    	  if(!isPro) {
    		  return url;
    	  }else {
    		  return uatUrl;
    	  }
      }
      
   

}
