package com.bartosz.gameteststudio.utils;

import org.apache.struts2.ServletActionContext;

public abstract class Utils {

	public static String bugTabState;
	public static String testTabState;
	public static String areaTabState;
	public static String projectTabState;
	public static String userTabState;
	
	public static boolean isNotLogged()
    {
    	if (ServletActionContext.getRequest().getSession().getAttribute("loginedEmail").equals("")) return true;
    	else return false;
    }

}
