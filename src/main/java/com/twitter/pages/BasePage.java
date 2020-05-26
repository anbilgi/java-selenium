package com.twitter.pages;

import com.twitter.utils.ConfigParser;
import com.twitter.utils.DriverProvider;
import com.twitter.utils.PageWaits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

  protected static final Logger LOG = Logger.getLogger(BasePage.class);
  protected String baseURL;
  protected WebDriver driver;

  @FindBy(how = How.CSS, using = "title")
  private WebElement page_title;


  public BasePage() {
    driver = DriverProvider.getDriver();
    baseURL = ConfigParser.getConfig().getEarlybird_url();
  }

  public void navigate() {
    driver.get(baseURL);
    waitForURL("https://mobile.twitter.com/explore", PageWaits.DEFAULT_PAGE_LOADING_TIMEOUT);
  }

  protected void waitForURL(String url, long timeOutSeconds) {
    waitForPageLoad(timeOutSeconds);
    int timer = 0;
    do {
      timer += 5;
      PageWaits.wait(PageWaits.DEFAULT_SMALL_WAIT);
    } while (timer < timeOutSeconds && !driver.getCurrentUrl().contains(url));

  }

  protected void waitForPageLoad(long timeOutSeconds) {
    new WebDriverWait(driver, timeOutSeconds).until(
        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

  }

  protected void waitForElement(WebElement element, long timeout) {
    WebDriverWait wait = new WebDriverWait(driver, timeout);
    wait.until((WebDriver drv) -> {
      try {
        return element.isDisplayed();
      } catch (WebDriverException ex) {
        return false;
      }
    });
  }

}
