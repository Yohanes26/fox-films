package br.com.fox.getQuantityResults;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;

import br.com.fox.entity.DirectorEntity;
import br.com.fox.repository.DirectorRepository;

@TestComponent
public class GetGoogle {

	WebDriver driver;
	
	@Autowired
	private DirectorRepository directorRepository;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/chromedriver");
		driver = new ChromeDriver();

		driver.get(
				"https://www.google.com.br");
	}
	
	@Test
	public void getResult() throws InterruptedException {
		
		List<DirectorEntity> directors = directorRepository.findAll();
		
		if (directors == null || directors.isEmpty()) {
			Assert.assertTrue(false);
		}
		
		Thread.sleep(2000);
		
		WebElement barraPesquisa = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		barraPesquisa.sendKeys(directors.get(0).name + " " + directors.get(0).films.get(0).name);
		barraPesquisa.submit();
		
		Thread.sleep(2000);
		
		WebElement resultStats = driver.findElement(By.id("resultStats"));
		System.out.println(resultStats);
		Assert.assertTrue(resultStats != null);
	}
}
