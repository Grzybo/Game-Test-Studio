package com.bartosz.gameteststudio.dp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.bartosz.gameteststudio.beans.ActionBean;
import com.bartosz.gameteststudio.beans.AreaBean;
import com.bartosz.gameteststudio.beans.AttachmentBean;
import com.bartosz.gameteststudio.beans.BugBean;
import com.bartosz.gameteststudio.beans.BuildBean;
import com.bartosz.gameteststudio.beans.IssueTypeBean;
import com.bartosz.gameteststudio.beans.PlatformBean;
import com.bartosz.gameteststudio.beans.PriorityBean;
import com.bartosz.gameteststudio.beans.ProjectBean;
import com.bartosz.gameteststudio.beans.ResultBean;
import com.bartosz.gameteststudio.beans.RoleBean;
import com.bartosz.gameteststudio.beans.StateBean;
import com.bartosz.gameteststudio.beans.TestBean;
import com.bartosz.gameteststudio.beans.UserBean;
import com.bartosz.gameteststudio.exceptions.GSException;
import com.bartosz.gameteststudio.repositories.ActionRepository;
import com.bartosz.gameteststudio.repositories.AreaRepository;
import com.bartosz.gameteststudio.repositories.AttachmentRepository;
import com.bartosz.gameteststudio.repositories.BugRepository;
import com.bartosz.gameteststudio.repositories.BuildRepository;
import com.bartosz.gameteststudio.repositories.IssueRepository;
import com.bartosz.gameteststudio.repositories.PlatformRepository;
import com.bartosz.gameteststudio.repositories.PriorityRepository;
import com.bartosz.gameteststudio.repositories.ProjectRepository;
import com.bartosz.gameteststudio.repositories.ResultRepository;
import com.bartosz.gameteststudio.repositories.RoleRepository;
import com.bartosz.gameteststudio.repositories.StateRepository;
import com.bartosz.gameteststudio.repositories.TestRepository;
import com.bartosz.gameteststudio.repositories.UserRepository;
import com.google.common.base.Strings;

/**
 * klasa zarzadzajaca danymi
 * @author Bartosz
 *
 */

public class DataProvider {

	protected static final Logger log = Logger.getLogger(DataProvider.class.getName());

// ##################################################################################################################################################################################################
// Results
// ##################################################################################################################################################################################################
	
	/**
	 * Metoda zwraca listę rezultatów pobraną z bazy danych.
	 * @return
	 */
	public static List<ResultBean> getAllResults() {
		List<ResultBean> lstResult = ResultRepository.findAll();
		return lstResult;
	}
	
	/**
	 * Słownik wyników. 
	 */
	public static  Map<String, ResultBean> mapResults = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(ResultBean rb : getAllResults()) {
				put(rb.getName(), rb);
			}
		}
	}; 
// ##################################################################################################################################################################################################
// Roles
// ##################################################################################################################################################################################################
	
	/**
	 * Metoda zwraca listę ról pobraną z bazy danych.
	 * @return
	 */
	public static List<RoleBean> getAllRoles() {
		List<RoleBean> lstResult = RoleRepository.findAll();
		return lstResult;
	}
	
	/**
	 *  Słownik ról.
	 */
	public static  Map<String, RoleBean> mapRoles = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(RoleBean rb : getAllRoles()) {
				put(rb.getName(), rb);
			}			
		}
	};
	
	
// ##################################################################################################################################################################################################
// Actions
// ##################################################################################################################################################################################################
	
	/**
	 * Metoda zwraca listę akc pobraną z bazy danych.
	 * @return
	 */
	public static List<ActionBean> getAllActions() {
		List<ActionBean> lstResult = ActionRepository.findAll();
		return lstResult;
	} 
	public static void updateAction(ActionBean action) {
		if (action != null ) {
			ActionRepository.update(action);
		} else
			log.error("Action is null.");
	}
	
	
	/**
	 *  Słownik ról.
	 */
	public static  Map<String, ActionBean> mapActions = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(ActionBean ab : getAllActions()) {
				put(ab.getName(), ab);
			}			
		}
	}; 
	
	public static List<String> getAllowedRoles(String action) {
		List<String> rolesList = new ArrayList<String>();
		for(RoleBean role: mapActions.get(action).getRoles()) {
			rolesList.add(role.getName());
		}
		return rolesList;
	} 
	
	public static List<Long> getAllowedRolesID(String action) {
		List<Long> rolesIdList = new ArrayList<Long>();
		for(RoleBean role: mapActions.get(action).getRoles()) {
			rolesIdList.add(role.getId());
		}
		return rolesIdList;
	}
	
	public static Set<Long> getAllRolesID() {
		Set<Long> rolesIdList = new HashSet<>();
		for(RoleBean role: mapRoles.values()) {
			rolesIdList.add(role.getId());
		}
		return rolesIdList;
	}

