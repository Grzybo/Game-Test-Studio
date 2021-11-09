package com.bartosz.gameteststudio.edit.action;
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editBug", //
results = { //
        @Result(name = "editBug", location = "/WEB-INF/pages/edit_pages/editBug.jsp")
} //
)
public class BugEditAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    
    private String itemID;
    
    private String title;
    private String account;
    private String priority; 
    private String state;
    private String description;
    private String reproSteps;
    //private String area;
    private String test; 
    private String platform;
    private String issue;
    private List<String> platforms;
    //file
    private String build;
	private Double version;
	private int minKitNumber;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String filePath; 
	private String fileID;
	
	private String reproStr;
    private List<String> reproList = Arrays.asList("100", "75", "50", "25");
    
    private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet()); 
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	private List<String> areaList = new ArrayList<String>();
	private List<String> testList = new ArrayList<String>();
	private List<String> platformList;
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = new ArrayList<String>(DataProvider.mapResults.keySet());
	private List<String> buildList = new ArrayList<String>(DataProvider.mapBuilds.keySet());
	private List<String> issuesList = new ArrayList<String>(DataProvider.getIssues().keySet());
    
    @Override
    public String execute() throws IOException {
          
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	session.setAttribute("selectedTab", "BugTab");
    	
    	
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
    	
    	BugBean bug = DataProvider.getBugById(Integer.parseInt(itemID));
    	
    	
    	platformList = bug.getTest().getArea().getProject().getPlatformsStringList();
    	
    	title = bug.getTitle(); 
    	account = bug.getUser().getEmail();
    	description = bug.getDescription(); 
    	reproSteps = bug.getReproSteps();
    	state = bug.getState().getName(); 
    	priority = bug.getPriority().getName();
    	platforms = bug.getPlatformList();
    	version = bug.getVersion();
    	build = bug.getBuild().getName();
    	test = bug.getTest().getTitle(); 
    	minKitNumber = bug.getMinKitNumber(); 
    	platforms = bug.getPlatformList();
    	reproStr = String.valueOf(bug.getReproFrequency());
    	issue = bug.getIssueType().getName();

    	
    	if(bug.getAttachment() != null) {
    		fileUploadFileName = bug.getAttachment().getFileName();
        	fileUploadContentType = bug.getAttachment().getFileType();
        	filePath = bug.getAttachment().getFilePath(); 
        	fileID = bug.getAttachment().getId().toString();
    	}
    	

    	return "editBug";
    }


    public List<String> getPlatforms() {
		return platforms;
	}


	public String getItemID() {
		return itemID;
	}


	public String getTest() {
		return test;
	}

  
	
	
	public String getFileID() {
		return fileID;
	}


	public void setFileID(String fileID) {
		this.fileID = fileID;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public void setTest(String test) {
		this.test = test;
	}


	public String getIssue() {
		return issue;
	}


	public String getReproStr() {
		return reproStr;
	}


	public void setReproStr(String reproStr) {
		this.reproStr = reproStr;
	}


	public List<String> getReproList() {
		return reproList;
	}


	public void setReproList(List<String> reproList) {
		this.reproList = reproList;
	}


	public void setIssue(String issue) {
		this.issue = issue;
	}


	public List<String> getIssuesList() {
		return issuesList;
	}


	public void setIssuesList(List<String> issuesList) {
		this.issuesList = issuesList;
	}


	public List<String> getTestList() {
		return testList;
	}


	public void setTestList(List<String> testList) {
		this.testList = testList;
	}


	public void setItemID(String itemID) {
		this.itemID = itemID;
	}


	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
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

	public List<String> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
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