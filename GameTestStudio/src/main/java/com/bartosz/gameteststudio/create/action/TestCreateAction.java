package com.bartosz.gameteststudio.create.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createTest", //
results = { //
        @Result(name = "createTest", location = "/WEB-INF/pages/create_pages/createTest.jsp")
} //
)
public class TestCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          
        return "createTest";
    }
    
}