// ##################################################################################################################################################################################################
// Build
// ##################################################################################################################################################################################################
	
	/**
	 * Metoda zwraca listę buildów pobraną z bazy danych.
	 * @return
	 */
	public static List<BuildBean> getAllBuilds() {
		List<BuildBean> lstResult = BuildRepository.findAll();
		return lstResult;
	}
	
	/**
	 * Słownik typu wersji (Build type).
	 */
	public static  Map<String, BuildBean> mapBuilds = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(BuildBean pb : getAllBuilds()) {
				put(pb.getName(), pb);
			}
			/**
			put("Release Candidate", new BuildBean("Release Candidate"));
			put("Alpha", new BuildBean("Alpha"));
			put("Beta", new BuildBean("Beta"));
			put("Release", new BuildBean("Release"));
			 * 
			 */
		}
	};
	
// ##################################################################################################################################################################################################
// Platforms 
// ##################################################################################################################################################################################################	
	
	/**
	 * Metoda zwraca listę platform pobraną z bazy danych.
	 * @return
	 */
	public static List<PlatformBean> getAllPlatforms() {
		List<PlatformBean> lstResult = PlatformRepository.findAll();
		return lstResult;
	}
	/**
	 * Słownik platform.
	 */
	public static Map<String, PlatformBean> mapPlatforms = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(PlatformBean pb : getAllPlatforms()) {
				put(pb.getName(), pb);
			}
			/**
			put("PlayStation 4", new PlatformBean("PlayStation 4"));
			put("PlayStation 5", new PlatformBean("PlayStation 5"));
			put("Xbox One", new PlatformBean("Xbox One"));
			put("Xbox One X", new PlatformBean("Xbox One X"));
			put("Xbox Series S", new PlatformBean("Xbox Series S"));
			put("Xbox Series X", new PlatformBean("Xbox Series X"));
			put("PC", new PlatformBean("PC"));
			 * 
			 */
		}
	}; 
	/**
	 * Metoda zwraca platformę pobraną z bazy danych o padanej nazwie. 
	 * @param title
	 * @return
	 * @throws GSException
	 */
	public static PlatformBean getPlatformByTitle(String title) throws GSException {
		if (title != null ) {
			PlatformBean db = PlatformRepository.findByName(title); 
			return db;
		} else
			log.error(" Project id is null."); 
		
		throw new GSException("Project id is null or out of range.");
	}

// ##################################################################################################################################################################################################
// Attachment 
// ##################################################################################################################################################################################################
	
	/**
	 * Metoda zwraca obiekt załączonego pliku pobranego z bazy danych o podanym id.
	 * @param id
	 * @return
	 * @throws GSException
	 */
	public static AttachmentBean getAttchmentByID(Long id) throws GSException {
		if (id != null && id.intValue() > 0) {
			AttachmentBean db = AttachmentRepository.findById(id); 
			return db;
		} else
			log.error(" Attachment id is null or out of range."); 
		
		throw new GSException(" Attachment id is null or out of range.");
	} 
	
	/**
	 * Metoda zapisuje podany załącznik w bazie danych.
	 * @param att
	 */
	public static void saveAttachment(AttachmentBean att) {
		if (att != null) {
			AttachmentRepository.save(att);
		} else
			log.error("Attachment is null.");
	} 
	
	/**
	 * Metoda usuwa z bazy danych podany załącznik oraz usuwa go z serwera.
	 * @param att
	 */
	public static void deleteAttachment(AttachmentBean att) {
		if (att != null) {	
			AttachmentRepository.delete(att);
			File f = new File(att.getFilePath() + "\\" + att.getFileName()); 
			f.delete();
		} else
			log.error("Attachment is null.");
	}
	
	/**
	 * Metoda zmienia nazwę załącznika w bazie danych.
	 * @param old
	 * @param newName
	 */
	public static void updateAttachmentName(AttachmentBean old, String newName) {
		if (old != null && newName != null) {
			AttachmentRepository.updateName(old, newName);
		} else
			log.error("Project is null.");
	}
