package fr.sirhen.liquibase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import liquibase.integration.commandline.Main;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ChangeLogGeneration {

	@Test
	public void generateChangelog() {

		Main.run(args);

	}

}
