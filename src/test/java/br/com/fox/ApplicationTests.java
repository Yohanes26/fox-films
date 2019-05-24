package br.com.fox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fox.resource.DirectorRestController;

@RunWith(SpringRunner.class)
@ComponentScan("br.com.fox")
@EntityScan("br.com.fox.entity")
@EnableMongoRepositories("br.com.fox.repository")
@TestPropertySource(locations="classpath:test.properties")
@SpringBootTest(classes = {DirectorRestController.class})
public class ApplicationTests {
	
	@Test
	public void contextLoads() {
		
	}

}
