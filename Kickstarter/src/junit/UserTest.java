package junit;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import user.User;

class UserTest {

	User user;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testSetUser() {
		User tester = new User();
		tester.setUser("Wadd", "wadd@wadd.com", "123");
		Assert.assertTrue(tester.getName().equals("Wadd"));
		Assert.assertTrue(tester.getEmail().equals("wadd@wadd.com"));
		Assert.assertTrue(tester.getPassword().equals("123"));
	}
	
	@Test
	void testUser() {
		User tester = new User();
		Assert.assertTrue(tester.getName().equals(""));
		Assert.assertTrue(tester.getEmail().equals(""));
		Assert.assertTrue(tester.getPassword().equals(""));
	}
	
	@Test
	void testUserStringStringString() {
		User tester = new User("Wadd", "wadd@wadd.com", "123");
		Assert.assertTrue(tester.getName().equals("Wadd"));
		Assert.assertTrue(tester.getEmail().equals("wadd@wadd.com"));
		Assert.assertTrue(tester.getPassword().equals("123"));
	}

}
