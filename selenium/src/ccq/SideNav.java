package ccq;

import org.openqa.selenium.By;

public class SideNav {
	public static final By componentLocator = By.xpath("//md-sidenav");
	public static final By ccqLogo = By.xpath("//md-sidenav//img");
	public static final By navToggleButton = By.xpath("//*[@id='nav-toggle']");
	public static final By signoutCTA = By.xpath("//*[@id='navigation-signout-btn']");
	public static final By cultureCuesCTA = By.xpath("//*[@id='navigation-company-btn']");
	public static final By candidatesCTA = By.xpath("//*[@id='navigation-candidates-btn']");
	public static final By leadersCTA = By.xpath("//*[@id='navigation-leaders-btn']");
}
