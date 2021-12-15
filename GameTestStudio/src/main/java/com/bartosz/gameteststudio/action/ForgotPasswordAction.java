package com.bartosz.gameteststudio.action;

import java.time.LocalDate;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Mailer;
import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "forgotPassword", //
results = { //
        @Result(name = "forgotPassword", location = "/WEB-INF/pages/forgotPassword.jsp"), 
        @Result(name = "login", type="redirect", location = "/login") 
} //
)
public class ForgotPasswordAction extends ActionSupport {

	private static final long serialVersionUID = 1438377035288316675L;
	private String email;
	
	@Override
	    public String execute() throws GSException {
		
		if(!Strings.isNullOrEmpty(email)) {
			if(DataProvider.mapUsers.keySet().contains(email)) {
				UserBean user = DataProvider.getUserByEmail(email);
				if(user.getConfirmed()) {
					user.setMailType("Verify");
					user.setMailDate(LocalDate.now().toString());
					DataProvider.updateUser(user, user);
					Mailer.sendResetPasswordEmail(user);	
				} 
			}
			addActionError("If email adress is valid, check your email box for further actions.");
			
		}else addActionError("Email adress cannot be empty.");
		
		return "forgotPassword";
	 }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	 
}
