package tests;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DataHelper;
import utils.PropertiesHelper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AbstractTest {
    protected WebDriver driver;
    protected DataHelper dataHelper;

    @BeforeTest
    @Parameters({"browser", "user-data-file"})
    public void setup(@Optional("chrome") String browser, @Optional("/src/main/resources/data.json") String userDataFile) throws IOException {
        String filePath = System.getProperty("user.dir") + userDataFile;
        driver = DriverFactory.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        dataHelper = DataHelper.get(filePath);
    }

    @AfterTest
    public void teardown() {
        driver.close();
    }

}
