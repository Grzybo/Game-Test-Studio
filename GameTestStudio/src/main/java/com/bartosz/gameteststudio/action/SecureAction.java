package com.bartosz.gameteststudio.action;
 
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.utils.Constants;
import com.bartosz.gameteststudio.utils.EnRoles;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "secure", //
		results = { //
		@Result(name = "showForm", location = "/WEB-INF/pages/login.jsp"), 
		@Result(name = "noPermissions",  type="redirect", location = "/noPermissions")
} //
)

public abstract class SecureAction extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String action;
    
    public abstract String executeSecured(); // Zastepuje execute akcji. 
    protected abstract Set<EnRoles> allowedRoles(); // Metoda zwaracająca id rol z uprawineiniem od akcji.
    
   
    @Override
    public String execute() {
 
    	Set<EnRoles> setAllowedRoles = null;
        Long roleID = null;
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	String roleStr = session.getAttribute(Constants.SESSION_ROLE_KEY).toString(); 
    	if(StringUtils.isNotBlank(roleStr)) {
    		
    		roleID = Long.parseLong(roleStr);
    		setAllowedRoles = allowedRoles();
    		if(setAllowedRoles != null && setAllowedRoles.contains(EnRoles.getById(roleID))) {
    			System.out.println(" UPR OK");
    			return executeSecured();
    		}else {
    			System.out.println(" BRAK UPR");
    			return "noPermissions";
    		}
    	}else {
    		System.out.println(" BRAK SESi");
    		return "noPermissions";
    		// global forward
    	} 
    }

    
    
    
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}