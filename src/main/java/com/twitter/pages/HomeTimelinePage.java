package com.twitter.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.twitter.utils.PageWaits;

public class HomeTimelinePage extends BasePage {

  public HomeTimelinePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindAll(value = {@FindBy(how = How.CSS, using = "div[data-testid='tweet']")})
  private List<WebElement> all_tweets;

  @FindBy(how = How.CSS, using = "input[type='email']")
  private WebElement username_input;

  public void scrollToTweet(String tweetText) {
    waitForElement(all_tweets.get(0), PageWaits.DEFAULT_WINDOW_APPEAR_TIMEOUT);
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getTweetWithText(tweetText));
  }

  public WebElement getTweetWithText(String tweetText) {
    for (WebElement element : all_tweets) {
      if (element.getText().contains(tweetText))
        return element;
    }
    throw new WebDriverException("Tweet not found");
  }

  public boolean isTweetVisible(String tweetText) {
    return getTweetWithText(tweetText).isDisplayed();
  }
}
