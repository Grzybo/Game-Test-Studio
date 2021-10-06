package com.bartosz.decorators;

import org.displaytag.decorator.TableDecorator;
import com.bartosz.gameteststudio.dp.Area;

public class AreaDecorator extends TableDecorator {

	private String titleLink;
	
	public String getTitleLink() {
		Area area = (Area)getCurrentRowObject();
		return "<a href=\"${pageContext.request.contextPath}/editArea?itemID=" + area.getId() + "\">" + area.getTitle() + "</a>";
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}



	
}
