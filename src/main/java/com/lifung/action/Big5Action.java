package com.lifung.action;

import com.opensymphony.xwork2.ActionSupport;

public class Big5Action extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String big5Text;
	private String result;
	private String resultMsg;
	

	
	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
	public String getBig5Text() {
		return big5Text;
	}

	public void setBig5Text(String big5Text) {
		this.big5Text = big5Text;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String translate() {
		try {
		 byte[] big5 = this.big5Text.getBytes("ISO-8859-1");
		 this.result= new String(big5 ,"Big5");
		 this.resultMsg="success";
		}catch(Exception e) {
			LOG.error("translate #0", e);
			 
		}
		return "success";
	}
}
