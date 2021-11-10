package com.bartosz.gameteststudio.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

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

}
