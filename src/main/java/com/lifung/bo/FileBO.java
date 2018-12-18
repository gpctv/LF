package com.lifung.bo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.bean.FileBean;
import com.lifung.bean.PageBean;
import com.lifung.bean.Times;
import com.lifung.dao.ItfConfig;

@Transactional
public class FileBO {
 

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<ItfConfig> queryItConfig(String storerkey){
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.ItfConfig.query");
		query.setString("storerkey", storerkey);
		List<ItfConfig> table=query.list();
		 
		return table;
		 
	}
	
	
	public List<FileBean> queryOut(FileBean filebean,PageBean page ){
		 Times timeObject=new Times();
		 timeObject.allDay();
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.OutLine.query");
		query.setString("datastream", filebean.getDatastream()); 
		query.setInteger("start", page.getStart());
		query.setInteger("end", page.getEnd());
		query.setString("time1", filebean.getAdddate()+" "+timeObject.getTime1());
		query.setString("time2",  filebean.getAdddate()+" "+timeObject.getTime2());
		query.setString("status", filebean.getStatus());
		query.setString("lineText", "%"+toDecode(filebean.getLineText())+"%");
		query.setString("lineTextUnicode", "%"+filebean.getLineTextUnicode()+"%");
		query.setString("filename", "%"+filebean.getFilename()+"%");
		List<FileBean> listFileBean=new ArrayList<FileBean>();
		List<Object[]> table=query.list();
		for(Object o[]:table) {
			FileBean fileBean=new FileBean();
			fileBean.setFileKey(o[0].toString());
			fileBean.setDatastream(o[1].toString());
			fileBean.setFilename(o[2].toString());
			fileBean.setStatus(o[3].toString());
			fileBean.setTry_(o[4].toString());
			fileBean.setAdddate(o[5].toString());
			 
				fileBean.setLineText(toBig5(o[6].toString()));
		 
			if(null!=o[7]) {
			fileBean.setErrMsg(o[7].toString());
			}else {
				fileBean.setErrMsg("");
			}
			fileBean.setLineTextUnicode(o[8].toString());
			fileBean.setRowNum(o[9].toString());
			listFileBean.add(fileBean);
		}
		return listFileBean;
	}
	
	public int queryOutSize(FileBean filebean ) {
		 Times timeObject=new Times();
		 timeObject.allDay();
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.OutLine.querySize");
		query.setString("datastream", filebean.getDatastream()); 
		query.setString("time1", filebean.getAdddate()+" "+timeObject.getTime1());
		query.setString("time2", filebean.getAdddate()+" "+timeObject.getTime2());
		query.setString("status", filebean.getStatus());
		query.setString("lineText", "%"+toDecode(filebean.getLineText())+"%");
		query.setString("lineTextUnicode", "%"+filebean.getLineTextUnicode()+"%");
		query.setString("filename", "%"+filebean.getFilename()+"%");
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		return size ;
	}
	
	public List<FileBean> queryIn(FileBean filebean,PageBean page  ){
		 Times timeObject=new Times();
		 timeObject.allDay();
		
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.InLine.query");
		query.setString("datastream", filebean.getDatastream()); 
		query.setInteger("start", page.getStart());
		query.setInteger("end", page.getEnd());
		query.setString("time1", filebean.getAdddate()+" "+timeObject.getTime1());
		query.setString("time2",  filebean.getAdddate()+" "+timeObject.getTime2());
		query.setString("status",  filebean.getStatus());
		query.setString("lineText", "%"+toDecode(filebean.getLineText())+"%");
		query.setString("lineTextUnicode", "%"+filebean.getLineTextUnicode()+"%");
		query.setString("filename", "%"+filebean.getFilename()+"%");
		List<FileBean> listFileBean=new ArrayList<FileBean>();
		List<Object[]> table=query.list();
		for(Object o[]:table) {
			FileBean fileBean=new FileBean();
			fileBean.setFileKey(o[0].toString());
			fileBean.setDatastream(o[1].toString());
			fileBean.setFilename(o[2].toString());
			fileBean.setStatus(o[3].toString());
			fileBean.setTry_(o[4].toString());
			fileBean.setAdddate(o[5].toString());
			 
				fileBean.setLineText(toBig5(o[6].toString()));
			 
			
			if(null!=o[7]) {
			fileBean.setErrMsg(o[7].toString());
			}else {
				fileBean.setErrMsg("");
			}
			fileBean.setLineTextUnicode(o[8].toString());
			fileBean.setRowNum(o[9].toString());
			listFileBean.add(fileBean);
		}
		return listFileBean;
	}
	
	public int queryInSize(FileBean filebean ) {
		 Times timeObject=new Times();
		 timeObject.allDay();
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.InLine.querySize");
		query.setString("datastream", filebean.getDatastream()); 
		query.setString("time1", filebean.getAdddate()+" "+timeObject.getTime1());
		query.setString("time2", filebean.getAdddate()+" "+timeObject.getTime2());
		query.setString("status", filebean.getStatus());
		query.setString("lineText", "%"+toDecode(filebean.getLineText())+"%");
		query.setString("lineTextUnicode", "%"+filebean.getLineTextUnicode()+"%");
		query.setString("filename", "%"+filebean.getFilename()+"%");
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		return size ;
	}
	
	private String toBig5(String text) {
		try {
		 byte[] big5 = text.getBytes("ISO-8859-1");
		 text = new String(big5 ,"Big5");
		 return text;
		}catch(Exception e) {
			return text;
		}
	}
	
	private String toDecode(String text) {
		try {
			 byte[] big5 = text.getBytes("Big5");
			 text = new String(big5 ,"ISO-8859-1");
			 return text;
		}catch(Exception e) {
			return text;
		}
	}
	 
}
