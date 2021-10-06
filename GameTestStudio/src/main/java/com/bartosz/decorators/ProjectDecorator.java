package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;
import com.bartosz.gameteststudio.dp.Project;

public class ProjectDecorator extends TableDecorator {

	private String titleLink;
	
	public String getTitleLink() {
		Project project = (Project)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editProject?itemID=" + project.getId() + "\">" + project.getTitle() + "</a>";
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}



	
}
