package com.semilleros.periferia.navegadores;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navegadores { 
	
	private WebDriver driver;
	
	@Before
	public void navegadorChrome()
	
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/?hl=es");
		
	}	
		@Test
		public void iniciarPrueba() 
		{
			WebElement txtBusqueda = driver.findElement(By.name("q"));
			txtBusqueda.clear();
			txtBusqueda.sendKeys("W3schools");
			txtBusqueda.submit();
			
			String titulo = driver.getTitle();
			System.out.println(titulo);
		}
		
		
		@After
		public void cerrarNavegador() 
		{
			driver.quit();
		}
		
		
	


}
