package aaa;

import org.openqa.selenium.By;

/**
 * Initializes By objects used to locate elements on the Quote Form
 */
public final class QuoteForm_ComponentObject {
	public static final By componentLocator = By.id("quoteForm");
	public static final String componentDescription = "Quote Form";
	
	public static final By zipCodeFieldLocator = By.id("zip");
	public static final By zipCodeValidInputLocator = By.xpath("//input[@class='zipNumeric dirty valid']");
	public static final By zipCodeInValidInputLocator = By.xpath("//input[@class='zipNumeric dirty invalid'] | //input[@class='zipNumeric pristine invalid']");
	
	public static final By genderDropDownLocator = By.id("gender");
	public static final By defaultGenderLocator = By.xpath("//select[@id='gender']/option[1]");
	public static final By genderValidSelectionLocator = By.xpath("//select[@id='gender' and @class='dirty valid']");
	public static final By genderInvalidSelectionLocator = By.xpath("//select[@id='gender' and @class='dirty invalid]");
	
	public static final By birthMonthDropDownLocator = By.id("month");
	public static final By birthMonthDefaultLocator = By.xpath("//select[@id='month']/option[1]");
	public static final By birthMonthValidSelectionLocator = By.xpath("//select[@id='month' and @class='dirty valid']");
	public static final By birthMonthInvalidSelectionLocator = By.xpath("//select[@id='month' and @class='invalid dirty']");
	
	public static final By birthDayDropDownLocator = By.id("day");
	public static final By birthDayDefaultLocator = By.xpath("//select[@id='day']/option[1]");
	public static final By birthDayValidSelectionLocator = By.xpath("//select[@id='day' and @class='dirty valid']");
	public static final By birthDayInvalidSelectionLocator = By.xpath("//select[@id='day' and @class='invalid dirty]");
	
	public static final By birthYearDropDownLocator = By.id("year");
	public static final By birthYearDefaultLocator = By.xpath("//select[@id='year']/option[1]");
	public static final By birthYearValidSelectionLocator = By.xpath("//select[@id='year' and @class='dirty valid']");
	public static final By birthYearInvalidSelectionLocator = By.xpath("//select[@id='year' and @class='invalid dirty]");
	
	public static final By yesRadioButtonLocator = By.xpath("//label[@for='isMemberYes']");
	public static final By yesButtonInvalidLocator = By.xpath("//input[@id='isMemberYes' and @class='dirty invalid']/following-sibling::label[@for='isMemberYes'] | //input[@id='isMemberYes' and @class='pristine invalid']/following-sibling::label[@for='isMemberYes']");
	public static final By yesButtonValidLocator = By.xpath("//input[@id='isMemberYes' and @class='dirty valid']/following-sibling::label[@for='isMemberYes'] | //input[@id='isMemberYes' and @class='pristine valid']/following-sibling::label[@for='isMemberYes']");
	
	public static final By noRadioButtonLocator = By.xpath("//label[@for='isMemberNo']");
	public static final By noButtonInvalidLocator = By.xpath("//input[@id='isMemberNo' and @class='dirty invalid']/following-sibling::label[@for='isMemberNo'] | //input[@id='isMemberNo' and @class='pristine invalid']/following-sibling::label[@for='isMemberNo']");
	public static final By noButtonValidLocator = By.xpath("//input[@id='isMemberNo' and @class='dirty valid']/following-sibling::label[@for='isMemberNo'] | //input[@id='isMemberNo' and @class='pristine valid']/following-sibling::label[@for='isMemberNo']");
	
	public static final By emailFieldLocator = By.id("contact_email");
	public static final By emailValidInputLocator = By.id("//input[@id='contact_email' and (@class='valid dirty' or @class='valid pristine')");
	
	public static final By feetDropDownLocator = By.id("feet");
	public static final By feetDefaultLocator= By.xpath("//select[@id='feet']/option[1]");
	public static final By feetValidSelectionLocator = By.xpath("//select[@id='feet' and @class='dirty valid']");
	public static final By feetInvalidSelectionLocator = By.xpath("//select[@id='feet' and @class='invalid dirty]");
	
	public static final By inchesDropDownLocator = By.id("inches");
	public static final By inchesDefaultLocator= By.xpath("//select[@id='inches']/option[1]");
	public static final By inchesValidSelectionLocator = By.xpath("//select[@id='inches' and @class='inc dirty valid']");
	public static final By inchesInvalidSelectionLocator = By.xpath("//select[@id='inches' and @class='inc dirty valid]");
	
	public static final By weightInputLocator = By.id("weight");
	public static final By weightInvalidInputLocator = By.className("weightNumeric invalid dirty'");
	public static final By weightValidInputLocator = By.xpath("//input[@id='weight' and @class='weightNumeric dirty valid']");
	
	public static final By nicotineUseYesLocator = By.xpath("//label[@for='nicotineUseYes']");
	public static final By nicotineUseYesValidInputLocator = By.xpath("//input[@id='nicotineUseYes' and @class='dirty valid']/following-sibling::label[@for='nicotineUseYes'] | //input[@id='nicotineUseYes' and @class='pristine']/following-sibling::label[@for='nicotineUseYes']");
	public static final By nicotineUseYesInvalidInputLocator = By.xpath("//input[@id='nicotineUseYes' and @class='pristine invalid']/following-sibling::label[@for='nicotineUseYes']");
	
	public static final By nicotineUseNoLocator = By.xpath("//label[@for='nicotineUseNo']");
	public static final By nicotineUseNoValidInputLocator = By.xpath("//input[@id='nicotineUseNo' and @class='pristine valid']/following-sibling::label[@for='nicotineUseNo'] | //input[@id='nicotineUseNo' and @class='pristine']/following-sibling::label[@for='nicotineUseNo']");
	public static final By nicotineUseNoInvalidInputLocator = By.xpath("//input[@id='nicotineUseNo' and @class='pristine invalid']/following-sibling::label[@for='nicotineUseNo']");
	
	public static final By coverageAmountDropDownLocator = By.id("coverageAmount");
	public static final By defaultCoverageAmountLocator = By.xpath("//select[@id='coverageAmount']/option[9]");
	public static final By coverageAmountValidInputLocator = By.xpath("//select[@id='coverageAmount' and @class='valid dirty']");
	
	public static final By termLengthDropDownLocator = By.xpath("//select[@name='termLength']");
	public static final By defaultTermLengthLocator = By.xpath("//select[@id='termLength']/option[1]");
	public static final By termLengthValidSelectionLocator = By.xpath("//select[@id='termLength' and @class='dirty valid']");
	public static final By termLengthInvalidSelectionLocator = By.xpath("//select[@id='termLength' and @class='dity invalid']");
	
	public static final By seeYourQuoteButtonLocator = By.id("seeQuote");
	
	public static final By dropDownInvalidInputLocator = By.xpath("//select[@class='dirty invalid'] | //select[@class='pristine invalid']");
	public static final By dropDownValidInputLocator = By.xpath("//select[@class='dirty valid']");
	public static final By errorFlipLocatorLocator = By.className("errorModal inline-window--content-inner");
}
