package net.sourceforge.jsptabcontrol.util;

 
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import net.sourceforge.jsptabcontrol.JSPTabControlConstants;
import net.sourceforge.jsptabcontrol.JSPTabControlResources;
import net.sourceforge.jsptabcontrol.characteristics.TabControlCharacteristics;
import net.sourceforge.jsptabcontrol.characteristics.TabPageCharacteristics;
import net.sourceforge.jsptabcontrol.config.TabPageStateConfig;

/**
 * Description : Utils for manage tabs with Action Struts.
 * @version 1.0.0 
 * @author <a href="mailto:angelo.zerr@gmail.com">Angelo ZERR</a>
 */
public class JSPTabControlUtil {
	
	/**
	 * Select Tab Page <b>tabPageName</b> of Tab Control with name <b>tabControlName</b>.
	 * @param request
	 * @param tabsName tabs name
	 * @param tabName tab name
	 */
	public static void setSelectedTabPageName(ServletRequest request, String tabControlName, String tabPageName) {
		// Get tab page characteristics
		TabPageCharacteristics tabPageCharacteristics = getTabPageCharacteristics(request, tabControlName, tabPageName, true);
		tabPageCharacteristics.setSelectedTab(true);
	}
	
	/**
	 * Get name of selected tabPage of tabControl with name <b>tabControlName</b>.
	 * Return null, if tabControlName doesn't exist into request.
	 * @param request
	 * @param tabsName
	 * @return name of tabPage selected for tabControl tabControlName.
	 */
	public static String getSelectedTabPageName(ServletRequest request, String tabControlName) {
		// Test if selected tabPage was save into request
		TabControlCharacteristics tabControlCharacteristics  = getTabControlCharacteristics(request, tabControlName, false);
		if (tabControlCharacteristics != null) {
			String selectedTabPageName = tabControlCharacteristics.getSelectedTabPageName();
			if(selectedTabPageName != null)
				return selectedTabPageName;
		}
		// otherwise return parameter of request
		return request.getParameter(getInputHiddenName(tabControlName));
	}
	
	/**
	 * Set state to Tab Page <b>tabPageName</b> of Tab Control with name <b>tabControlName</b>.
	 * @param servletContext
	 * @param request
	 * @param tabControlName
	 * @param tabPageName
	 * @param stateName
	 */
	public static void setTabPageState(ServletContext servletContext, ServletRequest request, String tabControlName, String tabPageName, String stateName) {
		// Get tab page characteristics
		TabPageCharacteristics tabPageCharacteristics = getTabPageCharacteristics(request, tabControlName, tabPageName, true);
		// Get tab page state config
		TabPageStateConfig tabPageStateConfig = getTabPageStateConfig(servletContext, stateName);
		tabPageCharacteristics.updateCharacteristics(tabPageStateConfig);
	} 
	
	/**
	 * Get state to Tab Page <b>tabPageName</b> of Tab Control with name <b>tabControlName</b>.
	 * @param request
	 * @param tabControlName
	 * @param tabPageName
	 * @return
	 */
	public static String getTabPageState(ServletRequest request, String tabControlName, String tabPageName) {
		// Test if selected tabPage was save into request
		TabPageCharacteristics tabPageCharacteristics  = getTabPageCharacteristics(request, tabControlName, tabPageName, false);
		if (tabPageCharacteristics != null) {
			String stateName = tabPageCharacteristics.getName();
			if(stateName != null)
				return stateName;
		}
		// otherwise return parameter of request
		return request.getParameter(getInputStateHiddenName(tabControlName, tabPageName));
	}
	
	public static TabControlCharacteristics getTabControlCharacteristics(ServletRequest request, String tabControlName, boolean instanciateIfNotExist) {
		// Test if TabPageControlleur is into request
		String key = getTabControlCharacteristicsRequestKey(tabControlName);
		TabControlCharacteristics tabControlCharacteristics  = (TabControlCharacteristics)request.getAttribute(key);
		if (tabControlCharacteristics == null && instanciateIfNotExist) {
			tabControlCharacteristics = new TabControlCharacteristics(tabControlName);
			request.setAttribute(key, tabControlCharacteristics);
		}
		return tabControlCharacteristics;
	}
	
