package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.BugBean;

public class BugDecorator extends TableDecorator {

	private String titleLink;
	private String deleteLink;
	
	public String getTitleLink() {
		BugBean bug = (BugBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editBug?itemID=" + bug.getId() + "\">" + bug.getTitle() + "</a>";
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}
	
	public String getDeleteLink() {
		BugBean bug = (BugBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/delete?itemID=" + bug.getId() + "?itemType=bug" + "\">" + "Delete" + "</a>";
	}
}
