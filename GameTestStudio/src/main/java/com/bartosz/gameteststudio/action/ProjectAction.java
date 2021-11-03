package com.bartosz.gameteststudio.action;
 
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import net.sourceforge.jsptabcontrol.util.JSPTabControlUtil;
import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.beans.IssueTypeBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.repositories.IssueRepository;
import com.bartosz.gameteststudio.utils.Utils;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "projects", //
results = { //
        @Result(name = "projects", location = "/WEB-INF/pages/projects.jsp"),
        @Result(name = "error", location = "/WEB-INF/pages/projectError.jsp")
} //
)
public class ProjectAction  extends ActionSupport {

	private static final long serialVersionUID = 1L;
		
	private List<String> projectsList;
	private String selectedProject; 
	
	private List<BugBean> bugObjList = new ArrayList<BugBean>();
	private List<TestBean> testObjList = new ArrayList<TestBean>();
	private List<AreaBean> areaObjList  = new ArrayList<AreaBean>();  
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	
	private String bugSort = request.getParameter((new ParamEncoder("bugTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
	private String testSort = request.getParameter((new ParamEncoder("testTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
	private String areaSort = request.getParameter((new ParamEncoder("areaTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));

	private UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString()); 

	private String itemID;
    private String title; 
    private String description; 
    private Integer testers_numbers;
    private Integer estimate_time; 
    private Integer work_time;
    private String startDate;
    private String endDate;
    private String state;
    private List<String> platformList = new ArrayList<String>(DataProvider.mapPlatforms.keySet()); 
    private List<String> selectedPlatforms = new ArrayList<String>();
    private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	
    
	 @Override
	    public String execute() {
		
		if (!user.getRole().getName().equals("Tester Manager")) {
			addActionError("Your Account do not have permission to perform this action.");
		}
		
		setProject();
		
		ProjectBean project = DataProvider.mapProjects.get(session.getAttribute("userProject")); 
		
		itemID = Long.toString(project.getId());
		title = project.getTitle(); 
		description = project.getDescription();
		testers_numbers = project.getTestersNumber();
		estimate_time = project.getEstimatedTime(); 
		selectedPlatforms = project.getPlatformsStringList();
		work_time = project.getWorkTime(); 
		startDate = project.getStartDate();
		endDate = project.getEndDate();
		state = project.getState().getName();
 
		setLists();  

		//System.out.print(JSPTabControlUtil.getTabPageState(ServletActionContext.getRequest(), "ProjectsTabs", "TestTab"));
		//JSPTabControlUtil.getTabPageState(ServletActionContext.getRequest(), "ProjectsTabs", "TestTab");
		//JSPTabControlUtil.setSelectedTabPageName(request, "ProjectsTabs", "BugTab");
		
		
		
		
		
		
		
		String state  = JSPTabControlUtil.getTabPageState(ServletActionContext.getRequest(), "ProjectsTabs", "TestTab");
		
		
		System.out.println("bug: " + bugSort);
		System.out.println("test: " + testSort);
		System.out.println("area: " + areaSort);
		System.out.println("state: " + state); 
		
		setTabs();
		//System.out.print(JSPTabControlUtil.getSelectedTabPageName(ServletActionContext.getRequest(), "ProjectsTabs"));

		return "projects";
	 }

	 
	 
	 
//---------------------------------------------------------------------------------------------------------------------------
	 private void setProject() {
		 projectsList = user.getProjectsList();
			
			if(selectedProject == null) {
				if(session.getAttribute("userProject") != null) {
					selectedProject = session.getAttribute("userProject").toString();
					
				}
				else {
					selectedProject = projectsList.get(0);
					session.setAttribute("userProject", selectedProject);			
				} 
			}
			else {
				session.setAttribute("userProject", selectedProject);
			} 
	 }
	 
	 private void setTabs() {
		 if(session.getAttribute("selectedTab") == null) {
				session.setAttribute("selectedTab", "BugTab"); 
			}
		 else if(Utils.bugTabState == null && Utils.testTabState == null && Utils.areaTabState == null) {
			 Utils.bugTabState = "1";
				Utils.testTabState = "1";
				Utils.areaTabState = "1";
				System.out.println("Test 1");
		 }
		 else {
			 {
 				
 				if(bugSort != null && !Utils.bugTabState.equals(bugSort)) {
 					session.setAttribute("selectedTab", "BugTab");
 					Utils.bugTabState = bugSort;
 					System.out.println("Test 2");
 				}
 				if(testSort != null && !Utils.testTabState.equals(testSort)) {
 					session.setAttribute("selectedTab", "TestTab");
 					Utils.testTabState = testSort;
 					System.out.println("Test 3");
 				}
 				if(areaSort != null && !Utils.areaTabState.equals(areaSort)) {
 					session.setAttribute("selectedTab", "AreaTab");
 					Utils.areaTabState = areaSort;
 					System.out.println("Test 4");
 				}
			 	} 
		 }
		 JSPTabControlUtil.setSelectedTabPageName(request, "ProjectsTabs", session.getAttribute("selectedTab").toString());	
		 
	 }
	 
	 private void setLists() {
		 
		 DataProvider.updateBugMaps();
		 DataProvider.updateTestMaps();
		 DataProvider.updateAreaMaps();
		 
		 for (String el : DataProvider.mapAreas.keySet()) {
			  if(DataProvider.mapAreas.get(el).getProject().getTitle().equals(selectedProject)) {
				  areaObjList.add(DataProvider.mapAreas.get(el));
				  
				}
			}
	
		  for (String el :DataProvider.mapTests.keySet()) {
			  if(DataProvider.mapTests.get(el).getArea().getProject().getTitle().equals(selectedProject)) {
				  testObjList.add(DataProvider.mapTests.get(el));
				}
			}
		  
	   
		  for (String el : DataProvider.mapBugs.keySet()) {
			  	if(DataProvider.mapBugs.get(el).getTest().getArea().getProject().getTitle().equals(selectedProject)) {
			  		bugObjList.add(DataProvider.mapBugs.get(el));	
			}
		  }
	 } 

	public List<BugBean> getBugObjList() {
		return bugObjList;
	}


	public void setBugObjList(List<BugBean> bugObjList) {
		this.bugObjList = bugObjList;
	}




	public List<TestBean> getTestObjList() {
		return testObjList;
	}




	public void setTestObjList(List<TestBean> testObjList) {
		this.testObjList = testObjList;
	}



	public List<AreaBean> getAreaObjList() {
		return areaObjList;
	}




	public void setAreaObjList(List<AreaBean> areaObjList) {
		this.areaObjList = areaObjList;
	}


	public HttpSession getSession() {
		return session;
	}


	public void setSession(HttpSession session) {
		this.session = session;
	}

	public List<String> getProjectsList() {
		return projectsList;
	}


	public void setProjectsList(List<String> projectsList) {
		this.projectsList = projectsList;
	}


	public String getSelectedProject() {
		return selectedProject;
	}


	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	} 
	 

	public String getItemID() {
		return itemID;
	}




	public void setItemID(String itemID) {
		this.itemID = itemID;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Integer getTesters_numbers() {
		return testers_numbers;
	}




	public void setTesters_numbers(Integer testers_numbers) {
		this.testers_numbers = testers_numbers;
	}




	public Integer getEstimate_time() {
		return estimate_time;
	}




	public void setEstimate_time(Integer estimate_time) {
		this.estimate_time = estimate_time;
	}




	public Integer getWork_time() {
		return work_time;
	}




	public void setWork_time(Integer work_time) {
		this.work_time = work_time;
	}




	public String getStartDate() {
		return startDate;
	}




	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}




	public String getEndDate() {
		return endDate;
	}




	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}




	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public List<String> getPlatformList() {
		return platformList;
	}




	public void setPlatformList(List<String> platformList) {
		this.platformList = platformList;
	}




	public List<String> getSelectedPlatforms() {
		return selectedPlatforms;
	}




	public void setSelectedPlatforms(List<String> selectedPlatforms) {
		this.selectedPlatforms = selectedPlatforms;
	}




	public List<String> getStateList() {
		return stateList;
	}




	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}
}