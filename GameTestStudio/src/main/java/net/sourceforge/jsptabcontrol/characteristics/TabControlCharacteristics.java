package net.sourceforge.jsptabcontrol.characteristics;

import java.util.HashMap;
import java.util.Map;

/**
 * Tab control characteristics.
 * @version 1.0.0 
 * @author <a href="mailto:angelo.zerr@gmail.com">Angelo ZERR</a>
 *
 */
public class TabControlCharacteristics {

	private String tabControlName;	
	private String selectedTabPageName;
	
	private Map tabPageCharacteristicsMap;

	public TabControlCharacteristics(String tabControlName) {
		this.tabControlName = tabControlName;
		this.tabPageCharacteristicsMap = null;
		this.selectedTabPageName = null;
	}
	
	/**
	 * @return Returns the tabControlName.
	 */
	public String getTabControlName() {
		return tabControlName;
	}
	
	public void setTabPageCharacteristics(TabPageCharacteristics tabPageCharacteristics) {
		if (tabPageCharacteristicsMap == null) {
			tabPageCharacteristicsMap = new HashMap();
		}
		tabPageCharacteristicsMap.put(tabPageCharacteristics.getTabPageName(), tabPageCharacteristics);
	}
	
	public TabPageCharacteristics getTabPageCharacteristics(String tabPageName) {
		if (tabPageCharacteristicsMap != null)
			return (TabPageCharacteristics)tabPageCharacteristicsMap.get(tabPageName);
		return null;
	}
	
	
	/**
	 * @return Returns the selectedTabPageName.
	 */
	public String getSelectedTabPageName() {
		return selectedTabPageName;
	}
	/**
	 * @param selectedTabPageName The selectedTabPageName to set.
	 */
	public void setSelectedTabPageName(String selectedTabPageName) {
		this.selectedTabPageName = selectedTabPageName;
	}
}
