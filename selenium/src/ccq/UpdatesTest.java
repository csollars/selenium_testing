package ccq;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import framework.Step;
import framework.TestBase;

public class UpdatesTest extends TestBase {
	
	@Test(priority = 10)
	public void initialize() {
		String prodURL = "https://www.cultureconnect.com";
		String localDevURL = "localhost:4200";
		String devURL = "http://34.200.86.155:8443/";
		
		Step.Browser.navigateTo(prodURL, 10);
		Step.Wait.forElementVisible(LandingPage.pageLocator, LandingPage.pageDescription, 20);
	}
	
	@Test(priority = 20)
	public void testUpdates() {
		ccq675();
		ccq673();
		ccq674();
		ccq672();
	}
	
	/**
	 * When I visit any pages on the site containing the verbiage “Match Percentage”
	 * Then it should now read “Match Strength”
	 */
	public void ccq673() {
		By whatWeDoSection = By.xpath("//*[@id='whatIsCCQ']");
		Step.Verify.content(whatWeDoSection, "What We Do Section", "innerText", "What do we do? We describe your culture by having your leaders select the importance of 28 cultural descriptors we call cultureCues. Then candidates select from the same cultureCues and we calculate the strength of the match. The greater the match the greater the likelihood the candidate will be successful.");
		
		Step.Action.click(LandingPage.loginButton, "Login Button");
		
		String companyAdmin = "ts@avengers.com";
		String ccqAdmin = "jbelcher@riis.com";
		String password = "Password1";

		Step.Wait.forElementVisible(LoginPage.emailField, "Email Field", 10);
		Step.Action.typeText(LoginPage.emailField, "Email Field", companyAdmin);
		Step.Action.typeText(LoginPage.passwordField, "Password", password);
		Step.Action.click(LoginPage.loginButton_loginPage, "Login Button on Login Page");
		
		By candidatesTab = By.xpath("//*[contains(text(),'Candidates')]");
		Step.Wait.forElementVisible(candidatesTab, "Candidates Tab", 20);
		Step.Action.click(candidatesTab, "Candidates Tab");
		
		By candidatesHeader = By.xpath("//*[@id='candidate-user-management-left-header-content']");
		Step.Wait.forElementVisible(candidatesHeader, "Candidates Header", 5);
		
		By matchStrengthColumnHeader = By.xpath("//*[contains(text(),'Match Strength')]");
		Step.Wait.forElementVisible(matchStrengthColumnHeader, "Match Strength Column Header", 5);
	}
	
	/**
	 * Given_ I am a candidate or potential employee
	 * When_ I have successfully filled out my CultureCues
	 * Then_ I will receive a match score that will fall into 1 of 3 results
	 *  (High Match, Moderate Match, or Low Match)
	 */
	public void ccq674() {
		By firstLowMatch = By.xpath("(//*[@class='font-medium candidate-user-management-candidate-match' and text()='Low Match'])[1]");
		By firstModerateMatch = By.xpath("(//*[@class='font-medium candidate-user-management-candidate-match' and text()='Moderate Match'])[1]");
		By firstHighMatch = By.xpath("(//*[@class='font-medium candidate-user-management-candidate-match' and text()='High Match'])[1]");
		
		Step.Verify.isVisible(firstLowMatch, "Low Match");
		Step.Verify.isVisible(firstModerateMatch, "Moderate Match");
		Step.Verify.isVisible(firstHighMatch, "High Match");
	}
	
	/**
	 * Given I am the CCQ Admin
	 * When I log into the website
	 * Then I can change the three thresholds for High Match, Moderate Match, and
	 *  Low Match by which each candidate gets classified
	 */
	public void ccq672() {
		
	}
	
	/**
	 * Given I want to use the new CultureConnect website
	 * When I navigate to https://cultureconnect.com/
	 * Then I am redirected to the new domain https://app.cultureconnect.com
	 */
	public void ccq675() {
//		Step.Browser.navigateTo("https://www.cultureconnect.com/", 20);
//		Step.Wait.forSeconds(10);
//		String currentURL = Step.Browser.getCurrentURL();
//		if (currentURL.contains("https://app.cultureconnect.com"))
//			Step.Passed("Redirected to https://app.cultureconnect.com");
//		else
//			Step.Failed("Redirected to https://app.cultureconnect.com");
	}
}
