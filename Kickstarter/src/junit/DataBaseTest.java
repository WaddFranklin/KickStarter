package junit;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.DataBase;
import protect.Project;
import user.User;

class DataBaseTest {

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testAddUser() {
		DataBase system = new DataBase();
		User user = new User("Wadd", "wadd@wadd.com", "1234");
		system.addUser(user);
		Assert.assertSame(user, system.getUsers().get(0));
		Assert.assertTrue(system.getIdUsers() == 1);
	}

	@Test
	void testAddProject() {
		DataBase system = new DataBase();
		User user = new User();
		Project project = new Project("projeto teste", "jogos", 100.00, 30, user, 15.00);
		system.addProject(project);
		Assert.assertSame(project, system.getProjects().get(0));
		Assert.assertTrue(system.getIdProjects() == 1);
	}

	@Test
	void testRemoveUser() {
		DataBase system = new DataBase();
		User user = new User();
		system.addUser(user);
		Assert.assertTrue(system.getNumUsers() == 1);
		system.removeUser(user);
		Assert.assertTrue(system.getNumUsers() == 0);
	}

}
