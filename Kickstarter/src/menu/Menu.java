package menu;

import java.util.Scanner;

import user.User;

public class Menu {
	
	Scanner input = new Scanner(System.in);
	
	public int mainMenu() {
		
		System.out.println("+----------------------------------+");
		System.out.println("| *** BEM VINDO AO KICKSTARTER *** |");
		System.out.println("+----------------------------------+");
		System.out.println("| 1. Criar uma conta               |");
		System.out.println("| 2. Fazer login                   |");
		System.out.println("| 3. Info                          |");
		System.out.println("| 4. Remover conta                 |");
		System.out.println("| 0. Sair                          |");
		System.out.println("+----------------------------------+");
		System.out.print("O que deseja fazer? > ");
		return input.nextInt();
	}
	
	public void createAccountTitle() {
		
		System.out.println("+----------------------------------+");
		System.out.println("|       *** CRIAR CONTA ***        |");
		System.out.println("+----------------------------------+");
	}
	
	public void deleteAccountTitle() {
		
		System.out.println("+----------------------------------+");
		System.out.println("|      *** REMOVER CONTA ***       |");
		System.out.println("+----------------------------------+");
	}
	
	public void loginTitle() {
		
		System.out.println("+----------------------------------+");
		System.out.println("|          *** LOGIN ***           |");
		System.out.println("+----------------------------------+");
	}
	
	public int userLoggedMenu(User user) {
		
		System.out.println("------------------------------------");
		System.out.printf(" USUARIO: %s%n", user.getName());
		System.out.printf(" SALDO: R$ %.2f%n", user.getBalance());
		System.out.println("+----------------------------------+");
		System.out.println("| 1. Criar projeto                 |");
		System.out.println("| 2. Seguir projeto                |");
		System.out.println("| 3. Editar Perfil                 |");
		System.out.println("| 4. Contribuir                    |");
		System.out.println("| 5. Adicionar fundos              |");
		System.out.println("| 6. Explorar                      |");
		System.out.println("| 0. Logout                        |");
		System.out.println("+----------------------------------+");
		System.out.print("O que deseja fazer? > ");
		return input.nextInt();
	}
	
public int editProfile() {
		
		System.out.println("+----------------------------------+");
		System.out.println("|       *** EDITAR PERFIL ***      |");
		System.out.println("+----------------------------------+");
		System.out.println("| 1. Editar nome                   |");
		System.out.println("| 2. Editar email                  |");
		System.out.println("| 3. Editar cidade                 |");
		System.out.println("| 4. Editar pais                   |");
		System.out.println("| 4. Editar senha                  |");
		System.out.println("| 0. Sair                          |");
		System.out.println("+----------------------------------+");
		System.out.print("O que deseja fazer? > ");
		return input.nextInt();
	}
}
