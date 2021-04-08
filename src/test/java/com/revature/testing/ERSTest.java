package com.revature.testing;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.revature.pages.ERSAdministratorPortal;
import com.revature.pages.ERSHome;
import com.revature.pages.ERSManageAccounts;

public class ERSTest {
    public WebDriver driver;
    public final String url="http://localhost:8080/ERS_Christopher_Castrillon/";
  @AfterClass
  public void afterClassTest() {
  }
  
  @BeforeClass
  public void beforeClassTest() {
      File file = new File("src/test/resources/chromedriver");
      System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
      this.driver = new ChromeDriver();
      driver.get(url);
  }
  @Test
  public void confirmHomePage() {
      ERSHome ersh = new ERSHome(this.driver);
      System.out.println("the title of the page is: " + this.driver.getCurrentUrl());
      assertEquals(driver.getTitle(), ersh.title);
  }
  //TODO: add data provider
  @Test(dependsOnMethods = {"confirmHomePage"})
  public void loginWorks() {
      ERSHome ersh = new ERSHome(driver);
      ersh.loginToERSHome("ccastrillon", "password"); 
  }
  @Test(dependsOnMethods= {"loginWorks"})
  public void confirmERSAdminPage() {
      ERSAdministratorPortal ersap = new ERSAdministratorPortal(this.driver);
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.urlToBe("http://localhost:8080/ERS_Christopher_Castrillon/administrator-portal"));
      assertEquals(driver.getTitle(), ersap.title);
  }
  @Test(dependsOnMethods= {"confirmERSAdminPage"})
  public void goToManageAccounts() {
      ERSAdministratorPortal ersap = new ERSAdministratorPortal(this.driver);
      ersap.goToManageAccounts();
  }
  @Test(dependsOnMethods = {"goToManageAccounts"})
  public void confirmManageAccountsPage() {
      ERSManageAccounts ersma = new ERSManageAccounts(this.driver);
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.urlToBe("http://localhost:8080/ERS_Christopher_Castrillon/manage-accounts"));
      assertEquals(driver.getTitle(), ersma.title);  
  }
  @Test(dependsOnMethods= {"confirmManageAccountsPage"})
  public void confirmBackToReimbursements() {
      ERSManageAccounts ersma = new ERSManageAccounts(this.driver);
      ERSAdministratorPortal ersap = new ERSAdministratorPortal(this.driver);
      try {
          ersma.backToAllReimbursements();
      }catch(UnhandledAlertException f) {
          try {
              Alert alert = driver.switchTo().alert();
              String alertText = alert.getText();
              System.out.println("Alert Data: " + alertText);
              alert.accept();
          }catch(NoAlertPresentException e) {
              e.printStackTrace();
          }
      }
      WebDriverWait wait = new WebDriverWait(driver, 20);
      wait.until(ExpectedConditions.urlToBe("http://localhost:8080/ERS_Christopher_Castrillon/administrator-portal"));
      assertEquals(driver.getTitle(),ersap.title);
      
      
  }
  @Test(dependsOnMethods= {"confirmERSAdminPage"})
  public void logoutWorks() {
      ERSAdministratorPortal ersap = new ERSAdministratorPortal(this.driver);
      ersap.logoutOfErsAdministratorPortal();
  }
}
