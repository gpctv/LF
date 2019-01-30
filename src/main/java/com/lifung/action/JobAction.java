package com.lifung.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.lifung.bean.SysJobsBean;
import com.lifung.bo.JobBO;
import com.opensymphony.xwork2.ActionSupport;

public class JobAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String jobName;
	private List<SysJobsBean> jobList;
	private JobBO jobBO;
	private String isEnable;
	
	
	
	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public List<SysJobsBean> getJobList() {
		return jobList;
	}
	@JSON(name="table")
	public void setJobList(List<SysJobsBean> jobList) {
		this.jobList = jobList;
	}

	public JobBO getJobBO() {
		return jobBO;
	}

	public void setJobBO(JobBO jobBO) {
		this.jobBO = jobBO;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
	public String queryJobList(){
		try {
		this.jobList=jobBO.queryJob(this.jobName);
		}catch(Exception e) {
			LOG.error("Job action queryJobList #0", e);
		}
		return "success";
	}
	
	public String updateJob() {
		this.jobBO.execJob(this.jobName);
		return "success";
	}
	
	public String turnJob() {
		this.jobBO.execEnable(this.jobName,this.isEnable);
		return "success";
	}

}
