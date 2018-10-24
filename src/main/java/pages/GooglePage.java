package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    private static final String NAME_SEARCH_FIELD = "q";
    private static final String URL_Homepage = "http://www.google.com";
    private static final String CLASS_TOOLS_LINK = "LC20lb";

    public void navigateToHomepage() {
        open(URL_Homepage);
    }

    public void enterQuery(String searchText) {
        $(By.name(NAME_SEARCH_FIELD)).setValue(searchText).pressEnter();
    }

    public ElementsCollection verifySearchResultRecord(int expectedSearchResults) {
        return $$(By.className(CLASS_TOOLS_LINK)).shouldHave(CollectionCondition.sizeGreaterThanOrEqual(expectedSearchResults));
    }
}