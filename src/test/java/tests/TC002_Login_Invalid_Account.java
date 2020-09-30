package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utils.PropertiesHelper;

import java.io.IOException;

public class TC002_Login_Invalid_Account extends AbstractTest {

    @Test
    public void launch() {
        try {
            driver.get(PropertiesHelper.getPropertyByName("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"launch"})
    public void login() {
        HomePage.init(driver)
                .clickOnSignInLink()
                .inputEmail(super.dataHelper.getEmail())
                .clickContinueButton()
                .inputPassword(super.dataHelper.getInValidPassword())
                .clickOnSignInButton()
                .isLoggedInUnsuccessful();
    }


}
