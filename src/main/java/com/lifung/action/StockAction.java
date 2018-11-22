package com.lifung.action;

import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.lifung.bo.StockBO;
import com.opensymphony.xwork2.ActionSupport;

public class StockAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StockBO stockBO;
	private String storerkey;
	private int locInsert;
	private int skuInsert;
	private int packInsert;
	private int stockInsert;
	private String sku;
	private String msg;
	private String facility;
	
	
	
public int getLocInsert() {
		return locInsert;
	}

	public void setLocInsert(int locInsert) {
		this.locInsert = locInsert;
	}

public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

public int getSkuInsert() {
		return skuInsert;
	}

	public void setSkuInsert(int skuInsert) {
		this.skuInsert = skuInsert;
	}

	public int getPackInsert() {
		return packInsert;
	}

	public void setPackInsert(int packInsert) {
		this.packInsert = packInsert;
	}

	public int getStockInsert() {
		return stockInsert;
	}

	public void setStockInsert(int stockInsert) {
		this.stockInsert = stockInsert;
	}

public String getStorerkey() {
		return storerkey;
	}

	public void setStorerkey(String storerkey) {
		this.storerkey = storerkey;
	}

public StockBO getStockBO() {
		return stockBO;
	}

	public void setStockBO(StockBO stockBO) {
		this.stockBO = stockBO;
	}

@Override
public String execute()   {
	// TODO Auto-generated method stub
	try {
		if(stockBO.condition(ServletActionContext.getServletContext())) {
			return "success";
		}else {
			return "error";
		}
	
	}catch(Exception e) {
		LOG.error("execut exception #0", e);
		return "error";
	}
	
}	

public String insertSKU() {
    this.skuInsert=0;
	if(null != this.storerkey && (!"".equals(this.storerkey.trim()))) {
	int i=this.stockBO.insertSKU(this.storerkey);
	this.skuInsert=i;
	LOG.info("#0", String.valueOf(i));
	LOG.info("#0", "insert sku success");
	}
	return "success";
	
}

public String insertPACK() {
	this.packInsert=0;
	if(null != this.storerkey && (!"".equals(this.storerkey.trim()))) {
		int i=this.stockBO.insertPACK(this.storerkey);
		this.packInsert=i;
		LOG.info("#0", String.valueOf(i));
		LOG.info("#0", "insert Pack success");
		}
	return "success";
}

public String insertTempStock() {
	this.stockInsert=0;
	if(this.validation(this.sku)) {
	if(null != this.storerkey && (!"".equals(this.storerkey.trim()))) {
		int i=this.stockBO.insertTempStock(storerkey,this.sku);
		this.stockInsert=i;
		LOG.info("#0", String.valueOf(i));
		LOG.info("#0", "insert tempStock success");
		}
	this.msg="success";
	}else {
		this.msg="error";
	}
	return "success";
}
public String calcualteNSP() {
	if(null != this.storerkey && (!"".equals(this.storerkey.trim()))) {
		int i=this.stockBO.execNSP();
		LOG.info("#0", String.valueOf(i));
		LOG.info("#0", "calculateNSP success");
		}
	return "success";
}

public String insertLOC() {
	this.locInsert=0;
	if(null != this.facility && (!"".equals(this.facility.trim()))) {
		int i=this.stockBO.insertLOC  (this.facility);
		this.locInsert=i;
		LOG.info("#0", String.valueOf(i));
		LOG.info("#0", "insert LOC success");
		this.msg="success";
		}
	return "success";
}

private boolean validation(String sku) {
	Pattern pattern = Pattern.compile("[\\d\\w-]");
	if("".equals(sku.trim())) {
		return true;
	}else {
	if(pattern.matcher(sku).find()) {
		return true;
	}else {
		return false;
	}
	}
}
}