// ##################################################################################################################################################################################################
// Project 
// ##################################################################################################################################################################################################
	
	
	/**
	 * Metoda zapisuje projekt w bazie danych oraz dodaje go do słowników.
	 * @param project
	 */
	public static void saveProject(ProjectBean project) {
		if (project != null) {
			//ProjectDbTest db = new ProjectDbTest (project.getTitle(), project.getDescription(), project.getEstimatedTime(), project.getWorkTime(), project.getStartDate(), project.getEndDate(), project.getTestersNumber());	
			ProjectRepository.save(project);
			mapProjects.put(project.getTitle(), project);
			mapProjectsId.put(project.getId(), project.getTitle());
		} else
			log.error("Project is null.");
	} 
	
	/**
	 * Metoda usuwa projekt z bazy danych oraz ze słowników.
	 * @param project
	 */
	public static void deleteProject(ProjectBean project) {
		if (project != null) {	
			ProjectRepository.delete(project);
			mapProjects.remove(project.getTitle(), project);
			mapProjectsId.remove(project.getId(), project.getTitle());
		} else
			log.error("Project is null.");
	} 
	
	/**
	 * Metoda aktualizuje projekt w bazie danych. W argumentach przyjmuje obiekt projektu który ma być zaktualizowany,
	 * i obiekt projektu na który ma zostać podmieniony. 
	 * @param oldProject
	 * @param newProject
	 */
	public static void updateProject(ProjectBean oldProject, ProjectBean newProject) {
		if (oldProject != null && newProject != null) {
			mapProjectsId.replace(oldProject.getId(), oldProject.getTitle(), newProject.getTitle());
			mapProjects.remove(oldProject.getTitle());
			ProjectRepository.update(oldProject, newProject);
			mapProjects.put(newProject.getTitle(), newProject);
		} else
			log.error("Project is null.");
	}
	
	/**
	 * Metoda zwraca obiekt projektu o podanym id. 
	 * @param id
	 * @return
	 * @throws GSException
	 */
	public static ProjectBean getProjectByID(Long id) throws GSException {
		if (id != null && id.intValue() > 0) {
			ProjectBean db = ProjectRepository.findById(id); 
			return db;
		} else
			log.error(" Project id is null or out of range."); 
		throw new GSException("Project id is null or out of range.");
	} 
	
	/**
	 * Metoda zwraca obiekt projektu o podanym tytule.
	 * @param title
	 * @return
	 * @throws GSException
	 */
	public static ProjectBean getProjectByTitle(String title) throws GSException {
		if (title != null ) {
			ProjectBean db = ProjectRepository.findByTitle(title); 
			return db;
		} else
			log.error(" Project id is null."); 
		throw new GSException("Project id is null or out of range.");
	}
	
	/**
	 * Metoda zwraca listę obiektów wszystkich projektów.
	 * @return
	 */
	public static List<ProjectBean> getAllProjects() {
		List<ProjectBean> lstResult = ProjectRepository.findAll();
		return lstResult;
	}
	
	/**
	 * Słownik projektów z tytułami jako kluczem.
	 */
	public static  Map<String, ProjectBean> mapProjects = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(ProjectBean pb : getAllProjects()) {
				put(pb.getTitle(), pb);
			}		
		}
	}; 
		
	/**
	 * Słownik projektów z id jako kluczem.
	 */
	public static  Map<Long, String> mapProjectsId = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(ProjectBean pb : getAllProjects()) {
				put(pb.getId(), pb.getTitle());
			} 
		} 
	};
		
	/**
	 * Metoda zwracająca obiekt ProjectBean po id.  
	 * @param id
	 * @return
	 */
	public static ProjectBean getProjectById(int id) {
		return mapProjects.get(mapProjectsId.get((long)id));
	}
	
	/**
	 * Metoda aktualizuje słowniki projektów.
	 */
	public static void updateProjectMaps() {
		mapProjectsId.clear();
		mapProjects.clear();
		for(ProjectBean b : getAllProjects()) {
			mapProjectsId.put(b.getId() , b.getTitle());
			mapProjects.put(b.getTitle(), b);
		}
	}
		
