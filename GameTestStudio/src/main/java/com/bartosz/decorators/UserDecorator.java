package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.UserBean;

public class UserDecorator extends TableDecorator {


	public String getEmailLink() {
		UserBean user = (UserBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editAccount?itemID=" + user.getId() + "\">" + user.getEmail() + "</a>";
	}

	public String getDeleteLink() {
		UserBean user = (UserBean)getCurrentRowObject();
		return "<button class=\"deleteBtn\" onclick=\"deleteConfirm('UserFromAdmin', " + user.getId() + ")\">Delete</button>"; 
	}

}
