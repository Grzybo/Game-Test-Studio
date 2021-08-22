package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createBug", //
results = { //
        @Result(name = "createBug", location = "/WEB-INF/pages/createBug.jsp")
} //
)
public class BugCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          
        return "createBug";
    }
    
}