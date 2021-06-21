package Ejerecicio.Uno;

import java.io.IOException;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.NuevoContaco;
import pageObjects.ServicePage;
import pageObjects.signInPage;
import resources.Base;
import resources.ExcelDataProvider;

public class PuntoTresTest extends Base {
	
	private WebDriver driver; 
	@BeforeTest 
	public void initalize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test (dataProvider = "data")
	public void Entrar(String campo, String valor, String campo1, String valor1) throws IOException, InterruptedException {		
		properties();
		signInPage sg = new signInPage(driver);
		ServicePage sp = sg.LoginServicePage();
		NuevoContaco nc = sp.LoginNuevoContacto(); 
		nc.getURLnewWindow();
		nc.creandoCuenta(prop.getProperty("name"), prop.getProperty("surname"));
		nc.defaultWindow();
		nc.navegaVentanas(2);
		nc.modificarBien(campo, valor, campo1, valor1);
		nc.confirmModificarBien();
		nc.modificarMal(prop.getProperty("number"));
		nc.confirmModificarMal();
		
	}
	
	@DataProvider (name = "data")
	public Object[][] getData() throws IOException {
		String path= System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.xlsx";		
		ExcelDataProvider excel = new ExcelDataProvider();
		Object data[][] = excel.testData(path, "Modifications");
		return data;		
	}
	
	
	@AfterTest
	public void Quit() {
		driver.quit();
	}


}
