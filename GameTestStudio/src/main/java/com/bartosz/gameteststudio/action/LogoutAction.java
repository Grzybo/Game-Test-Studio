package com.bartosz.gameteststudio.action;
 
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.utils.Utils;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "logout", //
results = { //
        @Result(name = "logout", location = "/WEB-INF/pages/hello.jsp")
}
)
public class LogoutAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
	private HttpSession session = ServletActionContext.getRequest().getSession();
    
    @Override
    public String execute() {
        
    	session.setAttribute("loginedEmail", null); 
    	session.setAttribute("userProject", null); 
    	session.setAttribute("selectedTab", null);  
    	session.setAttribute("loginedUsername", null);
    	session.setAttribute("userRole", null);
    	session.setAttribute("admin", null); 
    	
    	
    	session.setAttribute("sessionUser", null);
    	
    			
    	Utils.bugTabState = null;
    	Utils.testTabState = null;
    	Utils.areaTabState = null;
    	Utils.projectTabState = null;
    	Utils.userTabState = null;
    	
    	return "logout"; 
    }
}