package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.ProjectBean;

public class ProjectDecorator extends TableDecorator {


	
	public String getTitleLink() {
		ProjectBean project = (ProjectBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editProject?itemID=" + project.getId() + "\">" + project.getTitle() + "</a>";
	}


	public String getDeleteLink() {
		ProjectBean project = (ProjectBean)getCurrentRowObject();
		return "<button class=\"deleteBtn\" onclick=\"deleteConfirm('ProjectFormAdmin', " + project.getId() + ")\">Delete</button>"; 
	}

	
}
