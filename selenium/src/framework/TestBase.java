package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.Step;

public class TestBase {
	
	protected static WebDriver driver;

	@BeforeClass(alwaysRun = true)
	protected final void init() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-extensions");
	    options.addArguments("disable-infobars");
	    driver = new ChromeDriver();
	
//		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
//	    driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
//		final DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
//		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
//		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//		capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//		capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
//	    driver = new InternetExplorerDriver(capabilities);
		
//		System.setProperty("webdriver.edge.driver","drivers/MicrosoftWebDriver.exe");
//		driver = new EdgeDriver();
		
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
