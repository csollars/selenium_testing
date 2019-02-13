package ccq;

import org.testng.annotations.Test;

import ccq.Updates;
import ccq.LandingPage_PO;
import framework.Step;
import framework.TestBase;

public class LandingPage_PT extends TestBase {
	@Test(priority = 10)
	public void initialize() {
		String prodURL = "https://www.cultureconnect.com";
		String localDevURL = "localhost:4200";
		String devURL = "http://34.200.86.155:8443/";
		
		Step.Browser.navigateTo(prodURL, 10);
		Step.Wait.forElementVisible(LandingPage_PO.pageLocator, LandingPage_PO.pageDescription, 20);
	}
	
	@Test(priority = 20)
	public void testUpdates() {
		Updates test = new Updates();
		test.ccq675();
		test.ccq673();
		test.ccq674();
		test.ccq672();
	}
	
//	@Test(priority = 20)
//	public void testQuoteFormComponent() {
//		QuoteForm_ComponentTest quoteForm = new QuoteForm_ComponentTest();
//		quoteForm.verifyAll();
//	}
}
