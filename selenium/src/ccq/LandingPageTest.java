package ccq;

import ccq.LandingPage;
import framework.Step;
import framework.TestBase;
import org.testng.annotations.Test;

public class LandingPageTest extends TestBase {
	@Test(priority = 10)
	public static void navigateToLandingPage() {
		String prodURL = "https://www.cultureconnect.com";
		String localDevURL = "localhost:4200";
		String devURL = "http://34.200.86.155:8443/";
		
		Step.Browser.navigateTo(localDevURL, 10);
		Step.Wait.forElementVisible(LandingPage.pageLocator, LandingPage.pageDescription, 20);
	}
	
//	@Test(priority = 20)
//	public void testQuoteFormComponent() {
//		QuoteForm_ComponentTest quoteForm = new QuoteForm_ComponentTest();
//		quoteForm.verifyAll();
//	}
}
