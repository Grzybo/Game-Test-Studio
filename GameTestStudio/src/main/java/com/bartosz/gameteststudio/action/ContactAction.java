package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "contact", //
results = { //
        @Result(name = "contact", location = "/WEB-INF/pages/contact.jsp")
} //
)
public class ContactAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          
        return "contact";
    }
    
}