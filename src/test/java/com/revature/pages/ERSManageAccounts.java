package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ERSManageAccounts {
    public final String title="Manage Accounts";
    
    @FindBy(xpath="//button[@type='submit'][@name='BackToAllReimbursements']")
    public WebElement backToAllReimbursements;
    
    @FindBy(xpath="//button[@type='submit'][@name='logout']")
    public WebElement logout;
    
    public ERSManageAccounts(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void backToAllReimbursements() {
        this.backToAllReimbursements.click();
    }
    public void logOutOfManageAccounts() {
        this.logout.click();
    }
}
