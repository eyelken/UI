package com.hepsiglobal.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {


    public static void hover(WebElement element){
        Actions actions= new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }

    public static WebElement waitForClickability(By locator, int timeout){
        WebDriverWait wait=new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithWait(By by, int attempts){
        int counter=0;

        while(counter<attempts){
            try {
                clickWithJS(Driver.get().findElement(by));
                break;
            }catch (WebDriverException e){
                e.printStackTrace();
                ++counter;
                waitFor(1);
            }
        }
    }

    public static void waitForPresenceOfElement(By by, long time){
        new WebDriverWait(Driver.get(), time).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForVisibility(By locator, int timeout){
        WebDriverWait wait= new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickWithTimeOut(WebElement element, int timeout){
        for (int i=0; i < timeout; i++){
            try {
                element.click();
            }catch (WebDriverException e){
                waitFor(1);
            }
        }
    }



}
