package com.bartosz.gameteststudio.action;
 
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "secure", //
results = { //
        @Result(name = "projects", location = "/WEB-INF/pages/secureError.jsp"),

} //
)

public abstract class SecureAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String action;
    
    public SecureAction() {
    	
    	System.out.println(" SECURE K ");
    	
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	
    	UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString());
    	
    	//session.setAttribute("loginedUser", user); 
    	//UserBean user2 = DataProvider.mapUsers.get(session.getAttribute("loginedUser")); 
    	

    	
    }
    
    @Override
    public String execute() {
 
    	System.out.print(" SECURE E ");
        
    	// HttpSession session = ServletActionContext.getRequest().getSession();
    	// UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString());
    	
    	 
    	 
        if(action.equals("createBug")) {
        	return "createBug";
        }  
          
          
          return "secure";
    }

    
    
    
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}