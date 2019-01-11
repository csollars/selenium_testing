package tests;

import org.openqa.selenium.By;

/**
 * Initializes By objects used to locate elements on the Quote Page
 */
public final class QuotePage_PageObject {
	public static final By pageLocator = By.xpath("//*[@id='quoteForm']");
	public static final String pageDescription = "Quote Page";
}
