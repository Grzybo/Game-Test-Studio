package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.UserBean;

public class UserDecorator extends TableDecorator {

	private String emailLink;
	
	
	public String getEmailLink() {
		UserBean user = (UserBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editAccount?itemID=" + user.getId() + "\">" + user.getEmail() + "</a>";
	}

	



	
}
