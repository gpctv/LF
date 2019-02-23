package com.lifung.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.lifung.bean.PageBean;
import com.lifung.bo.PrinterBO;
import com.lifung.dao.Rdtprinter;
import com.opensymphony.xwork2.ActionSupport;

public class PrinterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrinterBO printerBO;
	private int offset;
	private int limit;
	private int total;
	private String printerId;
	private Rdtprinter printer;
	private List<Rdtprinter> rdtPrinterTable;
	private String valid;
	
	 
	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getPrinterId() {
		return printerId;
	}

	public void setPrinterId(String printerId) {
		this.printerId = printerId;
	}

	@JSON(name="rows")
	public List<Rdtprinter> getRdtPrinterTable() {
		return rdtPrinterTable;
	}

	public void setRdtPrinterTable(List<Rdtprinter> rdtPrinterTable) {
		this.rdtPrinterTable = rdtPrinterTable;
	}

	public Rdtprinter getPrinter() {
		return printer;
	}

	public void setPrinter(Rdtprinter printer) {
		this.printer = printer;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

  
	public void setPrinterBO(PrinterBO printerBO) {
		this.printerBO = printerBO;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		clientIp();
		return "success";
	}
	public String queryPrinter() {
		try {
		//LOG.info("query #0", this.printer.getPrinterId());
		
		PageBean page=new PageBean();
		page.setLimit(this.limit);
		page.setOffset(this.offset);
		this.rdtPrinterTable=this.printerBO.queryPrinter(printer, page);
		this.total=this.printerBO.querySize(printer);
		
		}catch(Exception e) {
			LOG.error("queryPrinter error #0 ", e);
		}
		return "success";
	}
	
	public String isExistPrinterId() {
		try {
			this.valid=this.printerBO.isExistPrinterId(this.printerId);
			 
		}catch(Exception e) {
			LOG.error("isExistPrinterId error #0 ", e);
		}
		return "success";
	}
	 
	
	public String updatePrinter() {
		try {
		this.printerBO.updatePrinterId(printer);
		}catch(Exception e) {
			LOG.error("updatePrinter error #0", e);
		}
		return "success";
	}
	
	public String insertPrinter() {
		try {
			this.printerBO.insertPrinter(printer);
		}catch(Exception e) {
			LOG.error("insert printer error #0", e);
		}
		return "success";
	}
	
	public String deletePrinter() {
		try {
			this.printerBO.deletePrinterId(printer);
		}catch(Exception e) {
			LOG.error("delete printer error #0", e);
		}
		return "success";
	}
	
	public String isExist() {
		
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
