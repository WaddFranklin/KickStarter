package user;

import java.util.ArrayList;
import java.util.Scanner;

import database.DataBase;
import menu.Menu;
import protect.Project;

public class User {
	
	private int id = 0;
	private String name = "";
	private String email = "";
	private String password = "";
	private String country = "";
	private String city = "";
	private double balance = 0.0;
	private double reward = 0.0;
	private ArrayList<Project> projectsOwnded = new ArrayList<Project>();
	private ArrayList<Project> projectsFollowed = new ArrayList<Project>();
	
	public User(String name, String email, String password) {
		
		this.setUser(name, email, password);
	}
	
	public User() {}
	
	public void createUser(User user) {
		
		Scanner input = new Scanner(System.in);
		
		String tempName;
		String tempEmail;
		String tempPassword1 = "#";
		String tempPassword2 = "*";

		
		System.out.print("Digite o nome de usuario: > ");
		tempName = input.nextLine();
		System.out.print("Digite o email: > ");
		tempEmail = input.nextLine();
		
		while(!(tempPassword1.equals(tempPassword2))) {
			
			System.out.print("Digite a senha: > ");
			tempPassword1 = input.nextLine();
			System.out.print("Confirme a senha: > ");
			tempPassword2 = input.nextLine();
			
			if (!(tempPassword1.equals(tempPassword2))) {
				System.out.println("*** As senhas nao conferem ***");
			}
		}
		
		user.setUser(tempName, tempEmail, tempPassword1);
	}
	
	public void followProject(DataBase system) throws NumberFormatException {
		
		Scanner input = new Scanner(System.in);
		Project project = new Project();
		int opt;
		int i;
		
		System.out.printf("Digite o ID do projeto que voce deseja seguir: > ");
		opt = Integer.parseInt(input.nextLine());
		
		if (opt < 0) {
			System.out.printf("%n *** Este ID nao e valido! *** %n%n");
		}
		
		project = system.getProjects().get(opt);
		
		if (project.getAuthor() == this) {
			System.out.printf("%n *** Voce nao pode seguir seu proprio projeto! ***%n%n");
			return;
		}
		
		if (project != null) {
			
			this.projectsFollowed.add(project);
			project.getFollowers().add(this);
			System.out.printf("%n *** Voce esta seguindo o projeto %s! *** %n%n", project.getName());
		}
		else {
			System.out.printf("%n *** Este ID nao de projeto nao existe! *** %n%n");
		}
	}

	public void setUser(String name, String email, String password) {
		
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public void addOwnedProject(Project project) {
		
		this.projectsOwnded.add(project);
	}
	
	public void printProfile() {
		
		System.out.printf("| ID: %d%n", this.getId());
		System.out.printf("| NOME: %s%n", this.getName());
		System.out.printf("| EMAIL: %s%n", this.getEmail());
		System.out.printf("| PASSWORD: %s%n", this.getPassword());
		System.out.printf("| PAIS: %s%n", this.getCountry());
		System.out.printf("| CIDADE: %s%n", this.getCity());
		System.out.printf("| SALDO: %.2f%n", this.getBalance());
		System.out.printf("| DESCONTO: %.2f%n", this.getReward());
		System.out.printf("| PROJETOS PROPRIOS: %d%n", this.getProjectsOwnded());
		System.out.printf("| PROJETOS SEGUIDOS: %d%n", this.getProjectsFollowed());
		System.out.println("+-----------------------------------");
	}
	
	public void printMyOwnnedProjects() {
		
		Project project = new Project();
		int i;
		
		if (this.projectsOwnded.size() == 0) {
			System.out.printf("%n *** Voce nao possui pojetos cadastrados! *** %n%n");
			return;
		}
		
		for (i = 0 ; i < this.projectsOwnded.size() ; i++) {
			
			project = this.projectsOwnded.get(i);
			
			System.out.println("+-----------------------------------");
			project.printProject();
			System.out.println("+-----------------------------------");
		}
	}
	
	public void printMyFollowedProjects() {
		
		Project project = new Project();
		int i;
		
		if (this.projectsFollowed.size() == 0) {
			System.out.printf("%n *** Voce nao segue nenhum projeto! *** %n%n");
			return;
		}
		
		for (i = 0 ; i < this.projectsFollowed.size() ; i++) {
			
			project = this.projectsFollowed.get(i);
			
			System.out.println("+-----------------------------------");
			project.printProject();
			System.out.println("+-----------------------------------");
		}
	}
	
	public void contribute(DataBase system) throws NumberFormatException,
												   IndexOutOfBoundsException,
												   ArrayIndexOutOfBoundsException {
		
		Scanner input = new Scanner(System.in);
		Menu menu = new Menu();
		Project project = null;
		int opt;
		double value;
		
		if (this.projectsFollowed.size() == 0) {
			
			System.out.printf("%n *** Voce nao segue nenhum projeto! *** %n%n");
			return;
		}
		
		menu.buildTitle("PROJETOS QUE SIGO");
		this.printMyFollowedProjects();
		menu.buildTitle("CONTRIBUIR");
		System.out.printf("Digite o ID do projeto que deseja contribuir: > ");
		opt = Integer.parseInt(input.nextLine());
		
		project = system.getProjects().get(opt);
		
		System.out.printf("Com quanto deseja contribuir? > R$ ");
		value = Double.parseDouble(input.nextLine());
		
		if (value > this.getBalance()) {
			System.out.printf("%n *** Voce nao possui saldo suficiente para contribuir com essa quantia! *** %n%n");
			return;
		}
		
		project.setAmount(project.getAmount() + value);
		this.setBalance(this.getBalance() - value);
		this.setReward(this.getReward() + project.getReward());
		
		System.out.printf("%n *** Parabens! Voce contribuiu com R$ %.2f reais! *** %n%n", value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void changePassword() {
		
		Scanner input = new Scanner(System.in);
		String newPassword;
		String oldPassword;
		
		System.out.print("Digite sua senha antiga: > ");
		oldPassword = input.nextLine();
		
		if (!this.getPassword().equals(oldPassword)) {
			System.out.printf("%n *** As senhas nao conferem! *** %n%n");
			return;
		}
		
		System.out.print("Digite a nova senha: > ");
		newPassword = input.nextLine();
		System.out.print("confirme a nova senha: > ");
		oldPassword = input.nextLine();
		
		if (!newPassword.equals(oldPassword)) {
			System.out.printf("%n *** As senhas nao conferem! *** %n%n");
			return;
		}
		
		System.out.printf("%n *** Senha alterada! *** %n%n");
		this.setPassword(newPassword);
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		
		if (balance < 0.0) {
			System.out.printf("%n%n *** Nao e possivel adicionar um saldo negativo! *** %n%n");
			return;
		}
		
		this.balance = balance;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", country=" + country + ", city="
				+ city + ", balance=" + balance + ", reward=" + reward + "]";
	}

	public int getProjectsOwnded() {
		return this.projectsOwnded.size();
	}

	public int getProjectsFollowed() {
		return this.projectsFollowed.size();
	}
	
}