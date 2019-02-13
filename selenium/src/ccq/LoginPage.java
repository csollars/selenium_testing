package ccq;

import org.openqa.selenium.By;

public class LoginPage {
	public static final By pageLocator = By.xpath("//app-login");
	public static final String pageDescription = "Login Page";
	
	public static final By emailField = By.xpath("//input[@id='login-email']");
	public static final By passwordField = By.xpath("//input[@id='login-password']");
	public static final By loginButton_loginPage = By.xpath("//*[@id='login-submit']");
	public static final By forgotPasswordCTA = By.xpath("//a[@id='reset-password']");
}
