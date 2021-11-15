/*
 * Created on 6 mars 2006
 *
 *To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package net.sourceforge.jsptabcontrol.config;

/**
 * Insert StyleClass for tab heade or body for a particulary tabPage.
 * Created on 6 mars 2006
 * @author azerr
 */
public class InsertStyleClass {

	private String where;
	private String styleClass;
		
	/**
	 * @return Returns the styleClass.
	 */
	public String getStyleClass() {
		return styleClass;
	}
	/**
	 * @param styleClass The styleClass to set.
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
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
        results.append("\t\tstyleClass = " + styleClass + "\n");              
        return results.toString();
    }	
}
