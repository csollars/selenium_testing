package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.Step;

public class BrowserManagement {
	
	protected static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	protected final void init() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	     options.addArguments("--disable-extensions");
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	protected final void cleanUp() {
		System.out.println("*************************************");
		System.out.println("Steps Passed: " + Step.PASS);
		System.out.println("Steps Failed: " + Step.FAIL);
		System.out.println("*************************************");
		driver.quit();
	}
}
