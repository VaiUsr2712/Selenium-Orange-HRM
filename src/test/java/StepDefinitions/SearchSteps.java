package StepDefinitions;

import Pages.SearchPage;
import io.cucumber.java.en.And;

public class SearchSteps {

    SearchPage searchPage = new SearchPage(BrowserDriver.getWebDriver());

    @And("Login Website")
    public void searchForVideo() {

        searchPage.Login();


    }
}
