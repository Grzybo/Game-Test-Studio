package com.bartosz.gameteststudio.create.action;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.dp.DataProvider;
import com.opensymphony.xwork2.ActionSupport;
 
@Action(value = "createAccount", //
results = { //
        @Result(name = "account_create", location = "/WEB-INF/pages/create_pages/createAccount.jsp")
} //
)
public class AccountCreateAction  extends ActionSupport {
  
    private static final long serialVersionUID = 1L;
 
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private List<String> projects;
    private String bugPer;
    private String testPer;
    private String areaPer;
    
    private List<String> rolesList = new ArrayList<String>(DataProvider.mapRoles.keySet());
    private List<String> projectsList = new ArrayList<String>(DataProvider.mapProjects.keySet());
    private List<String> permissionsList = new ArrayList<String>(DataProvider.mapPermissions.keySet());
    
    private String from = "gameteststudiomail@gmail.com";
    private String emailPassword = "Pa$$word1!"; 
    private String body;

	
    
	static Properties properties = new Properties();
    static {
	       properties.put("mail.smtp.host", "smtp.gmail.com");
	       properties.put("mail.smtp.socketFactory.port", "465");
	       properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	       properties.put("mail.smtp.auth", "true");
	       properties.put("mail.smtp.port", "465");
    }
    
    @Override
    public String execute() {
    	
    	HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();  
    	session.setAttribute("selectedTab", "AccountsTab");
    	
    	if(this.firstName != null && this.lastName != null && this.email != null ) {
    		if(!DataProvider.mapUsers.keySet().contains(email)) {
    			
               
                
                this.password = generateRandomPassword();
                session.setAttribute("generatedPassword", this.password);
                
                body = "Hello " + this.firstName + " " + this.lastName + 
            			", your password to Game Test Studio is: " + this.password + " \nYour Role is: " + this.role; 
                
                SendMail();

        		UserBean user = new UserBean(firstName, lastName, email, password, DataProvider.mapRoles.get(role), projects); 
        		DataProvider.saveUser(user);

        		addActionError("Account created.");
        		
                return "account_create";
    		}
    		addActionError("Acccount with this email already exists.");
    		return "account_create"; 
    	}
    	else {
    	
    		addActionError("Fill all fields.");
    		
            return "account_create"; 
    	}
    	 
    }
    
   
    
    public String generateRandomPassword() {

    	List<CharacterRule> rules = Arrays.asList(new CharacterRule(EnglishCharacterData.UpperCase, 1),
													new CharacterRule(EnglishCharacterData.LowerCase, 1), 
													new CharacterRule(EnglishCharacterData.Digit, 1));

		PasswordGenerator generator = new PasswordGenerator();
		return generator.generatePassword(8, rules);
	} 
    
    
    public void SendMail() {
    	
    	String ret = SUCCESS; 
    	
        try {
           Session emailSession = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                 protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, emailPassword);
                 }
              }
           );

           Message message = new MimeMessage(emailSession);
           message.setFrom(new InternetAddress(from));
           message.setRecipients(Message.RecipientType.TO, 
              InternetAddress.parse(this.email));
           message.setSubject("Game Test Studio Password!");
           message.setText(body);
           Transport.send(message);
        } catch(Exception e) {
           ret = ERROR;
           e.printStackTrace();
        }
        System.out.print(ret);
    } 
    
    
    
    
    public String getFirstName() {return firstName;}
    
    public List<String> getPermissionsList() {
		return permissionsList;
	}



	public void setPermissionsList(List<String> permissionsList) {
		this.permissionsList = permissionsList;
	}



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
    
    public String getPassword() {return password;}
    
    public void setPassword(String password) {
    	if(password == "") password = null;
        else this.password = password;
    }



	


	public String getBugPer() {
		return bugPer;
	}



	public void setBugPer(String bugPer) {
		this.bugPer = bugPer;
	}



	public String getTestPer() {
		return testPer;
	}



	public void setTestPer(String testPer) {
		this.testPer = testPer;
	}



	public String getAreaPer() {
		return areaPer;
	}



	public void setAreaPer(String areaPer) {
		this.areaPer = areaPer;
	}






	public List<String> getProjects() {
		return projects;
	}



	public void setProjects(List<String> projects) {
		this.projects = projects;
	}



	public List<String> getRolesList() {
		return rolesList;
	}



	public void setRolesList(List<String> rolesList) {
		this.rolesList = rolesList;
	}



	public List<String> getProjectsList() {
		return projectsList;
	}



	public void setProjectsList(List<String> projectsList) {
		this.projectsList = projectsList;
	}



	public String getRole() {
			return role;
		}
	
	
	
	public void setRole(String role) {
		this.role = role;
	}

} 


