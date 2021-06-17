package Ejerecicio.Uno;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageObjects.NuevoContaco;
import pageObjects.ServicePage;
import pageObjects.signInPage;
import resources.Base;

public class PuntoTresTest extends Base {
	
	public WebDriver driver;
	public Properties prop;
	@BeforeTest 
	public void initalize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test
	public void Entrar() throws IOException, InterruptedException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\59892\\eclipse-workspace\\Uno\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		signInPage sg = new signInPage(driver);
		ServicePage sp = sg.LoginServicePage();
		NuevoContaco nc = sp.LoginNuevoContacto(); 
		nc.getURLnewWindow();
		nc.creandoCuenta(prop.getProperty("name"), prop.getProperty("surname"));
		nc.defaultWindow();
		nc.navegaVentanas(2);
		nc.modificarBien();
		nc.confirmModificarBien();
		nc.modificarMal(prop.getProperty("number"));
		nc.confirmModificarMal();
		
	}
	
	@AfterTest
	public void Quit() {
		driver.quit();
	}


}
