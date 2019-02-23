package com.lifung.bo;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.lifung.bean.PageBean;
import com.lifung.dao.Rdtprinter;
import com.lifung.dao.RdtprinterDAO;

@Transactional
public class PrinterBO {
	private SessionFactory sessionFactory;
	private RdtprinterDAO rdtprinterDAO;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public RdtprinterDAO getRdtprinterDAO() {
		return rdtprinterDAO;
	}
	public void setRdtprinterDAO(RdtprinterDAO rdtprinterDAO) {
		this.rdtprinterDAO = rdtprinterDAO;
	}
 
	public List<Rdtprinter> queryPrinter(Rdtprinter printer,PageBean page ) {
		if(null==printer.getPrinterId()) {
			printer.setPrinterId("");
		}
		if(null==printer.getDescription()) {
			printer.setDescription("");
		}
		if(null==printer.getWinPrinter()) {
			printer.setWinPrinter("");
		}
		
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Rdtprinter.query");
		query.setString("printerId", "%"+printer.getPrinterId()+"%");
		query.setString("ipaddress", "%"+printer.getDescription()+"%");
		query.setString("printerName", "%"+printer.getWinPrinter()+"%");
		query.setInteger("start", page.getStart());
		query.setInteger("end", page.getEnd());
		List<Rdtprinter> printerList=query.list();
		return printerList;
	}
	
	public int querySize(Rdtprinter printer) {
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Rdtprinter.querySize");
		query.setString("printerId", "%"+printer.getPrinterId()+"%");
		query.setString("ipaddress", "%"+printer.getDescription()+"%");
		query.setString("printerName", "%"+printer.getWinPrinter()+"%");
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		 return size;
	}
	
	public int insertPrinter(Rdtprinter printer) {
		Query query =this.sessionFactory.getCurrentSession().createSQLQuery(insertPrinterSQL());
		query.setString("printerId", printer.getPrinterId());
		query.setString("description", printer.getDescription());
		query.setString("winprinter", printer.getWinPrinter());
		query.setString("printerGroup", printer.getPrinterGroup());
		int i=query.executeUpdate();
		  return i;
	}
	
	public String isExistPrinterId(String printerId) {
		Query query =this.sessionFactory.getCurrentSession().getNamedQuery("com.lifung.dao.Rdtprinter.isExist");
		query.setString("printerId",  printerId ); 
		 Integer size=Integer.valueOf(query.list().get(0).toString());
		 if(size>0) {
			 return "false";
		 }else {
			 return "true";
		 }
		 
	}
	public void updatePrinterId(Rdtprinter printer) {
		PageBean page=new PageBean();
		page.setLimit(1);
		page.setOffset(0);
		Rdtprinter oringPrinter=new Rdtprinter();
		oringPrinter.setPrinterId(printer.getPrinterId());
		List<Rdtprinter> printerList=queryPrinter(oringPrinter,page);
		
		printer.setAddWho(printerList.get(0).getAddWho());
		printer.setAddDate(printerList.get(0).getAddDate());
		printer.setEditWho("robot");
		printer.setEditDate(new Date());
		 
		this.rdtprinterDAO.merge(printer);
	}
	public void deletePrinterId(Rdtprinter printer) {
		this.rdtprinterDAO.delete(printer);
	}
	private  String insertPrinterSQL() {
		String sqlCmd="insert into rdt.rdtprinter(printerId,description,winprinter,printerGroup,addwho ,editwho,adddate) "+
	"values(:printerId,:description,:winprinter,:printerGroup,'robot','robot',getDate())";
		
		return sqlCmd;
	}
	
	 
}
