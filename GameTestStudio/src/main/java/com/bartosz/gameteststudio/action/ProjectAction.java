package com.bartosz.gameteststudio.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "projects", //
results = { //
        @Result(name = "projects", location = "/WEB-INF/pages/projects.jsp"),
        @Result(name = "error", location = "/WEB-INF/pages/projectError.jsp")
} //
)
public class ProjectAction  extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	
	 @Override
	    public String execute() {
		
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpSession session = request.getSession(); 
	    		  
		 if(session.getAttribute("userProject") == null) {
			 return "error";
		 }
		 
		return "projects";
	 }
}