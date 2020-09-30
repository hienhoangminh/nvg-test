package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "nav-link-accountList")
    private WebElement accountList;

    @FindBy(xpath = "//div[@id='nav-signin-tooltip']//a[descendant::span[text()='Sign in']]")
    private WebElement signInLink;

    @FindBy(id = "ap_email")
    private WebElement emailField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "ap_password")
    private WebElement passwordField;

    @FindBy(id = "signInSubmit")
    private WebElement signInSubmitButton;

    @FindBy(xpath = "//div[@id='nav-tools']/a[@id='nav-link-accountList']/div[contains(descendant::text(),'Hello')]")
    private WebElement userName;

    @FindBy(id = "auth-error-message-box")
    private WebElement errorMessage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public static HomePage init(WebDriver driver) {
        return new HomePage(driver);
    }

    public boolean isAt() {
        return this.accountList.isDisplayed();
    }

    public HomePage clickOnSignInLink() {
        wait.until(ExpectedConditions.visibilityOf(this.signInLink));
        this.signInLink.click();
        return this;
    }

    public HomePage inputEmail(String email) {
        this.emailField.sendKeys(email);
        return this;
    }

    public HomePage clickContinueButton() {
        this.continueButton.click();
        return this;
    }

    public HomePage clickOnSignInButton() {
        this.signInSubmitButton.click();
        return this;
    }


    public HomePage inputPassword(String password) {
        this.passwordField.sendKeys(password);
        return this;
    }

    public void isLoggedInSuccessful() {
        wait.until(ExpectedConditions.visibilityOf(this.userName));
        Assert.assertNotEquals(this.userName.getText().split(" ")[1], "");
    }

    public boolean isLoggedInUnsuccessful() {
        return this.errorMessage.isDisplayed();
    }

}
