package StepDefinitions;

import Pages.PIMPage;
import io.cucumber.java.en.And;

public class PIMSteps {

    PIMPage pimPage = new PIMPage(BrowserDriver.getWebDriver());




    @And("User able to create user")
    public void userAbleToCreateUser() {

        pimPage.AddCustomer();
        pimPage.verifyCustCreated();
    }
}
