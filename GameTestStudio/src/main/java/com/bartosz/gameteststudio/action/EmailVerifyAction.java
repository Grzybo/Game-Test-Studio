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
import com.bartosz.gameteststudio.utils.Utils;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "resetPassword", //
results = { //
        @Result(name = "changePassword", location = "/WEB-INF/pages/changePassword.jsp"), 
        @Result(name = "expired", location = "/WEB-INF/pages/emailExpired.jsp"),
        @Result(name = "login", type="redirect", location = "/login") 
} //
)
public class EmailVerifyAction extends ActionSupport {

	private static final long serialVersionUID = 1438377035288316675L;
	private String hash;
	private String date;
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	@Override
	    public String execute() throws GSException {
		
		if(LocalDate.now().isBefore(LocalDate.parse(Utils.Decode64(date)).plusDays(4)) ){
			System.out.println(" JESZCZE JEST CZAS");
			UserBean user = DataProvider.getUserByHash(this.hash);
			session.setAttribute("loginedUsername", user.getDisplayName());
			session.setAttribute("loginedEmail", user.getEmail());
			session.setAttribute(Constants.SESSION_ROLE_STR, user.getRole().getName());
			session.setAttribute(Constants.SESSION_ROLE_KEY, user.getRole().getId());
			session.setAttribute("userID", user.getId().toString());

			return "changePassword";
			
		}
		
		return "expired";
	 }

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	
	



	
	 
}
