package com.bartosz.gameteststudio.utils;

import org.apache.struts2.ServletActionContext;

public abstract class Utils {

	public static boolean isNotLogged()
    {
    	if (ServletActionContext.getRequest().getSession().getAttribute("loginedEmail").equals("")) return true;
    	else return false;
    }

}