// ##################################################################################################################################################################################################
// Priorities 
// ##################################################################################################################################################################################################
	
	/**
	 * Metoda zwraca listę obiektów priorytetów pobraną z bazy danych.	
	 * @return
	 */
	public static List<PriorityBean> getAllPriorities() {
		List<PriorityBean> lstResult = PriorityRepository.findAll();
		return lstResult;
	}
			
	/**
	 * Pobiera słowink priorytetów. (PriorityBean)
	 * @return
	 */
	public static Map<String, PriorityBean> getPriorities(){
		Map<String, PriorityBean> mapPriorities = new LinkedHashMap<>();
		for(PriorityBean rb : getAllPriorities()) {
			mapPriorities.put(rb.getName(), rb);
		}
		return mapPriorities;
	}  
// ##################################################################################################################################################################################################
// State
// ##################################################################################################################################################################################################
	
	/**
	 * Metoda zwraca listę obiektów stanów pobraną z bazy danych.	
	 * @return
	 */
	public static List<StateBean> getAllStates() {
		List<StateBean> lstResult = StateRepository.findAllStates();
		return lstResult;
	}

	/**
	 * Pobiera słownik stanów. 
	 * @return
	 */
	public static Map<String, StateBean> getStates(){
		Map<String, StateBean> mapStates = new LinkedHashMap<>();
		for(StateBean sb : getAllStates()) {
			mapStates.put(sb.getName(), sb);
		}
		return mapStates;
	} 
// ##################################################################################################################################################################################################
// Issue
// ##################################################################################################################################################################################################
	
	/**
	 * Zwraca listę typów błędów 
	 * @return
	 */
	public static List<IssueTypeBean> getAllIssues() {
		List<IssueTypeBean> lstResult = IssueRepository.findAll();
		return lstResult;
	}

	/**
	 * Zwraca słownik typów błędów.
	 * @return
	 */
	public static Map<String, IssueTypeBean> getIssues(){
		Map<String, IssueTypeBean> mapStates = new LinkedHashMap<>();
		for(IssueTypeBean i : getAllIssues()) {
			mapStates.put(i.getName(), i);
		}
		return mapStates;
	} 	
