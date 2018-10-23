package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    private static final String NAME_SEARCH_FIELD = "q";
    private static final String URL_Homepage = "http://www.google.com";

    public void navigateToHomepage() {
        open(URL_Homepage);
    }

    public void enterQuery(String searchText) {
        $(By.name(NAME_SEARCH_FIELD)).setValue(searchText).pressEnter();
    }

    public boolean verifyPageTitle(String expectedPageTitle) {
       return title().equals(expectedPageTitle);
    }
}