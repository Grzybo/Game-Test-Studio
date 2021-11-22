package com.bartosz.gameteststudio.delete.action;
 
import java.io.IOException;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
 
@Action(value = "deleteBug", //
results = { //
        @Result(name = "deleted", type="redirect", location = "/projects"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class BugDeleteAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
 
    private String itemID;

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {
	     
	    	BugBean bug = DataProvider.getBugByID(Long.parseLong(itemID));

	    	DataProvider.deleteAttachment(bug.getAttachment());
	    	DataProvider.deleteBug(bug); 
	    		    	
	    	return "deleted";
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	}
    
}