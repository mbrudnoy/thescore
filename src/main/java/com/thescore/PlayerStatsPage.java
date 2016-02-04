package com.thescore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Michael on 2/2/2016.
 *
 * Represents a player stats page
 */
public class PlayerStatsPage {

    private WebDriver driver;
    private final String HEIGHT_WEIGHT_XPATH_LOCATOR    = "//div[@class='info-segment']/span[@class='formatted-height-weight info-segment-data']";
    private final String BIRTHDATE_AGE_XPATH_LOCATOR    = "//div[@class='info-segment']/span[@class='formatted-birthdate info-segment-data']";

    public PlayerStatsPage(WebDriver driver) {
        this.driver = driver;

        // Make sure we're on the Player Stats page
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".player-info-card")));

    }
    public String getPlayerHeight() {
        String heightAndWeight = driver.findElement(By.xpath(HEIGHT_WEIGHT_XPATH_LOCATOR)).getText();
        return heightAndWeight.substring(0, heightAndWeight.indexOf('/'));
    }

    public String getPlayerWeight() {
        String heightAndWeight = driver.findElement(By.xpath(HEIGHT_WEIGHT_XPATH_LOCATOR)).getText();
        return heightAndWeight.substring(heightAndWeight.indexOf('/')+1);
    }

    /**
     * Retrieves the WebElement that represents the player's height/weight
     * @return WebElement
     */
    public WebElement getPlayerHeightAndWeight() {
        return driver.findElement(By.xpath(HEIGHT_WEIGHT_XPATH_LOCATOR));
    }

    public String getPlayerBithdateAndAge() {
        return driver.findElement(By.xpath(BIRTHDATE_AGE_XPATH_LOCATOR)).getText();

    }

    public String getPlayerAge() {
        String birthdateAndAge = driver.findElement(By.xpath(BIRTHDATE_AGE_XPATH_LOCATOR)).getText();
        return birthdateAndAge.substring(birthdateAndAge.indexOf('(')+1, birthdateAndAge.indexOf(')'));
    }
}