package com.lifung.bean;

public class Times {

	private String time1;
	private String time2;
	public String getTime1() {
		return time1;
	}
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	public String getTime2() {
		return time2;
	}
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	
	public void isNoon(String times) {
		if("noon".equals(times)) {
			setTime1("12:00:00");
			setTime2("23:59:59");
			
		}else {
			setTime1("00:00:00");
			setTime2("12:00:00");
		}
	}
	
}
