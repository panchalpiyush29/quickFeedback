package pages;

import config.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends Hooks {

    private static final String NAME_SEARCH_FIELD = "q";
    private static final String URL_Homepage = "http://www.google.com";

    public void navigateToHomepage() {
        driver.get(URL_Homepage);
    }

    public void enterQuery(String searchText) {
        WebElement element = driver.findElement(By.name(NAME_SEARCH_FIELD));
        element.sendKeys(searchText);
        element.submit();
    }

    public boolean verifyPageTitle(String expectedPageTitle) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(expectedPageTitle));
        return driver.getTitle().equals(expectedPageTitle);
    }
}