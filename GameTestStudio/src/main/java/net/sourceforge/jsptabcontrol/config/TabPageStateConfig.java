package net.sourceforge.jsptabcontrol.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sourceforge.jsptabcontrol.JSPTabControlConstants;
import org.apache.commons.collections.FastHashMap;

/**
 * Tab page State config : 
 * add particulary stylesheet and javascript for a tab state.
 * @version 1.0.0 
 * @author <a href="mailto:angelo.zerr@gmail.com">Angelo ZERR</a>
 */
public class TabPageStateConfig {

	private static final long serialVersionUID = 1L;
	
	private String name; // State name
	private boolean visible; // by default tab page is visible (true)
	
	private List insertStyleClassList;	
	private Map insertStyleClassMap;	
	private List insertJavascriptList;	
	private Map insertJavascriptMap;
	
	public TabPageStateConfig() {
		this(null);
	}
	
	public TabPageStateConfig(String name) {
		this.name = name;
		this.insertStyleClassList = new ArrayList();
		this.insertStyleClassMap = new FastHashMap();	
		this.insertJavascriptMap = new FastHashMap();
		this.insertJavascriptList = new ArrayList();
		this.visible = true;
	}
	
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void addInsertJavascript(InsertJavascript insertJavaScript) {
		insertJavascriptList.add(insertJavaScript);
		insertJavascriptMap.put(insertJavaScript.getWhere(), insertJavaScript);
	}
	
	public List getInsertJavascriptList() {
		return insertJavascriptList;
	}
	public Map getInsertJavascriptMap() {
		return insertJavascriptMap;
	}

	public void addInsertStyleClass(InsertStyleClass insertStyleClass) {
		insertStyleClassList.add(insertStyleClass);
		insertStyleClassMap.put(insertStyleClass.getWhere(), insertStyleClass);
	}

	public List getInsertStyleClassList() {
		return insertStyleClassList;
	}

	public Map getInsertStyleClassMap() {
		return insertStyleClassMap;
	}

	////////// CSS
	/**
	 * @return Returns the tabPageHeaderClass.
	 */
	public String getTabPageHeaderClass() {
		InsertStyleClass insertStylesheet = (InsertStyleClass)insertStyleClassMap.get(JSPTabControlConstants.STYLECLASS_WHERE_TABPAGE_HEADER);
		if (insertStylesheet != null)
			return insertStylesheet.getStyleClass();
		return null;
	}

	public String getTabPageBodyClass() {
		InsertStyleClass insertStylesheet = (InsertStyleClass)insertStyleClassMap.get(JSPTabControlConstants.STYLECLASS_WHERE_TABPAGE_BODY);
		if (insertStylesheet != null)
			return insertStylesheet.getStyleClass();
		return null;
	}
	
    public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/**
     * Returns a string representation of the object.
     */
    public String toString() {
        StringBuffer results = new StringBuffer();

        results.append("TabPageStateConfig: ");
        results.append(name);
        results.append("\n");
        results.append("\tvisible:" + visible);
        results.append("\n");        
        for (Iterator i = insertStyleClassList.iterator(); i.hasNext();) {
            results.append("\tInsertStyleClass: \n");
            results.append(i.next());
            results.append("\n");
        }
        for (Iterator i = insertJavascriptList.iterator(); i.hasNext();) {
            results.append("\tInsertJavascript: \n");
            results.append(i.next());
            results.append("\n");
        }       
        return results.toString();
    }		
}
