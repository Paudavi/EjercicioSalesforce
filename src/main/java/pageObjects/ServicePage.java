package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ServicePage {

	WebDriver driver;
	public ServicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	

	@FindBy(xpath="//a[@title='Nuevo']")
	private WebElement nuevoCuentas;
	@FindBy(how = How.XPATH, using="//div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[@data-id='Account']")
	private WebElement Cuentas;
	@FindBy (xpath="//a[@title='Cuenta2']")
	private WebElement cuenta2;
	@FindBy (xpath="//button[@name='Global.NewContact']")
	private WebElement nuevocontacto;
	@FindBy(how = How.XPATH, using="//div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root")
	private List<WebElement> Ventanas;
	@FindBy (xpath="//a[contains(@title,'Nuevo')]")
	private WebElement nuevo;
	@FindBy (xpath="//button[@name='CancelEdit']")
	private WebElement cancel;
	@FindBy (how = How.XPATH, using="//div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root/a[@title='Chatter']")
	private WebElement chatter;
	@FindBy (xpath="//button[@title='Cancelar']")
	private WebElement cancelar;
	@FindBy (xpath = "//a[@title='Nuevo informe']")
	private WebElement nuevoInforme;
	@FindBy (xpath="//iframe[@class='isEdit reportsReportBuilder']")
	private WebElement informeFrame;
	@FindBy (xpath="//button[text()='Cancelar']")
	private WebElement textCancelar;
	@FindBy (xpath="//a[@title='Nuevo panel']")
	private WebElement nuevoPanel;
	@FindBy (xpath="//iframe[@title='dashboard']")
	private WebElement panelesFrame;
	@FindBy (xpath="//button[@id='cancelBtn']")
	private WebElement cancelButton;
	@FindBy (xpath="//div[@class='inlineFooter']/div/div/div[3]/button")
	private WebElement cancel1;
	public static final String xpathTab1="//div/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root/a[@title='%s']";
	
	
	public WebElement cancel1() {
		return cancel1;
	}
	
	public WebElement methodChatter() {
	      String newUser = "Chatter";
	      String fullXpath = String.format(xpathTab1, newUser);
	     return driver.findElement(By.xpath(fullXpath));
	    }
	
	public WebElement methodAccount() {
	      String newUser = "Account";
	      String fullXpath = String.format(xpathTab1, newUser);
	     return driver.findElement(By.xpath(fullXpath));
	    }
	
	public WebElement cancelButton() {
		return cancelButton;
	}
	
	
	
	public WebElement panelesFrame() {
		return panelesFrame;
	}
	
	
	public WebElement Wait(WebElement a) {
		WebDriverWait w= new WebDriverWait(driver,5);
		return w.until(ExpectedConditions.visibilityOf(a));
	}
	public WebElement nuevoPanel() {
		return nuevoPanel;
	}
	public WebElement textCancelar() {
		return textCancelar;
	}
	public WebElement informeFrame() {
		return informeFrame;
	}
	
	public WebElement nuevoInforme() {
		return nuevoInforme;
	}
	
	public WebElement cancelar() {
		return cancelar;
	}
	
	
	public WebElement cancel() {
		return cancel;
	}
	
	
	public WebElement nuevoContacto() {
		return nuevocontacto;
	}
	
	public WebElement cuenta2() {
		return cuenta2;	
	}
	
	
	public WebElement cuentas() {
		return Cuentas;
	}
	
	public WebElement nuevoCuentas() {
		return nuevoCuentas;
	}

	public List<WebElement> Ventanas() {
	return Ventanas;
	}
	
	public WebElement nuevo() {
		return nuevo;
	}
	public WebElement chatter() {
		return chatter;
	}
	
	public void nuevoYcierro() throws InterruptedException {
		waitURL();
		nuevo().click();
		Wait(cancel());
		cancel().click();
	}
	public void nuevoYcancelo() throws InterruptedException {
		waitURL();		
		nuevoCuentas().click();
		Wait(cancelar());
		cancelar().click();
	}
	
	public WebDriver switchTo(WebElement element) {
		return driver.switchTo().frame(element);
	}
	
	public WebDriver switchBack() {
		return 	driver.switchTo().defaultContent();

	}
	
	
	
	
	public void nuevoYcanceloInforme() throws InterruptedException {
		nuevoInforme().click();
		WebDriverWait w= new WebDriverWait(driver,5);
		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(informeFrame()));
		
		textCancelar().click();
		switchBack();
			}
	
	public void nuevoYcanceloPanel() throws InterruptedException {
		
		nuevoPanel().click();
		WebDriverWait w= new WebDriverWait(driver,5);

		w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(panelesFrame()));
	
		cancelButton().click();
		switchBack();

	}
	
	public void navegaVentanas (int i) {
		Ventanas().get(i).click();
	}
	public void quit() {
		driver.quit();
	}
	
	public NuevoContaco LoginNuevoContacto() {
		cuentas().click();
		cuenta2().click();
		nuevoContacto().click();
		NuevoContaco nc = new NuevoContaco(driver);
		return nc;
		
	}
	
	public  void waitURL() {
	WebDriverWait w= new WebDriverWait(driver,5);
	w.until(ExpectedConditions.urlContains("Recent"));
	}
	
}
