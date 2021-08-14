package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editAccount", //
results = { //
        @Result(name = "account_edit", location = "/WEB-INF/pages/account_edit.jsp")
} //
)
public class AccountEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          
    	return "account_edit";
    }
    
}