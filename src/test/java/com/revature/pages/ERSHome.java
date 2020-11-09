package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ERSHome {
    public final String title="ERS Home";
    
    @FindBy(xpath="//input[@name='username']")
    public WebElement username;
    
    @FindBy(xpath="//input[@name='password']")
    public WebElement password;
    
    @FindBy(xpath="//button[@type='submit'][@name='submit']")
    public WebElement submitButton;
    
    public ERSHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void loginToERSHome(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.submitButton.click();
    }
}
