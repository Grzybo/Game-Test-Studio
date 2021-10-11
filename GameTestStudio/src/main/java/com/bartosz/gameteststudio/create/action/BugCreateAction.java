package com.bartosz.gameteststudio.create.action;
 
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.AttachmentBean;
import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.VersionBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createBug", //
results = { //
        @Result(name = "createBug", location = "/WEB-INF/pages/create_pages/createBug.jsp")
} //
)
public class BugCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String title;
    private String account;
    private String priority; 
    private String state;
    private String description;
    private String reproSteps;
    private String test;
    private String platform;
   
    private List<String> selectedPlatforms = new ArrayList<String>();
    private List<PlatformBean> selectedPlatformsList;
    
    private String build;
	private Double version;
	private int minKitNumber;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	private AttachmentBean att;
	//private Version ver; 
    
    private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet());
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	private List<String> testList = new ArrayList<String>();
	private List<String> platformList;
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = new ArrayList<String>(DataProvider.mapResults.keySet());
	private List<String> buildList = new ArrayList<String>(DataProvider.mapBuilds.keySet());
    
    @Override
    public String execute() {
          
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	ProjectBean project = DataProvider.mapProjects.get(session.getAttribute("userProject").toString());
    	
    	platformList = project.getPlatformsStringList();
    	
    	for (String el : DataProvider.mapUsers.keySet()) {
    		if(DataProvider.mapUsers.get(el).getProjects() != null) {
    			if(DataProvider.mapUsers.get(el).getProjectsList().
    					contains(session.getAttribute("userProject"))) {
    				accountList.add(el);
    			}
    		}	
		} 
    	
    	for (String el : DataProvider.mapTests.keySet()) {
			if(DataProvider.mapTests.get(el).getArea().getProject().getTitle()
					.equals(session.getAttribute("userProject").toString())){
				testList.add(el);
			}
		}
    	
    	if(!selectedPlatforms.isEmpty()) {
    		for (String pl : selectedPlatforms) {
        		selectedPlatformsList.add(DataProvider.mapPlatforms.get(pl));
    		}
        	
    	}
    	
    	
    	if(title != null) {
    		BugBean bug = new BugBean();
        	
    		bug.setId((long)DataProvider.mapBugsId.keySet().size() + 1);  
    		bug.setTitle(title);
        	bug.setUser(DataProvider.mapUsers.get(account));
        	bug.setDescription(description);
        	bug.setReproSteps(reproSteps);
        	bug.setState(DataProvider.getStates().get(state));
        	bug.setPriority(DataProvider.getPriorities().get(priority));
        	bug.setPlatforms(selectedPlatformsList);
        	bug.setVersion(new VersionBean(version, DataProvider.mapBuilds.get(build)));
        	bug.setTest(DataProvider.mapTests.get(test));
        	bug.setAttachment(att);
          	
        	DataProvider.mapBugs.put(bug.getTitle(), bug);
        	
        	addActionError("Bug created!");
    	}else {
    		addActionError("Title field cannot be empty");
    	}
    	
    	
    	
    	return "createBug";
    } 
    
    
    
    
    
    

	public List<String> getList() {
		return selectedPlatforms;
	}







	public void setList(List<String> list) {
		this.selectedPlatforms = list;
	}







	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReproSteps() {
		return reproSteps;
	}

	public void setReproSteps(String reproSteps) {
		this.reproSteps = reproSteps;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String area) {
		this.test = area;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}

	public int getMinKitNumber() {
		return minKitNumber;
	}

	public void setMinKitNumber(int minKitNumber) {
		this.minKitNumber = minKitNumber;
	}

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	public List<String> getPriorityList() {
		return priorityList;
	}

	public void setPriorityList(List<String> priorityList) {
		this.priorityList = priorityList;
	}

	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}

	public List<String> getTestList() {
		return testList;
	}

	public void setTestList(List<String> areaList) {
		this.testList = areaList;
	}

	public List<String> getPlatformList() {
		return platformList;
	}

	public void setPlatformList(List<String> platformList) {
		this.platformList = platformList;
	}

	public List<String> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<String> accountList) {
		this.accountList = accountList;
	}

	public List<String> getResultList() {
		return resultList;
	}

	public void setResultList(List<String> resultList) {
		this.resultList = resultList;
	}

	public List<String> getBuildList() {
		return buildList;
	}

	public void setBuildList(List<String> buildList) {
		this.buildList = buildList;
	}
    
}