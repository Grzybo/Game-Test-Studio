package com.bartosz.gameteststudio.create.action;
 
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
import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;
 
@Action(value = "createBug", //
results = { //
        @Result(name = "createBug", location = "/WEB-INF/pages/create_pages/createBug.jsp"),
        @Result(name = "created", type="redirect", location = "/projects"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)
public class BugCreateAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
 
    HttpSession session = ServletActionContext.getRequest().getSession();
    
    private String title;
    private String account;
    private String priority; 
    private String state;
    private String description;
    private String reproSteps;
    private String test;
    private String platform;
    private String issue;
    private int reproFrequency;
    private String reproStr;
    private List<String> reproList = Arrays.asList("100", "75", "50", "25");
  
	private List<String> selectedPlatforms = new ArrayList<String>();
    private List<PlatformBean> selectedPlatformsList;
    
    private String build;
	private Double version = 0.0;
	private int minKitNumber;
	AttachmentBean att;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	private String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userFiles");
	
	ProjectBean project = DataProvider.mapProjects.get(session.getAttribute("userProject").toString());
    
    private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet());
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	private List<String> testList = new ArrayList<String>();
	private List<String> platformList = project.getPlatformsStringList();
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = new ArrayList<String>(DataProvider.mapResults.keySet());
	private List<String> buildList = new ArrayList<String>(DataProvider.mapBuilds.keySet());
	private List<String> issuesList = new ArrayList<String>(DataProvider.getIssues().keySet());
	List<AttachmentBean> listAtt = new ArrayList<AttachmentBean>();
    
	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {

    	Utils.setTab("BugTab");

    	fillLists();

    	String ret = "createBug";
    	
    	if(!Strings.isNullOrEmpty(title)) {
    		if(!Strings.isNullOrEmpty(this.description)) {
    			if(!Strings.isNullOrEmpty(this.reproSteps)) {
    				if(!Strings.isNullOrEmpty(this.test)) {
    						createBug();
            				ret = "created";
    				}else addActionError("Bug has to be assigned to test.");
            	}else addActionError("Repro Steps field cannot be empty.");
        	}else addActionError("Description field cannot be empty.");
    	}else addActionError("Title field cannot be empty.");

    	
    	return ret;
	}

	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
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
    
    private void createBug() throws IOException, NumberFormatException, GSException {
    	if(this.fileUpload != null) {
    		createAttachment();
        	
    		DataProvider.saveBug(new BugBean(title, DataProvider.mapUsers.get(account), description, reproSteps,
    				DataProvider.getStates().get(state), DataProvider.getPriorities().get(priority), selectedPlatforms,  
    				version, minKitNumber, DataProvider.mapTests.get(test), DataProvider.getIssues().get(issue),
    				Integer.parseInt(reproStr), DataProvider.mapBuilds.get(build),
    				DataProvider.getAttchmentByID(this.att.getId())));
    	}
    	else {    		
    		DataProvider.saveBug(new BugBean(title, DataProvider.mapUsers.get(account), description, reproSteps,
    				DataProvider.getStates().get(state), DataProvider.getPriorities().get(priority), selectedPlatforms,  
    				version, minKitNumber, DataProvider.mapTests.get(test), DataProvider.getIssues().get(issue),
    				Integer.parseInt(reproStr), DataProvider.mapBuilds.get(build)));
    	}
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
    
    
    
    

	public String getIssue() {
		return issue;
	}







	public String getFilePath() {
		return filePath;
	}







	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}







	public void setIssue(String issue) {
		this.issue = issue;
	}


	public int getReproFrequency() {
		return reproFrequency;
	}







	public void setReproFrequency(int reproFrequency) {
		this.reproFrequency = reproFrequency;
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







	public List<String> getSelectedPlatforms() {
		return selectedPlatforms;
	}







	public void setSelectedPlatforms(List<String> selectedPlatforms) {
		this.selectedPlatforms = selectedPlatforms;
	}







	public List<PlatformBean> getSelectedPlatformsList() {
		return selectedPlatformsList;
	}







	public void setSelectedPlatformsList(List<PlatformBean> selectedPlatformsList) {
		this.selectedPlatformsList = selectedPlatformsList;
	}







	public List<String> getIssuesList() {
		return issuesList;
	}







	public void setIssuesList(List<String> issuesList) {
		this.issuesList = issuesList;
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