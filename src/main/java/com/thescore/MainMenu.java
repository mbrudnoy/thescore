package com.thescore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by Michael on 2/1/2016.
 *
 * Represents the menu located in the upper-left corner of the top navigation bar
 */
public class MainMenu {

    private WebDriver driver;

    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on a link to go to a league's page
     * @param leagueName The name of the league to go to
     * @return LeagueNewsPage
     */
    public LeagueNewsPage selectLeague(String leagueName) {
        String cssSelector = "//span[contains (text(), '"+leagueName+"')]";
        WebElement leagueLink = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(cssSelector)));
        leagueLink.click();

        return new LeagueNewsPage(driver);
    }
}
