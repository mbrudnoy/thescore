package com.thesource;

import com.thescore.PlayerStatsPage;
import com.thescore.TopHeader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Michael on 2/1/2016.
 */
public class playerStatsDisplayTests {

    private final String HOME_PAGE_URL = "http://www.thescore.com";

    private WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void cleanup() {

        driver.close();
    }

    @Test
    public void playerHeightAndBirthdateDisplayCorrectly() {

        driver.get(HOME_PAGE_URL);
        TopHeader header = new TopHeader(driver);
        // Get to a random player's stats page
        PlayerStatsPage statsPage = header.openMenu().selectLeague("EPL Soccer").goToLeadersTab().goToRandomPlayer();
        // Extract their height, weight, and birthdate
        String playerHeight = statsPage.getPlayerHeight().trim();
        String playerWeight = statsPage.getPlayerWeight().trim();
        String playerBirthdate = statsPage.getPlayerBithdateAndAge().trim();
        WebElement playerHeightAndWeight = statsPage.getPlayerHeightAndWeight();


        // Assert correct css properties
        Assert.assertTrue("Font size of player's height text is incorrect", playerHeightAndWeight.getCssValue("font-size").equals("14px"));
        Assert.assertTrue("Font style of player's height text  is incorrect", playerHeightAndWeight.getCssValue("font-style").equals("normal"));
        Assert.assertTrue("Font color of player's height text  is incorrect", playerHeightAndWeight.getCssValue("color").equals("rgba(31, 31, 31, 1)"));

        // Assert the values to be correctly formatted
        Assert.assertTrue("Player's height is not formatted correctly. Found: " + playerHeight + ". URL=" + driver.getCurrentUrl(),
                             playerHeight.matches("\\d{1}'\\s*\\d{1,2}\""));

        Assert.assertTrue("Player's weight is not formatted correctly (e.g. 165 lbs). Found: " + playerWeight + ". URL=" + driver.getCurrentUrl(),
                            playerWeight.matches("\\d{2,3}\\s*lbs"));

        Assert.assertTrue("Player's birthdate is not formatted correctly. Found: '" + playerBirthdate + "'. URL=" + driver.getCurrentUrl(),
                            playerBirthdate.matches("\\d{4}-\\d{2}-\\d{2}\\s*\\(\\d*\\)"));


    }

}
