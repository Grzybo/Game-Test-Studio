package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;
import com.bartosz.gameteststudio.dp.User;

public class UserDecorator extends TableDecorator {

	private String emailLink;
	
	
	public String getEmailLink() {
		User user = (User)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editAccount?itemID=" + user.getId() + "\">" + user.getEmail() + "</a>";
	}

	



	
}
