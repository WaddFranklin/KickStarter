package database;

import java.util.Scanner;
import java.util.ArrayList;

import protect.Project;
import user.User;

public class DataBase {
	
	private static int numUsers = 0;
	private static int numProjects = 0;
	private ArrayList<User> users = new ArrayList<User>();
	private ArrayList<Project> projects = new ArrayList<Project>();
	
	public void createAccount() {
		
		User newUser = new User();
		newUser.createUser(newUser);
		newUser.setId(this.numUsers);
		
		addUser(newUser);
	}
	
	public void addUser(User user) {
		
		this.users.add(user);
		this.numUsers++;
	}
	
	public void removeUser(User user) {
		
		this.users.remove(user.getId());
		this.numUsers--;
	}
	
	public User getUserById(int i) {
		
		return this.users.get(i);
	}
	
	public User login() {
		
		Scanner input = new Scanner(System.in);
		String email;
		String password;
		User user = null;
		int i;
		
		System.out.print("Digite seu email: > ");
		email = input.nextLine();
		
		
		for (i = 0 ; i < this.numUsers ; i++) {
			user = this.users.get(i);
			
			if (user.getEmail().equals(email)) {
				break;
			}
		}
		if (i == this.numUsers) {
			System.out.printf("%n*** Email nao cadastrado! ***%n%n");
			return null;
		}
		
		System.out.print("Digite sua senha: > ");
		password = input.nextLine();
		
		if (user.getPassword().equals(password)) {
			return user;
		}
		else {
			System.out.printf("%n*** Email nao cadastrado! ***%n%n");
			return null;
		}
	}
	
	public void printUsers() {
		
		User user = new User();
		int i;
		
		System.out.println("---------------------------------------------------------");
		for (i = 0 ; i < this.numUsers ; i++) {
			
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
	
	public static int getNumUsers() {
		return numUsers;
	}

	public static void setNumUsers(int numUsers) {
		DataBase.numUsers = numUsers;
	}

	public static int getNumProjects() {
		return numProjects;
	}

	public static void setNumProjects(int numProjects) {
		DataBase.numProjects = numProjects;
	}
}
