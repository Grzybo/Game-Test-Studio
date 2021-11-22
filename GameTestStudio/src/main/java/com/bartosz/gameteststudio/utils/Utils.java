package com.bartosz.gameteststudio.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import com.bartosz.gameteststudio.dp.DataProvider;

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
	
	public static String generateRandomPassword() {

	    	List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
														new CharacterRule(EnglishCharacterData.LowerCase, 1), 
														new CharacterRule(EnglishCharacterData.Digit, 1));

			PasswordGenerator generator = new PasswordGenerator();
			return generator.generatePassword(8, rules);
	} 
	
	
	public static Set<Long> setAllowedRolesID(String className) {
		Set<Long> set = new HashSet<>();
		List<Long> list = DataProvider.getAllowedRolesID(className);
		for(Long role : list) {
			set.add(role);
		}
		return set;
	} 
	
	public static void setTab(String tabName) {
        ServletActionContext.getRequest().setAttribute("selectedTab", tabName);
	}
	
	
}