	public static TabPageCharacteristics getTabPageCharacteristics(ServletRequest request, String tabControlName, String tabPageName, boolean instanciateIfNotExist) {
		// 
		TabPageCharacteristics tabPageCharacteristics = null;
		TabControlCharacteristics tabControlCharacteristics  = getTabControlCharacteristics(request, tabControlName, instanciateIfNotExist);
		if (tabControlCharacteristics != null) {
			tabPageCharacteristics = tabControlCharacteristics.getTabPageCharacteristics(tabPageName);
			if (tabPageCharacteristics == null) {
				tabPageCharacteristics = new TabPageCharacteristics(tabControlCharacteristics, tabPageName);
				tabControlCharacteristics.setTabPageCharacteristics(tabPageCharacteristics);
			}
		}
		return tabPageCharacteristics;		
	}
	
	public static TabPageStateConfig getTabPageStateConfig(ServletContext servletContext, String stateName) {
		JSPTabControlResources resources  = getJSPTabControlResources(servletContext);
		if (resources != null) {
			return resources.getTabPageStateConfig(stateName);
		}
		return null;
	}
	
	/**
	 * Return Collection of TabPageStateConfig configurate into 
	 * jspatbcontrol-config.xml.
	 * @param servletContext
	 * @return Collection of TabPageStateConfig
	 */
	public static Collection getTabPageStateConfigList(ServletContext servletContext) {
		JSPTabControlResources resources  = getJSPTabControlResources(servletContext);
		if (resources != null) {
			return resources.getTabPageStateConfigList();
		}
		return null;
	}
	
	
	/**
	 * Save JSPTabControlResources into Servlet Context.
	 * @param context
	 * @param resources
	 */
	public static void saveJSPTabControlResources(ServletContext context,JSPTabControlResources resources) {
		context.setAttribute(JSPTabControlConstants.SERVLETCONTEXT_JSPTABCONTOL_RESSOURCES_KEY , resources);
	}
	
	public static JSPTabControlResources getJSPTabControlResources(ServletContext servletContext) {
		JSPTabControlResources resources = (JSPTabControlResources)servletContext.getAttribute(JSPTabControlConstants.SERVLETCONTEXT_JSPTABCONTOL_RESSOURCES_KEY);
    	if (resources == null) {
            throw new IllegalArgumentException("Impossible to get JSPTabControlResources into servlet context. Check if you have register JSPTabControlResources into WEB Servlet Context with key \"net.sourceforge.formview.SERVLETCONTEXT_JSPTABCONTROL_RESSOURCES_KEY\" (If you are in Struts check if you have intiliaze Plugin JSPTabControlPlugin correctly).");
        }
        return resources;		
	}
	
	
	private static String getTabControlCharacteristicsRequestKey(String tabControlName) {
		return JSPTabControlConstants.TABPAGE_NAME_INPUT_HIDDEN + "_" + tabControlName;
	}
	
	/**
	 * Return name of input HIDDEN of tabControl with name <b>tabControlName</b>
	 * which store tabPageName which is selected. 
	 * @param tabControlName
	 * @return
	 */
	public static String getInputHiddenName(String tabControlName) {
		return JSPTabControlConstants.TABPAGE_NAME_INPUT_HIDDEN + "_" + tabControlName;
	}
	
	/**
	 * Return STATE name of input HIDDEN of tab Page <b>tabPageName</b> of 
	 * tabControl with name <b>tabControlName</b>.
	 * @param tabControlName
	 * @return
	 */
	public static String getInputStateHiddenName(String tabControlName, String tabPageName) {
		return JSPTabControlConstants.TABPAGE_STATENAME_INPUT_HIDDEN + "_" + tabControlName + "_" + tabPageName;
	}	
	

}
