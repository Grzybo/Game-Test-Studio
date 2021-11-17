package com.bartosz.gameteststudio.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Action(value = "sessionExpired", //
results = { //
        @Result(name = "sessionExpired", location = "/WEB-INF/pages/sessionExpired.jsp")
} //
)
public class SessionExpiredAction extends ActionSupport {

	private static final long serialVersionUID = -8457623456978440636L;

	@Override
	    public String execute() {
		 return "sessionExpired";
	 }

	 
}
