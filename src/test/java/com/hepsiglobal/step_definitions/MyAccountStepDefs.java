package com.hepsiglobal.step_definitions;

import com.hepsiglobal.pages.LoginPage;
import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class MyAccountStepDefs {


    @Then("the user clicks to the profile")
    public void the_user_clicks_to_the_profile() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        BrowserUtils.waitFor(3);
        loginPage.navigateToProfile();
    }

    @Then("the user is able to land to the My Account")
    public void the_user_is_able_to_land_to_the_My_Account() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("account"));

    }

    @Then("logs in with valid credentials")
    public void logs_in_with_valid_credentials() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        BrowserUtils.waitFor(2);
        loginPage.loginAZ();

    }

}
