package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='ctl00_MainContent_username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_password']")
    public WebElement password;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement signIn;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    public WebElement order;
}
