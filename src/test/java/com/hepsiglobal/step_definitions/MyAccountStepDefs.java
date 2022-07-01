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
import org.openqa.selenium.support.ui.Select;
import java.util.Locale;
import java.util.Random;

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

        Driver.get().findElement(By.xpath("//button[@class='btn btn-primary save-profile']")).click();
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
    @Then("the user is navigating to the Addresses")
    public void the_user_is_navigating_to_the_Addresses() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage();
        myAccountPage.navigateToAddressAZ();
    }

    @Then("the user is able to change the address")
    public void the_user_is_able_to_change_the_address() throws InterruptedException {
        MyAccountPage myAccountPage=new MyAccountPage();
        Locale locale=new Locale("az");
        Faker faker=new Faker(locale);

        Thread.sleep(3000);
        String firstName= faker.name().firstName();
        String middleName= faker.name().nameWithMiddle();
        String lastName= faker.name().lastName();
        String city= faker.address().cityName();
        String zipcode=faker.address().zipCode();
        String district= faker.address().streetAddress();
        String fullAddress= city+district+faker.address().fullAddress();
        String phone=faker.phoneNumber().cellPhone();
        String fincode=faker.number().digits(6);

        myAccountPage.addressAlias.click();
        myAccountPage.addressAlias.sendKeys(firstName);
        myAccountPage.addressFirstname.sendKeys(firstName);
        myAccountPage.addressMiddlename.sendKeys(middleName);
        myAccountPage.addressLastname.sendKeys(lastName);
        myAccountPage.addressPhone.sendKeys(phone);
        myAccountPage.addressCity.sendKeys(city);
        myAccountPage.addressDistrict.sendKeys(district);
        myAccountPage.addressZipcode.sendKeys(zipcode);
        myAccountPage.addressFull.sendKeys(fullAddress);
        myAccountPage.addressFincode.sendKeys(fincode);

        Driver.get().findElement(By.xpath("//button[@class='save btn-primary']")).click();
        Thread.sleep(3000);


    }
    }