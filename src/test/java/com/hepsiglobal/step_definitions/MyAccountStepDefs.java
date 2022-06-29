package com.hepsiglobal.step_definitions;

import com.github.javafaker.Faker;
import com.hepsiglobal.pages.LoginPage;
import com.hepsiglobal.pages.MyAccountPage;
import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
            /*
        Male=0
        Female=1
        No answer=2
         */
    @Then("the user updates the gender as female")
    public void the_user_updates_the_gender_as_female() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage();
        LoginPage loginPage=new LoginPage();
        Driver.get().manage().window().maximize();

        Select gendersDropdown=new Select(myAccountPage.gender);
        gendersDropdown.selectByValue("1");

        JavascriptExecutor jse=(JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,250)");

        Driver.get().findElement(By.xpath("//button[@class='btn btn-primary save-profile']")).click();
        Thread.sleep(2000);

        String expected="Female";
        String actual=gendersDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);
    }
    @Then("the user updates the gender as male")
    public void the_user_updates_the_gender_as_male() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage();
        LoginPage loginPage=new LoginPage();
        Driver.get().manage().window().maximize();

        Select gendersDropdown=new Select(myAccountPage.gender);
        gendersDropdown.selectByValue("0");

        JavascriptExecutor jse=(JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,250)");

        Driver.get().findElement(By.xpath("//button[@class='btn btn-primary save-profile']")).click();
        Thread.sleep(2000);

        String expected="Male";
        String actual=gendersDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);
    }
    @Then("the user updates the gender as no answer")
    public void the_user_updates_the_gender_as_no_answer() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage();
        LoginPage loginPage=new LoginPage();
        Driver.get().manage().window().maximize();

        Select gendersDropdown=new Select(myAccountPage.gender);
        gendersDropdown.selectByValue("2");

        JavascriptExecutor jse=(JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,250)");

        Driver.get().findElement(By.xpath("//button[@class='btn btn-primary save-profile']")).click();
        Thread.sleep(2000);

        String expected="No answer";
        String actual=gendersDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,actual);
    }

    @Then("the user is changing the birthday date")
    public void the_user_is_changing_the_birthday_date() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage();
        Random rn=new Random();
        int maxMonth=12;
        int minMonth=1;
        int showMonth= minMonth + rn.nextInt(maxMonth);

        System.out.println("showMonth = " + showMonth);

        Select months=new Select(myAccountPage.birthdayMonth);
        months.selectByValue(String.valueOf(showMonth));

        int maxDay=31;
        int minDay=1;
        int showDay= minDay + rn.nextInt(maxDay);

        System.out.println("showDay = " + showDay);

        Select days=new Select(myAccountPage.birthdayDay);
        days.selectByValue(String.valueOf(showDay));

        int maxYear=2022;
        int minYear=1922;
        int showYear= (int) Math.floor(Math.random()*(maxYear-minYear+1)+minYear);

        System.out.println("showYear = " + showYear);

        Select years=new Select(myAccountPage.birthdayYear);
        years.selectByValue(String.valueOf(showYear));

        Driver.get().findElement(By.xpath("//button[@class='btn btn-primary save-profile']")).click();
        Thread.sleep(2000);
    }
    }