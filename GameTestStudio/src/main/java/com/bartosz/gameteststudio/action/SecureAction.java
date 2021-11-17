package com.bartosz.gameteststudio.action;
 
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Constants;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "secure", //
		results = { //
		@Result(name = "showForm", location = "/WEB-INF/pages/login.jsp")
} //
)

public abstract class SecureAction extends ActionSupport {

	private static final long serialVersionUID = 1812356272496984591L;
	private String action;
    
    public abstract String executeSecured() throws GSException, NumberFormatException, IOException; // Zastepuje execute akcji. 
    //protected abstract Set<EnRoles> allowedRoles(); // Metoda zwaracająca id rol z uprawineiniem od akcji.
    //protected abstract Set<String> allowedRolesStr();
    protected abstract Set<Long> allowedRolesID();
    
    @Override
    public String execute() throws GSException, NumberFormatException, IOException {
 
    	//Set<EnRoles> setAllowedRoles = null;
    	//Set<String> setAllowedRolesStr = null;
    	Set<Long> setAllowedRolesID = null;
    	
        Long roleID = null;
        //String role = null;
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	
    	//String roleStr;
    	//if(StringUtils.isNotBlank(roleStr)
    	
    	if(session.getAttribute(Constants.SESSION_ROLE_KEY) != null) {
    		
    		roleID = Long.parseLong(session.getAttribute(Constants.SESSION_ROLE_KEY).toString());
    		//role = session.getAttribute("userRole").toString();
    		setAllowedRolesID = allowedRolesID();
    		if(setAllowedRolesID != null && setAllowedRolesID.contains(roleID)) {
    			System.out.println(" UPR OK");
    			return executeSecured();
    		}else {
    			System.out.println(" BRAK UPR");
    			return "noPermissions";
    		}
    	}else {
    		System.out.println(" BRAK SESi / nie zalogowany ");
    		return "sessionExpired";
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