package com.bartosz.gameteststudio.action;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.RoleBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.utils.Utils;

import net.sourceforge.jsptabcontrol.util.JSPTabControlUtil;
 
@Action(value = "adminPage", 
		results = { 
		@Result(name = "admin", location = "/WEB-INF/pages/adminPage.jsp"),
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} 
)
public class AdminPageAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
    
    private List<ProjectBean> projectObjList;
    private List<UserBean> userObjList = new ArrayList<UserBean>(DataProvider.getAllUsers()); 
    private List<RoleBean> rolesObjList = new ArrayList<RoleBean>(DataProvider.getAllRoles()); 
    private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession(); 
	private String projectSort = request.getParameter((new ParamEncoder("projectsTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
	private String userSort = request.getParameter((new ParamEncoder("accountsTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
	
	private List<String> rolesList = new ArrayList<String>(DataProvider.mapRoles.keySet());
	private List<String> selectedRoles = new ArrayList<String>();
	private List<String> actionList = new ArrayList<String>(DataProvider.mapActions.keySet());
    private String selectedAction;
	
	@Override
	public String executeSecured() {
    	
		if(selectedAction == null) {selectedAction = actionList.get(0);} 
        DataProvider.updateProjectMaps();
        projectObjList = new ArrayList<ProjectBean>(DataProvider.mapProjects.values());
        selectedRoles = DataProvider.mapActions.get(selectedAction).getRolesList();

        setTabs();  
    	return "admin";
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	}
	
    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    private void setTabs() {
		 if(session.getAttribute("selectedTab") == null) {
				session.setAttribute("selectedTab", "ProjectsTab"); 
			}
		 else if(Utils.projectTabState == null && Utils.userTabState == null) {
			 	Utils.projectTabState = "0";
				Utils.userTabState = "0";
		 }
		 else {
			 {	
				if(projectSort != null && !Utils.projectTabState.equals(projectSort)) {
					session.setAttribute("selectedTab", "ProjectsTab");
					Utils.projectTabState = projectSort;
				}
				if(userSort != null && !Utils.userTabState.equals(userSort)) {
					session.setAttribute("selectedTab", "AccountsTab");
					Utils.userTabState = userSort;
				}
		 	} 
		 }
		 JSPTabControlUtil.setSelectedTabPageName(request, "AdminTabs", session.getAttribute("selectedTab").toString());	
		 
	 }

	public List<ProjectBean> getProjectObjList() {
		return projectObjList;
	}

	public void setProjectObjList(List<ProjectBean> projectObjList) {
		this.projectObjList = projectObjList;
	}

	public List<UserBean> getUserObjList() {
		return userObjList;
	}

	public void setUserObjList(List<UserBean> userObjList) {
		this.userObjList = userObjList;
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

	public List<RoleBean> getRolesObjList() {
		return rolesObjList;
	}

	public void setRolesObjList(List<RoleBean> rolesObjList) {
		this.rolesObjList = rolesObjList;
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

	
    
    
}