package junit;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import protect.Project;
import user.User;

class ProjectTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testProject() {
		Project tester = new Project();
		Assert.assertTrue(tester.getName().equals(""));
		Assert.assertTrue(tester.getCategory().equals(""));
		Assert.assertNull(tester.getAuthor());
	}

	@Test
	void testProjectStringStringDoubleIntUserDouble() {
		User user = new User();
		Project tester = new Project("projeto teste", "jogos", 100.00, 30, user, 15.00);
		Assert.assertTrue(tester.getName().equals("projeto teste"));
		Assert.assertTrue(tester.getCategory().equals("jogos"));
		Assert.assertEquals(100.00, tester.getGoal(), 0);
		Assert.assertEquals(15.00, tester.getReward(), 0);
		Assert.assertTrue(tester.getDeadline() == 30);
		Assert.assertSame(user, tester.getAuthor());
	}

}
