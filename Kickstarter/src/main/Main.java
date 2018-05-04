package main;

import database.DataBase;
import menu.Menu;
import protect.Project;
import user.User;

public class Main {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		DataBase system = new DataBase();
		Menu menu = new Menu();
		int option;
		boolean running = true;
		
		system.loadDatabase();
		
		while(running) {
			
			System.out.printf("TOTAL DE USUARIOS: %d%n", system.getNumUsers());
			System.out.printf("TOTAL DE PROJETOS: %d%n", system.getNumProjects());
			
			try {
				option = menu.mainMenu();
			}
			catch(NumberFormatException e) {
				option = 100; // invalid value to enter default
			}
			
			
			switch(option) {
			
				case 1:
					
					menu.buildTitle("CRIAR CONTA");
					system.createAccount();
					System.out.printf("%n*** Conta criada com sucesso! ***%n%n");
					break;
				case 2:
					
					User currentUser = new User();
					menu.buildTitle("LOGIN");;
					currentUser = system.login();
					
					if (currentUser != null) {
						
						controller.userLoggedFlow(currentUser, system);
					}
					
					break;
				case 3:
					
					system.printUsers();
					break;
				case 4:
					
					User user = new User();
					menu.buildTitle("REMOVER CONTA");
					user = system.login();
					system.removeUser(user);
					System.out.printf("%n *** Sua conta foi removida com sucesso! *** %n%n");
					
					break;
				case 0:
					
					System.out.printf("%n *** KICKSTARTER ENCERRADO *** ");
					System.exit(0);
					break;
				default:
					System.out.printf("%n *** Entrada invalida! *** %n%n");
			}
		}
		
		

	}

}
