package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;
import com.bartosz.gameteststudio.dp.Test;

public class TestDecorator extends TableDecorator {

	private String titleLink;
	
	public String getTitleLink() {
		Test test = (Test)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editTest?itemID=" + test.getId() + "\">" + test.getTitle() + "</a>";
	}


	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}



	
}
