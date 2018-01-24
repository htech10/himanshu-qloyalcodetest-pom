package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import utils.ConfigReader;
import utils.Settings;

public class TestInit {
	protected WebDriver driver = null;
	protected String browser = "Chrome";
	protected String app = null;
	WebDriverWait wait = null;

	@BeforeClass
	public void beforeTests() throws IOException {
		ConfigReader.PopulateSettings();
		app = Settings.app;
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.navigate().to(app);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 40);
	}
	
	@AfterMethod
	public void afterEachTest(ITestResult result) {
		
		String testCaseName = result.getName();
		if(result.isSuccess()) {
			System.out.println("Test Case "+testCaseName+" is PASSED !!");
		} else {
			System.out.println("Test Case "+testCaseName+" is FAILED !!");
		}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
