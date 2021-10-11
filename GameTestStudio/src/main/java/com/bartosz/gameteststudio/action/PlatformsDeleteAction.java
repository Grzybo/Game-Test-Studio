package com.bartosz.gameteststudio.action;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.DataProvider;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "deletePlatforms", //
results = { //
        @Result(name = "cratePlatforms", location = "/WEB-INF/pages/edit_pages/editPlatforms.jsp")
} //
)

public class PlatformsDeleteAction  extends ActionSupport {
  

	private static final long serialVersionUID = 1L; 
	
	private List<String> platformList = new ArrayList<String>(DataProvider.mapPlatforms.keySet()); 
	private List<String> selectedPlatforms = new ArrayList<String>();

	@Override
    public String execute() {
          
    	if(!selectedPlatforms.isEmpty()) {
    //		DataProvider.mapPlatforms.remove(selectedPlatforms);
    	}	
            //TODO zrobic cos z tym 
    		return "cratePlatforms";
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
	
	
    	 
    }
    
   
    
  
 




