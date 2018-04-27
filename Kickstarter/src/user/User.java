package user;

import java.util.ArrayList;
import java.util.Scanner;

import protect.Project;

public class User {
	
	private int id = 0;
	private String name = "";
	private String email = "a";
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

	public void setUser(String name, String email, String password) {
		
		this.name = name;
		this.email = email;
		this.password = password;
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