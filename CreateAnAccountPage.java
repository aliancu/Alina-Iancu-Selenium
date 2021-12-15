package automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.css.model.Value;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.regex.MatchResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

public class CreateAnAccountPage {


    @FindBy(xpath = "//*[contains(@class, 'required form-group form-error')][1]")
    public WebElement nameError;
    @FindBy(className = "navigation_page")
    public WebElement createAnAccountHeader;
    @FindBy(name="id_gender")
    public List<WebElement> genderRadioButtons;
    @FindBy(name="customer_firstname")
    public static WebElement firstNameInput;
    @FindBy(name = "customer_lastname")
    public WebElement lastNameInput;
    @FindBy(id = "email")
    public WebElement emailInput;
    @FindBy(name = "passwd")
    public WebElement passwordInput;
    @FindBy(name = "days")
    public WebElement dayOfBirthDropdown;
    @FindBy(name = "months")
    public WebElement monthOfBirthDropdown;
    @FindBy(name = "years")
    public WebElement yearOfBirthDropdown;
    @FindBy(name = "newsletter")
    public WebElement newsletterCheckBox;
    @FindBy(name = "optin")
    public WebElement specialOffersCheckBox;

    @FindBy(name ="firstname")
    public WebElement firstNameInput2;
    @FindBy(name = "lastname")
    public WebElement lastNameInput2;
    @FindBy(name ="company")
    public WebElement companyNameInput;
    @FindBy(name = "address1")
    public WebElement address1Input;
    @FindBy(name = "address2")
    public WebElement address2Input;
    @FindBy(name = "city")
    public WebElement cityInput;
    @FindBy(name = "id_state")
    public WebElement stateDropdown;
    @FindBy(name = "postcode")
    public WebElement postalCodeInput;
    @FindBy(name = "id_country")
    public WebElement countryDropdown;
    @FindBy(name = "other")
    public WebElement additionalInfoInput;
    @FindBy(name = "phone")
    public WebElement homePhoneInput;
    @FindBy(name = "phone_mobile")
    public WebElement mobilePhoneInput;
    @FindBy(name = "alias")
    public WebElement aliasAddressInput;
    @FindBy(name = "submitAccount")
    public WebElement registerButton;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/ol")
    public WebElement listOfErrors;

    protected WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String headerOfCreateAnAccountPage() {
      return createAnAccountHeader.getText();
    }


    public void selectGender(String gender) {
        if(gender.equalsIgnoreCase("Mr."))
            genderRadioButtons.get(0).click();
        else genderRadioButtons.get(1).click();
    }
    public void typeYourFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }
    public void typeYourLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }
    public void typeYourPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void selectDayOfBirth(String day) {
        Select dobDropdown = new Select(dayOfBirthDropdown);
        dobDropdown.selectByValue(day);
    }
    public void selectMonthOfBirth(String month) {
        Select dobDropdown = new Select(monthOfBirthDropdown);
        dobDropdown.selectByValue(month);
    }
    public void selectYearOfBirth(String year) {
        Select dobDropdown = new Select(yearOfBirthDropdown);
        dobDropdown.selectByValue(year);
    }
    public void setNewsletterCheckbox() {
        if (!newsletterCheckBox.isSelected())
            newsletterCheckBox.click();
    }
    public void setSpecialOffersCheckBox() {
        if (!specialOffersCheckBox.isSelected())
            specialOffersCheckBox.click();
    }
    public void typeYourFirstName2(String firstName2) {
        firstNameInput2.sendKeys(firstName2);
    }
    public void typeYourLastName2(String lastName2) {
        lastNameInput2.sendKeys(lastName2);
    }
    public void typeYourCompany(String company) {
        companyNameInput.sendKeys(company);
    }
    public void typeYourAddress(String address1) {
        address1Input.sendKeys(address1);
    }
    public void typeYourAddress2(String address2) {
        address2Input.sendKeys(address2);
    }
    public void typeYourCity(String city) {
        cityInput.sendKeys(city);
    }
    public void selectYourState(String state) {
        Select dobDropdown = new Select(stateDropdown);
        dobDropdown.selectByVisibleText(state);
    }
    public void typeYourPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
    }
    public void selectYourCountry(String country) {
        Select dobDropdown = new Select(countryDropdown);
        dobDropdown.selectByVisibleText(country);
    }
    public void addAdditionalInfo(String additionalInfo) {
        additionalInfoInput.sendKeys(additionalInfo);
    }
    public void typeYourHomeNumber(String homeNumber) {
        homePhoneInput.sendKeys(homeNumber);
    }
    public void typeYourMobileNumber(String mobileNumber) {
        mobilePhoneInput.sendKeys(mobileNumber);
    }
    public void addAdditionalEmail(String additionalEmail) {
        aliasAddressInput.sendKeys(additionalEmail);
    }
    public void clickOnRegisterButton() {
        registerButton.click();
    }
    public String listOfErrorsPopUp() {
        return listOfErrors.getText();
    }
}
