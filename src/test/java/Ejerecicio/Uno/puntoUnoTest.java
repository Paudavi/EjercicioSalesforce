package Ejerecicio.Uno;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ServicePage;
import pageObjects.signInPage;
import resources.Base;

public class puntoUnoTest extends Base {
	
private WebDriver driver;
private ServicePage sp;	
	
@BeforeTest 
	public void initalize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test
	public void Entrar() throws IOException, InterruptedException {
		signInPage sg = new signInPage(driver);
		sp = sg.LoginServicePage();
		sp.navegaVentanas(1);
		sp.navegaVentanas(2);
		sp.nuevoYcierro();
		sp.navegaVentanas(3);
		//sp.wait();
		sp.nuevoYcierro();
		sp.navegaVentanas(4);
		sp.nuevoYcierro();
		sp.navegaVentanas(5);
		sp.nuevoYcanceloInforme();
		sp.navegaVentanas(6);
		sp.nuevoYcanceloPanel();
			}
		

	
	@AfterTest
	public void Quit() {
		driver.quit();
	}


			


}
