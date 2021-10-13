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

import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "projects", //
results = { //
        @Result(name = "projects", location = "/WEB-INF/pages/projects.jsp"),
        @Result(name = "error", location = "/WEB-INF/pages/projectError.jsp")
} //
)
public class ProjectAction  extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String sort; 
	private String tab;
	
	
	private List<String> projectsList;
	private String selectedProject; 
	
	private List<BugBean> bugObjList; 
	private List<TestBean> testObjList;
	private List<AreaBean> areaObjList;
	

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	 @Override
	    public String execute() {
		 
		bugObjList = new ArrayList<BugBean>();
		testObjList = new ArrayList<TestBean>();
		areaObjList = new ArrayList<AreaBean>(); 
			
		UserBean user = DataProvider.mapUsers.get(session.getAttribute("loginedEmail").toString());

		projectsList = user.getProjectsList();
		if(selectedProject == null) selectedProject = projectsList.get(0);
		session.setAttribute("userProject", selectedProject); 
		 
		fillLists();  

		//System.out.print(JSPTabControlUtil.getTabPageState(ServletActionContext.getRequest(), "ProjectsTabs", "TestTab"));
		//JSPTabControlUtil.getTabPageState(ServletActionContext.getRequest(), "ProjectsTabs", "TestTab");
		JSPTabControlUtil.setSelectedTabPageName(ServletActionContext.getRequest(), "ProjectsTabs", "BugTab");
		
		String state  = JSPTabControlUtil.getTabPageState(ServletActionContext.getRequest(), "ProjectsTabs", "TestTab");
		//String testSort = ServletActionContext.getRequest().getParameter((new ParamEncoder("testTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
		//String areaSort = ServletActionContext.getRequest().getParameter((new ParamEncoder("areaTable")).encodeParameterName(TableTagParameters.PARAMETER_SORT));
		
		//System.out.print(bugSort);
		//System.out.print(testSort);
		//System.out.print(areaSort);
		System.out.print(JSPTabControlUtil.getSelectedTabPageName(ServletActionContext.getRequest(), "ProjectsTabs"));

		return "projects";
	 }

	 
	 
	 
//---------------------------------------------------------------------------------------------------------------------------
	
	 
	 private void fillLists() {
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
	 
	 private void sortDsc(String element) {
		 List<String> tmpList = new ArrayList<String>();
		 switch(element) {
		 	case "sortBug": 
		 		for (BugBean el : bugObjList) tmpList.add(el.getTitle());
				 Collections.reverse(tmpList); 
				 bugObjList.clear(); 
				 for (String str : tmpList) bugObjList.add(DataProvider.mapBugs.get(str));
				 this.tab= "bug";
				 System.out.print(tab); 
				
			 break;
		 	case "sortTest":
				 for (TestBean el : testObjList) tmpList.add(el.getTitle());
				 Collections.reverse(tmpList); 
				 testObjList.clear(); 
				 for (String str : tmpList) testObjList.add(DataProvider.mapTests.get(str));
				 this.tab= "test";
				 System.out.print(tab); 
			 break;
		 	case "sortArea":
				 for (AreaBean el : areaObjList) tmpList.add(el.getTitle());
				 Collections.reverse(tmpList); 
				 areaObjList.clear(); 
				 for (String str : tmpList) areaObjList.add(DataProvider.mapAreas.get(str));
				 this.tab= "area";
				 System.out.print(tab); 
			 break;	
		 } 
	 }
	 
	 

	public List<BugBean> getBugObjList() {
		return bugObjList;
	}


	

	public String getSort() {
		return sort;
	}




	public void setSort(String sort) {
		this.sort = sort;
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
	 
	 
}