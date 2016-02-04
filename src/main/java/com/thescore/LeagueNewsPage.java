package com.thescore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Michael on 2/1/2016.
 *
 * Represents a League page
 */


public class LeagueNewsPage {
    private WebDriver driver;

    public LeagueNewsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Switches to the Leaders tab on the league page
     * @return LeaderPage
     */
    public LeadersPage goToLeadersTab() {

        try {
            // Wait for menu icon to be clickable, then proceed to click
            WebElement menuIcon = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains (@href, 'leaders')]")));
            menuIcon.click();

        } catch (RuntimeException e) {
            throw new RuntimeException("Unable to click on 'Leaders' tab. Error was: " + e.getMessage());
        }
        return new LeadersPage(driver);
    }
}