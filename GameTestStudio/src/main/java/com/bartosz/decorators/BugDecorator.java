package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.BugBean;

public class BugDecorator extends TableDecorator {


	
	public String getTitleLink() {
		BugBean bug = (BugBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editBug?itemID=" + bug.getId() + "\">" + bug.getTitle() + "</a>";
	}


	public String getDeleteLink() {
		BugBean bug = (BugBean)getCurrentRowObject();
		return "<button class=\"deleteBtn\" onclick=\"deleteConfirm('BugFromProjects', " + bug.getId() + ")\">Delete</button>"; 
	}
}
