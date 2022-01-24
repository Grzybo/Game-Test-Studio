package com.bartosz.gameteststudio.action;
 
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Constants;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Akcja obłsugująca weryfikację linku aktywacyjnego/weryfikacyjnego.
 * Przenosi użytkownika do akcji zmiany hasła.
 * @author Bartosz
 *
 */
@Action(value = "confirmEmail", 
results = { //
        @Result(name = "confirm", location = "/WEB-INF/pages/confirmedEmail.jsp"),
        @Result(name = "changePassword", location = "/WEB-INF/pages/changePassword.jsp"), 
        @Result(name = "expired", location = "/WEB-INF/pages/emailExpired.jsp"),
        @Result(name = "active", location = "/WEB-INF/pages/accountActive.jsp")
} //
)

public class EmailConfirmAction extends ActionSupport {
  
	private static final long serialVersionUID = -7282173756012263259L;
	private String hash;
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	/**
	 * Główna logika akcji.
	 */
	@Override
    public String execute() throws GSException {
         						
		if(DataProvider.userHashList.contains(hash)) {
			UserBean user = DataProvider.getUserByHash(this.hash);
			if(!user.getMailUsed()) {
				if(LocalDate.now().isBefore(LocalDate.parse(user.getMailDate())
						.plusDays(4))){
					if(user.getMailType().equals("Confirm")) {
						if(!user.getConfirmed()) {user.setConfirmed(true);}
						else return "active";
					}
					user.setMailUsed(true);
					DataProvider.updateUser(user, user);
					session.setAttribute(Constants.SESSION_ROLE_KEY, (long)7);
					session.setAttribute("userID", user.getId().toString());
					return "changePassword";
				} 
			}
		}
		return "expired";
    }

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	

	
	
	
	
	
    
	
}