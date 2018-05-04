package protect;

import java.util.ArrayList;
import java.util.Scanner;

import user.User;

public class Project {
	
	private int id = 0;
	private String name = "";
	private String category = "";
	private double goal = 0.0;
	private int deadline = 0;
	private double reward= 0.0;
	private double amount = 0.0;
	private User author = null;
	
	private ArrayList<User> followers = new ArrayList<User>();
	
	public Project(String name, String category, double goal, int deadline, User author, double reward) {
		
		this.setProject(name, category, goal, deadline, author, reward);
	}
	
	public Project() {}
	
	public void createProject(Project project, User user) {
		
		Scanner input = new Scanner(System.in);
		String name;
		String category;
		double goal;
		int deadline;
		double reward;
		
		System.out.print("Qual o nome do seu projeto? > ");
		name = input.nextLine();
		System.out.print("Qual a categoria do seu projeto? > ");
		category = input.nextLine();
		System.out.print("De quanto precisa para realizar o seu projeto? > R$ ");
		goal = input.nextDouble();
		System.out.print("Qual o valor da recompensa dos seus contribuidores? > R$ ");
		reward = input.nextDouble();
		
		if (goal < 0.0 ) {
			System.out.println("%n *** Metas negativas não sao permitidas! *** %n%n");
			return;
		}
		
		if (reward < 0.0 ) {
			System.out.println("%n *** Recompensas negativas não sao permitidas! *** %n%n");
			return;
		}
		
		System.out.print("Em ate quanto tempo? (em dias) > ");
		deadline = input.nextInt();
		
		if (deadline < 0) {
			System.out.println("%n *** Prazos negativos não sao permitidos! *** %n%n");
			return;
		}
		
		project.setProject(name, category, goal, deadline, user, reward);
	}
	
	public void setProject(String name, String category, double goal, int deadline, User author, double reward) {
		
		this.name = name;
		this.category = category;
		this.goal = goal;
		this.deadline = deadline;
		this.author = author;
		this.reward = reward;
	}
	
	public void printProject() {
		
		System.out.printf("| ID: %d%n", this.getId());
		System.out.printf("| NOME: %s%n", this.getName());
		System.out.printf("| CATEGORIA: %s%n", this.getCategory());
		System.out.printf("| META: R$ %.2f%n", this.getGoal());
		System.out.printf("| PRAZO: %d dias%n", this.getDeadline());
		System.out.printf("| AUTOR: %s%n", this.getAuthor().getName());
		System.out.printf("| MONTANTE: R$ %.2f%n", this.getAmount());
		System.out.printf("| RECOMPENSA: +R$ %.2f%n", this.getReward());
		System.out.printf("| SEGUIDORES: %d%n", this.getFollowers().size());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getGoal() {
		return goal;
	}

	public void setGoal(double goal) {
		this.goal = goal;
	}

	public int getDeadline() {
		return deadline;
	}

	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public ArrayList<User> getFollowers() {
		return followers;
	}

	public double getReward() {
		return reward;
	}

	public void setReward(double reward) {
		this.reward = reward;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
