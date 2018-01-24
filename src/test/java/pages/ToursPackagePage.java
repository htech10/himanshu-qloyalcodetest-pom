package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToursPackagePage {

	private WebDriver _driver = null;
	private WebDriverWait wait = null;
	
	//locators
	private By txtAsScrollPoint = By.xpath("//*[text()='Who']");
	private By btnBookNow = By.xpath("//form[contains(@action,'The-Nile-3')]/div[4]/button");
	

	
	//constructor
	public ToursPackagePage(WebDriver driver) {
		this._driver = driver;
		wait = new WebDriverWait(this._driver, 40);
	}
	
	
	public void scrollDown() {
		// Create instance of Javascript executor
    	JavascriptExecutor je = (JavascriptExecutor) _driver;
    	//Identify the WebElement which will appear after scrolling down
    	wait.until(ExpectedConditions.elementToBeClickable(txtAsScrollPoint));
    	WebElement element1 = _driver.findElement(txtAsScrollPoint);
    	// now execute query which actually will scroll until that element is not appeared on page.
    	je.executeScript("arguments[0].scrollIntoView(true);",element1);
	}
	
	
	public SignInPage clickBookNowWithDefaultEntries() throws InterruptedException {
		try {
			scrollDown();
		} catch(Exception e1) {
			Thread.sleep(5000);
			scrollDown();
		}
		
		try {
			_driver.findElement(btnBookNow).click();
		} catch(Exception e) {
			System.out.println("click on btn Details failed. attempting again");
			wait.until(ExpectedConditions.elementToBeClickable(btnBookNow));
			try {
				_driver.findElement(btnBookNow).click();
			} catch(WebDriverException e2) {
				System.out.println("Failed twice. attempting again");
				Thread.sleep(5000);
				_driver.findElement(btnBookNow).click();
			}
			
		}
		
		return new SignInPage(_driver);
	}
}
