package com.bartosz.gameteststudio.action;
 
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Constants;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Klasa zapewniająca autoryzację dostępu do akcji. 
 * Klasy akcji wymagających autoryzacji są klasami pochodnymi tej klasy. 
 * @author Bartosz
 *
 */
@Action(value = "secure", results = {
		@Result(name = "showForm", location = "/WEB-INF/pages/login.jsp"), 
		@Result(name = "sessionExpired", location = "/WEB-INF/pages/sessionExpired.jsp")})
public abstract class SecureAction extends ActionSupport {

	private static final long serialVersionUID = 1812356272496984591L;
	private String action;
    
	/**
	 * Zastępuje  metodę execute klasy pochodnej.
	 * @return
	 * @throws GSException
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws InterruptedException
	 */
    public abstract String executeSecured() throws GSException,
    NumberFormatException, 
    												IOException, InterruptedException; 
    
    /**
     * Metoda zwaracająca identyfikatory ról z uprawineiniem do danej akcji.
     */
    protected abstract Set<Long> allowedRolesID();
    
    /**
     * Główna logika akcji. Sprawdza dane użytkownika z sesji i na tej podstawie
     * udziela dostępu do akcji.  
     */
    @Override
    public String execute() throws GSException, NumberFormatException, 
    									IOException, InterruptedException {
        Long roleID = null;
    	Object sessionAttribute = ServletActionContext.getRequest().
    				getSession().getAttribute(Constants.SESSION_ROLE_KEY);
    	
    	if((sessionAttribute != null) && (NumberUtils.isNumber(sessionAttribute.toString()) )) {
    		roleID = Long.parseLong(sessionAttribute.toString());
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