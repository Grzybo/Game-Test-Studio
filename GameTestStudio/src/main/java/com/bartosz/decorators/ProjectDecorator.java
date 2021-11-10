package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.ProjectBean;

public class ProjectDecorator extends TableDecorator {

	private String titleLink;
	private String deleteLink;
	
	public String getTitleLink() {
		ProjectBean project = (ProjectBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editProject?itemID=" + project.getId() + "\">" + project.getTitle() + "</a>";
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}

	public String getDeleteLink() {
		ProjectBean project = (ProjectBean)getCurrentRowObject();
		return "<button class=\"deleteBtn\" onclick=\"deleteConfirm('ProjectFormAdmin', " + project.getId() + ")\">Delete</button>"; 
	}

	
}
