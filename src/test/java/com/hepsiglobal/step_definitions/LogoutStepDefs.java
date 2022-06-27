package com.hepsiglobal.step_definitions;

import com.hepsiglobal.pages.LoginPage;
import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogoutStepDefs {
    LoginPage loginPage=new LoginPage();

    @Given("the user logs in successfully")
    public void the_user_logs_in_successfully() throws InterruptedException {
        loginPage.loginAZ();
    }

    @Then("the user clicks on the log out button")
    public void the_user_clicks_on_the_log_out_button() {
        BrowserUtils.waitFor(2);
        loginPage.navigateToLogout();
    }

    @Then("the user is able to log out")
    public void the_user_is_able_to_log_out() {
        String actualTitle= Driver.get().getCurrentUrl();
        Assert.assertEquals("https://qa2.hepsiglobal.com/", actualTitle);
    }
}
