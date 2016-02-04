package com.thescore;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Michael on 2/2/2016.
 *
 * Represents the 'Leaders' section of a league page
 */
public class LeadersPage {

    private WebDriver driver;

    public LeadersPage(WebDriver driver) {
        this.driver = driver;
        // wait for the list of players to load
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.list-view.leaders-list")));
    }

    public PlayerStatsPage goToRandomPlayer() {
        // generate a random player index based on length of roster
        int playerIndex = new Random().nextInt(getRosterCount()) + 1;
        // click on player at the generated list index
        WebElement randomPlayerLink = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[@class='list-view-item-headshot leader']["+ playerIndex +"]")));
        randomPlayerLink.click();
        return new PlayerStatsPage(driver);
    }

    public LeadersPage sortByAssists() {
        // To be implemented
        return this;
    }

    public LeadersPage sortByCleanSheets() {
        // To be implemented
        return this;
    }

    public LeadersPage sortByGoals() {
        // To be implemented
        return this;
    }

    private int getRosterCount() {
        try {
            int rosterCount = driver.findElements(By.cssSelector(".list-view-item-headshot")).size();
            return rosterCount;
        } catch (Exception e) {
            throw new RuntimeException("Unable to get leaders counts. Error was: " + e.getMessage());
        }

    }

}
