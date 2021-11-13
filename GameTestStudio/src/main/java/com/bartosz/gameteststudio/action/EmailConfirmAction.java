package com.bartosz.gameteststudio.action;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "confirmEmail", //confirmEmail?itemID=23
results = { //
        @Result(name = "confirm", type="redirect", location = "/hello")
} //
)
public class EmailConfirmAction extends ActionSupport {
  
	private static final long serialVersionUID = -7282173756012263259L;

	private String itemID;
	
	@Override
    public String execute() throws GSException {
         
		UserBean user = DataProvider.getUserByID(Long.parseLong(itemID));
		//UserBean newUser = new UserBean();
		//newUser.setAllFields(user);
		//newUser.setConfirmed(true);
		user.setConfirmed(true);
		System.out.println(user.toString());
		DataProvider.updateUser(user, user);
		
		
		//UserBean user = DataProvider.getUserByEmail(email);
		//user.setConfirmed(true);
		
		System.out.println(" CONFIRMED ");
		
        return "confirm";
    }

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	
	
	
	
	
    
	
}