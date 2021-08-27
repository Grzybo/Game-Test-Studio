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

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import com.bartosz.gameteststudio.db.*;
import com.bartosz.gameteststudio.dictionary.RolesDictionary;
import com.bartosz.gameteststudio.dictionary.ProjectsDictionary;
import com.bartosz.gameteststudio.db.RoleRespository;
import com.bartosz.gameteststudio.db.User;
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
    private String from = "gameteststudiomail@gmail.com";
    private String emailPassword = "Pa$$word1!"; 
    private String body;
    private String role;
    private List<String> userProjects;
    private List<Project> projects;
    
    private List<String> rolesList;
    private List<String> projectsList; 
    
    
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
          
    	rolesList =  new ArrayList<String>();
    	projects =  new ArrayList<Project>();
    	projectsList = new ArrayList<String>();
    	
    	rolesList = RolesDictionary.keys();     	
    	projectsList = ProjectsDictionary.keys();  
    	
    	if(this.firstName != null && this.lastName != null && this.email != null ) {  		
                       
            this.password = generateRandomPassword();  
            
            for(String project : userProjects) {
            	projects.add(ProjectsDictionary.getProject(project));
            }
            
           UserRepository.save(new User(firstName, lastName, email, password, RoleRespository.findByName(role), projects));
            body = "Hello " + this.firstName + " " + this.lastName + 
        			", your password to Game Test Studio is: " + this.password + " \nYour Role is: " + this.role; 
            
            SendMail();
            addActionError("Account created.");
            return "account_create";
    	}
    	else return "account_create";
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



	public String getFrom() {
		return from;
	}



	public void setFrom(String from) {
		this.from = from;
	}



	public String getEmailPassword() {
		return emailPassword;
	}



	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}



	public String getBody() {
		return body;
	}



	public void setBody(String body) {
		this.body = body;
	}



	public static Properties getProperties() {
		return properties;
	}



	public static void setProperties(Properties properties) {
		AccountCreateAction.properties = properties;
	}

	 public String getRole() {
			return role;
		}
		
	public void setRole(String role) {
		this.role = role;
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

	public List<String> getUserProjects() {
		return userProjects;
	}

	public void setUserProjects(List<String> userProjects) {
		this.userProjects = userProjects;
	}
	
	public List<Project> getProjects() {
		return projects;
	}
		
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

} 


