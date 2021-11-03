package com.bartosz.gameteststudio.utils;

import org.apache.struts2.ServletActionContext;

public abstract class Utils {

	public static String bugTabState;
	public static String testTabState;
	public static String areaTabState;
	public static String projectTabState;
	public static String userTabState;
	public static String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
	
	public static boolean isNotLogged()
    {
    	if (ServletActionContext.getRequest().getSession().getAttribute("loginedEmail").equals("")) return true;
    	else return false;
    }

}
