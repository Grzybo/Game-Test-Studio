package com.bartosz.gameteststudio.action;
 
import java.io.IOException;
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

import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;

import net.sourceforge.jsptabcontrol.util.JSPTabControlUtil;
 
/**
 * Klasa odpowiadająca wywołąniuakcji strony Projects dla użytkowników o rolach: Developer, Tester i Tester Manager. 
 * @author Bartosz
 *
 */
@Action(value = "projects", //
results = { //
        @Result(name = "projects", location = "/WEB-INF/pages/projects.jsp"),
        @Result(name = "error", location = "/WEB-INF/pages/projectError.jsp"),
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class ProjectAction  extends SecureAction {

	private static final long serialVersionUID = 1L;
		
	private List<String> projectsList = new ArrayList<String>();
	private String selectedProject; 
	
	private List<BugBean> bugObjList = new ArrayList<BugBean>();
	private List<TestBean> testObjList = new ArrayList<TestBean>();
	private List<AreaBean> areaObjList  = new ArrayList<AreaBean>();  
	
	
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpSession session = request.getSession();
	
	private String bugSort = request.getParameter((new ParamEncoder("bugTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
	private String testSort = request.getParameter((new ParamEncoder("testTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
	private String areaSort = request.getParameter((new ParamEncoder("areaTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));

	private  UserBean user;

	private String itemID;
    private String title; 
    private String description; 
    private Integer testers_numbers;
    private Double estimate_time; 
    private Double work_time;
    private String startDate;
    private String endDate;
    private String state;
    private List<String> platformList = new ArrayList<String>(DataProvider.mapPlatforms.keySet()); 
    private List<String> selectedPlatforms = new ArrayList<String>();
    private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	


//---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Metoda przekazue pola projektu do zmiennych akcji, aby były widoczne dla użytkownika.
	 */
	 private void setProjectFields() {
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
	}
	 
	 /**
	  * Ustawia projekt do zapamiętania w sesji. Dzięki temu po wykonaniu akcji i powrocie na stronę projects, użytkownik będzie widział itemy z projektu który wybrał poprzednio. 
	  */
	 private void setProject() {
		 projectsList = user.getProjectsList();
			
			if(selectedProject == null) {
				if(session.getAttribute("userProject") != null) {
					selectedProject = session.getAttribute("userProject").toString();			
				}else {
					selectedProject = projectsList.get(0);
					session.setAttribute("userProject", selectedProject);
				} 
			}
			else {
				session.setAttribute("userProject", selectedProject);
			} 
	 }
	 
	 /**
	  * Metoda ustawiająca odpowiednią zakładkę na stownie tak, aby użytkownik cały czas znajdował się w jednej zakładce po wykonaniu czynności np. sortowania.
	  */
	 private void setTabs() {
		 if(Strings.isNullOrEmpty((String) session.getAttribute("selectedTab"))) { // po zalogowaniu, ustawia domyślnie na Bug Tab
				session.setAttribute("selectedTab", "BugTab"); 
			}
		 else if(Strings.isNullOrEmpty(Utils.bugTabState) && Strings.isNullOrEmpty(Utils.testTabState) && Strings.isNullOrEmpty(Utils.areaTabState)) { // ustwiawia pomocnicze zmianne na 1 czyli na sortowanie drugą kolumną
			 Utils.bugTabState = "0"; 																		//(pierwsza jest ID po ktorej nie da sie sortowac )
				Utils.testTabState = "0";
				Utils.areaTabState = "0";
		 }
		 else {
			 {
 				if(!Strings.isNullOrEmpty(bugSort) && !Utils.bugTabState.equals(bugSort)) {
 					session.setAttribute("selectedTab", "BugTab");
 					Utils.bugTabState = bugSort;
 				}
 				if(!Strings.isNullOrEmpty(testSort) && !Utils.testTabState.equals(testSort)) {
 					session.setAttribute("selectedTab", "TestTab");
 					Utils.testTabState = testSort;
 				}
 				if(!Strings.isNullOrEmpty(areaSort) && !Utils.areaTabState.equals(areaSort)) {
 					session.setAttribute("selectedTab", "AreaTab");
 					Utils.areaTabState = areaSort;
 				}
		 	} 
		 }
		 JSPTabControlUtil.setSelectedTabPageName(request, "ProjectsTabs", session.getAttribute("selectedTab").toString());	
		 
	 }
	 
	/**
	 * Metoda wypełnia listy obiektami odpowiednimi dla danego projektu.
	 */
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




	public Double getEstimate_time() {
		return estimate_time;
	}




	public void setEstimate_time(Double estimate_time) {
		this.estimate_time = estimate_time;
	}




	public Double getWork_time() {
		return work_time;
	}




	public void setWork_time(Double work_time) {
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

	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {
		
		user = DataProvider.getUserByEmail(session.getAttribute("loginedEmail").toString());
		setProject();
		setProjectFields();
		setLists();  		
		setTabs();
		
		return "projects";
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	}
}