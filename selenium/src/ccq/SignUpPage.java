package ccq;

import org.openqa.selenium.By;

public class SignUpPage {
	public static final By pageLocator = By.xpath("//app-signup");
	public static final String pageDescription = "Sign Up  Page";
	
	public static final By companyField = By.xpath("//input[@id='signup-company']");
	public static final By emailField = By.xpath("//input[@id='signup-email']");
	public static final By authCodeField = By.xpath("//input[@id='signup-authorization-code']");
	public static final By passwordField = By.xpath("//input[@id='signup-password']");
	public static final By confirmPasswordField = By.xpath("//input[@id='signup-confirm-password']");
	public static final By createAccountButton = By.xpath("//button[@id='signup-submit']");
	public static final By loginCTA = By.xpath("//a[@href='/login']");
}
