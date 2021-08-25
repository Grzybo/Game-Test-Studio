package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "hello", //
results = { //
        @Result(name = "helloPage", location = "/WEB-INF/pages/hello.jsp")
} //
)
public class HelloAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
    
    @Override
    public String execute() {
          
    	return "helloPage";
    }
    
}