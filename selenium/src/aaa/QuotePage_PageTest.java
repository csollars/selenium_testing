package aaa;

import org.testng.annotations.Test;

import framework.TestBase;
import framework.Step;
/**
 * Tests the Quote Page
 */
public class QuotePage_PageTest extends TestBase {

	@Test(priority = 10)
	public void initialize() {
		Step.Browser.navigateTo("https://www.aaalife.com/term-life-insurance-quote-input", 10);
		Step.Wait.forElementVisible(QuotePage_PageObject.pageLocator, QuotePage_PageObject.pageDescription, 20);
	}
	
	@Test(priority = 20)
	public void testQuoteFormComponent() {
		QuoteForm_ComponentTest quoteForm = new QuoteForm_ComponentTest();
		quoteForm.verifyAll();
	}
}
