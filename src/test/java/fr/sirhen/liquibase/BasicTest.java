package fr.sirhen.liquibase;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.francoisandre.testliquibase.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class BasicTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	@Sql({"classpath:delete.sql", "classpath:data.sql" })
	@Sql(scripts = "classpath:delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void test() {
		List < User > users = jdbcTemplate.query("select * from users", new UserRowMapper());
		display(users);
		Assert.assertEquals(2, users.size());
	}

	private void display(final List < User > users) {
		System.out.println("------------ Liste des users ------ ");
		for (User user : users) {
			System.out.println(user.getFullname());
		}
		System.out.println("------------ Fin ------ ");

	}

}
