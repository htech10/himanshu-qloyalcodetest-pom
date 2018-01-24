package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvoicePage {

	private WebDriver _driver = null;
	private WebDriverWait wait = null;
	
	//locators
	private By btnPayOnArrival = By.xpath("//button[text()='Pay on Arrival']");
	private By msgBookingStatus = By.xpath("//table[@id='invoiceTable']//tr[1]/td/div");
	
		
	//constructor
	public InvoicePage(WebDriver driver) {
		this._driver = driver;
		wait = new WebDriverWait(this._driver, 40);
	}
	
	
	public void clickPayOnArrival() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnPayOnArrival));
    		_driver.findElement(btnPayOnArrival).click();
		} catch(Exception e) {
			Thread.sleep(2000);
			_driver.findElement(btnPayOnArrival).click();
		}
		
		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(5000);
	    	robot.keyPress(KeyEvent.VK_ENTER);
	    	robot.keyRelease(KeyEvent.VK_ENTER);
	    
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem with windows confirm dialog on Pay On Arrival screen");
		}
	}
	
	public String getBookingStatusMsg() throws InterruptedException {
		clickPayOnArrival();
		WebElement m = null;
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(msgBookingStatus));
			m = _driver.findElement(msgBookingStatus);
			} catch(Exception e) {
				Thread.sleep(3000);
				m = _driver.findElement(msgBookingStatus);
			}
		
		
		return m.getText();
	}
	
}
