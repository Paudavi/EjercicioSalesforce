package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import resources.Base;

public class NuevoContaco extends Base {
	
	WebDriver driver;
	Properties prop;
	JavascriptExecutor js;

	public NuevoContaco(WebDriver driver) {
		this.driver = driver;
		 this.js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public void getURLnewWindow() {
		WebDriverWait w= new WebDriverWait(driver,5);
		w.until(ExpectedConditions.urlContains("NewContact"));
		String urlNuevoCuentas = driver.getCurrentUrl();
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(urlNuevoCuentas);
	}
	
	
	@FindBy (xpath="//input[@placeholder='Nombre']")
	private WebElement name;
	
	public WebElement name() {
		return name;
	} 
	
	@FindBy (xpath="//input[@placeholder='Apellidos']")
	private WebElement surname;

	public WebElement surname() {
		return surname;
	} 
	
	@FindBy (xpath="//div[@class='modal-footer slds-modal__footer']/button[2]")
	private WebElement guardar;
	
	public WebElement guardar() {
		return guardar;
	}
	
	
	@FindBy (xpath="//footer[@class='slds-modal__footer']/button[2]")
	private WebElement guardar1;
	
	public WebElement guardar1() {
		return guardar1;
	}
	
	
	
	@FindBy (xpath="//div[@class='modal-footer slds-modal__footer']/button[1]")
	private WebElement cancelar;
	
	public WebElement cancelar() {
		return cancelar;
	}
	
	@FindBy (xpath="//footer[@class='slds-modal__footer']/button[1]")
	private WebElement cancelar1;
	
	public WebElement cancelar1() {
		return cancelar1;
	}
	//tbody/tr[1]/td[6]/span[1]/div
	//tbody/tr[1]/td[6]/span[1]/div[1]/a[1]/span[1]/span[1]
	
	@FindBy (xpath="//tbody/tr/td[6]/span/div") 
	private WebElement flecha;
	
	
	
//	@FindBy (xpath="//tbody/tr[1]/td[6]/span[1]/div[1]/a[1]/span[1]/span[1]")
//	private WebElement flecha;
//	
	
	private By flecha1 = By.xpath("//tbody/tr[1]/td[6]/span[1]/div[1]/a[1]/span[1]/span[1]");
	
	public WebElement flecha1() {
		return driver.findElement(flecha1);
	}
	
	public void flecha0() {
		 js.executeScript("arguments[0].click();", flecha);
	}
	
	
	public WebElement flecha() {
		return flecha;
	}
	
	@FindBy (xpath="//a[@title='Modificar']")
	private WebElement modificar1;
	
	public WebElement modificar1() {
		return modificar1;
	}
	
	@FindBy (xpath="//label[text()='Valoración']/following-sibling::div/lightning-base-combobox/div")
	private WebElement valoracion;
	
	public WebElement valoracion() {
		return valoracion;
	}
	
	@FindBy (xpath="//lightning-base-combobox-item[@data-value='Cold']")
	private WebElement valoracionCold;
	
	public WebElement valoracionCold() {
		return valoracionCold;
	}
	 @FindBy (xpath="//label[text()='Tipo']/following-sibling::div/lightning-base-combobox/div")
	 private WebElement tipo;
	 
	 public WebElement tipo() {
		 return tipo;
	 }
	 
	 @FindBy (xpath="//lightning-base-combobox-item[@data-value='Customer - Direct']")
	 private WebElement tipoDirect;
	 
	 public WebElement tipoDirect() {
		 return tipoDirect;
	 }
	 
	 @FindBy (xpath="//button[@name='SaveEdit']")
	 private WebElement save;
	 
	 public WebElement save() {
		 return save;
	 }
	 
	 @FindBy (xpath="//div[@data-key= 'success']")
	 private WebElement messageSuccess;
	 
	 public WebElement messageSuccess() {
		 return messageSuccess;
	 }
	 
	@FindBy (xpath="//input[@name='NumberOfEmployees']")
	private WebElement numbEmployees;
	
	public WebElement numbEmployees() {
		return numbEmployees;
	}
	
	
	@FindBy (xpath="//input[@name='Sic']")
	private WebElement sic;
	
	public WebElement sic() {
	return  sic;
	}
	
	public void sic1() {
		 js.executeScript("arguments[0].click();", sic);
	}
	
	
	
	@FindBy (xpath="//div[contains(text(), 'fuera del rango')]")
	private WebElement errorMessage;
	
	public WebElement errorMessage() {
		return errorMessage;
	}
	
	public void creandoCuenta(String name, String surname) {
		name().sendKeys(name);
		surname().sendKeys(surname);
		guardar1().click();
	}
	 public void cargandoProper() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	 }
	 
	 public void defaultWindow() {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(0));
		 cancelar1().click();
	 }
	 
	 @FindBy(how = How.XPATH, using="//div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root")
		private List<WebElement> Ventanas;
	 
	 public List<WebElement> Ventanas() {
			return Ventanas;
			}
	 
	 public void navegaVentanas (int i) {
			Ventanas().get(i).click();
		}
	 @FindBy (xpath="//div[@data-key=\"success\"]/button")
		private WebElement cierre;
		
	 public WebElement cierre() {
		 return cierre;
	 }
	 

		@FindBy (xpath="//span[text()='success']")
		private WebElement success;
		
	 
	 public WebElement success() {
		 return success;
	 }
	 
	 public void modificarBien() {
		 //Wait1(flecha());
		 WebDriverWait w= new WebDriverWait(driver,5);
		 w.until(ExpectedConditions.urlContains("Recent"));
		 flecha().click();		 
		 modificar1().click();
		 valoracion().click();
		 valoracionCold().click();
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("document.querySelector('.actionBody').scrollTop=200");
		 tipo().click();
		 tipoDirect().click();
		 save().click();
		 w.until(ExpectedConditions.visibilityOf(success()));
		
		 
	 }
	 
	 public void confirmModificarBien() {
			SoftAssert a = new SoftAssert();
			a.assertFalse(messageSuccess().isDisplayed());
			cierre().click();
	 }
	 
	 public void modificarMal(String number) throws InterruptedException {
//		WebDriverWait w= new WebDriverWait(driver,5);
//		 w.until(ExpectedConditions.urlContains("Recent"));
//		 w.until(ExpectedConditions.elementToBeClickable(flecha()));
		 Thread.sleep(3000);
		 flecha().click();
//		 if(!modificar1().isDisplayed()) {flecha().click();}
//		 Wait(modificar1());
		 modificar1().click();
		 js= (JavascriptExecutor)driver;
		 js.executeScript("document.querySelector('.actionBody').scrollTop=200");
		 numbEmployees().sendKeys(number);
		 sic1();
		 numbEmployees().click();
		 save().click();
	 }
	 
	 public void confirmModificarMal() {
			SoftAssert a = new SoftAssert();
			a.assertFalse(errorMessage().isDisplayed());
	 }
	 public WebElement Wait(WebElement a) {
			WebDriverWait w= new WebDriverWait(driver,5);
			return w.until(ExpectedConditions.visibilityOf(a));
		}
	 public WebElement Wait1(WebElement a) {
			WebDriverWait w= new WebDriverWait(driver,5);
			return w.until(ExpectedConditions.elementToBeClickable(a));
		}
	 
	 
}
