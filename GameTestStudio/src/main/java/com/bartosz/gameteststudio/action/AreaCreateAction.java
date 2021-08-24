package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createArea", //
results = { //
        @Result(name = "createArea", location = "/WEB-INF/pages/createArea.jsp")
} //
)
public class AreaCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    @Override
    public String execute() {
          
        return "createArea";
    }
    
}