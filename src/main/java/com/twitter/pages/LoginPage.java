package com.twitter.pages;

import com.twitter.utils.PageWaits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }


  @FindBy(how = How.CSS, using = "input[type='email']")
  private WebElement username_input;

  @FindBy(how = How.CSS, using = "input[type='password']")
  private WebElement password_input;

  @FindBy(how = How.CSS, using = "div[data-testid='LoginForm_Login_Button']")
  private WebElement login;

  public void navigateTo() {
    navigate();
  }


  public void login_to_Twitter(String username, String password) {
    waitForElement(username_input, PageWaits.DEFAULT_WINDOW_APPEAR_TIMEOUT);
    waitForElement(password_input, PageWaits.DEFAULT_WINDOW_APPEAR_TIMEOUT);
    username_input.click();
    username_input.sendKeys(username);
    password_input.click();
    password_input.sendKeys(password);
    waitForElement(login, PageWaits.DEFAULT_SMALL_WAIT);
    login.click();
    waitForURL("https://twitter.com/home", PageWaits.DEFAULT_ELEMENT_APPEAR_TIMEOUT);
  }
}
