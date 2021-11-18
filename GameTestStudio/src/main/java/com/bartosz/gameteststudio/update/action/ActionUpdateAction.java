package com.bartosz.gameteststudio.update.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.ActionBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;

@Action(value = "updateAction", //
results = { //
        @Result(name = "updateAction",  type="redirect", location = "/adminPage"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class ActionUpdateAction  extends SecureAction {

	private List<String> rolesList = new ArrayList<String>(DataProvider.mapRoles.keySet());
	private List<String> selectedRoles = new ArrayList<String>();
	private List<String> actionList = new ArrayList<String>(DataProvider.mapActions.keySet());
    private String selectedAction;
    
	private static final long serialVersionUID = -8884553460159631776L;

	
	
	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {
		ActionBean action = DataProvider.mapActions.get(selectedAction); 
		action.setRoles(selectedRoles); 
		DataProvider.updateAction(action);
		return "updateAction";
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	}

	
	
	
	public List<String> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<String> rolesList) {
		this.rolesList = rolesList;
	}

	public List<String> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<String> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	public List<String> getActionList() {
		return actionList;
	}

	public void setActionList(List<String> actionList) {
		this.actionList = actionList;
	}

	public String getSelectedAction() {
		return selectedAction;
	}

	public void setSelectedAction(String selectedAction) {
		this.selectedAction = selectedAction;
	}

	
}
  
