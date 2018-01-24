package base;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utils.ConfigReader;
import utils.Settings;

public class TestInit_docker {
	protected WebDriver driver = null;
//	protected String browser = "Chrome";
	protected String app = null;
	WebDriverWait wait = null;
	protected String _url = null;
	protected DesiredCapabilities capabilities;
	
	@BeforeClass
	@Parameters({ "browser" })
	public void beforeTests(String browser) throws IOException {
		ConfigReader.PopulateSettings();
		app = Settings.app;
		_url = "http://192.168.99.100:8888/wd/hub";
		
		if (browser.equals("Chrome")) {
			capabilities = DesiredCapabilities.chrome();
		} else if(browser.equals("Firefox")) {
			capabilities = DesiredCapabilities.firefox();
		}

		driver = new RemoteWebDriver(new URL(_url), capabilities);
		driver.navigate().to(app);
//		driver.manage().window().maximize();
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
