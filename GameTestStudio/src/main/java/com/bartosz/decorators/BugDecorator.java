package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;
import com.bartosz.gameteststudio.dp.Bug;

public class BugDecorator extends TableDecorator {

	private String title;
	
	public String getTitle() {
		
		Bug bug = (Bug)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editBug?itemID=" + bug.getId() + "/>" + bug.getTitle() + "</a>";
	}
}
