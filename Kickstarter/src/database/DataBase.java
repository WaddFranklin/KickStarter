package database;

import java.util.Scanner;

import exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.InputMismatchException;

import protect.Project;
import user.User;

public class DataBase {
	
	private static int idUsers = 0;
	private static int idProjects = 0;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Project> projects = new ArrayList<Project>();
	
	public void loadDatabase() {
		User defaultUser = new User("Wadd", "wadd@wadd.com", "123");
		this.addUser(defaultUser);
		defaultUser.setBalance(10.0);
		
		defaultUser = new User("Sam", "sam@sam.com", "1234");
		this.addUser(defaultUser);
		defaultUser.setId(1);
		defaultUser.setBalance(200.0);
		
		defaultUser = new User("Baldoino", "baldoino@baldoino.com", "000");
		this.addUser(defaultUser);
		defaultUser.setId(2);
		defaultUser.setBalance(20000.0);
		
		defaultUser = new User("Ficticio", "fic@ticio.com", "555");
		this.addUser(defaultUser);
		defaultUser.setId(3);
		defaultUser.setBalance(5000.0);
		
		Project defaultProject = new Project("Teclado Personalizável", "Tecnologia", 50000.0, 60, this.getUsers().get(0), 15.0);
		this.addProject(defaultProject);
		defaultProject.setId(0);
		this.getUsers().get(0).addOwnedProject(defaultProject);
		
		defaultProject = new Project("Sentinels of Freedom", "Jogos", 10000.0, 45, this.getUsers().get(1), 20.0);
		this.addProject(defaultProject);
		defaultProject.setId(1);
		this.getUsers().get(1).addOwnedProject(defaultProject);
		
		defaultProject = new Project("Reparador de roupas", "Utilidades", 25000.0, 90, this.getUsers().get(2), 25.0);
		this.addProject(defaultProject);
		defaultProject.setId(2);
		this.getUsers().get(2).addOwnedProject(defaultProject);
	}
	
	public void createAccount() {
		
		User newUser = new User();
		newUser.createUser(newUser);
		newUser.setId(this.idUsers);
		
		addUser(newUser);
	}
	
	public Project newProject(User user) throws NumberFormatException,
	                                            InputMismatchException,
	                                            NegativeNumberException {
		
		Project newProject = new Project();
		newProject.createProject(newProject, user);
		newProject.setId(idProjects);
		
		addProject(newProject);
		return newProject;
	}
	
	public void addUser(User user) {
		
		this.users.add(user);
		this.idUsers++;
	}
	
	public void addProject(Project project) {
		
		this.projects.add(project);
		this.idProjects++;
	}
	
	public void removeUser(User user) {
		
		User userWillRemoved = null;
		int i;
		
		for (i = 0 ; i < this.users.size() ; i++) {
			
			userWillRemoved = this.users.get(i);
			
			if (userWillRemoved.getEmail().equals(user.getEmail()) &&
				userWillRemoved.getPassword().equals(user.getPassword())) {
			
				this.users.remove(i);
				return;
			}
		}
		
		if (i == this.users.size()) {
			System.out.println(" *** Este usuario nao existe! *** ");
			return;
		}
	}
	
	public User login() {
		
		Scanner input = new Scanner(System.in);
		String email;
		String password;
		User user = null;
		int i;
		
		System.out.print("Digite seu email: > ");
		email = input.nextLine();
		
		
		for (i = 0 ; i < this.users.size() ; i++) {
			user = this.users.get(i);
			
			if (user.getEmail().equals(email)) {
				break;
			}
		}
		if (i == this.users.size()) {
			System.out.printf("%n*** Email nao cadastrado! ***%n%n");
			return null;
		}
		
		System.out.print("Digite sua senha: > ");
		password = input.nextLine();
		
		if (user.getPassword().equals(password)) {
			return user;
		}
		else {
			System.out.printf("%n*** Esta conta nao existe! ***%n%n");
			return null;
		}
	}
	
	public void printUsers() {
		
		User user = new User();
		int i;
		
		if (this.users.size() == 0) {
			System.out.println("---------------------------------------------------------");
			System.out.println("           *** NAO HA USUARIOS CADASTRADOS ***           ");
			System.out.println("---------------------------------------------------------");
			return;
		}
		
		System.out.println("---------------------------------------------------------");
		
		for (i = 0 ; i < this.users.size() ; i++) {
			
			user = this.users.get(i);
			
			if (user != null) {
				System.out.printf("ID: %d%n", user.getId());
				System.out.println("NOME: " + user.getName());
				System.out.println("EMAIL: " + user.getEmail());
				System.out.println("PAÍS: " + user.getCountry());
				System.out.println("CIDADE: " + user.getCity());
				System.out.println("PROJETOS PROPRIOS: " + user.getProjectsOwnded());
				System.out.println("PROJETOS SEGUIDOS: " + user.getProjectsFollowed());
				System.out.println("---------------------------------------------------------");
			}
		}
	}
	
	public void printProjects() {
		
		Project project = new Project();
		int i;
		
		if (this.projects.size() == 0) {
			
			System.out.println("---------------------------------------------------------");
			System.out.println("           *** NAO HA PROJETOS CADASTRADOS ***           ");
			System.out.println("---------------------------------------------------------");
			return;
		}
		
		System.out.println("+--------------------------------------------------------");
		for (i = 0 ; i < this.projects.size() ; i++) {
			
			project = this.projects.get(i);
			
			if (project != null) {
				/*
				System.out.printf("ID: %d%n", project.getId());
				System.out.println("TITULO: " +  project.getName());
				System.out.println("CATEGORIA: " + project.getCategory());
				System.out.printf("META: R$ %.2f%n", project.getGoal());
				System.out.printf("PRAZO: %d%n", project.getDeadline());
				System.out.println("AUTOR: " + project.getAuthor().getName());
				System.out.printf("SEGUIDORES: %d%n", project.getFollowers().size());*/
				project.printProject();
				System.out.println("+--------------------------------------------------------");
			}
		}
	}
	
	public int getNumUsers() {
		return this.users.size();
	}
	
	public int getNumProjects() {
		return this.projects.size();
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public static int getIdUsers() {
		return idUsers;
	}

	public static void setIdUsers(int idUsers) {
		DataBase.idUsers = idUsers;
	}

	public static int getIdProjects() {
		return idProjects;
	}

	public static void setIdProjects(int idProjects) {
		DataBase.idProjects = idProjects;
	}
}