// ##################################################################################################################################################################################################
// Area
// ##################################################################################################################################################################################################
	
	/**
	 * Zwraca listę obiektów obszarów z bazy danych.
	 * @return
	 */
	public static List<AreaBean> getAllAreas() {
		List<AreaBean> lstResult = AreaRepository.findAll();
		return lstResult;
	}
	
	/**
	 * Zwraca obiekt obszaru o podanym id.
	 * @param id
	 * @return
	 * @throws GSException
	 */
	public static AreaBean getAreaByID(Long id) throws GSException {
		if (id != null && id.intValue() > 0) {
			AreaBean a = AreaRepository.findById(id); 
			return a;
		} else
			log.error(" Area id is null or out of range."); 
		throw new GSException("Area id is null or out of range.");
	} 
	
	/**
	 * Zwraca obiekt obszaru o podanym w argumencie tytule.
	 * @param title
	 * @return
	 * @throws GSException
	 */
	public static AreaBean getAreaByTitle(String title) throws GSException {
		if (title != null ) {
			AreaBean db = AreaRepository.findByTitle(title); 
			return db;
		} else
			log.error(" Area id is null."); 
		
		throw new GSException("Area is null.");
	}
	
	/**
	 * Zapisuje obszar w bazie danych.
	 * @param area
	 */
	public static void saveArea(AreaBean area) {
		if (area != null) {
			AreaRepository.save(area);
			mapAreas.put(area.getTitle(), area);
			mapAreasId.put(area.getId(), area.getTitle());
		} else
			log.error("Area is null.");
	}  
	
	/**
	 * Usuwa obszar z bazy danych.
	 * @param area
	 */
	public static void deleteArea(AreaBean area) {
		if (area != null) {
			AreaRepository.delete(area);
			mapAreas.remove(area.getTitle());
			mapAreasId.remove(area.getId());
		} else
			log.error("Area is null.");
	} 
	
	/**
	 * Metoda aktualizuje obszar w bazie danych. W argumentach przyjmuje obiekt obszaru który ma być zaktualizowany,
	 * i obiekt obzasu na który ma zostać podmieniony. 
	 * @param old
	 * @param newArea
	 */
	public static void updateArea(AreaBean old, AreaBean newArea) {
		if (old != null && newArea != null) {
			mapAreasId.replace(old.getId(), old.getTitle(), newArea.getTitle());
			mapAreas.remove(old.getTitle());
			AreaRepository.update(old, newArea);
			mapAreas.put(newArea.getTitle(), newArea);
		} else
			log.error("User is null.");
	}
	
	/**
	 * Słowink obszarów. (klasa AreaBean)
	 * @return
	 */
	public static Map<String, AreaBean> mapAreas = new LinkedHashMap<>() {

		private static final long serialVersionUID = 1L;

		{
			for(AreaBean sb : getAllAreas()) {
				put(sb.getTitle(), sb);
			}
		}
	};  
	
	/**
	 * Słowink Id obszarów. 
	 * @return
	 */
	public static Map<Long, String> mapAreasId = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(AreaBean sb : getAllAreas()) {
				put(sb.getId(), sb.getTitle());
			}
		}	
	}; 
	
	/**
	 * Metoda zwracająca obiekt AreaBean po id z metody getAreasId().  
	 * @param id
	 * @return
	 */
	public static AreaBean getAreaById(int id) {
		return mapAreas.get(mapAreasId.get((long)id)); 	
	} 
	
	/**
	 * Aktualizuje słowniki obszarów.
	 */
	public static void updateAreaMaps() {
		mapAreasId.clear();
		mapAreas.clear();
		for(AreaBean b : getAllAreas()) {
			mapAreasId.put(b.getId() , b.getTitle());
			mapAreas.put(b.getTitle(), b);
		}
		
	}
// ##################################################################################################################################################################################################
// User 
// ##################################################################################################################################################################################################
	
	/**
	 * Zwraca listę obiektów użytkowników pobraną z bazy danych.
	 * @return
	 */
	public static List<UserBean> getAllUsers() {
		List<UserBean> lstResult = UserRepository.findAll();
		return lstResult;
	}
	
	/**
	 * Zwraca obiekt użytkownika o podanym id. 
	 * @param id
	 * @return
	 * @throws GSException
	 */
	public static UserBean getUserByID(Long id) throws GSException {
		if (id != null && id.intValue() > 0) {
			UserBean db = UserRepository.findById(id); 
			return db;
		} else
			log.error(" User id is null or out of range."); 
		throw new GSException("User id is null or out of range.");
	}
	
	public static UserBean getUserByHash(String hash) throws GSException {
		if (!Strings.isNullOrEmpty(hash)) {
			UserBean db = UserRepository.findByHash(hash); 
			return db;
		} else {log.error(" User hash is null."); }
		throw new GSException("User hash is null dupa.");
	} 
	
	/**
	 * Zwraca obiekt użytkownika o podanym emailu.
	 * @param title
	 * @return
	 * @throws GSException
	 */
	public static UserBean getUserByEmail(String title) throws GSException {
		if (title != null ) {
			UserBean db = UserRepository.findByEmail(title); 
			return db;
		} else
			log.error(" User id is null."); 
		
		throw new GSException("User is null.");
	}
	
	/**
	 * Zapisuje danego użytkownika w bazie danych.
	 * @param user
	 */
	public static void saveUser(UserBean user) {
		if (user != null) {
			user.updateHashKey();
			UserRepository.save(user);
			mapUsers.put(user.getEmail(), user);
			mapUsersId.put(user.getId(), user.getEmail());
		} else
			log.error("User is null.");
	} 
	
	/**
	 * Usuwa danego użytkownika z bazy danych.
	 * @param user
	 */
	public static void deleteUser(UserBean user) {
		if (user != null) {
			UserRepository.delete(user);
			mapUsers.remove(user.getEmail());
			mapUsersId.remove(user.getId());
		} else
			log.error("User is null.");
	} 
	
	/**
	 * Metoda aktualizuje użytkownika w bazie danych. W argumentach przyjmuje obiekt użytkownika który ma być zaktualizowany,
	 * i obiekt użytkownika na który ma zostać podmieniony. 
	 * @param old
	 * @param newUser
	 */
	public static void updateUser(UserBean old, UserBean newUser) {
		if (old != null && newUser != null) {
			mapUsersId.replace(old.getId(), old.getEmail(), newUser.getEmail());
			mapUsers.remove(old.getEmail());
			newUser.updateHashKey();
			UserRepository.update(old, newUser);
			mapUsers.put(newUser.getEmail(), newUser);
		} else
			log.error("User is null.");
	}
	
	/**
	 * Słownik użytkowników.
	 */
	public static  Map<String, UserBean> mapUsers = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{			
			
			for(UserBean sb : getAllUsers()) {
				put(sb.getEmail(), sb);
			}
		}
	};
	
	/**
	 * Słownik użytkowników z id jako kluczem.
	 */
	public static  Map<Long, String> mapUsersId = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(UserBean ub : getAllUsers()) {
				put(ub.getId(), ub.getEmail());
			}
		} 
	};
	
	/**
	 * Metoda zwracająca użytkownika po id.  
	 * @param id
	 * @return
	 */
	public static UserBean getUserById(int id) {
		return mapUsers.get(mapUsersId.get((long)id));
	}
	
