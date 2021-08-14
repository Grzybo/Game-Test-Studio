package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "newUserInfo", //
results = { //
        @Result(name = "newUserInfoPage", location = "/WEB-INF/pages/newUserInfo.jsp")
} //
)
public class NewUserInfoAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
         
        return "newUserInfoPage";
    }
     
}