package test;

import database.DataBase;
import user.User;

public class DataBaseTest {

	public static void main(String[] args) {
		
		DataBase system = new DataBase();
		
		system.createAccount();
		
		
		
		
		
		System.out.println(system.getNumUsers());
		
		User user = system.getUserById(0);
		
		System.out.println(user);
		
		system.login();

	}

}
