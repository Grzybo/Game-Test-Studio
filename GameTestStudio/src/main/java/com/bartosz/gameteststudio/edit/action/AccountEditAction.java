package com.bartosz.gameteststudio.edit.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editAccount", //
results = { //
        @Result(name = "editAccount", location = "/WEB-INF/pages/edit_pages/editAccount.jsp")
} //
)
public class AccountEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          
    	return "editAccount";
    }
    
}