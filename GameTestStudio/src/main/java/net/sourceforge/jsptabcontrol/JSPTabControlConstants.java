package net.sourceforge.jsptabcontrol;

/**
 * 
 * Constants for JSP Tab Control.
 * 
 * @version 1.0.0 
 * @author <a href="mailto:angelo.zerr@gmail.com">Angelo ZERR</a>
 */
public class JSPTabControlConstants {
	
    /**
     * Application scope key that <code>JSPTabControlResources</code> is stored under.
     */
    public final static String SERVLETCONTEXT_JSPTABCONTOL_RESSOURCES_KEY =
            "net.sourceforge.jsptabcontrol.SERVLETCONTEXT_JSPTABCONTOL_RESSOURCES_KEY";
    
	/**
	 * Parameters stored into request
	 */
	public final static String REQUEST_LAST_TABCONTROL_ID = "net.sourceforge.jsptabcontrol.REQUEST_LAST_TABCONTROL_ID";
	public final static String REQUEST_TABCONTROL_NAME_MAP = "net.sourceforge.jsptabcontrol.REQUEST_TABCONTROL_NAME_MAP";
	
	
	/**
	 * Default style class
	 */
	public final static String DEFAULT_TABCONTROL_BODY_CLASS = "tabControlBody";
	public final static String DEFAULT_TABCONTROL_HEADER_CLASS = "tabControlHeader";
	public final static String DEFAULT_TABPAGE_BODY_CLASS = "tabPageBody";
	public final static String DEFAULT_TABPAGE_HEADER_CLASS = "tabPageHeader";	
	
	/**
	 * Name of input HIDDEN which store name of tabPage selected for one tabControl
	 */
	public final static String TABPAGE_NAME_INPUT_HIDDEN = "tabPageInputHiddenName";
	public final static String TABPAGE_STATENAME_INPUT_HIDDEN = "tabPageStateInputHiddenName";
	
	/**
	 * Tab page state
	 */
	public final static String TABPAGE_STATE_INVISIBLE = "INVISIBLE";		
	public final static String TABPAGE_STATE_READONLY = "READ-ONLY";	
	public final static String TABPAGE_STATE_FORBIDDEN = "FORBIDDEN";	
	
	/**
	 * Style class
	 */
	public final static String STYLECLASS_WHERE_TABCONTROL_HEADER = "tabControlHeader"; // class for ul
	public final static String STYLECLASS_WHERE_TABPAGE_HEADER = "tabPageHeader";		// class for li 
	public final static String STYLECLASS_WHERE_TABPAGE_BODY = "tabPageBody";		// class for div tab page
	

}
