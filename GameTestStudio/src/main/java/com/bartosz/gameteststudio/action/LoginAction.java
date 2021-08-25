package com.bartosz.gameteststudio.action;

import com.bartosz.gameteststudio.db.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "login", //
        results = { //
                @Result(name = "showForm", location = "/WEB-INF/pages/login.jsp"), //
                @Result(name = "loginError", location = "/WEB-INF/pages/hello.jsp"), //
                // loginSuccess: Redirect to /userInfo
                @Result(name = "loginSuccess", type="redirect", location= "/userInfo"), 
                @Result(name = "admin", type="redirect", location= "/adminPage") //
        } //
)
public class LoginAction extends ActionSupport {
 
    private static final long serialVersionUID = 7299264265184515893L;
    private String email;
    private String password;
 
 
    @Override
    public String execute() {
        String ret = "showForm";
    	
    	if (this.email == null && this.password == null) {
            return ret;
        }
       
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
         
        User user = new User();
        
        try {
        	user = UserRepository.findByEmail(email); 
        	
        	//System.out.print(user.toString() + " " + user.getRole().getName() + " " + user.isAdmin());
        	
        	if(user.getPassword().equals(this.password)) {
        		session.setAttribute("loginedUsername", user.NametoString());
        		session.setAttribute("loginedEmail", this.getEmail());
        		
        		if(user.isAdmin()) {
            		ret = "admin";
            	}
        		else {ret = "loginSuccess";}
        		
        	}
        	else {
        		addActionError("Wrong password.");
            	ret = "loginError";
        	}
        }
        catch(Exception e) {
        	addActionError("Login Failed.");
        	ret = "loginError";
        } 
        return ret;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String username) {
        this.email = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}