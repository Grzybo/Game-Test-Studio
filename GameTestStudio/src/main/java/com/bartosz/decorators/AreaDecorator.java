package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.AreaBean;

public class AreaDecorator extends TableDecorator {

	private String titleLink;
	private String deleteLink;
	
	public String getTitleLink() {
		AreaBean area = (AreaBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editArea?itemID=" + area.getId() + "\">" + area.getTitle() + "</a>";
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}
	
	public String getDeleteLink() {
		AreaBean area = (AreaBean)getCurrentRowObject();
		return "<button class=\"deleteBtn\" onclick=\"deleteConfirm('AreaFromProjects', " + area.getId() + ")\">Delete</button>"; 
	}

}
