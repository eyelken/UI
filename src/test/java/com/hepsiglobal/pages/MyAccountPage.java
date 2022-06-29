package com.hepsiglobal.pages;

import com.hepsiglobal.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
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



}
