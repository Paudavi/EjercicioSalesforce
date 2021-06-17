package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class principalPage {
	
	WebDriver driver;
	public principalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}

	@FindBy(xpath="//*[@class='slds-icon-waffle']")
	WebElement iniciador;
	@FindBy(xpath="//input[@class='slds-input']")
	WebElement buscador;
	@FindBy (xpath="//*[@class='slds-truncate']/*[text()='Servicio']")
	WebElement servicio;

	public WebElement iniciador() {
		return iniciador;
	}
	public WebElement buscador() {
		return buscador;
	}
	public WebElement servicio() {
		return servicio;
	}

	
}
