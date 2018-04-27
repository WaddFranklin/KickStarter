package main;

import menu.Menu;
import user.User;

public class Controller {
	
	public void userLoggedFlow(User currentUser) {
		
		Menu menu = new Menu();
		
		System.out.printf("%n*** Login realizado com sucesso! ***%n%n");
		boolean logged = true;
		int opt;
		
		while (logged) {
			
			opt = menu.userLoggedMenu(currentUser);
			
			switch (opt) {
				
				case 1:
					System.out.println("entrou no 1");
					break;
				case 2:
					System.out.println("entrou no 2");
					break;
				case 3:
					System.out.println("entrou no 3");
					break;
				case 4:
					System.out.println("entrou no 4");
					break;
				case 5:
					System.out.println("entrou no 5");
					break;
				case 6:
					System.out.println("entrou no 6");
					break;
				case 0:
					System.out.printf("%n *** Logout realizado com sucesso! ***%n%n");
					logged = false;
					break;
			}
		}
	}
}
