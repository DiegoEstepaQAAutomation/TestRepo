package com.semilleros.periferia.navegadores;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MapObjeInicio extends ClaseBase 
{
	//CONSTRUCTOR DE LA CLASE
		public MapObjeInicio(WebDriver driver) 
		{
			super(driver);
		}
		
		//ELEMENTOS PAGINA INICIAL 
		By txtBusquedaGoogle = By.name("q");
		By btnBuscar = By.name("btnk");
		By resultado =By.xpath("//h3[contains(text(),'Periferia IT Group – Somos innovación en tecnologí')]"); 

}
