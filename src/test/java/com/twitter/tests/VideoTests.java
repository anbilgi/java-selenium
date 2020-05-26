package com.twitter.tests;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.twitter.pages.HomeTimelinePage;
import com.twitter.pages.LoginPage;
import com.twitter.utils.ConfigParser;
import com.twitter.utils.DriverProvider;
import com.twitter.utils.LoggerUtil;


public class VideoTests extends TestBase {

  public final static Logger LOG = Logger.getLogger(VideoTests.class.getName());
  private final static String mockjson = "src/main/java/com/twitter/fixtures/video.json";
  WebDriver driver;
  LoginPage loginPage;
  HomeTimelinePage homeTimelinePage;

  @BeforeClass
  private void init() {
    LOG.info("initializing test...");
    driver = DriverProvider.getDriver();
    //MockUtils.mockHomeTimeline(mockjson);
    loginPage = new LoginPage(driver);
    homeTimelinePage = new HomeTimelinePage(driver);
    loginPage.navigateTo();
    LOG.info("Starting BrowserMobProxy... ");
    //addRequestResponseFilters(proxy);
    //proxy.newHar("test-har");
    loginPage.login_to_Twitter(ConfigParser.getConfig().getUsername(), ConfigParser.getConfig().getPassword());
  }

  @Test
  public void testVideoTweet() throws InterruptedException, UnsupportedEncodingException {
    LOG.info("Logged in..");
    homeTimelinePage.scrollToTweet("Promoted by Frank McNuggets");
    Assert.assertTrue(homeTimelinePage.isTweetVisible("Promoted by Frank McNuggets"), "Tweet is not visible!");
    Thread.sleep(8000); //Wait for video to play
    LoggerUtil.getLogs(driver);
  }
}
