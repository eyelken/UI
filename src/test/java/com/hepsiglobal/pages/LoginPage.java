package com.hepsiglobal.pages;

import com.hepsiglobal.utilities.BrowserUtils;
import com.hepsiglobal.utilities.ConfigurationReader;
import com.hepsiglobal.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(className = "forgot-password")
    public WebElement forgotPassword;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement forgotEmail;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[2]/div/div/div/div/form/div[1]/div/div/p")
    public WebElement validationMsg;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement forgotSubmit;

    @FindBy(xpath = "/html/body/header/div[2]/div/div/div/div/div[4]/div[2]/div/div[2]/a[5]")
    public WebElement logoutBtn;

    @FindBy(xpath = "/html/body/header/div[1]/div/div/div[2]/div/div/div[1]/img")
    public WebElement countryLogo;

    @FindBy(xpath = "/html/body/header/div[2]/div/div/div/div/div[4]/div[2]/div/div[2]/a[1]")
    public WebElement profile;

    public void navigateToLogin() throws InterruptedException {
        avatarIcon.click();
        loginbtn.click();
    }

    public void navigateToLogout(){
        avatarIcon.click();
        logoutBtn.click();
    }

    public void navigateToProfile() throws InterruptedException {
        avatarIcon.click();
        Thread.sleep(2000);
        profile.click();
    }

    public void loginAZ() throws InterruptedException {
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);

        Driver.get().findElement(By.xpath("/html/body/div/div[1]/div[2]/div[3]/a[1]")).click();
        BrowserUtils.waitFor(3);

        cookies.click();

        navigateToLogin();

        userName.click();
        userName.sendKeys(ConfigurationReader.get("username"));
        BrowserUtils.waitFor(2);

        password.click();
        password.sendKeys(ConfigurationReader.get("password"));
        BrowserUtils.waitFor(3);

        submit.click();
    }

    public void loginIS() throws InterruptedException {
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);

        Driver.get().findElement(By.xpath("/html/body/div/div[1]/div[2]/div[3]/a[2]")).click();
        BrowserUtils.waitFor(3);

        cookies.click();

        navigateToLogin();

        userName.click();
        userName.sendKeys(ConfigurationReader.get("username"));
        BrowserUtils.waitFor(2);

        password.click();
        password.sendKeys(ConfigurationReader.get("password"));
        BrowserUtils.waitFor(3);

        submit.click();

    }



}
