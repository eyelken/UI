package com.hepsiglobal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    @FindBy(id = "account_firstName")
    public WebElement firstName;

    @FindBy(id = "account_middleName")
    public WebElement middleName;

    @FindBy(id = "account_lastName")
    public WebElement lastName;

    @FindBy(xpath = "//button[@class='btn btn-primary save-profile']")
    public WebElement save;


}
