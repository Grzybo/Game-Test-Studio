/*
 * Created on 6 mars 2006
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package net.sourceforge.jsptabcontrol.config;

/**
 * Insert Javascript for an event of A HREF of tab page header.
 * Created on 6 mars 2006
 * @author azerr
 */
public class InsertJavascript {

	private String event;
	private String where;
	private String javascriptContent;
		
	/**
	 * @return Returns the event.
	 */
	public String getEvent() {
		return event;
	}
	/**
	 * @param event The event to set.
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	/**
	 * @return Returns the javascriptContent.
	 */
	public String getJavascriptContent() {
		return javascriptContent;
	}
	/**
	 * @param javascriptContent The javascriptContent to set.
	 */
	public void setJavascriptContent(String javascriptContent) {
		this.javascriptContent = javascriptContent;
	}
	/**
	 * @return Returns the where.
	 */
	public String getWhere() {
		return where;
	}
	/**
	 * @param where The where to set.
	 */
	public void setWhere(String where) {
		this.where = where;
	}
	
	/**
     * Returns a string representation of the object.
     */
    public String toString() {
        StringBuffer results = new StringBuffer();
        results.append("\t\twhere = " + where + "\n");     
        results.append("\t\tevent = " + event + "\n");
        results.append("\t\tjavascriptContent = " + javascriptContent + "\n");          
        return results.toString();
    }		
}
