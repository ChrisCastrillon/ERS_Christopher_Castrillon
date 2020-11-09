package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ERSAdministratorPortal {
    
    public final String title="Administrator Portal";
    
    @FindBy(xpath="//button[@type='submit'][@id='viewAllReimbursements']")
    public WebElement viewAllReimbursements;
    
    @FindBy(xpath="//button[@type='submit'][@name='ManageAccounts']")
    public WebElement manageAccounts;
    @FindBy(xpath="//button[@type='submit'][@name='logout']")
    public WebElement logout;
    
    public ERSAdministratorPortal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void goToManageAccounts() {
        this.manageAccounts.click();
    }
    public void logoutOfErsAdministratorPortal() {
        this.logout.click();
    }
    

}
