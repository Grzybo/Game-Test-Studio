package com.bartosz.gameteststudio.action;
 
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createAccount", //
results = { //
        @Result(name = "account_create", location = "/WEB-INF/pages/account_create.jsp")
} //
)
public class AccountCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String firstName, lastName, email, password;
    
    @Override
    public String execute() {
          
    	
    	if(this.firstName != null && this.lastName != null && this.email != null ) {
    		HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession(); 
            
            this.password = generateRandomPassword();
            session.setAttribute("generatedPassword", this.password);
    		return "account_create";
    	}
    	else {
    		
    		HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession(); 
            
            session.setAttribute("generatedPassword", null); 
           
            return "account_create";
    	}
    	 
    }
    
    public String getFirstName() {return firstName;}
 
    public void setFirstName(String firstName) {
        if(firstName == "") firstName = null;
        else this.firstName = firstName;
    }
    
    public String getLastName() { return lastName; }
 
    public void setLastName(String lastName) {
    	if(lastName == "") lastName = null;
        else this.lastName = lastName;
    } 
    
    public String getEmail() {return email;}
 
    public void setEmail(String email) {
    	if(email == "") email = null;
        else this.email = email;
    } 
    
    public String generateRandomPassword() {

    	List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
													new CharacterRule(EnglishCharacterData.LowerCase, 1), 
													new CharacterRule(EnglishCharacterData.Digit, 1));

		PasswordGenerator generator = new PasswordGenerator();
		return generator.generatePassword(8, rules);
	}
}