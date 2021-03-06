package com.bartosz.gameteststudio.action;
 
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.utils.Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Akcja odpoiwda za wylogowanie użytkownika, czyli za usunięcie z sesji jego danych.
 * @author Bartosz
 *
 */
@Action(value = "logout", //
results = { //
        @Result(name = "logout", location = "/WEB-INF/pages/login.jsp"),
        
}
)
public class LogoutAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
	private HttpSession session = ServletActionContext.getRequest().getSession();
    
	/**
	 * Główna logika akcji.
	 */
    @Override
    public String execute() {
        
    	clearSessionAtributes();
    	
    	return "logout"; 
    } 
    
    /**
     * Metoda usuwa z sesji dane użytkownika. 
     */
    private void clearSessionAtributes() {
    	session.setAttribute("loginedEmail", null); 
    	session.setAttribute("userProject", null); 
    	session.setAttribute("selectedTab", null);  
    	session.setAttribute("loginedUsername", null);
    	session.setAttribute("userRole", null);
    	session.setAttribute("userID", null);
    	session.setAttribute("admin", null); 
    	
    	session.setAttribute("sessionUser", null);
    	
    			
    	Utils.bugTabState = null;
    	Utils.testTabState = null;
    	Utils.areaTabState = null;
    	Utils.projectTabState = null;
    	Utils.userTabState = null;
    }
}