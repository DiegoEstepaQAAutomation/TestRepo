package com.semilleros.periferia.navegadores;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import utilidadesExcel.ReadExcelFile;



public class PagsObjeInicioPrueba extends MapObjeInicio  
{
	//CREAR CONSTRUCTOR DE CLASE
	public PagsObjeInicioPrueba(WebDriver driver) 
	{
		super(driver);
	}
	
	//METODO INICIAL
	
	public void urlAcceso(String url) 
	{
		driver.get(url);
		//busquedaInicial();
	}
	
	//METODO PRIMERA PRUEBA
	
	public void busquedaInicial(ReadExcelFile leer, Properties propiedades) throws Exception
	{
		//OBTENER EL NOMBRE DEL METODO A EJECUTAR
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		//CREAR CARPETA PARA EL ALMACENAMIENTO DE IMAGENES
		File rutaCarpeta = crearCarpeta(propiedades,nomTest);
		
		sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"),"Hoja1",1,0),txtBusquedaGoogle,rutaCarpeta);
		submit(txtBusquedaGoogle,rutaCarpeta);
		tiempoEspera(2000);
		click(resultado,rutaCarpeta);
		driver.close();
		
	}
	
	
	

}
