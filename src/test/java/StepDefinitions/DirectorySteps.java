package StepDefinitions;

import Pages.DirectoryPage;
import io.cucumber.java.en.And;

public class DirectorySteps {

    DirectoryPage dirpage = new DirectoryPage(BrowserDriver.getWebDriver());

    @And("I enter jobtitle {string} and location {string}")
    public void iEnterJobtitleAndLocation(String jt, String loc) {

        dirpage.SearchEmployee(jt,loc);
    }
}
