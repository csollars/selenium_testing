package framework;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	protected static WebDriver driver;
//	protected static AppiumDriver<WebElement> driver;
	
	@BeforeTest(alwaysRun = true)
	@Parameters({"browser", "appName"})
	protected final void init(String browser, String appName) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		/**
		 * 	NOTE: Microsoft WebDriver, used to drive Edge browser, is now included in Windows 10.
		 *	You must enable it in Windows. Go to Start > Settings > Apps  > Manage Optional Features
		 *   > Add a Feature > Microsoft Web Driver
		 */
		switch (browser) {
			case "CHROME": 		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
								ChromeOptions options = new ChromeOptions();
								options.addArguments("--disable-extensions");
								driver = new ChromeDriver();
								driver.manage().deleteAllCookies();
								driver.manage().window().maximize();
								break;
			case "FIREFOX" :	System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		    					driver = new FirefoxDriver();	
		    					driver.manage().deleteAllCookies();
		    					driver.manage().window().maximize();
		    					break;
			case "EDGE" :		driver = new EdgeDriver();
								driver.manage().deleteAllCookies();
								driver.manage().window().maximize();
								break;
			case "IE" :			System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
//								capabilities = DesiredCapabilities.internetExplorer();
//								capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//								capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
//								capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//								capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//								capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
//								driver = new InternetExplorerDriver(capabilities);
								driver = new InternetExplorerDriver();
								driver.manage().deleteAllCookies();
								driver.manage().window().maximize();
								break;
//			case "IOS" :		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.2");
//								capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
//								capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
//								capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
//								capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7");
//								capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
//								capabilities.setCapability("newCommandTimeout", 2000);
//								capabilities.setCapability(MobileCapabilityType.APP, "/data/app/" + appName + ".apk");
//								driver = (AppiumDriver<WebElement>) driver;
//								driver = new IOSDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//								break;
//			case "ANDROID" :	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//								capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
//								capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
//								capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.10.0");
//								capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "52034576ecb9a32b");
//								capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
//								capabilities.setCapability(MobileCapabilityType.APP, "/data/app/" + appName + ".apk");
//								capabilities.setCapability(MobileCapabilityType.APP, "/data/app/com.riis.ramen/base.apk");
//								capabilities.setCapability("appPackage", "com.riis.ramen");
//								capabilities.setCapability("appActivity", "com.riis.ramen.activity.MainActivity");
//								capabilities.setCapability("newCommandTimeout", 2000);
//								driver = (AppiumDriver<?>) driver;
//								driver = new AppiumDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//								break;
		}
	}

	@AfterTest(alwaysRun = true)
	protected final void cleanUp() {
		System.out.println("*************************************");
		System.out.println("Steps Passed: " + Step.PASS);
		System.out.println("Steps Failed: " + Step.FAIL);
		System.out.println("*************************************");
		driver.quit();
	}
}
