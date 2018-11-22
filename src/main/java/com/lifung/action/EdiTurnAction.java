package com.lifung.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.lifung.bo.EdiBo;
import com.lifung.dao.ItfConfig2;
import com.opensymphony.xwork2.ActionSupport;

public class EdiTurnAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> storer;
	private EdiBo ediBo;
	private String storerKey;
	private List<ItfConfig2> table;
	private List<String> ediStorer;
	private int total;
	
	
	public List<String> getEdiStorer() {
		return ediStorer;
	}

	public void setEdiStorer(List<String> ediStorer) {
		this.ediStorer = ediStorer;
	}

	@JSON(name="total")
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
	public List<ItfConfig2> getTable() {
		return table;
	}

	public void setTable(List<ItfConfig2> table) {
		this.table = table;
	}

	public void setStorerKey(String storerKey) {
		this.storerKey = storerKey;
	}

	public void setEdiBo(EdiBo ediBo) {
		this.ediBo = ediBo;
	}

	@JSON(name="storer")
	public List<String> getStorer() {
		return storer;
	}

	public void setStorer(List<String> storer) {
		this.storer = storer;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return "success";
	}
	
	public String queryStorer() {
	 
		 this.storer= this.ediBo.getStorer();
		return "success";
	}
	public String queryEdiStorer() {
		this.ediStorer=this.ediBo.getEdiStorer();
		return "success";
	}
	
	public String queryDataTable() {
		List<Object[]> table=ediBo.getTable(this.storerKey);
		this.table=new ArrayList<ItfConfig2>();
		for(Object config2[]:table) {
			ItfConfig2 itconfig2=new ItfConfig2(); 
			itconfig2.setDatastream(config2[0].toString());
			itconfig2.setType(config2[1].toString());
			itconfig2.setDescr(config2[2].toString());
			itconfig2.setPostingSP(config2[3].toString());
			itconfig2.setActiveflag(config2[4].toString());
			itconfig2.setStorerkey(config2[5].toString());
			itconfig2.setWatcherConfigKey(config2[6].toString());
			this.table.add(itconfig2);
		}
		 
		 this.total=table.size();
	 
		return "success";
	}
	
	public String updateWatcherActiveflag() {
	  LOG.info("test  #0 ", this.table.get(0).getActiveflag());
	  this.ediBo.updateItfgtwatcherconfig(table);
	  List<Object[]> table=ediBo.getTable(this.storerKey);
		this.table=new ArrayList<ItfConfig2>();
		for(Object config2[]:table) {
			ItfConfig2 itconfig2=new ItfConfig2(); 
			itconfig2.setDatastream(config2[0].toString());
			itconfig2.setType(config2[1].toString());
			itconfig2.setDescr(config2[2].toString());
			itconfig2.setPostingSP(config2[3].toString());
			itconfig2.setActiveflag(config2[4].toString());
			itconfig2.setStorerkey(config2[5].toString());
			itconfig2.setWatcherConfigKey(config2[6].toString());
			this.table.add(itconfig2);
		}
		 
		 this.total=table.size();
	  return "success"; 
	}

}
