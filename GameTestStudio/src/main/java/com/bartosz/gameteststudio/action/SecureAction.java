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
    
    public abstract String executeSecured() throws GSException, NumberFormatException, IOException, InterruptedException; // Zastepuje execute akcji. 
    protected abstract Set<Long> allowedRolesID(); // Metoda zwaracająca id rol z uprawineiniem od akcji.
    
    @Override
    public String execute() throws GSException, NumberFormatException, IOException, InterruptedException {

        Long roleID = null;
    	HttpSession session = ServletActionContext.getRequest().getSession();

    	if(session.getAttribute(Constants.SESSION_ROLE_KEY) != null) {
    		roleID = Long.parseLong(session.getAttribute(Constants.SESSION_ROLE_KEY).toString());
    		if(allowedRolesID() != null && allowedRolesID().contains(roleID)) {
    			return executeSecured();
    		}else {
    			return "noPermissions";
    		}
    	}else {
    		return "sessionExpired";
    	} 
    }

    
    
    
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}