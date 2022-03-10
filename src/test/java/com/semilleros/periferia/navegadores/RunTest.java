package com.semilleros.periferia.navegadores;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//import java.lang.ClassNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunTest {
	private WebDriver driver;
	PagsObjeInicioPrueba paginas;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;

	@Before
	public void setUp() throws InterruptedException, IOException {

		// INSTANCIAR LA CLASE PROPIEDADES DE JAVA UNIT
		propiedades = new Properties();
		
		//INSTANCIAR CLASES DE EXCEL 
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();

		// CREAR LA VARIABLE TIPO INPUTSTRING
		InputStream entrada = null;

		// VALIDAR SI GENERA ERROR AL NO ENCONTRAR EL ARCHIVO
		try {
			entrada = new FileInputStream("./Properties/datos.properties");
			propiedades.load(entrada);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
			// TODO: handle exception
		}
		// INSTANCIAR LA CLASE PAGOBJET
		paginas = new PagsObjeInicioPrueba(driver);

		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER

		driver = paginas.chromeDriverConnection();

		// ACCEDER AL METODO DE ABRIR LA PAGINA

		paginas.urlAcceso(propiedades.getProperty("url"));
	}

	@Test

	public void test() throws Exception 
	{
		// ACCEDER AL METODO DE PRUEBA INICIAL
		paginas.busquedaInicial(leer,propiedades);
	}

	@After
	public void cerrar() {
		driver.quit();
	}

}