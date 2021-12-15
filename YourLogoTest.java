package tests;

import automationpractice.CreateAnAccountPage;
import automationpractice.SignInPage;
import helpers.StringHelper;
import nopcommerce.BuildYourOwnComputerPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;

public class YourLogoTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aliancu\\Downloads\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void CreateAnAccountCheckWithAValidEmailAddress() {
        SignInPage signInPage = new SignInPage(driver);
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        String email = StringHelper.generateRandomEmail();

        signInPage.CreateAnAccount(email);
        signInPage.ClickOnSubmitButton();

        assertThat(createAnAccountPage.headerOfCreateAnAccountPage(), is("Authentication"));
    }

    @Test
    public void CheckBlankSpaceValidationForFirstNameInput() {
        SignInPage signInPage = new SignInPage(driver);
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        String email = StringHelper.generateRandomEmail();
        signInPage.CreateAnAccount(email);
        CreateAnAccountPage setYourAccount = signInPage.createYourAccount();
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(setYourAccount.firstNameInput));

        setYourAccount.selectGender("Mr.");
        setYourAccount.typeYourFirstName(" ");
        setYourAccount.clickOnRegisterButton();

        assertThat(setYourAccount.listOfErrorsPopUp(), is("You must register at least one phone number.\n" +
                "firstname is required." +
                "lastname is required.\n" +
                "passwd is required.\n" +
                "address1 is required.\n" +
                "city is required.\n" +
                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" +
        "This country requires you to choose a State."));
    }

    @Test
    public void CheckIfRespondentsUnder18YoCanRegister() {
        SignInPage signInPage = new SignInPage(driver);
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        String email = StringHelper.generateRandomEmail();
        signInPage.CreateAnAccount(email);
        CreateAnAccountPage setYourAccount = signInPage.createYourAccount();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(setYourAccount.firstNameInput));

        setYourAccount.selectGender("Mrs.");
        setYourAccount.typeYourFirstName("Maria");
        setYourAccount.typeYourLastName("Popescu");
        setYourAccount.typeYourPassword("12345");
        setYourAccount.selectDayOfBirth("1");
        setYourAccount.selectMonthOfBirth("1");
        setYourAccount.selectYearOfBirth("2004");
        setYourAccount.setNewsletterCheckbox();
        setYourAccount.setSpecialOffersCheckBox();
        setYourAccount.typeYourCompany("Endava");
        setYourAccount.typeYourAddress("757 3rd Avenue");
        setYourAccount.typeYourCity("New York");
        setYourAccount.selectYourState("New York");
        setYourAccount.typeYourPostalCode("10017");
        setYourAccount.selectYourCountry("United States");
        setYourAccount.typeYourMobileNumber("01234567");
        setYourAccount.clickOnRegisterButton();

        assertThat(setYourAccount.listOfErrorsPopUp(), is("You must be at least 18 years old to continue."));
    }

    @Test
    public void CheckIfRespondentsCanContinueWithInvalidPostalCodeFormat() {
        SignInPage signInPage = new SignInPage(driver);
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        String email = StringHelper.generateRandomEmail();
        signInPage.CreateAnAccount(email);
        CreateAnAccountPage setYourAccount = signInPage.createYourAccount();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(setYourAccount.firstNameInput));

        setYourAccount.selectGender("Mrs.");
        setYourAccount.typeYourFirstName("Maria");
        setYourAccount.typeYourLastName("Popescu");
        setYourAccount.typeYourPassword("12345");
        setYourAccount.selectDayOfBirth("1");
        setYourAccount.selectMonthOfBirth("1");
        setYourAccount.selectYearOfBirth("2004");
        setYourAccount.setNewsletterCheckbox();
        setYourAccount.setSpecialOffersCheckBox();
        setYourAccount.typeYourCompany("Endava");
        setYourAccount.typeYourAddress("757 3rd Avenue");
        setYourAccount.typeYourCity("New York");
        setYourAccount.selectYourState("New York");
        setYourAccount.typeYourPostalCode("1001");
        setYourAccount.selectYourCountry("United States");
        setYourAccount.typeYourMobileNumber("01234567");
        setYourAccount.clickOnRegisterButton();

        assertThat(setYourAccount.listOfErrorsPopUp(), is("The Zip/Postal code you've entered is invalid. It must follow this format: 00000"));
    }




}




