package com.bartosz.gameteststudio.update.action;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.action.SecureAction;
import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.utils.Utils;
import com.google.common.base.Strings;

/**
 * Akcja odpowiada za aktualizację obiektu testu.
 * @author Bartosz
 *
 */
@Action(value = "updateTest", //
results = { //
        @Result(name = "update", location = "/WEB-INF/pages/edit_pages/editTest.jsp"), 
        @Result(name = "noPermissions",  type="redirect", location = "/noPermissions"), 
        @Result(name = "sessionExpired",  type="redirect", location = "/sessionExpired")
} //
)


public class TestUpdateAction  extends SecureAction {
  
    private static final long serialVersionUID = 1L;
 
    private String itemID;
    private String title;
    private String account;
    private String priority; 
    private String state;
    private String description; 
    private String area;
    private List<String> selectedPlatforms = new ArrayList<String>();
    private Double  estimatedTime; 
    private Integer testersNumber;
	private Double  workTime;
	private String startDate;
	private String endDate;
	private String result;
	private String build;
	private Double version;

	HttpSession session = ServletActionContext.getRequest().getSession();    	
    
    private List<String> priorityList = new ArrayList<String>(DataProvider.getPriorities().keySet());
	private List<String> stateList = new ArrayList<String>(DataProvider.getStates().keySet());
	private List<String> areaList = new ArrayList<String>();
	private List<String> platformList = new ArrayList<String>(); //DataProvider.mapPlatforms.keySet()); // TYMCZASOWO
	private List<String> accountList = new ArrayList<String>();
	private List<String> resultList = new ArrayList<String>(DataProvider.mapResults.keySet());
	private List<String> buildList = new ArrayList<String>(DataProvider.mapBuilds.keySet());

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


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	


	public List<String> getSelectedPlatforms() {
		return selectedPlatforms;
	}


	public void setSelectedPlatforms(List<String> selectedPlatforms) {
		this.selectedPlatforms = selectedPlatforms;
	}


	public Double  getEstimatedTime() {
		return estimatedTime;
	}


	public void setEstimatedTime(Double  estimatedTime) {
		this.estimatedTime = estimatedTime;
	}


	public Integer getTestersNumber() {
		return testersNumber;
	}


	public void setTestersNumber(Integer testersNumber) {
		this.testersNumber = testersNumber;
	}


	public Double  getWorkTime() {
		return workTime;
	}


	public void setWorkTime(Double  workTime) {
		this.workTime = workTime;
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


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
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


	public String getItemID() {
		return itemID;
	}


	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	/**
	 * Główna logika akcji.
	 */
	@Override
	public String executeSecured() throws GSException, NumberFormatException, IOException {

    	fillLists();

    	if(!Strings.isNullOrEmpty(title)) {
    		if(!Strings.isNullOrEmpty(this.description)) {
    			updateTest();
        	}else addActionError("Description field cannot be empty.");
    	}else addActionError("Title field cannot be empty.");
    	
    	return "update";
	}


	/**
	 * Lista ról z dostępem do akcji.
	 */ 
	@Override
	protected Set<Long> allowedRolesID() {
		return Utils.setAllowedRolesID(this.getClass().getSimpleName());
	}
    
	/**
	 * Metoda aktualizuje obiekt testu zapisując obiekt zawierający zmiany.
	 * @throws NumberFormatException
	 * @throws GSException
	 */
	private void updateTest() throws NumberFormatException, GSException {
		TestBean test = DataProvider.getTestByID(Long.parseLong(itemID));
    	TestBean newTest = new TestBean();
    	platformList = test.getArea().getProject().getPlatformsStringList();
		newTest.setTitle(title);
    	newTest.setUser(DataProvider.mapUsers.get(account));
    	newTest.setPriority(DataProvider.getPriorities().get(priority));
    	newTest.setState(DataProvider.getStates().get(state));
    	newTest.setDescription(description);
    	newTest.setArea(DataProvider.getAreaByTitle(area));
    	newTest.setEstimatedTime(estimatedTime);
    	newTest.setWorkTime(workTime);
    	newTest.setTestersNumber(testersNumber);
    	newTest.setStartDate(startDate);
    	newTest.setEndDate(endDate);
    	newTest.setId(test.getId());
    	newTest.setBuild(DataProvider.mapBuilds.get(build));
    	newTest.setResult(DataProvider.mapResults.get(result)); 
    	newTest.setVersion(version);
    	newTest.setPlatforms(selectedPlatforms);
    	
    	DataProvider.updateTest(test, newTest);
	} 
	
	/**
	 * Metoda wypełnia listy użytkowników i obszarów do wyboru.
	 */
	private void fillLists() {
		for (String el : DataProvider.mapUsers.keySet()) {
    		if(DataProvider.mapUsers.get(el).getProjects() != null) {
    			if(DataProvider.mapUsers.get(el).getProjectsList().
    					contains(session.getAttribute("userProject"))) {
    				accountList.add(el);
    			}
    		}	
		} 
    	    	
    	for(AreaBean area : DataProvider.getAllAreas()) {
    		if(area.getProject().getTitle().equals(session.getAttribute("userProject").toString())) {
    			areaList.add(area.getTitle());
    		}
    	}
	}
}