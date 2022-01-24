package com.bartosz.gameteststudio.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Akcja odpowiada za ekran informujący o braku dostępu do danej akcji.
 * @author Bartosz
 *
 */
@Action(value = "noPermissions", //
results = { //
        @Result(name = "noPermissions", location = "/WEB-INF/pages/secureError.jsp")
} //
)
public class NoPermissionsAction extends ActionSupport {
		
	private static final long serialVersionUID = 7646722546122824316L;

	@Override
	    public String execute() {
		 return "noPermissions";
	 }

	 
}
