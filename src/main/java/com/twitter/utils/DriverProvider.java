package com.twitter.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverProvider {

  public final static Logger LOG = Logger.getLogger(DriverProvider.class.getName());
  private static WebDriver driver = null;
  private static BrowserMobProxy proxy = null;
  private static String browser = ConfigParser.getConfig().getBrowser();

  private DriverProvider() {
  }

  public static WebDriver getDriver() {
    LOG.info("Getting  driver...");
    if (driver == null) {
      switch (browser.toUpperCase()) {
        case "FIREFOX":
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver(setFirefoxOptions());
          break;
        case "CHROME":
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver(setChromeOptions());
          break;
      }
    }
    return driver;
  }

//  public static BrowserMobProxy getProxy() {
//    if (proxy == null) {
//      proxy = new BrowserMobProxyServer();
//      proxy.start(0);
//    }
//    return proxy;
//  }

  public static void CloseAllOtherHandles() {
    String originalHandle = driver.getWindowHandle();
    for (String handle : driver.getWindowHandles()) {
      if (!handle.equals(originalHandle)) {
        driver.switchTo().window(handle);
        driver.close();
      }
    }
    driver.switchTo().window(originalHandle);
  }

  private static DesiredCapabilities setFirefoxOptions() {
    DesiredCapabilities caps = DesiredCapabilities.firefox();
    //FirefoxOptions firefoxOptions = new FirefoxOptions();
//    firefoxOptions.setCapability("network.proxy.type", 1);
//    firefoxOptions.setCapability("network.proxy.socks", "127.0.0.1");
//    firefoxOptions.setCapability("network.proxy.socks_port", 1080);
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    //firefoxOptions.setExperimentalOption("w3c", false);
    caps.setCapability("w3c", false);
    //caps.setCapability(ChromeOptions.CAPABILITY, firefoxOptions);
    return caps;
  }

  private static DesiredCapabilities setChromeOptions() {
    DesiredCapabilities caps = DesiredCapabilities.chrome();

    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

    ChromeOptions options = new ChromeOptions();
    //Proxy seleniumProxy = ClientUtil.createSeleniumProxy(getProxy());
    //options.setCapability(CapabilityType.PROXY, seleniumProxy);
    options.setExperimentalOption("w3c", false);
    caps.setCapability(ChromeOptions.CAPABILITY, options);
    return caps;
  }
}

