package com.bartosz.gameteststudio.delete.action;
 
import java.io.IOException;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
 
@Action(value = "deleteProject", //
results = { //
       @Result(name = "deleted", type="redirect", location = "/adminPage"), 
       @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
       @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class ProjectDeleteAction  extends SecureAction {

	private static final long serialVersionUID = -5395159485825349657L;
	private String itemID;

	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {
		DataProvider.deleteProject(DataProvider.getProjectByID(Long.parseLong(itemID)));
		return "deleted";
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	}
	
	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
    
}