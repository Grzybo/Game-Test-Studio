package com.bartosz.gameteststudio.action;
 
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.hash.Hashing;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "login", //
        results = { //
                @Result(name = "showForm", location = "/WEB-INF/pages/login.jsp"), //
                @Result(name = "loginError", location = "/WEB-INF/pages/hello.jsp"), //
                // loginSuccess: Redirect to /userInfo
                @Result(name = "loginSuccess", type="redirect", location= "/projects"), 
                @Result(name = "admin", type="redirect", location= "/adminPage") //
        } //
)
public class LoginAction extends ActionSupport {
 
    private static final long serialVersionUID = 7299264265184515893L;
    private String email;
    private String password;
    private String ret;
 

    public String execute() throws GSException {
        
    	if (this.email == null && this.password == null) {
            return "showForm";
        }
    	
        HttpSession session = ServletActionContext.getRequest().getSession();
        UserBean user = new UserBean();
        
        String email = this.email;
        Pattern pattern = Pattern.compile(Utils.emailPattern);
        Matcher match = pattern.matcher(email);
        
        
        if(this.email != "") {
        	
    		if(match.matches()) {
            	if(DataProvider.mapUsers.containsKey(email)) {
            		user = DataProvider.getUserByEmail(this.email);
            		if(user.getConfirmed()) {
            			
            		if(password != "") {
            		
            			//System.out.println(Hashing.sha256().hashString(this.password, StandardCharsets.UTF_8).toString());
            			if(user.getPassword().equals(Hashing.sha256().hashString(this.password, StandardCharsets.UTF_8).toString())){
	            		//if(user.getPassword().equals(this.password)) {
	            			
	            				session.setAttribute("loginedUsername", user.getDisplayName());
		        	    		session.setAttribute("loginedEmail", this.getEmail());
		        	    		session.setAttribute("userRole", user.getRole().getName());
		        	    		session.setAttribute("userID", user.getId().toString());
		        	    		
		        	    		if(user.isAdmin()) {
		        	    			session.setAttribute("admin", "admin");
		        	    			ret = "admin";
		        	        	}
		        	        	else if(user.getProjectsList().size() > 0) {	
		        	        		ret = "loginSuccess";
		        	        	}
		        	        	else {
			            			addActionError("User is not assigned to any project. Please contact system Administrator.");
			        	        	ret = "loginError";
			            		}
	            			
	            		}
	            		else {
	            			addActionError("Wrong password.");
	        	        	ret = "loginError";
	            		}
            		}
                    else {
                    	addActionError("Password cannot be empty.");
                    	ret = "loginError";
                    }
            		
            		
            		}else {
            			addActionError("Your email adress is not confirmed. Please check your email.");
            			ret = "loginError";
            		}
            	}
            	else {
            		addActionError("Account with this email not exist.");
    	        	ret = "loginError";
            	}
            }
            else {
            	addActionError("Email not valid.");
            	ret = "loginError";
            }
           
        }
        else {
        	addActionError("Email cannot be empty.");
        	ret = "loginError";
        }
        
        
        
        // ----------- 
         
        return ret;
        
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