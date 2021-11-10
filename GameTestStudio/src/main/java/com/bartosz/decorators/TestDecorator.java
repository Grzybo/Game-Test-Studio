package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.TestBean;

public class TestDecorator extends TableDecorator {

	private String titleLink;
	private String deleteLink;
	
	public String getTitleLink() {
		TestBean test = (TestBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editTest?itemID=" + test.getId() + "\">" + test.getTitle() + "</a>";
	}


	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}

	public String getDeleteLink() {
		TestBean test = (TestBean)getCurrentRowObject();
		return "<button class=\"deleteBtn\" onclick=\"deleteConfirm('TestFromProjects', " + test.getId() + ")\">Delete</button>"; 
	}

	
}
