package com.thescore;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Michael on 2/1/2016.
 */
public class TopHeader {
    private WebDriver driver;

    public TopHeader(WebDriver driver) {
        this.driver = driver;

    }

    public MainMenu openMenu()  {
        try {
            WebElement menuIcon = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.site-menu__toggle")));
            menuIcon.click();

        } catch (RuntimeException e) {
            throw new RuntimeException("Unable to open the main menu. Error was: " + e.getMessage());
        }
        return new MainMenu(driver);
    }



}