package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ComparatorHelper;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private ComparatorHelper comparatorHelper;

    private static By by = By.xpath("//div[contains(@class,'a-color-secondary')]/span[contains(@class,'a-text-normal')]");

    @FindBy(id = "searchDropdownBox")
    private WebElement departmentDropdown;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@id='nav-belt']/div[@class='nav-right']/div[@id='nav-tools']/a[@id='icp-nav-flyout']//span[contains(@class, 'icp-nav-flag')]")
    private WebElement languageDropdown;

    @FindBy(xpath = "//div[@id='nav-flyout-icp']/div[contains(@class, 'nav-flyout-content')]//*[contains(@class,'nav-item') and descendant::i[contains(@class, 'icp-radio')]]")
    private List<WebElement> languageOption;

    @FindBy(xpath = "//input[@type='submit' and @value='Go']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@data-component-type='s-search-results']/div[contains(@class,'s-main-slot')]/div[(@data-uuid)]")
    private List<WebElement> searchResults;

    @FindBy(id = "a-autoid-0-announce")
    private WebElement sortDropdown;

    @FindBy(xpath="//ul[@role='listbox']/li[@class='a-dropdown-item']/a")
    private List<WebElement> sortOptions;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
        this.action = new Actions(driver);
        comparatorHelper = ComparatorHelper.getInstance();
    }

    public static SearchPage init(WebDriver driver) {
        return new SearchPage(driver);
    }

    public SearchPage selectDepartment(String value) {
        Select select = new Select(this.departmentDropdown);
        select.selectByVisibleText(value);
        return this;
    }

    public SearchPage inputValueIntoSearch(String text) {
        this.searchInput.sendKeys(text);
        return this;
    }

    public SearchPage mouseOverLanguageDropdown() {
        action.moveToElement(this.languageDropdown).build().perform();
        return this;
    }

    public SearchPage selectLanguage(String language) {
        wait.until(ExpectedConditions.visibilityOfAllElements(this.languageOption));
        WebElement matchingLanguage = this.languageOption.stream().filter(el -> el.getText().contains(language)).findAny().orElse(null);
        if (matchingLanguage != null) {
            matchingLanguage.click();
        }
        return this;
    }

    public SearchPage clickOnSearchInput() {
        this.searchButton.click();
        return this;
    }

    public void validSearchResultNumber() {
        Assert.assertEquals(this.searchResults.size(), 16);
    }

    public SearchPage clickOnSortDropdown() {
        this.sortDropdown.click();
        return this;
    }

    public SearchPage clickOnSortOption(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElements(this.sortOptions));
        WebElement sortOption = this.sortOptions.stream().filter(el -> el.getText().contains(text)).findAny().orElse(null);
        if (sortOption != null) {
            sortOption.click();
        }
        return this;

    }

    public void validateSearchResultsWithSort() {
        List<String> publishedDateList = this.searchResults.stream()
                .map(el -> el.findElement(by))
                .map(e -> e.getText())
                .filter(ele -> ele != null)
                .collect(Collectors.toList());
        comparatorHelper.isSorted(publishedDateList);
    }
}
