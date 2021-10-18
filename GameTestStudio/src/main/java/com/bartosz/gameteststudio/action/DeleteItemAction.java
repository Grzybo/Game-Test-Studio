package com.bartosz.gameteststudio.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.bartosz.gameteststudio.dp.DataProvider;
import com.opensymphony.xwork2.ActionSupport;


@Action(value = "deleteItem", //
results = { //
        @Result(name = "deleteItem", location = "/WEB-INF/pages/projects.jsp")
} //
)
public class DeleteItemAction  extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String itemID;
	private String itemType;
	
	 @Override
	    public String execute() {

		 
		 /**
		  * 
		  switch(itemType) {
			 case "bug": 
				 DataProvider.mapBugs.remove(DataProvider.getBugById(Integer.parseInt(itemID)).getTitle());
				 DataProvider.mapBugsId.remove(Long.parseLong(itemID));
			 break;
			 case "test": 
				 DataProvider.mapBugs.remove(DataProvider.getBugById(Integer.parseInt(itemID)).getTitle());
				 DataProvider.mapBugsId.remove(Long.parseLong(itemID));
			 break;
			 case "area": 
				 DataProvider.mapBugs.remove(DataProvider.getBugById(Integer.parseInt(itemID)).getTitle());
				 DataProvider.mapBugsId.remove(Long.parseLong(itemID));
			 break;
		 }
		  * 
		  * 
		  */
		 System.out.print("deletepage");
		 return "deleteItem";
		  
		 
		

	 }

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	 
	 
}