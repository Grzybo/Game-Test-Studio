package net.sourceforge.jsptabcontrol.characteristics;

import java.util.Iterator;
import java.util.List;

import net.sourceforge.jsptabcontrol.config.InsertJavascript;
import net.sourceforge.jsptabcontrol.config.InsertStyleClass;
import net.sourceforge.jsptabcontrol.config.TabPageStateConfig;

/**
 * Tab page characteristics.
 * @version 1.0.0 
 * @author <a href="mailto:angelo.zerr@gmail.com">Angelo ZERR</a>
 */
public class TabPageCharacteristics extends TabPageStateConfig {
	
	private TabControlCharacteristics parentTabControlCharacteristics ;
	private String tabPageName;	// tab page name
	private boolean selectedTab;	// true if tab page is selected and false otherwise
	
	
		
	public TabPageCharacteristics(TabControlCharacteristics parentTabControlCharacteristics, String tabPageName) {
		this.parentTabControlCharacteristics = parentTabControlCharacteristics;
		this.tabPageName = tabPageName;
		this.selectedTab = false;
	}	

	/**
	 * @return Returns the tabPageName.
	 */
	public String getTabPageName() {
		return tabPageName;
	}
	
	/**
	 * @return Returns the selectedTab.
	 */
	public boolean isSelectedTab() {
		return selectedTab;
	}
	/**
	 * @param selectedTab The selectedTab to set.
	 */
	public void setSelectedTab(boolean selectedTab) {
		this.selectedTab = selectedTab;
		this.parentTabControlCharacteristics.setSelectedTabPageName(tabPageName);
	}
	
	public void updateCharacteristics(TabPageStateConfig tabPageStateConfig) {
		if (tabPageStateConfig != null) {
			super.setVisible(tabPageStateConfig.isVisible());
			// Javascript
			List insertJavascriptList = tabPageStateConfig.getInsertJavascriptList();
			for (Iterator iter = insertJavascriptList.iterator(); iter
					.hasNext();) {
				InsertJavascript insertJavascript = (InsertJavascript) iter.next();
				super.addInsertJavascript(insertJavascript);
			}
			// Stylesheet
			List insertStylesheetList = tabPageStateConfig.getInsertStyleClassList();
			for (Iterator iter = insertStylesheetList.iterator(); iter
					.hasNext();) {
				InsertStyleClass insertStyleClass = (InsertStyleClass) iter.next();
				super.addInsertStyleClass(insertStyleClass);
			}		
			// State name
			super.setName(tabPageStateConfig.getName());
		}
	}
}
