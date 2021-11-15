package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bartosz.gameteststudio.beans.TestBean;

public class TestDecorator extends TableDecorator {


	
	public String getTitleLink() {
		TestBean test = (TestBean)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editTest?itemID=" + test.getId() + "\">" + test.getTitle() + "</a>";
	}


	public String getDeleteLink() {
		TestBean test = (TestBean)getCurrentRowObject();
		return "<button class=\"deleteBtn\" onclick=\"deleteConfirm('TestFromProjects', " + test.getId() + ")\">Delete</button>"; 
	}

	
}
