package menu;

import java.util.Scanner;

import user.User;

public class Menu {
	
	Scanner input = new Scanner(System.in);
	
	public int mainMenu() throws NumberFormatException {
		
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
		return Integer.parseInt(input.nextLine());
	}
	
	public void buildTitle(String title) {
		
		title = title.toUpperCase();
		
		String str = "*** ";
		final int RANGE = 34;
		str += title;
		str += " ***";
		int blancSpace = RANGE - str.length();
		int halfBlankSpace = (int) Math.floor(blancSpace / 2);
		int i;
		
		System.out.printf("+----------------------------------+%n|"); // 34
		for (i = 1 ; i <= blancSpace; i++) {
			if (i == halfBlankSpace) {
				System.out.print(" ");
				System.out.print(str);
			}
			else {
				System.out.print(" ");
			}
		}
		System.out.printf("|%n+----------------------------------+%n");
	}
	
	public int userLoggedMenu(User user) throws NumberFormatException {
		
		System.out.println("------------------------------------");
		System.out.printf(" USUARIO: %s%n", user.getName());
		System.out.printf(" SALDO: R$ %.2f%n", user.getBalance());
		System.out.println("+----------------------------------+");
		System.out.println("| 1. Criar projeto                 |");
		System.out.println("| 2. Seguir projeto                |");
		System.out.println("| 3. Editar Perfil                 |");
		System.out.println("| 4. Exibir Perfil                 |");
		System.out.println("| 5. Contribuir                    |");
		System.out.println("| 6. Adicionar fundos              |");
		System.out.println("| 7. Meus projetos                 |");
		System.out.println("| 8. Projetos que sigo             |");
		System.out.println("| 9. Explorar                      |");
		System.out.println("| 0. Logout                        |");
		System.out.println("+----------------------------------+");
		System.out.print("O que deseja fazer? > ");
		return Integer.parseInt(input.nextLine());
	}
	
	
	
	public int editProfile() throws NumberFormatException {
		
		System.out.println("+----------------------------------+");
		System.out.println("|       *** EDITAR PERFIL ***      |");
		System.out.println("+----------------------------------+");
		System.out.println("| 1. Editar nome                   |");
		System.out.println("| 2. Editar email                  |");
		System.out.println("| 3. Editar cidade                 |");
		System.out.println("| 4. Editar pais                   |");
		System.out.println("| 5. Editar senha                  |");
		System.out.println("| 0. Voltar                        |");
		System.out.println("+----------------------------------+");
		System.out.print("O que deseja fazer? > ");
		return Integer.parseInt(input.nextLine());
	}
}
