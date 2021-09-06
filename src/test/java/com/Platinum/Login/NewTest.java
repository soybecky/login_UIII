package com.Platinum.Login;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class NewTest {
	private org.openqa.selenium.WebDriver driver;
	/* private WebDriver driver; */
	
  @Test
  public void f() {	  
	  org.openqa.selenium.WebElement cuadroBusqueda = driver.findElement(By.name("q"));
	  cuadroBusqueda.sendKeys("pagina principal iplacex");
	  cuadroBusqueda.click();
	  cuadroBusqueda.submit();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  /* Se colocó Buscar con Google */
	  assertEquals("pagina principal iplacex - Buscar con Google", driver.getTitle());
  }
  
  @BeforeTest
  public void beforeTest() {
	  /* Definir el Driver de Chrome */
	  System.setProperty("webdriver.chrome.driver", 			  
			  "H:\\\\SW\\IPLACEX\\08_2021-III\\chromedriver_win32\\chromedriver.exe");	  	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
  }

  @AfterTest
  public void afterTest() {
	  /* Cerrar el driver */
	  driver.quit();
  }
}
