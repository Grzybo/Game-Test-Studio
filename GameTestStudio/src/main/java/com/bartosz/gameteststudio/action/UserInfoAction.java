package com.bartosz.gameteststudio.action;
 
import com.bartosz.gameteststudio.dictionary.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "userInfo", //
		results = { //
        @Result(name = "userInfoPage", location = "/WEB-INF/pages/userInfo.jsp")
} //
)
public class UserInfoAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L; 
    
    private String project;
 
    @Override
    public String execute() {
         
	 HttpServletRequest request = ServletActionContext.getRequest();
	 HttpSession session = request.getSession(); 
	 session.setAttribute("userProject", ProjectsDictionary.getName(project));
    	
	 return "userInfoPage";
	 
    }

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
    
}