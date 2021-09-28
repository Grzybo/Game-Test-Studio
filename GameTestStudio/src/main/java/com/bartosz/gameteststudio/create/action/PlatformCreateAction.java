package com.bartosz.gameteststudio.create.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "cratePlatforms", //
results = { //
        @Result(name = "cratePlatforms", location = "/WEB-INF/pages/create_pages/createPlatform.jsp")
} //
)

public class PlatformCreateAction  extends ActionSupport {
  

	private static final long serialVersionUID = 1L;

	@Override
    public String execute() {
          
    		
            return "cratePlatforms";
    	}
    	 
    }
    
   
    
  
 




