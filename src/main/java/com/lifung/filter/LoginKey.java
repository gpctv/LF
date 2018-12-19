package com.lifung.filter;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

public class LoginKey extends AbstractInterceptor {
   

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Logger LOG=LoggerFactory.getLogger(LoginKey.class);
		
		 Map<String, Object> session = ActionContext.getContext().getSession();
		 //抓USER ActionName
		 session.put("actionName", invocation.getProxy().getActionName());
		 LOG.info("LoginKey #0", getCookie());  
		 //如果有COOKIE 比對是否跟目前SESSION一樣(關掉瀏覽器，或清除COOKIE需重新登入) 
		 if(getCookie().equals(ServletActionContext.getRequest().getSession().getId())) {
			 //如果一樣，比對是否有拿到KEY
		 if( !session.isEmpty()&&session.containsKey("key")&&"123".equals(session.get("key").toString())) { 
			 return invocation.invoke();
		 }else {
			 return "input";
		 }
		 }else {
			 //不一樣將KEY移除掉
			 session.remove("key");
			 return "input";
		 }
       
	}
	/**
	 * 抓KEY1 COOKIE
	 * @return
	 */
	private String getCookie() {
		HttpServletRequest  request=ServletActionContext.getRequest();
		Cookie cookies[]=request.getCookies();
		if(cookies!=null) {
		for (Cookie c :cookies ) {
            if (c.getName().equals("key1"))  //抓KEY1 SESSION ID save cookie
                return c.getValue();
             
        }
		} 
		return "";
		 
	}
	/**
	 * 移除COOKIE 這裡不會用到
	 * @param cookies
	 */
	private void removeCookie(Cookie cookies[]) {
		if(cookies!=null) {
			for (Cookie c :cookies ) {
				 if (c.getName().equals("JSESSIONID")) { 
					 c.setMaxAge(0);
					 c.setValue("");
				 }
	        }
			} 
	}
	

}