// ##################################################################################################################################################################################################
// Test
// ##################################################################################################################################################################################################
	
	/**
	 * Zwraca liste obiektów testów pobraną z bazy danych.
	 * @return
	 */
	public static List<TestBean> getAllTests() {
		List<TestBean> lstResult = TestRepository.findAll();
		return lstResult;
	}

	/**
	 * Zwaraca obiekt testu o podanym id.
	 * @param id
	 * @return
	 * @throws GSException
	 */
	public static TestBean getTestByID(Long id) throws GSException {
		if (id != null && id.intValue() > 0) {
			TestBean db = TestRepository.findById(id); 
			return db;
		} else
			log.error(" Test id is null or out of range."); 
		throw new GSException("Test id is null or out of range.");
	} 
	
	/**
	 * Zwraca obiekt testu o podanym tytule.
	 * @param title
	 * @return
	 * @throws GSException
	 */
	public static TestBean getTestByTitle(String title) throws GSException {
		if (title != null ) {
			TestBean db = TestRepository.findByTitle(title); 
			return db;
		} else
			log.error(" Test id is null."); 
		
		throw new GSException("Test is null.");
	}
	
	/**
	 * Zapisuje test w bazie danych.
	 * @param test
	 */
	public static void saveTest(TestBean test) {
		if (test != null) {
			TestRepository.save(test);
			mapTests.put(test.getTitle(), test);
			mapTestsId.put(test.getId(), test.getTitle());
		} else
			log.error("Test is null.");
	} 
	
	/**
	 * Usuwa test z bazy danych.
	 * @param test
	 */
	public static void deleteTest(TestBean test) {
		if (test != null) {
			TestRepository.delete(test);
			mapTests.remove(test.getTitle());
			mapTestsId.remove(test.getId());
		} else
			log.error("Test is null.");
	} 
	
	/**
	 * Metoda aktualizuje test w bazie danych. W argumentach przyjmuje obiekt testu który ma być zaktualizowany,
	 * i obiekt testu na który ma zostać podmieniony. 
	 * @param old
	 * @param newTest
	 */
	public static void updateTest(TestBean old, TestBean newTest) {
		if (old != null && newTest != null) {
			mapTestsId.replace(old.getId(), old.getTitle(), newTest.getTitle());
			mapTests.remove(old.getTitle());
			TestRepository.update(old, newTest);
			mapTests.put(newTest.getTitle(), newTest);
		} else
			log.error("User is null.");
	}
	
	/**
	 * Słownik testów. 
	 */
	public static  Map<String, TestBean> mapTests = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(TestBean tb : getAllTests()) {
				put(tb.getTitle(), tb);
			}
		}
	};
	
	/**
	 * Słownik testów z id jako kluczem.
	 */
	public static  Map<Long, String> mapTestsId = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(TestBean tb : getAllTests()) {
				put(tb.getId(), tb.getTitle());
			}
		} 
	};
	
	/**
	 * Metoda zwracająca obiekt Test po id.  
	 * @param id
	 * @return
	 */
	public static TestBean getTestById(int id) {
		return mapTests.get(mapTestsId.get((long)id));
	}  

	/**
	 * Aktualizuje słowniki testów.
	 */
	public static void updateTestMaps() {
		mapTestsId.clear();
		mapTests.clear();
		for(TestBean b : getAllTests()) {
			mapTestsId.put(b.getId() , b.getTitle());
			mapTests.put(b.getTitle(), b);
		}
		
	}
