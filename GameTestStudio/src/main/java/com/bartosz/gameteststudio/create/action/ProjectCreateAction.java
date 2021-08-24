package com.bartosz.gameteststudio.create.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createProject", //
results = { //
        @Result(name = "project_create", location = "/WEB-INF/pages/create_pages/createProject.jsp")
} //
)
public class ProjectCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          
    	return "project_create";
    }
    
}