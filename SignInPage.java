package automationpractice;

import nopcommerce.BuildYourOwnComputerPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SignInPage {

    @FindBy(name = "email_create")
    public WebElement createEmailAddress;
    @FindBy(id = "SubmitCreate")
    public WebElement submitButton;

    protected WebDriver driver;
    WebDriverWait wait;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void CreateAnAccount(String email) {
        createEmailAddress.sendKeys(email);
    }
    public void ClickOnSubmitButton() {
        submitButton.click();
    }

    public CreateAnAccountPage createYourAccount() {
        submitButton.click();
        return new CreateAnAccountPage(driver);
    }



}