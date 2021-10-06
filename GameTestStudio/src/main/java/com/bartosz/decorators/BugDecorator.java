package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;
import com.bartosz.gameteststudio.dp.Bug;

public class BugDecorator extends TableDecorator {

	private String titleLink;
	
	
	
	public String getTitleLink() {
		Bug bug = (Bug)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editBug?itemID=" + bug.getId() + "\">" + bug.getTitle() + "</a>";
		//return "" + "[] "+ bug.getTitle();
	}



	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}



	
}
