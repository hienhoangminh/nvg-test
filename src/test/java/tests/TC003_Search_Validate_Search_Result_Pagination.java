package tests;

import org.testng.annotations.Test;
import pages.SearchPage;
import utils.PropertiesHelper;
import java.io.IOException;

public class TC003_Search_Validate_Search_Result_Pagination extends AbstractTest {

    @Test
    public void launch() {
        try {
            driver.get(PropertiesHelper.getPropertyByName("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(dependsOnMethods = {"launch"})
    public void searchWithoutSort() {
        SearchPage.init(driver)
                .mouseOverLanguageDropdown()
                .selectLanguage(super.dataHelper.getLanguage())
                .selectDepartment(super.dataHelper.getDepartment())
                .inputValueIntoSearch(super.dataHelper.getKeyword())
                .clickOnSearchInput()
                .validSearchResultNumber();
    }
}
