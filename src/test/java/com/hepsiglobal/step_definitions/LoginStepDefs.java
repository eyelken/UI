package com.hepsiglobal.step_definitions;

import com.hepsiglobal.pages.LoginPage;
import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.ConfigurationReader;
import com.hepsiglobal.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs {


    @Given("the user is on the welcome page")
    public void the_user_is_on_the_welcome_page() {
       String url=ConfigurationReader.get("url");
       Driver.get().get(url);

    }

    @Given("chooses Azerbaijan")
    public void chooses_azerbaijan() throws InterruptedException {
        Driver.get().findElement(By.xpath("/html/body/div/div[1]/div[2]/div[3]/a[1]")).click();
        BrowserUtils.waitFor(3);
    }

    @Given("chooses Israel")
    public void chooses_Israel() {
        Driver.get().findElement(By.xpath("/html/body/div/div[1]/div[2]/div[3]/a[2]")).click();
    }

    @Then("the user lands to the home page")
    public void the_user_lands_to_the_home_page() throws InterruptedException {
        new LoginPage().cookies.click();
    }

    @Given("the user clicks on the login button on the home page")
    public void the_user_clicks_on_the_login_button_on_the_home_page() throws InterruptedException {
        BrowserUtils.waitFor(3);
        new LoginPage().navigateToLogin();
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.userName.click();
        loginPage.userName.sendKeys("paulinaberg1@gmail.com");
        BrowserUtils.waitFor(2);

        loginPage.password.click();
        loginPage.password.sendKeys("123456");
        BrowserUtils.waitFor(3);

        loginPage.submit.click();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(2);
    }


    @When("the user logs in using invalid credentials")
    public void the_user_logs_in_using_invalid_credentials() {
        LoginPage loginPage=new LoginPage();
        loginPage.userName.click();
        loginPage.userName.sendKeys("paulinaberg1@gmail.comM");
        BrowserUtils.waitFor(2);

        loginPage.password.click();
        loginPage.password.sendKeys("123456");
        BrowserUtils.waitFor(3);

        loginPage.submit.click();
    }


    @Then("the user should see the error message")
    public void the_user_should_see_the_error_message() {
        LoginPage loginPage=new LoginPage();
        BrowserUtils.waitFor(2);
        Assert.assertEquals("error", loginPage.errorMsg.getAttribute("class") );
    }

    @When("the user enters invalid credentials {string} and {string}")
    public void the_user_enters_invalid_credentials_and(String username, String password) {
        LoginPage loginPage= new LoginPage();
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();
    }

    @Then("the user should see the placeholders")
    public void the_user_should_see_the_placeholders() {
        LoginPage loginPage=new LoginPage();
        Assert.assertEquals("E-mail", loginPage.userName.getAttribute("placeholder") );
        Assert.assertEquals("Password", loginPage.password.getAttribute("placeholder"));

    }

    @Then("the user click to forgot my password button")
    public void the_user_click_to_forgot_my_password_button() {
        LoginPage loginPage=new LoginPage();
        loginPage.forgotPassword.click();
    }

    @Then("enters the email adress and clicks continue")
    public void enters_the_email_adress_and_clicks_continue() {
        LoginPage loginPage=new LoginPage();
        loginPage.forgotEmail.sendKeys("paulinaberg1@gmail.com");
        BrowserUtils.waitFor(2);
        loginPage.forgotSubmit.click();
    }

    @Then("the user is able to see the validation message on the screen")
    public void the_user_is_able_to_see_the_validation_message_on_the_screen()  {
        Assert.assertEquals("Please check your e-mail for reset your password.",new LoginPage().validationMsg);
    }








}
