package Ejerecicio.Uno;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.NuevoCuentas;
import pageObjects.ServicePage;
import pageObjects.signInPage;
import resources.Base;

public class PuntoDosTest extends Base {

	public WebDriver driver;
	public ServicePage sp;	
		
	@BeforeTest 
		public void initalize() throws IOException {
			driver = initializeDriver();
		}
		
		@Test
		public void Entrar() throws IOException, InterruptedException {
			signInPage sg = new signInPage(driver);
			ServicePage sp = sg.LoginServicePage();
			sp.navegaVentanas(2);
			NuevoCuentas c = new NuevoCuentas (driver);
			c.nuevoCuentas().click();
			c.creandoCuenta(prop.getProperty("1Cuenta"), "Hot","Prospect", "Public", "Banking", "Low", "Silver", "No", "No");
			WebDriverWait w= new WebDriverWait(driver,7);
			w.until(ExpectedConditions.urlContains("count=2"));
			c.creandoCuenta(prop.getProperty("2Cuenta"), "Cold", "Customer - Channel", "Subsidiary", "Chemicals", "High", "Bronze", "Yes", "No");
			c.creandoFlasaCuenta();
}
		
		@AfterTest
		public void Quit() {
			driver.quit();
		}

}