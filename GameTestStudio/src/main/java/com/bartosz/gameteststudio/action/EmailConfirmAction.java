package com.bartosz.gameteststudio.action;
 
import java.time.LocalDate;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "confirmEmail", 
results = { //
        @Result(name = "confirm", location = "/WEB-INF/pages/confirmedEmail.jsp"), 
        @Result(name = "expired", location = "/WEB-INF/pages/emailExpired.jsp"),
        @Result(name = "active", location = "/WEB-INF/pages/accountActive.jsp")
} //
)
public class EmailConfirmAction extends ActionSupport {
  
	private static final long serialVersionUID = -7282173756012263259L;
	private String hash;
	private String date;
	
	@Override
    public String execute() throws GSException {
         				
		System.out.println(date);
		System.out.println(Utils.Decode64(date));
		
		if(LocalDate.now().isBefore(LocalDate.parse(Utils.Decode64(date)).plusDays(4)) ){
			System.out.println(" JESZCZE JEST CZAS");
			UserBean user = DataProvider.getUserByHash(this.hash);
			if(!user.getConfirmed()) {
				user.setConfirmed(true);
				System.out.println(user.toString());
				DataProvider.updateUser(user, user);
				return "confirm";
			}
			return "active";
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