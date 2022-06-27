package com.hepsiglobal.step_definitions;

import com.hepsiglobal.pages.LoginPage;
import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class MyAccountStepDefs {

    LoginPage loginPage=new LoginPage();

    @Then("the user clicks to the {string}")
    public void the_user_clicks_to_the(String profile) {
        BrowserUtils.waitFor(2);
        loginPage.profile.click();
    }

    @Then("the user is able to land to the {string}")
    public void the_user_is_able_to_land_to_the(String account) {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(account));

    }
}
