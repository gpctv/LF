package com.lifung.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.lifung.bean.PageBean;
import com.lifung.bo.PmaBO;
import com.lifung.dao.PmaRtnQty;
import com.opensymphony.xwork2.ActionSupport;

public class PmaRtnQtyAction extends ActionSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int offset;
	private int limit;
	private PmaBO pmaBo;
	private PmaRtnQty pmaRtnQty;
	private List<PmaRtnQty> pmaTable;
	private int total;
	private String valid;
	private String carrierReference;
	private String qty;
	
	
	
	 
	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getCarrierReference() {
		return carrierReference;
	}

	public void setCarrierReference(String carrierReference) {
		this.carrierReference = carrierReference;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@JSON(name="rows")
public List<PmaRtnQty> getPmaTable() {
		return pmaTable;
	}

	public void setPmaTable(List<PmaRtnQty> pmaTable) {
		this.pmaTable = pmaTable;
	}

public PmaRtnQty getPmaRtnQty() {
		return pmaRtnQty;
	}

	public void setPmaRtnQty(PmaRtnQty pmaRtnQty) {
		this.pmaRtnQty = pmaRtnQty;
	}

public PmaBO getPmaBo() {
		return pmaBo;
	}

	public void setPmaBo(PmaBO pmaBo) {
		this.pmaBo = pmaBo;
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

@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	return "success";
}

public String queryTable() {
	try {
	 LOG.info("#0", this.pmaRtnQty.getCarrierReference());
	 PageBean page=new PageBean();
	 page.setLimit(this.limit);
	 page.setOffset(this.offset);
	 this.total=this.pmaBo.querySize(this.pmaRtnQty.getCarrierReference());
	 this.pmaTable=this.pmaBo.queryTable(this.pmaRtnQty.getCarrierReference(), page);
	}catch(Exception e) {
		LOG.error("query table error :#0",e);
	}
	return "success";
}

public String insertTable() {
	try {
		 LOG.info("#0", this.pmaRtnQty.getCarrierReference());
		clientIp();
		PmaRtnQty pmartnqty=new PmaRtnQty();
		pmartnqty.setCarrierReference(this.pmaRtnQty.getCarrierReference());
		pmartnqty.setCreateDateTime(new Date());
		pmartnqty.setIpAddress(clientIp());
		pmartnqty.setQtyExpected(Long.valueOf(this.pmaRtnQty.getQtyExpected()));
		 
		this.pmaBo.insertTable(pmartnqty);
	}catch(Exception e) {
		LOG.error("insert table error :#0",e);
	}
	return "success";
}

public String modifyTable() {
	try {
		clientIp();
		PmaRtnQty pmartnqty=new PmaRtnQty();
		pmartnqty.setCarrierReference(carrierReference.trim());
		pmartnqty.setCreateDateTime(new Date());
		pmartnqty.setIpAddress(clientIp());
		pmartnqty.setQtyExpected(Long.valueOf(this.qty.trim()));
		 
		this.pmaBo.modifyTable(pmartnqty);
	}catch(Exception e) {
		LOG.error("modify table error :#0", e);
	}
	return "success";
}


public String deleteTable() {
	try {
		clientIp();
		PmaRtnQty pmartnqty=new PmaRtnQty();
		pmartnqty.setCarrierReference(carrierReference.trim());
		 
		 
		this.pmaBo.deleteTable(pmartnqty);
	}catch(Exception e) {
		LOG.error("modify table error :#0", e);
	}
	return "success";
}

public String isExist() {
	try {
	this.valid=	this.pmaBo.isExist(this.carrierReference.trim());
	}catch(Exception e) {
		LOG.error("isExist table error :#0",e);
	}
	return "success";
}

private String clientIp() {
	String ipAddress="";
	HttpServletRequest httpServletRequest =  ServletActionContext.getRequest();;
	String userIpaddress=httpServletRequest.getHeader("X-Forwarded-For");
	if(null ==userIpaddress || "".equals(userIpaddress)) {
		ipAddress = httpServletRequest.getRemoteAddr();
		}
	LOG.info("ip address: #0", ipAddress);
	return ipAddress;
}

}
