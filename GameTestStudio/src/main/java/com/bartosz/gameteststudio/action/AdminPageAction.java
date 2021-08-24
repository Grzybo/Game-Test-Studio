package com.bartosz.gameteststudio.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "adminPage", 
		results = { 
        
		@Result(name = "admin", location = "/WEB-INF/pages/adminPage.jsp"),
        
        @Result(name = "login", type="redirect", location = "/login")
        
} 
)
public class AdminPageAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          	
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        
        if(session.getAttribute("loginedUsername") == null ){
        	return "login";
        }
    	
    	if(session.getAttribute("loginedUsername").equals("admin")){	
    		return "admin";
    	}
    	return "login";
    }
    
}