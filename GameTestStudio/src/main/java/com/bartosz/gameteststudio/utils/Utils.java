package com.bartosz.gameteststudio.utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import com.bartosz.gameteststudio.dp.DataProvider;
import com.google.common.hash.Hashing;

/**
 * Metoda abstrakcynja posiadająca pomocnicze metody oraz atrybuty.  
 * @author Bartosz
 *
 */
public abstract class Utils {

	public static String bugTabState;
	public static String testTabState;
	public static String areaTabState;
	public static String projectTabState;
	public static String userTabState; 
	
	public static String selectedAction;
	
	public static String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
	
	
	/**
	 * Metoda generująca hasło.
	 * @return
	 */
	public static String generateRandomPassword() {

	    	List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
														new CharacterRule(EnglishCharacterData.LowerCase, 1), 
														new CharacterRule(EnglishCharacterData.Digit, 1));

			PasswordGenerator generator = new PasswordGenerator();
			return generator.generatePassword(8, rules);
	} 
	
	/**
	 * Metoda tworząca listę id ról z dostępami do danej akcji. 
	 * Metoda używana w akcjach wymagających autoryzacji. 
	 * @param className
	 * @return
	 */
	public static Set<Long> setAllowedRolesID(String className) {
		Set<Long> set = new HashSet<>();
		List<Long> list = DataProvider.getAllowedRolesID(className);
		for(Long role : list) {
			set.add(role);
		}
		return set;
	} 

	/**
	 * Metoda wspomagająca widok, aktywująca wskazaną zakładkę.
	 * @param tabName
	 * @param session
	 */
	public static void setTab(String tabName, HttpSession session) {
		session.setAttribute("selectedTab", tabName);
	} 
	
	/**
	 * Metoda licząca funkcję sktótu z podanego ciągu znaków.
	 * @param str
	 * @return
	 */
	public static String HashSHA256(String str) { 
		return Hashing.sha256().hashString(str, StandardCharsets.UTF_8).toString();
	} 
	
	

	/**
	 * 	public static String Encode64(String input) {
		return  Base64.getEncoder().encodeToString(input.getBytes());
	} 
	 * 
	 * 
	 * 	public static String Decode64(String input) {
		byte[] decodedBytes = Base64.getDecoder().decode(input);
		return  new String(decodedBytes);
	} 
	 * 
	 * 
	 * 
	public static boolean isNotLogged()
    {
    	if (ServletActionContext.getRequest().getSession().getAttribute("loginedEmail").equals("")) return true;
    	else return false;
    } 
	 */
	
}
