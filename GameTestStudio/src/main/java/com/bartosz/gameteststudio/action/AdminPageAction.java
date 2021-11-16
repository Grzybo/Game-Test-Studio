package com.bartosz.gameteststudio.action;
 
import java.util.ArrayList;
import java.util.HashSet;
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
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.utils.EnRoles;
import com.bartosz.gameteststudio.utils.Utils;

import net.sourceforge.jsptabcontrol.util.JSPTabControlUtil;
 
@Action(value = "adminPage", 
		results = { 
		@Result(name = "admin", location = "/WEB-INF/pages/adminPage.jsp"),
        @Result(name = "login", type="redirect", location = "/login"),
} 
)
public class AdminPageAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
    
    private List<ProjectBean> projectObjList; // = new ArrayList<ProjectBean>(DataProvider.mapProjects.values());
    private List<UserBean> userObjList = new ArrayList<UserBean>(DataProvider.getAllUsers());
    private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession(); 
	private String projectSort = request.getParameter((new ParamEncoder("projectsTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
	private String userSort = request.getParameter((new ParamEncoder("accountsTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
    
    
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

	@Override
	public String executeSecured() {
		HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
    	
        DataProvider.updateProjectMaps();
        projectObjList = new ArrayList<ProjectBean>(DataProvider.mapProjects.values());
    	
        setTabs();
    	  
    	  if(session.getAttribute("loginedUsername") == null ){
    		  return "login";
    	  }
    	  
    	  System.out.println(" ADMIN PAGE  ");
    	  
    	 // if(DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString()).isAdmin()){	
    	//	  return "admin";
    	 // } 
    	  
    	  
    	return "admin";
	}

	@Override
	protected Set<EnRoles> allowedRoles() {
		// zmienna set z rolami 
		Set<EnRoles> roles = new HashSet<>(); 
		roles.add(EnRoles.administrator);
		return roles;
	} 
    
    
}