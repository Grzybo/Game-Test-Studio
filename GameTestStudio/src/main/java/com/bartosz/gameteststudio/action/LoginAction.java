package com.bartosz.gameteststudio.action;
 
import java.util.regex.Pattern;

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
 
@Action(value = "login", //
        results = { //
                @Result(name = "showForm", location = "/WEB-INF/pages/login.jsp"), //
                @Result(name = "loginSuccess", type="redirect", location= "/projects"), 
                @Result(name = "admin", type="redirect", location= "/adminPage") //
        } //
)
public class LoginAction extends ActionSupport {
 
    private static final long serialVersionUID = 7299264265184515893L;
    
    HttpSession session = ServletActionContext.getRequest().getSession();
    
    private String email;
    private String password;
    private String ret;
    UserBean user;    

    public String execute() throws GSException {

        ret = "showForm";

        if(!Strings.isNullOrEmpty(this.email)) {
    		if(Pattern.compile(Utils.emailPattern).matcher(this.email).matches()) {
            	if(DataProvider.mapUsers.containsKey(this.email)) {
            		user = DataProvider.getUserByEmail(this.email);
            		if(user.getConfirmed()) {
	            		if(!Strings.isNullOrEmpty(password)) {
	            			if(user.getPassword().equals(Utils.HashSHA256(this.password))){
		            		//if(user.getPassword().equals(this.password)) {
	            				setSessionAttributes();
		        	    		if(user.isAdmin()) {
		        	    			session.setAttribute("admin", "admin");
		        	    			ret = "admin";
		        	        	}
		        	        	else if(user.getProjectsList().size() > 0) {	
		        	        		ret = "loginSuccess";
		        	        	}else addActionError("User is not assigned to any project. Please contact system Administrator.");
		            		}else addActionError("Wrong email or password.");
	            		}else addActionError("Password cannot be empty.");
            		}else addActionError("Your email adress is not confirmed. Please check your email.");
            	}else addActionError("Wrong email or password.");
            }else addActionError("Wrong email or password.");
        }else addActionError("Email cannot be empty.");

        return ret;
        
    }
    
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