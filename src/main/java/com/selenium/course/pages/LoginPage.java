package com.selenium.course.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(className="btn_action")
    private WebElement loginButton;

    public LoginPage (WebDriver driver){
        super(driver);
    }

    public ProductListerPage login(String usernameField, String passwordField){
        executeOperationWithExplicitWait(10, ExpectedConditions.visibilityOf(username), 10);
        username.sendKeys(usernameField);
        password.sendKeys(passwordField);
        loginButton.click();
        return new ProductListerPage(driver);
    }


}
