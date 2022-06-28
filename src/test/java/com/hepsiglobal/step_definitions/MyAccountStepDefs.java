package com.hepsiglobal.step_definitions;

import com.github.javafaker.Faker;
import com.hepsiglobal.pages.LoginPage;
import com.hepsiglobal.pages.MyAccountPage;
import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.Locale;


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

    @Then("the user updates the name")
    public void the_user_updates_the_name() {
        MyAccountPage myAccountPage=new MyAccountPage();

        Locale locale=new Locale("en");
        Faker faker=new Faker(locale);

        String firstName= faker.name().firstName();
        String middleName= faker.name().nameWithMiddle();
        String lastName= faker.name().lastName();

        myAccountPage.firstName.clear();
        myAccountPage.firstName.sendKeys(firstName);
        myAccountPage.middleName.clear();
        myAccountPage.middleName.sendKeys(middleName);
        myAccountPage.lastName.clear();
        myAccountPage.lastName.sendKeys(lastName);
        myAccountPage.save.click();

        String actualFirst= myAccountPage.firstName.getAttribute("value");
        String actualMiddle= myAccountPage.middleName.getAttribute("value");
        String actualLast= myAccountPage.lastName.getAttribute("value");

        Assert.assertEquals(firstName,actualFirst);
        Assert.assertEquals(middleName, actualMiddle);
        Assert.assertEquals(lastName, actualLast);
    }
}
