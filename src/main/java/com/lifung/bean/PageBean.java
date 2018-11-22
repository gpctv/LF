package com.lifung.bean;

public class PageBean {

	private int limit;
	private int offset;
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
	
	public int getStart() {
		return  offset+1 ;
	}
	public int getEnd() {
		int endRow=Integer.valueOf(limit)+Integer.valueOf(offset);
		return  endRow ;
	}
	
}
