package ccq;

import org.openqa.selenium.By;

public class CandidatesPage {
	public static final By pageLocator = By.xpath("//*[@id='candidate-header']");
	public static final String pageDescription = "Candidates Page";
	
	public static final By matchStrengthColumnHeader = By.xpath("//*[contains(text(),'Match Strength')]");
	public static final By firstLowMatch = By.xpath("(//*[@class='font-medium candidate-user-management-candidate-match' and text()='Low Match'])[1]");
	public static final By firstModerateMatch = By.xpath("(//*[@class='font-medium candidate-user-management-candidate-match' and text()='Moderate Match'])[1]");
	public static final By firstHighMatch = By.xpath("(//*[@class='font-medium candidate-user-management-candidate-match' and text()='High Match'])[1]");
	
	public static final By matchStrengthSettingsHeader = By.xpath("//*[@id='candidate-user-management-left-header-content' and contains(text(),'Match Strength Settings')]");
	public static final By lowerSlider = By.xpath("//*[@class='noUi-handle noUi-handle-lower']");
	public static final By upperSlider = By.xpath("//*[@class='noUi-handle noUi-handle-upper']");
	public static final By highMatchThresholdDisplay = By.xpath("//*[@id='high-threshold-display']");
	public static final By moderateMatchThresholdDisplay = By.xpath("//*[@id='moderate-threshold-display']");
	public static final By lowMatchThresholdDisplay = By.xpath("//*[@id='low-threshold-display']");
	public static final By submitButton = By.xpath("//*[@id='candidate-user-management-submit']");
	public static final By resetButton = By.xpath("//*[@id='candidate-user-management-reset']");
}
