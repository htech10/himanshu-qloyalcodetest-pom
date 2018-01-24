package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToursPage {

	private WebDriver _driver = null;
	private WebDriverWait wait = null;
	
	//locators
	private By btnFirstSearchResultDetails = By.xpath("//*[@class='itemscontainer']/table//tr[1]/td/div[2]//button[text()='Details']");

	
	//constructor
	public ToursPage(WebDriver driver) {
		this._driver = driver;
		wait = new WebDriverWait(this._driver, 40);
	}
	
	public ToursPackagePage getDetailsOfFirstSearchResult() throws InterruptedException {
		try {
			_driver.findElement(btnFirstSearchResultDetails).click();
		} catch(Exception e) {
			System.out.println("click on btn Details failed. attempting again");
			wait.until(ExpectedConditions.elementToBeClickable(btnFirstSearchResultDetails));
			try {
				_driver.findElement(btnFirstSearchResultDetails).click();
			} catch(WebDriverException e2) {
				System.out.println("Failed twice. attempting again");
				Thread.sleep(15000);
				_driver.findElement(btnFirstSearchResultDetails).click();
			}
			
		}
	
		return new ToursPackagePage(_driver);
	}
}
