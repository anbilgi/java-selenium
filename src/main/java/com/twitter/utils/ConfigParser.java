package com.twitter.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigParser {

  private static ConfigParser parser = null;
  private static final String propertiesFile = "src/main/resources/config.properties";
  private String earlybird_url;
  private String browser;
  private String username;
  private String password;

  private ConfigParser() {
  }

  public static ConfigParser getConfig() {
    if (parser == null) {
      parser = new ConfigParser();
      Properties properties = loadProperties(propertiesFile);
      parser.setEarlybird_url(properties.getProperty("EARLYBIRD_URL").toString());
      parser.setBrowser(properties.getProperty("BROWSER").toString());
      parser.setUsername(properties.getProperty("USERNAME").toString());
      parser.setPassword(properties.getProperty("PASSWORD").toString());
    }
    return parser;
  }

  private static Properties loadProperties(String file) {
    Properties properties = new Properties();
    try {
      FileReader fileReader = new FileReader(file);
      properties.load(fileReader);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return properties;
  }

  public String getEarlybird_url() {
    return earlybird_url;
  }

  public void setEarlybird_url(String earlybird_url) {
    this.earlybird_url = earlybird_url;
  }

  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
