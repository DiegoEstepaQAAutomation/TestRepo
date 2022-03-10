package com.semilleros.periferia.navegadores;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

import org.openqa.selenium.PageLoadStrategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ClaseBase {
	
	protected WebDriver driver;
	//CONSTRUCTOR DE CLASE
	public ClaseBase(WebDriver driver) 
	{
		super();
	}
	
	
	//CLASE BASE CLASICA 
	
	//METODO NAVEGADOR
	public WebDriver chromeDriverConnection()
	{
		//SETEAR LAS OPCIONES DEL NAVEGADOR
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//SETEAR LAS PROPIEDADES DEL NAVEGADOR
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();
		//MAXIMIZAR NAVEGADOR
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public String fechaHora() 
	{
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		
		//DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyymmdd-HHmmss");
		
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}
	public String HoraSistema() 
	{
		//TOMAMOS LA FECHA DEL SISTEMA
		LocalTime horaSistema = LocalTime.now();
		
		//DEFINIR FORMATO FECHA 
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");
		
		//DAR FORMATO A LA FECHA DEL SISTEMA
		String hora = fecha.format(horaSistema);
		return hora;
	}
	
	public void captureScreen(File rutaCarpeta) throws Exception
	{
		String hora = HoraSistema();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png",new File(rutaCarpeta+"/"+hora+"jpg")); 
		
		
	}
	
	public File crearCarpeta(Properties propiedades,String nomTest ) 
	{
		//FECHA DEL SISTEMA
		String fecha = fechaHora();
		
		//NOMBRE CARPETA 
		String nomCarpeta = nomTest+"-"+fecha;
		
		//RUTA DE ALOJAMIENTO DE SALIDA Y NOMBRE DE TEST A EJECUTAR
		File directorio = new File("./output/" + nomCarpeta);
		
		//CREAMOS LA CARPETA 
		directorio.mkdir();
		return directorio;
		
	} 
	
	//METODO CLICK
	public void click(By locator,File rutaCarpeta) throws Exception
	{
		driver.findElement(locator).click();
		tiempoEspera(5000);
		captureScreen(rutaCarpeta);
		
	}
	
	//METODO BORRAR
	public void borrar(By locator,File rutaCarpeta) throws Exception  
	{
		driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	} 
	
	//METODO ENVIAR TEXTO
	
	public void sendkey(String inputText,By locator,File rutaCarpeta) throws Exception 
	{
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta);
		
	}
	
	//METODO ENTER SUBMIN
	
	public void submit(By locator,File rutaCarpeta) throws Exception 
	{
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta);
	}
	
	//METODO DE TIEMPO DE ESPERA 
	public void tiempoEspera(long tiempo)throws InterruptedException
	{
		Thread.sleep(tiempo);
	}
	
	

}
