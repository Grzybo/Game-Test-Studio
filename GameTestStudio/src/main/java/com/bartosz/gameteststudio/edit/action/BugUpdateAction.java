package com.bartosz.gameteststudio.edit.action;
 
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.AreaFabric;
import com.bartosz.gameteststudio.dp.Bug;
import com.bartosz.gameteststudio.dp.BugFabric;
import com.bartosz.gameteststudio.dp.BuildTypeFabric;
import com.bartosz.gameteststudio.dp.PlatformFabric;
import com.bartosz.gameteststudio.dp.PriorityFabric;
import com.bartosz.gameteststudio.dp.ResultFabric;
import com.bartosz.gameteststudio.dp.StateFabric;
import com.bartosz.gameteststudio.dp.UserFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "updateBug", //
results = { //
        @Result(name = "update", location = "/WEB-INF/pages/edit_pages/editBug.jsp")
} //
)
public class BugUpdateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String itemID;
    
    private String title;
    private String account;
    private String priority; 
    private String state;
    private String description;
    private String reproSteps;
    private String area;
    private String platform;
    //file
    private String build;
	private Double version;
	private int minKitNumber;
	
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
    
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
    	
    	Bug bug = BugFabric.getById(Long.parseLong(itemID));
    	
    	
    	
    	//bug.setTitle(title);
    	bug.setUser(UserFabric.getUserByEmail(account));
    	bug.setPriority(PriorityFabric.getPriority(priority));
    	bug.setState(StateFabric.getState(state));
    	bug.setDescription(description);
    	bug.setArea(AreaFabric.getArea(area));
    	bug.setReproSteps(reproSteps);
    	
    	
    	
    	
    	return "update";
    }


    public String getItemID() {
		return itemID;
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