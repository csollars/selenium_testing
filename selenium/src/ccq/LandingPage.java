package ccq;

import org.openqa.selenium.By;

public class LandingPage {
	public static final By pageLocator = By.xpath("//*[@id='why-culturecliq']");
	public static final String pageDescription = "Landing Page";
	
	public static final By aboutCTA = By.xpath("//a[contains(text(),'About')]");
	public static final By featuresCTA = By.xpath("//a[contains(text(),'Features')]");
	public static final By contactCTA = By.xpath("//a[contains(text(),'Contact')]");
	public static final By loginButton = By.xpath("//button[@id='landing-login-btn']");
	public static final By signUpButton = By.xpath("//button[@id='landing-signup-btn']");

	public static final By learnHowButton = By.xpath("//button[@id='learn-how-btn']");
	public static final By getStartedButton = By.xpath("//button[@id='get-started-btn']");
	public static final By contactUsButton = By.xpath("//button[@id='contact-us-button']");
	
	public static final By whatWeDoSection = By.xpath("//*[@id='whatIsCCQ']");
}
