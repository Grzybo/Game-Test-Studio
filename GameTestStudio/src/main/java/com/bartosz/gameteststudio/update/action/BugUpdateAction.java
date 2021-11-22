package com.bartosz.gameteststudio.update.action;
 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.AttachmentBean;
import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
 
@Action(value = "updateBug", //
results = { //
        @Result(name = "update", location = "/WEB-INF/pages/edit_pages/editBug.jsp"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class BugUpdateAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
 
    private String itemID;
    
    private String title;
    private String account;
    private String priority; 
    private String state;
    private String description;
    private String reproSteps;
    private String area;
    private List<String> platforms;
    private String test;
    private String issue;
    //file
    private String build;
	private Double version;
	private int minKitNumber;
	private BugBean newBug;
	
	HttpSession session = ServletActionContext.getRequest().getSession();
	
	private String reproStr;
    private List<String> reproList = Arrays.asList("100", "75", "50", "25");
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userFiles");  
	private String fileID;
	AttachmentBean att;
	
	private BugBean bug;
	
    private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet());
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	private List<String> areaList = new ArrayList<String>();
	private List<String> platformList;
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = new ArrayList<String>(DataProvider.mapResults.keySet());
	private List<String> buildList = new ArrayList<String>(DataProvider.mapBuilds.keySet());
	private List<String> testList = new ArrayList<String>();
	private List<String> issuesList = new ArrayList<String>(DataProvider.getIssues().keySet());
    
    
    private void newBug(BugBean oldBug) {
    	newBug.setTitle(this.title);
    	newBug.setUser(DataProvider.mapUsers.get(account));
    	newBug.setDescription(description);
    	newBug.setReproSteps(reproSteps);
    	newBug.setState(DataProvider.getStates().get(state));
    	newBug.setPriority(DataProvider.getPriorities().get(priority));
    	newBug.setPlatformsList(platforms);
    	newBug.setTest(DataProvider.mapTests.get(test));
    	newBug.setVersion(version);
    	newBug.setBuild(DataProvider.mapBuilds.get(build));
    	newBug.setTest(DataProvider.mapTests.get(test)); 
    	newBug.setId(oldBug.getId());
    	newBug.setIssueType(DataProvider.getIssues().get(issue));
    	newBug.setReproFrequency(Integer.parseInt(reproStr));
    	newBug.setMinKitNumber(minKitNumber);
    	newBug.setAttachment(att);
    }
    
    
    
    private void createAttachment() throws IOException {
    	String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userFiles");  
		att = new AttachmentBean(fileUploadFileName ,fileUploadContentType, filePath);
		DataProvider.saveAttachment(att);
		String name = att.getId() + "." + att.getFileType().split("/")[1];
		File file = new File(filePath + "/" +  name);
		DataProvider.updateAttachmentName(att, name);
    	FileUtils.copyFile(fileUpload, file);
    }

    public List<String> getPlatforms() {
		return platforms;
	}


	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
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

	public String getReproStr() {
		return reproStr;
	}





	public AttachmentBean getAtt() {
		return att;
	}

	public void setAtt(AttachmentBean att) {
		this.att = att;
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





	public String getItemID() {
		return itemID;
	}


	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}


	public void setItemID(String itemID) {
		this.itemID = itemID;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {

    	
		fillLists();
    	
    	bug = DataProvider.getBugById(Integer.parseInt(itemID));
    	newBug = new BugBean(); 
    	
    	fillAttachmentFileds();
    	
    	platformList = bug.getTest().getArea().getProject().getPlatformsStringList();
    	
    	
    	if(!Strings.isNullOrEmpty(title)) {
    		if(!Strings.isNullOrEmpty(this.description)) {
    			if(!Strings.isNullOrEmpty(this.reproSteps)) {
    				if(version != null) {
    					newBug(bug);
        				if(fileUpload != null) {	
        		    		createAttachment();
        		 			newBug.setAttachment(DataProvider.getAttchmentByID(att.getId())); 
        		 			fileID = att.getId().toString();
        		    	}
        				DataProvider.updateBug(bug, newBug);
        				addActionError("Bug Updated!"); 
    				}else addActionError("Repro Steps field cannot be empty.");
            	}else addActionError("Repro Steps field cannot be empty.");
        	}else addActionError("Description field cannot be empty.");
    	}else addActionError("Title field cannot be empty.");

    	return "update";
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	} 
	
	
	private void fillLists() {
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
	} 
	
	private void fillAttachmentFileds() {
		if(bug.getAttachment() != null) {
    		att = bug.getAttachment();
    		fileUploadFileName = bug.getAttachment().getFileName();
        	fileUploadContentType = bug.getAttachment().getFileType();
        	filePath = bug.getAttachment().getFilePath(); 
        	fileID = bug.getAttachment().getId().toString();
    	}
	} 
    
}