package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "logout", //
results = { //
        @Result(name = "logout", location = "/WEB-INF/pages/hello.jsp")
} //
)
public class LogoutAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
        
    	System.out.print(ServletActionContext.getRequest().getSession().getAttribute("loginedEmail").toString());
    	ServletActionContext.getRequest().getSession().setAttribute("loginedEmail", "");
    	System.out.print(ServletActionContext.getRequest().getSession().getAttribute("loginedEmail"));
    	return "logout"; 
    }
}