package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dashboard {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://127.0.0.1:32767/21.56.36/login.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDashboard() throws Exception {
    driver.navigate().refresh();
    // ERROR: Caught exception [ERROR: Unsupported command [mouseOver | id=u24_img | ]]
    assertTrue(driver.findElement(By.id("u43")).isDisplayed());
    // ERROR: Caught exception [ERROR: Unsupported command [mouseOut | id=u24_img | ]]
    assertFalse(driver.findElement(By.id("u43")).isDisplayed());
    driver.findElement(By.id("u92_div")).click();
    assertTrue(driver.findElement(By.id("u113_div")).isDisplayed());
    driver.findElement(By.id("u92_div")).click();
    assertFalse(driver.findElement(By.id("u113_div")).isDisplayed());
    assertTrue(driver.findElement(By.id("u9_div")).isDisplayed());
    driver.findElement(By.id("u6_div")).click();
    assertFalse(driver.findElement(By.id("u9_div")).isDisplayed());
    driver.findElement(By.id("u6_div")).click();
    assertTrue(driver.findElement(By.id("u9_div")).isDisplayed());
    driver.navigate().refresh();
    driver.findElement(By.id("u92_div")).click();
    driver.findElement(By.id("u98_div")).click();
    assertEquals("Sign In", driver.findElement(By.cssSelector("#u8 > p > span")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
