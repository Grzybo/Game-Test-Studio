package com.bartosz.gameteststudio.create.action;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.Platform;
import com.bartosz.gameteststudio.dp.PlatformFabric;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "editPlatforms", //
results = { //
        @Result(name = "cratePlatforms", location = "/WEB-INF/pages/edit_pages/editPlatforms.jsp")
} //
)

public class PlatformCreateAction  extends ActionSupport {
  

	private static final long serialVersionUID = 1L; 
	
	private String platformName;
	private List<String> platformList = PlatformFabric.keys();
	private List<String> selectedPlatforms = new ArrayList<String>();

	@Override
    public String execute() {
          
    	if(platformName != null) {
    		if(!PlatformFabric.keys().contains(platformName)){
    			PlatformFabric.add(platformName, new Platform(platformName));
    			addActionError("Platform created!");
    		}
    		else addActionError("Platform already exists!");
    	}	
		
            return "cratePlatforms";
    	}

	
	
	
	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
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
    
   
    
  
 




