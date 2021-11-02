package com.bartosz.gameteststudio.action;
 
import javax.servlet.http.HttpSession;
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
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
 
 
    
    public String execute() {
        
    	if (this.email == null && this.password == null) {
            return "showForm";
        }
    	System.out.println(" LOGIN ");
    	
        HttpSession session = ServletActionContext.getRequest().getSession();
        
        UserBean user = new UserBean();
        
        try {
        	user = DataProvider.getUserByEmail(this.email);
        	
        	if(user.getPassword().equals(this.password)) {
        		session.setAttribute("loginedUsername", user.getDisplayName());
        		session.setAttribute("loginedEmail", this.getEmail());
        		session.setAttribute("userRole", user.getRole().getName());
        		
        		if(user.isAdmin()) {
        			session.setAttribute("admin", "admin");
        			System.out.println("     ADMIN ");
        			ret = "admin";
            	}
            	else ret = "loginSuccess";
        	}
        	else {
        		addActionError("Wrong Password.");
            	ret = "loginError";
        	}
        	
        	
        }
        catch(Exception e) {
        	addActionError("Login Failed.");
        	ret = "loginError";
        } 
        System.out.println(ret);
        
        return ret;
        
        /*
        
        
        // Valid username and password  - admin     
        if ("admin".equals(this.username) && 
        		"admin123".equals(this.password)) {
             
            // Store userName in session
            session.setAttribute("loginedUsername", this.username);
             
            return "admin";
        }
        if ("user".equals(this.username) && 
        		"user123".equals(this.password)) {
             
            // Store userName in session
            session.setAttribute("loginedUsername", this.username);
            session.setAttribute("userProject", "FIFA 22");
            
            return "loginSuccess";
        }
        // Invalid username or password
        else {
            // ** See in ApplicationResources.properties
            String message = getText("error.login");
 
            addActionError(message);
 
            return "loginError";
        }
        */
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