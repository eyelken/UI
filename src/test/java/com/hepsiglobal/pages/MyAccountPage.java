package com.hepsiglobal.pages;

import com.github.javafaker.Faker;
import com.hepsiglobal.step_definitions.MyAccountStepDefs;
import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MyAccountPage extends BasePage{

    @FindBy(id = "account_firstName")
    public WebElement firstName;

    @FindBy(id = "account_middleName")
    public WebElement middleName;

    @FindBy(id = "account_lastName")
    public WebElement lastName;

    @FindBy(xpath = "//button[@class='btn btn-primary save-profile']")
    public WebElement save;

    @FindBy(xpath = "//select[@id='account_gender']")
    public WebElement gender;

    @FindBy(xpath = "//select[@id='account_birthdayAt_month']")
    public WebElement birthdayMonth;

    @FindBy(xpath = "//select[@id='account_birthdayAt_day']")
    public WebElement birthdayDay;

    @FindBy(xpath = "//select[@id='account_birthdayAt_year']")
    public WebElement birthdayYear;

    @FindBy(id = "customer_address_alias")
    public WebElement addressAlias;

    @FindBy(id = "customer_address_firstName")
    public WebElement addressFirstname;

    @FindBy(id = "customer_address_middleName")
    public WebElement addressMiddlename;

    @FindBy(id = "customer_address_lastName")
    public WebElement addressLastname;

    @FindBy(xpath = "//input[@name='customer_address[phone]']")
    public WebElement addressPhone;

    @FindBy(id = "customer_address_city")
    public WebElement addressCity;

    @FindBy(id = "customer_address_district")
    public WebElement addressDistrict;

    @FindBy(id = "customer_address_zipCode")
    public WebElement addressZipcode;

    @FindBy(id = "customer_address_citizenID")
    public WebElement addressFincode;

    @FindBy(id = "customer_address_address")
    public WebElement addressFull;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/ul/li[3]/a")
    public WebElement addresses;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div/p[2]/a")
    public WebElement addNewAddress;

    @FindBy(xpath = "//a[@class='delete-address']")
    public WebElement deleteOldOne;

    public void navigateToAddressAZ() throws InterruptedException {
        addresses.click();
        Thread.sleep(5000);
        try {
            if (addNewAddress.isDisplayed()){
                addNewAddress.click();
            }
        }catch (Exception e){
        }   if (deleteOldOne.isDisplayed()) {
            deleteOldOne.click();
            Thread.sleep(2000);
            addNewAddress.click();
        }
    }


}
