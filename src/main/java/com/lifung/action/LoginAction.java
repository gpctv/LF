package com.lifung.action;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts.action.ActionServlet;
import org.apache.struts2.ServletActionContext;

import com.lifung.bean.UserBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
public class LoginAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	private String result;
	private UserBean userBean;
    private String actionName;	

	public String getActionName() {
		return actionName;
	}



	public void setActionName(String actionName) {
		this.actionName = actionName;
	}



	public UserBean getUserBean() {
		return userBean;
	}



	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return "success";
	 
		
	}
	
	public String login() {
		if(null!=userBean) {
		if("admin".equals(userBean.getUser())&&"taoyuan4".equals(userBean.getPassword())) {
			 LOG.info("user #0", this.userBean.getUser());
			 ActionContext.getContext().getSession().put("key","123");//驗證過關 給KEY
			 Map<?, ?> session=ActionContext.getContext().getSession();
			 ActionContext.getContext().getName();
			 if(session.containsKey("actionName")) {//從interceptor 來的actionName紀錄USER成功登入後的網頁
				 setActionName(session.get("actionName").toString());//setAction name吐回給struts.xml
			 }else {
				 setActionName("index");
			 }
			 //因為成功，所以將SESSION ID 存入COOKIE
			 ServletActionContext.getResponse().addCookie(new Cookie("key1", ServletActionContext.getRequest().getSession().getId()));
				return "success";
		}else {
			return "input";
		}
		
		}
		return "input";
	}
	
}
