package com.hepsiglobal.pages;

import com.github.javafaker.Faker;
import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.ConfigurationReader;
import com.hepsiglobal.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@data-parsley-trigger='input'][1]")
    public WebElement userName;

    @FindBy(xpath = "//*[@id=\"inputPassword\"]")
    public WebElement password;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div/div[2]/div[1]/form[3]/button")
    public WebElement submit;

    @FindBy(css = "a[href^='/?deliver_to=AZ']")
    public WebElement azerbaijanBtn;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[3]/a[2]")
    public WebElement israelBtn;

    @FindBy(xpath = "/html/body/header/div[2]/div/div/div/div/div[4]/div[2]/div/div[2]/a[1]")
    public WebElement loginbtn;

    @FindBy(className = "account-bar-content")
    public WebElement avatarIcon;

    @FindBy(className = "accept")
    public WebElement cookies;

    @FindBy(xpath = "//body[@class='logged']")
    public WebElement loggedIn;

    @FindBy(xpath = "//div[@class='error']")
    public WebElement errorMsg;

    public void navigateToLogin() throws InterruptedException {

        avatarIcon.click();
        Thread.sleep(2000);
        loginbtn.click();


    }



}
