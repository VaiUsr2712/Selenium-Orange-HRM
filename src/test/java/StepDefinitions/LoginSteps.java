package StepDefinitions;

import io.cucumber.java.en.Given;

import java.io.IOException;

public class LoginSteps {

    BrowserDriver browserDriver =new BrowserDriver();

    public LoginSteps() throws IOException {
    }

    @Given("^User opens website$")
    public void login() {

        browserDriver.Webdriverinit();


    }


}
