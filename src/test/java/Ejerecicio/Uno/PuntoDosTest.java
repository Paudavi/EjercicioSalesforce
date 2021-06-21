package Ejerecicio.Uno;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.NuevoCuentas;
import pageObjects.ServicePage;
import pageObjects.signInPage;
import resources.Base;
import resources.ExcelDataProvider;
import resources.Utilities;

public class PuntoDosTest extends Base {

	private WebDriver driver;
	@BeforeMethod 
		public void initalize() throws IOException {
			driver = initializeDriver();
			new Utilities(driver);
		
		}
		
		@Test (dataProvider = "data")
		public void Entrar(String NameAccount, String Valoracion, String Customer, String Propiedad, String Sector, String Priority, String SLA, String opp,
			String Bin, String wantedMonth, String wantedDay) throws IOException, InterruptedException {
			signInPage sg = new signInPage(driver);
			ServicePage sp = sg.LoginServicePage();
			sp.navegaVentanas(2);
			NuevoCuentas c = new NuevoCuentas (driver);
			c.nuevoCuentas().click();
			c.creandoCuenta(NameAccount, Valoracion, Customer, Propiedad, Sector, Priority, SLA, 
					opp, Bin, wantedMonth, wantedDay);
}
	@Test
	public void flaseAccount() throws IOException, InterruptedException {
		signInPage sg = new signInPage(driver);
		ServicePage sp = sg.LoginServicePage();
		sp.navegaVentanas(2);
		NuevoCuentas c = new NuevoCuentas (driver);
		c.nuevoCuentas().click();
		c.creandoFlasaCuenta();
	}
		
		
	@DataProvider (name = "data")
	public Object[][] getData() throws IOException {
		String path= System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.xlsx";		
		ExcelDataProvider excel = new ExcelDataProvider();
		Object data[][] = excel.testData(path, "Accounts");
		return data;		
	}
		
		
		@AfterMethod
		public void Quit() {
			driver.quit();
		}

}