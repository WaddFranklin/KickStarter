package test;

import user.User;

public class UserTest {

	public static void main(String[] args) {
		
		User user = new User();
		
		user.createUser(user);
		
		System.out.println(user);

	}

}