// ##################################################################################################################################################################################################
// Bug 
// ##################################################################################################################################################################################################
	
	/**
	 * Zwraca listę obiektów błędów pobraną z bazy danych. 
	 * @return
	 */
	public static List<BugBean> getAllBugs() {
		List<BugBean> lstResult = BugRepository.findAll();
		return lstResult;
	}

	/**
	 * Zwaraca błąd o podanym id.
	 * @param id
	 * @return
	 * @throws GSException
	 */
	public static BugBean getBugByID(Long id) throws GSException {
		if (id != null && id.intValue() > 0) {
			BugBean db = BugRepository.findById(id); 
			return db;
		} else
			log.error(" Bug id is null or out of range."); 
		throw new GSException("Bug id is null or out of range.");
	} 
	
	/**
	 * Zwraca błąd o podanym tytule.
	 * @param title
	 * @return
	 * @throws GSException
	 */
	public static BugBean getBugByTitle(String title) throws GSException {
		if (title != null ) {
			BugBean db =BugRepository.findByTitle(title); 
			return db;
		} else
			log.error(" Bug id is null."); 
		
		throw new GSException("Bug is null.");
	}
	
	/**
	 * Zapisuje błąd w bazie danych oraz dodaje go do słowników.
	 * @param bug
	 */
	public static void saveBug(BugBean bug) {
		if (bug != null) {
			BugRepository.save(bug);
			mapBugs.put(bug.getTitle(), bug);
			mapBugsId.put(bug.getId(), bug.getTitle());
		} else
			log.error("Bug is null.");
	} 
	
	/**
	 * Usuwa błąd z bazy danych oraz ze słowników. 
	 * @param bug
	 */
	public static void deleteBug(BugBean bug) {
		if (bug != null) {
			BugRepository.delete(bug);
			mapBugs.remove(bug.getTitle());
			mapBugsId.remove(bug.getId());
		} else
			log.error("Bug is null.");
	} 
	
	/**
	 *  Metoda aktualizuje błąd w bazie danych. W argumentach przyjmuje obiekt błędu który ma być zaktualizowany,
	 * i obiekt błędu na który ma zostać podmieniony. 
	 * @param old
	 * @param newBug
	 */
	public static void updateBug(BugBean old, BugBean newBug) {
		if (old != null && newBug != null) {
			mapBugsId.replace(old.getId(), old.getTitle(), newBug.getTitle());
			mapBugs.remove(old.getTitle());
			BugRepository.update(old, newBug);
			mapBugs.put(newBug.getTitle(), newBug);
		} else
			log.error("Bug is null.");
	}
	
	/**
	 * Słownik błędów.
	 */
	public static Map<String, BugBean> mapBugs = new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			for(BugBean b : getAllBugs()) {
				put(b.getTitle(), b);
			}	
		} 
	};
	
	/**
	 * Słownik błędów z id jako kluczem.
	 */
	public static  Map<Long, String> mapBugsId =new LinkedHashMap<>() {
		private static final long serialVersionUID = 1L;
		{	
			for(BugBean b : getAllBugs()) {
				put(b.getId() , b.getTitle());
			}
		} 
	}; 
	
	/**
	 * Aktualizuje słowniki błędów.
	 */
	public static void updateBugMaps() {
		mapBugsId.clear();
		mapBugs.clear();
		for(BugBean b : getAllBugs()) {
			mapBugsId.put(b.getId() , b.getTitle());
			mapBugs.put(b.getTitle(), b);
		}
	}
	
	/**
	 * Metoda zwracająca obiekt BugBean po id.  
	 * @param id
	 * @return
	 */
	public static BugBean getBugById(int id) {
		return mapBugs.get(mapBugsId.get((long)id));
	} 
}
