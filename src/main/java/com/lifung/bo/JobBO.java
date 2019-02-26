package com.lifung.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.bean.SysJobsBean;

@Transactional
public class JobBO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public ArrayList<SysJobsBean> queryJobList(String jobName){
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(queryJobListString());
		query.setString("jobName", jobName.trim());
		List<Object[]> rows = query.list();
		ArrayList<SysJobsBean> sysJobList = new ArrayList<SysJobsBean>();

		for (Object[] row : rows) {
			SysJobsBean sysJob = new SysJobsBean();
			sysJob.setDescription(null == row[2] ? "" : row[2].toString());
			sysJob.setEnabled(row[1].toString());
			sysJob.setName(row[0].toString());
			sysJobList.add(sysJob);
		}
		return sysJobList;
	}

	public ArrayList<SysJobsBean> queryJob(String jobName) {
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(queryJobString());
		query.setString("jobName", jobName.trim());
		List<Object[]> rows = query.list();
		ArrayList<SysJobsBean> sysJobList = new ArrayList<SysJobsBean>();

		for (Object[] row : rows) {
			SysJobsBean sysJob = new SysJobsBean();
			sysJob.setDescription(null == row[2] ? "" : row[2].toString());
			sysJob.setEnabled(row[1].toString());
			sysJob.setName(row[0].toString());
			sysJobList.add(sysJob);
		}
		return sysJobList;
	}

	public String execJob(String jobName) {
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(execJobString());
		query.setString("jobName", jobName);
		int i = query.executeUpdate();
		return String.valueOf(i);
	}

	public String execEnable(String jobName,String isEnable) {
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(execJobEnableString());
		query.setString("jobName", jobName);
		query.setString("isEnable", isEnable);
		int i = query.executeUpdate();
		return String.valueOf(i);
	}
	
	private String queryJobListString() {
		String str = "Select name, enabled ,description " + " from msdb.dbo.sysjobs_view where name like :jobName+'%'"
				+ " order by name";
		return str;
	}

	private String queryJobString() {
		String str = "Select name, enabled ,description " + " from msdb.dbo.sysjobs_view where name like :jobName "
				+ " order by name";
		return str;
	}

	private String execJobString() {
		String str = "EXEC msdb.dbo.sp_start_job :jobName ";
		return str;
	}

	private String execJobEnableString() {
		String str = "EXEC msdb.dbo.sp_update_job  @enabled=:isEnable , @job_name=:jobName";
		return str;
	}

}
