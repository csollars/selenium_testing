package tests;

import org.openqa.selenium.By;

import framework.Step;

/**
 * Tests the elements on the Quote Form
 */
public class QuoteForm_ComponentTest {
	public void verifyAll() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.componentLocator,
				QuoteForm_ComponentObject.componentDescription, 10)) {
			zipCodeFieldTest();
			genderDropDownTest();
			dateOfBirthDropDownTest();
			areYouAAAmemberRadioButtonTest();
			emailFieldTest();
			heightWeightTest();
			useOfNicotineRadioButtonTest();
			coverageAmountDropDownTest();
			termLengthDropDownTest();
		}
	}
	
	/**
	 * Tests the functionality of the zip code input field
	 */
	public void zipCodeFieldTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.zipCodeFieldLocator, "Zip Code Input Field", 10)) {
			
			//Verifies the zip code field populates with the user's zip code
			String zipInputBoxTextContent = 
					Step.Extract.getContentUsingJS(QuoteForm_ComponentObject.zipCodeFieldLocator, "Zip Code Field");
			if(zipInputBoxTextContent.isEmpty()) {
				Step.Failed("Zip Code Field is empty");
			} else {
				Step.Passed("Zip Code Field populated with user's location");
			}
			
			//Verifies special characters aren't accepted
			Step.Wait.forSeconds(1);
			Step.Action.typeText(QuoteForm_ComponentObject.zipCodeFieldLocator, "Zip Code Input Field", "!@#$%");
			Step.Action.click(QuoteForm_ComponentObject.seeYourQuoteButtonLocator, "See Your Quote Button");
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.zipCodeInValidInputLocator,
					"Zip Code Field shows invalid input", 10);
			
			//Veriies invalid zip codes aren't accepted
			Step.Action.typeText(QuoteForm_ComponentObject.zipCodeFieldLocator, "Zip code Input field", "00000");
			Step.Action.click(QuoteForm_ComponentObject.seeYourQuoteButtonLocator, "See Your Quote button");
			Step.Action.click(QuoteForm_ComponentObject.seeYourQuoteButtonLocator, "See Your Quote button");
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.zipCodeInValidInputLocator,
					"Zip Code Field shows invalid input", 10);
			
			//Verifies that only 5 digits are accepted
			Step.Action.typeText(QuoteForm_ComponentObject.zipCodeFieldLocator, "Zip Code Input Field", "1234567");
			zipInputBoxTextContent = Step.Extract.getContentUsingJS(QuoteForm_ComponentObject.zipCodeFieldLocator,
					"Zip code text box");
			if(zipInputBoxTextContent.length() > 5) {
				Step.Failed("Zip Code Input Field contains more than 5 digits");
			} else {
				Step.Passed("Zip Code Input Field does not accept more than 5 digits");
			}
			
			//Verifies user cannot submit a blank zip code
			Step.Action.clear(QuoteForm_ComponentObject.zipCodeFieldLocator, "Zip Code Input Field");
			Step.Action.click(QuoteForm_ComponentObject.seeYourQuoteButtonLocator, "See Your Quote Button");
			Step.Action.click(QuoteForm_ComponentObject.seeYourQuoteButtonLocator, "See Your Quote Button");
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.zipCodeInValidInputLocator,
					"Zip Code Input Field shows invalid input", 10);
			
			//Verifies that a valid input is accepted
			Step.Action.typeText(QuoteForm_ComponentObject.zipCodeFieldLocator, "Zip Code Input Field", "48146");
			Step.Action.click(QuoteForm_ComponentObject.seeYourQuoteButtonLocator, "See Your Quote Button");
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.zipCodeValidInputLocator,
					"Zip Code Field displays as valid input", 10);
		}
	}
	
	/**
	 * Tests the gender drop-down menu
	 */
	public void genderDropDownTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.genderDropDownLocator, "Gender drop-down", 5)) {
			dropDownTest(QuoteForm_ComponentObject.genderDropDownLocator, QuoteForm_ComponentObject.defaultGenderLocator, 
					QuoteForm_ComponentObject.genderValidSelectionLocator,QuoteForm_ComponentObject.genderInvalidSelectionLocator, "Select", "Male");
		}
	}
	
	/**
	 * Tests the date of birth drop-downs
	 */
	public void dateOfBirthDropDownTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.birthMonthDropDownLocator, "Birth month drop-down", 5)) {
			dropDownTest(QuoteForm_ComponentObject.birthMonthDropDownLocator,QuoteForm_ComponentObject.birthMonthDefaultLocator,
					QuoteForm_ComponentObject.birthMonthValidSelectionLocator, QuoteForm_ComponentObject.birthMonthInvalidSelectionLocator, "MM", "June");
		}
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.birthDayDropDownLocator, "Birth day drop-down", 5)) {
			dropDownTest(QuoteForm_ComponentObject.birthDayDropDownLocator, QuoteForm_ComponentObject.birthDayDefaultLocator,
					QuoteForm_ComponentObject.birthDayValidSelectionLocator,QuoteForm_ComponentObject.birthDayInvalidSelectionLocator, "DD", "14");
		}
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.birthYearDropDownLocator, "Birth year drop-down", 5)) {
			dropDownTest(QuoteForm_ComponentObject.birthYearDropDownLocator, QuoteForm_ComponentObject.birthYearDefaultLocator,
					QuoteForm_ComponentObject.birthYearValidSelectionLocator, QuoteForm_ComponentObject.birthYearInvalidSelectionLocator, "YYYY", "1990");
		}
	}
	
	/**
	 * Tests the "Are you a AAA member?" radio buttons
	 */
	public void areYouAAAmemberRadioButtonTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.yesRadioButtonLocator, "Yes radio button", 5) &&
				Step.Wait.forElementVisible(QuoteForm_ComponentObject.noRadioButtonLocator, "No radio button", 5)){
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.yesButtonInvalidLocator, "Yes button invalid (your quote button has already been pressed before)", 5);
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.noButtonInvalidLocator, "No button invalid (your quote button has already been pressed before)", 5);
			
			Step.Action.click(QuoteForm_ComponentObject.yesRadioButtonLocator, "AAA member (yes radio button)");
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.yesButtonValidLocator, "Yes button is now valid", 5);
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.noButtonValidLocator, "No button is now valid", 5);
		}
	}
	
	/**
	 * Tests the email input field
	 */
	public void emailFieldTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.emailFieldLocator, "Email input field", 5)) {
			Step.Action.typeText(QuoteForm_ComponentObject.emailFieldLocator, "Email input field", "test@test.com");
		}
	}
	
	/**
	 * Tests the height drop-downs and weight input field
	 */
	public void heightWeightTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.feetDropDownLocator, "Feet drop-down", 5)) {
			dropDownTest(QuoteForm_ComponentObject.feetDropDownLocator, QuoteForm_ComponentObject.feetDefaultLocator, 
					QuoteForm_ComponentObject.feetValidSelectionLocator, QuoteForm_ComponentObject.feetInvalidSelectionLocator, "FT.", "6");
		}
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.inchesDropDownLocator, "Inches drop-down", 5)) {
			dropDownTest(QuoteForm_ComponentObject.inchesDropDownLocator, QuoteForm_ComponentObject.inchesDefaultLocator,
					QuoteForm_ComponentObject.inchesValidSelectionLocator, QuoteForm_ComponentObject.inchesInvalidSelectionLocator, "IN.", "1");
		}
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.weightInputLocator, "Weight input field", 5)) {
			String weightPlaceHolderLBS = Step.Extract.getContent(QuoteForm_ComponentObject.weightInputLocator, "Weight placeholder", "placeholder");
			
			if(weightPlaceHolderLBS.contentEquals("LBS.")) {
				Step.Passed("Weight text box displays 'LBS.' as a placeholder");
			} else {
				Step.Failed("Weight text box does not display 'LBS.' as a placeholder");
			}
			
			Step.Action.typeText(QuoteForm_ComponentObject.weightInputLocator, "Weight input field", "2345");
			String weightSpecified = Step.Extract.getContentUsingJS(QuoteForm_ComponentObject.weightInputLocator,
					"Weight input field content");
			if(weightSpecified.length() > 3) {
				Step.Failed("Weight input field accepts more than 3 digits");
			} else {
				Step.Passed("Weight input field does not accept more than 3 digits");
			}
		}
	}
	
	/**
	 * Tests the "Have you used nicotine in the last 12 months?" radio buttons
	 */
	public void useOfNicotineRadioButtonTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.nicotineUseYesLocator, "Nicotine use YES button", 5) &&
				Step.Wait.forElementVisible(QuoteForm_ComponentObject.nicotineUseNoLocator, "Nicotine use NO button", 5)){
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.nicotineUseYesInvalidInputLocator, "Nicotine YES button is not selected by default", 5);
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.nicotineUseNoInvalidInputLocator, "Nicotine NO button is not selected by default", 5);
			
			Step.Action.click(QuoteForm_ComponentObject.nicotineUseYesLocator, "Nicotine use YES button");
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.nicotineUseYesValidInputLocator, "Nicotine YES button appears selected", 5);
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.nicotineUseNoValidInputLocator, "Nicotine NO button no longer shows an error", 5);
		}
	}
	
	/**
	 * Tests coverage amount drop-down
	 */
	public void coverageAmountDropDownTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.coverageAmountDropDownLocator, "Coverage Amount drop-down", 5)) {
			dropDownTest(QuoteForm_ComponentObject.coverageAmountDropDownLocator, QuoteForm_ComponentObject.defaultCoverageAmountLocator,
					QuoteForm_ComponentObject.coverageAmountValidInputLocator, null, "$500,000", "$250,000");
		}
	}
	
	/**
	 * Tests Term Length drop-down
	 */
	public void termLengthDropDownTest() {
		if(Step.Wait.forElementVisible(QuoteForm_ComponentObject.termLengthDropDownLocator, "Term Length drop-down", 5)) {
			dropDownTest(QuoteForm_ComponentObject.termLengthDropDownLocator, QuoteForm_ComponentObject.defaultTermLengthLocator, 
					QuoteForm_ComponentObject.termLengthValidSelectionLocator, QuoteForm_ComponentObject.termLengthInvalidSelectionLocator, "Select", "10 Years");
		}
	}
	
	/**
	 * @param dropDownElement - drop-down box you are testing
	 * @param defaultDropDownElement - drop-down element's placeholder
	 * @param validDropDownStatus - element when information entered in the text-box is correct
	 * @param invalidDropDownStatus - element when information entered in the text-box is incorrect
	 * @param defaultDropDownText - text that drop-down displays by default
	 * @param optionToSelect - text option that you want to select from the drop-down
	 */
	public void dropDownTest(By dropDownElement, By defaultDropDownElement, By validDropDownStatus, By invalidDropDownStatus,
			String defaultDropDownText, String optionToSelect) {
		String dropDownText = Step.Extract.getContent(defaultDropDownElement, "default status of the drop-down", "textContent");

		if(dropDownText.contentEquals(defaultDropDownText)) {
			Step.Passed("drop-down displays " + defaultDropDownText + " by default");
			Step.Action.click(QuoteForm_ComponentObject.seeYourQuoteButtonLocator, "See your quote");
			Step.Wait.forElementVisible(QuoteForm_ComponentObject.dropDownInvalidInputLocator, "Drop-down displays invalid input", 10);
		} else {
			Step.Failed("drop-down displays " + dropDownText + " by default");
		}
		
		Step.Action.selectByValue(dropDownElement, "Drop-down", optionToSelect);
		
		String selectedElementXpath = "//option[contains(text(),'%s')]";
		By selectedOption = By.xpath(String.format(selectedElementXpath, optionToSelect));
		
		dropDownText = Step.Extract.getContent(selectedOption, "Selected drop-down option", "textContent");
		
		if(dropDownText.contains(optionToSelect)) {
			Step.Passed("Drop-down displays selected option " + optionToSelect);
			if(validDropDownStatus != null) {
				Step.Wait.forElementVisible(validDropDownStatus, "drop-down displays valid input", 10);
			}
		} else {
			Step.Failed("Drop-down does not display selected option: " + optionToSelect);
		}
	}
	
}
