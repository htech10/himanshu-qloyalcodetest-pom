package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Settings;

public class SignInPage {

	private WebDriver _driver = null;
	private WebDriverWait wait = null;
	
	//locators
	private By btnSignIn = By.xpath("//a[@href='#Sign-In']");
	private By txtBoxEmail 	= By.id("username");
	private By txtBoxPasswd = By.id("password");
	private By btnLogin = By.name("login");
	
	
	
	//constructor
	public SignInPage(WebDriver driver) {
		this._driver = driver;
		wait = new WebDriverWait(this._driver, 40);
	}
	
	
	public void gotoExistingUserTab() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(btnSignIn));
    		_driver.findElement(btnSignIn).click();
		} catch(Exception e) {
			Thread.sleep(5000);
			_driver.findElement(btnSignIn).click();
		}
	}
	
	public InvoicePage signInAsDemoUser() throws InterruptedException {
		
		try {
			gotoExistingUserTab();
		} catch(Exception e) {
			Thread.sleep(2000);
			gotoExistingUserTab();
		}
		
		try {
    		_driver.findElement(txtBoxEmail).sendKeys(Settings.username);
    		_driver.findElement(txtBoxPasswd).sendKeys(Settings.password);
    		_driver.findElement(btnLogin).click();
    	} catch(Exception e) {
    		Thread.sleep(5000);
    		_driver.findElement(txtBoxEmail).clear();
    		_driver.findElement(txtBoxEmail).sendKeys(Settings.username);
    		_driver.findElement(txtBoxPasswd).clear();
    		_driver.findElement(txtBoxPasswd).sendKeys(Settings.password);
    		_driver.findElement(btnLogin).click();
    	}
		
		return new InvoicePage(_driver);
	}
	
	
}
