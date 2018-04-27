package main;

import database.DataBase;
import menu.Menu;
import user.User;

public class Main {

	public static void main(String[] args) {
		
		Controller controller = new Controller();
		DataBase system = new DataBase();
		Menu menu = new Menu();
		int option;
		boolean running = true;
		
		// carga na base de dados -------------------------------------------------
		User defaultUser = new User("Wadd", "wadd@wadd.com", "123");
		system.addUser(defaultUser);
		defaultUser.setBalance(10.0);
		
		
		defaultUser = new User("Sam", "sam@sam.com", "1234");
		system.addUser(defaultUser);
		defaultUser.setId(1);
		defaultUser.setBalance(200.0);
		
		defaultUser = new User("Baldoino", "baldoino@baldoino.com", "000");
		system.addUser(defaultUser);
		defaultUser.setId(2);
		defaultUser.setBalance(20000.0);
		// carga na base de dados -------------------------------------------------
		
		while(running) {
			
			System.out.printf("TOTAL DE USUARIOS: %d%n", system.getNumUsers());
			System.out.printf("TOTAL DE PROJETOS: %d%n", system.getNumProjects());
			option = menu.mainMenu();
			
			switch(option) {
			
				case 1:
					menu.createAccountTitle();
					system.createAccount();
					System.out.printf("%n*** Conta criada com sucesso! ***%n%n");
					break;
				case 2:
					
					User currentUser = new User();
					menu.loginTitle();
					currentUser = system.login();
					
					if (currentUser != null) {
						
						controller.userLoggedFlow(currentUser);
					}
					
					break;
				case 3:
					system.printUsers();
					break;
				case 4:
					
					User user = new User();
					menu.deleteAccountTitle();
					user = system.login();
					system.removeUser(user);
					System.out.printf("%n *** Sua conta foi removida com sucesso! *** %n%n");
					
					
					break;
				case 0:
					System.out.printf("%n *** KICKSTARTER ENCERRADO *** ");
					System.exit(0);
					break;
			}
		}
		
		

	}

}
