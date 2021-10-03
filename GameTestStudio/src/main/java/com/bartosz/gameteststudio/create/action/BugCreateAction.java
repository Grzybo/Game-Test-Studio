package com.bartosz.gameteststudio.create.action;
 
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.AreaFabric;
import com.bartosz.gameteststudio.dp.Attachment;
import com.bartosz.gameteststudio.dp.Bug;
import com.bartosz.gameteststudio.dp.BugFabric;
import com.bartosz.gameteststudio.dp.BuildTypeFabric;
import com.bartosz.gameteststudio.dp.Platform;
import com.bartosz.gameteststudio.dp.PlatformFabric;
import com.bartosz.gameteststudio.dp.PriorityFabric;
import com.bartosz.gameteststudio.dp.ResultFabric;
import com.bartosz.gameteststudio.dp.StateFabric;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.bartosz.gameteststudio.dp.Version;
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
    private String area;
    private String platform;
   
    private List<String> selectedPlatforms = new ArrayList<String>();
    private List<Platform> selectedPlatformsList;
    
    private String build;
	private Double version;
	private int minKitNumber;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	private Attachment att;
	private Version ver; 
    
    private List<String> priorityList = PriorityFabric.keys();
	private List<String> stateList = StateFabric.keys();
	private List<String> areaList = new ArrayList<String>();
	private List<String> platformList = PlatformFabric.keys();
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = ResultFabric.keys();
	private List<String> buildList = BuildTypeFabric.keys();
    
    @Override
    public String execute() {
          
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	
    	
    	
    	for (String el : UserFabric.keys()) {
    		if(UserFabric.getUserByEmail(el).getProjects() != null) {
    			if(UserFabric.getUserByEmail(el).getProjectsList().
    					contains(session.getAttribute("userProject"))) {
    				accountList.add(el);
    			}
    		}	
		} 
    	
    	for (String el : AreaFabric.keys()) {
			if(AreaFabric.getArea(el).getProject().getTitle()
					.equals(session.getAttribute("userProject").toString())){
				areaList.add(el);
			}
		}
    	
    	if(!selectedPlatforms.isEmpty()) {
    		for (String pl : selectedPlatforms) {
        		selectedPlatformsList.add(PlatformFabric.getPlatform(pl));
    		}
        	
    	}
    	
    	
    	if(title != null) {
    		Bug bug = new Bug();
        	
        	bug.setTitle(title);
        	bug.setUser(UserFabric.getUserByEmail(account));
        	bug.setDescription(description);
        	bug.setReproSteps(reproSteps);
        	bug.setState(StateFabric.getState(state));
        	bug.setPriority(PriorityFabric.getPriority(priority));
        	bug.setPlatforms(selectedPlatformsList);
        	bug.setVersion(new Version(version, BuildTypeFabric.get(build)));
        	bug.setArea(AreaFabric.getArea(area));
        	bug.setAttachment(att);
          	
        	BugFabric.add(bug.getTitle(), bug);
        	
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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