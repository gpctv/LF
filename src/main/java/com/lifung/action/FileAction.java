package com.lifung.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.lifung.bean.FileBean;
import com.lifung.bean.PageBean;
import com.lifung.bo.FileBO;
import com.lifung.dao.ItfConfig;
import com.opensymphony.xwork2.ActionSupport;

public class FileAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileBO fileBO;
	private String storerkey;
	private List<ItfConfig> itfConfigList;
	private int offset;
	private int limit;
	private List<FileBean> fileBeanList;
	 
	private int total; 
	 
	private FileBean fileBean;
	 
	
	

	public FileBean getFileBean() {
		return fileBean;
	}

	public void setFileBean(FileBean fileBean) {
		this.fileBean = fileBean;
	}

	 
 

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

 
 
	@JSON(name="rows")
	public List<FileBean> getFileBeanList() {
		return fileBeanList;
	}

	public void setFileBeanList(List<FileBean> fileBeanList) {
		this.fileBeanList = fileBeanList;
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

	public List<ItfConfig> getItfConfigList() {
		return itfConfigList;
	}

	public void setItfConfigList(List<ItfConfig> itfConfigList) {
		this.itfConfigList = itfConfigList;
	}

	public String getStorerkey() {
		return storerkey;
	}

	public void setStorerkey(String storerkey) {
		this.storerkey = storerkey;
	}

	 

	public FileBO getFileBO() {
		return fileBO;
	}

	public void setFileBO(FileBO fileBO) {
		this.fileBO = fileBO;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		clientIp();
		return "success";
	}
	
	public String queryStorerKey() {
		try {
		 this.itfConfigList=this.fileBO.queryItConfig(this.storerkey);
			
		}catch(Exception e) {
			LOG.info("queryStorerkey: #0", e);
		}
		return "success";
	}
	
	public String queryFileTable() {
		try {
			clientIp();
			LOG.info("query #0", this.fileBean.getType()); 
			LOG.info("query file #0", fileBean.getAdddate());
			PageBean page=new PageBean();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
			if("E".equals(fileBean.getType())) {
			
			page.setLimit(this.limit);
			page.setOffset(this.offset);
			 
			if("".equals(fileBean.getAdddate())||null==fileBean.getAdddate()) {
				fileBean.setAdddate(sdf.format(Calendar.getInstance().getTime()));
			}else {
				fileBean.setAdddate( sdf.format(sdf2.parse(fileBean.getAdddate())));
			}
			
			if(!"".equals(fileBean.getDatastream())&&null!=fileBean.getDatastream()) {
				this.fileBeanList=this.fileBO.queryOut(this.fileBean, page );
				this.total=this.fileBO.queryOutSize(this.fileBean );
			}
			}else {
				page.setLimit(this.limit);
				page.setOffset(this.offset);
				
				if("".equals(this.fileBean.getAdddate())||null==this.fileBean.getAdddate()) {
					this.fileBean.setAdddate(sdf.format(Calendar.getInstance().getTime()))  ;
				}else {
					this.fileBean.setAdddate(sdf.format(sdf2.parse(this.fileBean.getAdddate())));
				}
				if(!"".equals(this.fileBean.getDatastream())&& null!=this.fileBean.getDatastream()) {
					this.fileBeanList=this.fileBO.queryIn(this.fileBean, page );
					this.total=this.fileBO.queryInSize(this.fileBean  );
				}
			}
		  
		}catch(Exception e) {
			LOG.info("#0","queryFileTable--"+ e);
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
