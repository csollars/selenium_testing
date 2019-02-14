package ccq;

import org.testng.annotations.Test;
import framework.Step;
import framework.TestBase;

public class UpdatesTest extends TestBase {
	
	@Test(priority = 20)
	public void testAllUpdates() {
		LandingPageTest.navigateToLandingPage();
		ccq675();
		ccq673();
		ccq674();
		ccq672();
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
	
	/**
	 * When I visit any pages on the site containing the verbiage “Match Percentage”
	 * Then it should now read “Match Strength”
	 */
	public void ccq673() {
		Step.Verify.content(LandingPage.whatWeDoSection, "What We Do Section", "innerText", "What do we do? We describe your culture by having your leaders select the importance of 28 cultural descriptors we call cultureCues. Then candidates select from the same cultureCues and we calculate the strength of the match. The greater the match the greater the likelihood the candidate will be successful.");
		
		Step.Action.click(LandingPage.loginButton, "Login Button");
		
		String companyAdmin = "ts@avengers.com";
		String ccqAdmin = "jbelcher@riis.com";
		String password = "Password1";

		Step.Wait.forElementVisible(LoginPage.emailField, "Email Field", 10);
		Step.Action.typeText(LoginPage.emailField, "Email Field", companyAdmin);
		Step.Action.typeText(LoginPage.passwordField, "Password", password);
		Step.Action.click(LoginPage.loginButton_loginPage, "Login Button on Login Page");
		
		Step.Wait.forElementVisible(SideNav.candidatesCTA, "Candidates Tab", 20);
		Step.Action.click(SideNav.candidatesCTA, "Candidates Tab");
		
		Step.Wait.forElementVisible(CandidatesPage.pageLocator, "Candidates Page", 10);
		
		Step.Verify.isVisible(CandidatesPage.matchStrengthColumnHeader, "Match Strength Column Header");
	}
	
	/**
	 * Given_ I am a candidate or potential employee
	 * When_ I have successfully filled out my CultureCues
	 * Then_ I will receive a match score that will fall into 1 of 3 results
	 *  (High Match, Moderate Match, or Low Match)
	 */
	public void ccq674() {
		Step.Wait.forElementVisible(CandidatesPage.firstLowMatch, "Low Match", 10);
		Step.Verify.isVisible(CandidatesPage.firstModerateMatch, "Moderate Match");
		Step.Verify.isVisible(CandidatesPage.firstHighMatch, "High Match");
	}
	
	/**
	 * Given I am the CCQ Admin
	 * When I log into the website
	 * Then I can change the three thresholds for High Match, Moderate Match, and
	 *  Low Match by which each candidate gets classified
	 */
	public void ccq672() {
		/**
		 * Verifying that all of the new elements appear on the page
		 */
		Step.Wait.forElementVisible(CandidatesPage.matchStrengthSettingsHeader, "Match Strength Settings Header", 10);
		Step.Verify.isVisible(CandidatesPage.lowerSlider, "Lower Slider");
		Step.Verify.isVisible(CandidatesPage.upperSlider, "Upper Slider");
		Step.Verify.isVisible(CandidatesPage.highMatchThresholdDisplay, "High Match Threshold");
		Step.Verify.isVisible(CandidatesPage.moderateMatchThresholdDisplay, "Moderate Match Threshold");
		Step.Verify.isVisible(CandidatesPage.lowMatchThresholdDisplay, "Low Match Threshold");
		Step.Verify.isVisible(CandidatesPage.submitButton, "Submit Button");
		Step.Verify.isVisible(CandidatesPage.resetButton, "Reset Button");
		
		/**
		 * Verifying that the sliders move and the threshold displays update with the corresponding values
		 */
		String lowerSliderStartingAria = Step.Extract.getContent(CandidatesPage.lowerSlider, "Lower Slider Aria Value", "aria-valuenow");
		String upperSliderStartingAria = Step.Extract.getContent(CandidatesPage.upperSlider, "Upper Slider Aria Value", "aria-valuenow");
		int lowerSliderStartingAriaValue =(int)  Double.parseDouble(lowerSliderStartingAria);
		int  upperSliderStartingAriaValue = (int) Double.parseDouble(upperSliderStartingAria);
		Step.Action.clickAndDrag(CandidatesPage.lowerSlider, "Lower Slider", -200, 0);
		Step.Wait.forSeconds(2);
		Step.Action.clickAndDrag(CandidatesPage.upperSlider, "Upper Slider", -100, 0);
		Step.Wait.forSeconds(2);
		String lowerSliderAriaNow = Step.Extract.getContent(CandidatesPage.lowerSlider, "Lower Slider Aria Value", "aria-valuenow");
		String upperSliderAriaNow = Step.Extract.getContent(CandidatesPage.upperSlider, "Upper Slider Aria Value", "aria-valuenow");
		int lowerSliderAriaValueNow = (int) Double.parseDouble(lowerSliderAriaNow);
		int upperSliderAriaValueNow =(int)  Double.parseDouble(upperSliderAriaNow);
		
		if (lowerSliderStartingAriaValue > lowerSliderAriaValueNow)
			Step.Passed("Lower Slider moved left");
		else
			Step.Failed("Lower Slider moved left");
		
		if (upperSliderStartingAriaValue > upperSliderAriaValueNow)
			Step.Passed("Upper Slider moved left");
		else
			Step.Failed("Upper Slider moved left");
		
		String highMatchThresholdDisplay = Step.Extract.getContent(CandidatesPage.highMatchThresholdDisplay, "High Match Threshold Display", "innerText");
		String moderateMatchThresholdDisplay = Step.Extract.getContent(CandidatesPage.moderateMatchThresholdDisplay, "Moderate Match Threshold Display", "innerText");
		
		if (highMatchThresholdDisplay.contains(upperSliderAriaNow.replaceAll(".0", "")))
			Step.Passed("High Match Threshold Display has updated with new values");
		else
			Step.Failed("High Match Threshold Display has updated with new values");

		if (moderateMatchThresholdDisplay.contains(lowerSliderAriaNow.replaceAll(".0", "")))
			Step.Passed("Moderate Match Threshold Display has updated with new values");
		else
			Step.Failed("Moderate Match Threshold Display has updated with new values");
		
		/**
		 * Verifying that the sliders move back to where they started from when the reset button is pressed
		 */
		Step.Action.click(CandidatesPage.resetButton,"Reset Button");
		Step.Wait.forSeconds(2);
		lowerSliderAriaNow = Step.Extract.getContent(CandidatesPage.lowerSlider, "Lower Slider Aria Value", "aria-valuenow");
		upperSliderAriaNow = Step.Extract.getContent(CandidatesPage.upperSlider, "Upper Slider Aria Value", "aria-valuenow");
		lowerSliderAriaValueNow = (int) Double.parseDouble(lowerSliderAriaNow);
		upperSliderAriaValueNow = (int) Double.parseDouble(upperSliderAriaNow);
		
		if (lowerSliderStartingAriaValue == lowerSliderAriaValueNow)
			Step.Passed("Clicking Reset Button moves Lower Slider back to starting position");
		else
			Step.Failed("Clicking Reset Button moves Lower Slider back to starting position");
		
		if (upperSliderStartingAriaValue == upperSliderAriaValueNow)
			Step.Passed("Clicking Reset Button moves Upper Slider back to starting position");
		else
			Step.Failed("Clicking Reset Button moves Upper Slider back to starting position");
		
		/**
		 * Verifying that the submitted threshold values are retained after navigating away from the page
		 */
		Step.Action.clickAndDrag(CandidatesPage.lowerSlider, "Lower Slider", -200, 0);
		Step.Wait.forSeconds(2);
		Step.Action.clickAndDrag(CandidatesPage.upperSlider, "Upper Slider", -100, 0);
		Step.Wait.forSeconds(2);
		Step.Action.click(CandidatesPage.submitButton, "Submit Button");
		Step.Wait.forSeconds(3);
		lowerSliderAriaNow = Step.Extract.getContent(CandidatesPage.lowerSlider, "Lower Slider Aria Value", "aria-valuenow");
		upperSliderAriaNow = Step.Extract.getContent(CandidatesPage.upperSlider, "Upper Slider Aria Value", "aria-valuenow");
		Step.Action.click(SideNav.leadersCTA, "Leaders CTA");
		Step.Wait.forElementVisible(LeadersPage.pageLocator, LeadersPage.pageDescription, 10);
		Step.Action.click(SideNav.candidatesCTA, "Candidates CTA");
		Step.Wait.forElementVisible(CandidatesPage.pageLocator, "Candidates Page", 10);
		Step.Wait.forSeconds(3);
		highMatchThresholdDisplay = Step.Extract.getContent(CandidatesPage.highMatchThresholdDisplay, "High Match Threshold Display", "innerText");
		moderateMatchThresholdDisplay = Step.Extract.getContent(CandidatesPage.moderateMatchThresholdDisplay, "Moderate Match Threshold Display", "innerText");
		
		if (highMatchThresholdDisplay.contains(upperSliderAriaNow.replaceAll(".0", "")))
			Step.Passed("High Match Threshold Display shows the values that were submitted before leaving the Candidates Page");
		else
			Step.Failed("High Match Threshold Display shows the values that were submitted before leaving the Candidates Page");

		if (moderateMatchThresholdDisplay.contains(lowerSliderAriaNow.replaceAll(".0", "")))
			Step.Passed("Moderate Match Threshold Display shows the values that were submitted before leaving the Candidates Page");
		else
			Step.Failed("Moderate Match Threshold Display shows the values that were submitted before leaving the Candidates Page");
		
		/**
		 * Just Moving the sliders back. Otherwise, after a few test runs both sliders would be all the way left and steps would begin to fail.
		 */
		Step.Action.clickAndDrag(CandidatesPage.upperSlider, "Upper Slider", 100, 0);
		Step.Wait.forSeconds(2);
		Step.Action.clickAndDrag(CandidatesPage.lowerSlider, "Lower Slider", 200, 0);
		Step.Wait.forSeconds(2);
		Step.Action.click(CandidatesPage.submitButton, "Submit Button");
		Step.Wait.forSeconds(3);
	}
	
}
