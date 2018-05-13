package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import database.DataBase;
import exceptions.NegativeNumberException;
import menu.Menu;
import protect.Project;
import user.User;

public class Controller {
	
	Scanner input = new Scanner(System.in);
	Menu menu = new Menu();
	
	public void editProfileFlow(User currentUser) {
		
		Menu menu = new Menu();
		boolean editting = true;
		int opt;
		
		while (editting) {
			
			try {
				opt = menu.editProfile();
			}
			catch(NumberFormatException e) {
				opt = 100; // invalid value to enter default
			}
			
			switch (opt) {
				case 1:
					String name;
					System.out.print("Digite o novo nome de usuario: > ");
					name = input.nextLine();
					currentUser.setName(name);
					System.out.printf("%n *** Nome de usuario alterado! *** %n%n");
					break;
				case 2:
					String email;
					System.out.print("Digite seu novo email: > ");
					email = input.nextLine();
					currentUser.setEmail(email);
					System.out.printf("%n *** Email alterado! *** %n%n");
					break;
				case 3:
					String city;
					System.out.print("Digite sua cidade natal: > ");
					city = input.nextLine();
					currentUser.setCity(city);
					System.out.printf("%n *** Cidade alterada! *** %n%n");
					break;
				case 4:
					String country;
					System.out.print("Digite seu pais de origem: > ");
					country = input.nextLine();
					currentUser.setCountry(country);
					System.out.printf("%n *** Pais alterado! *** %n%n");
					break;
				case 5:
					currentUser.changePassword();
					break;
				case 0:
					editting = false;
					break;
				default:
					System.out.printf("%n *** Entrada invalida! *** %n%n");
				}
		}
	}
	
	public void userLoggedFlow(User currentUser, DataBase system) {
		
		Menu menu = new Menu();
		
		System.out.printf("%n*** Login realizado com sucesso! ***%n%n");
		boolean logged = true;
		int opt;
		
		while (logged) {
			
			try {
				opt = menu.userLoggedMenu(currentUser);
			}
			catch(NumberFormatException e) {
				opt = 100; // invalid value to enter default
			}
			
			switch (opt) {
				
				case 1:
					Project newProject = new Project();
					
					try {
						menu.buildTitle("CRIAR PROJETO");;
						newProject = system.newProject(currentUser);
					}
					catch(NumberFormatException e1) {
						System.out.printf("%n *** O tipo de entrada nao foi a esperada! ***");
						System.out.printf("%n *** Digite ponto para separar as casas decimais dos números! *** %n%n");
						System.out.println(e1.getMessage());
						break;
					}
					catch(NegativeNumberException e2) {
						System.out.printf("%n%s%n%n", e2.getMessage());
						break;
					}
					currentUser.addOwnedProject(newProject);
					System.out.printf("%n *** Projeto criado com sucesso! *** %n%n");
					break;
				case 2:
					
					system.printProjects();
					menu.buildTitle("SEGUIR");
					currentUser.followProject(system);
					break;
				case 3:
					
					this.editProfileFlow(currentUser);
					break;
				case 4:
					
					menu.buildTitle("PERFIL");
					currentUser.printProfile();
					break;
				case 5:
					
					try {
						currentUser.contribute(system);
					}
					catch(NumberFormatException e1) {
						System.out.printf("%n *** O valor informado nao eh valido! *** %n%n");
						System.out.println(" " + e1.getMessage());
					}
					catch(ArrayIndexOutOfBoundsException e2) {
						System.out.printf("%n *** O ID %s nao existe! *** %n%n", e2.getMessage());
					}
					catch(IndexOutOfBoundsException e3) {
						System.out.printf("%n *** O ID nao existe! *** %n%n");
						System.out.println(" " + e3.getMessage());
					}
					break;
				case 6:
					
					double balance;
					
					System.out.print("Digite a quantia que deseja adicionar: > R$ ");
					balance = Double.parseDouble(input.nextLine());
					currentUser.setBalance(currentUser.getBalance() + balance);
					System.out.printf("%n *** Saldo adicionado com sucesso! *** %n%n");
					break;
				case 7:
					
					menu.buildTitle("MEUS PROJETOS");
					currentUser.printMyOwnnedProjects();
					break;
				case 8:
					
					menu.buildTitle("PROJETOS QUE SIGO");
					currentUser.printMyFollowedProjects();
					break;
				case 9:
					
					menu.buildTitle("EXPLORAR");
					system.printProjects();
					break;
				case 0:
					
					System.out.printf("%n *** Logout realizado com sucesso! ***%n%n");
					logged = false;
					break;
				default:
					System.out.printf("%n *** Entrada invalida! *** %n%n");
			}
		}
	}
}
