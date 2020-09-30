package tests;


import lombok.experimental.Helper;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DataHelper;
import utils.PropertiesHelper;

import java.io.IOException;

public class TC001_Login_Valid_Account extends AbstractTest {

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
                .inputPassword(super.dataHelper.getValidPassword())
                .clickOnSignInButton()
                .isLoggedInSuccessful();
    }

}
