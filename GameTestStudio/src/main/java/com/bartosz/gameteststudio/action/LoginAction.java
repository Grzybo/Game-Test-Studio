package com.bartosz.gameteststudio.action;
 
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Constants;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Akcja odpowiada za uwierzytelnienie użytkownika. 
 * @author Bartosz
 *
 */
@Action(value = "login", //
        results = { //
                @Result(name = "showForm", location = "/WEB-INF/pages/login.jsp"), //
                @Result(name = "loginSuccess", type="redirect", location= "/projects"), 
                @Result(name = "admin", type="redirect", location= "/adminPage") //
        } 
)
public class LoginAction extends ActionSupport {
 
    private static final long serialVersionUID = 7299264265184515893L;
    
    HttpSession session = ServletActionContext.getRequest().getSession();
    
    private String email;
    private String password;
    private String ret;
    UserBean user;    

    /**
     * Główna logika akcji.
     */
    public String execute() throws GSException {

        ret = "showForm";

        if(!Strings.isNullOrEmpty(this.email)) {
        	if(DataProvider.mapUsers.containsKey(this.email)) {
        		user = DataProvider.getUserByEmail(this.email);
        		if(user.getConfirmed()) {
            		if(!Strings.isNullOrEmpty(password)) {
            			if(user.getPassword().equals(Utils.HashSHA256(this.password))){
            				setSessionAttributes();
	        	    		if(user.isAdmin()) {
	        	    			session.setAttribute("admin", "admin");
	        	    			ret = "admin";
	        	        	}
	        	        	else if(user.getProjectsList().size() > 0) {	
	        	        		ret = "loginSuccess";
	        	        	}else addActionError("User is not assigned to any project."
	        	        			+ " Please contact system Administrator.");
	            		} 
            		}
        		}
        	}addActionError("Wrong email or password.");
        }else addActionError("Email cannot be empty.");

        return ret;
    }
    
    /**
     * Metoda zapisuje do sesji dane użytkownika kótre potrzebne są do póiejszej autoryzacji.
     */
    private void setSessionAttributes() {
    	session.setAttribute("loginedUsername", user.getDisplayName());
		session.setAttribute("loginedEmail", this.getEmail());
		session.setAttribute(Constants.SESSION_ROLE_STR, user.getRole().getName());
		session.setAttribute(Constants.SESSION_ROLE_KEY, user.getRole().getId());
		session.setAttribute("userID", user.getId().toString());
    }
    
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}