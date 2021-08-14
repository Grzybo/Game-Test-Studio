package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editProject", //
results = { //
        @Result(name = "project_edit", location = "/WEB-INF/pages/project_edit.jsp")
} //
)
public class ProjectEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          
    	return "project_edit";
    }
    
}