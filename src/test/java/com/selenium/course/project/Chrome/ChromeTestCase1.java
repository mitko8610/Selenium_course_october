package com.selenium.course.project.Chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTestCase1 {

    WebDriver driver = null;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void testCase1() {
        driver.get("https://finance.yahoo.com/");
//Отваря се прозорец за приемане на политиката за бисквитки
        WebElement acceptButton = driver.findElement(By.xpath("//*[@class='btn primary']"));
        acceptButton.click(); //Приемаме политиката за бисквитки

        WebElement signinButton = driver.findElement(By.id("header-signin-link"));
        signinButton.click();

        WebElement createAccountButton = driver.findElement(By.id("createacc"));
        createAccountButton.click();

        WebElement firstName = driver.findElement(By.id("usernamereg-firstName"));
        firstName.sendKeys("project");

        WebElement lastName = driver.findElement(By.id("usernamereg-lastName"));
        lastName.sendKeys("test");

        WebElement email = driver.findElement(By.id("usernamereg-yid"));
        email.sendKeys("test");

        WebElement password = driver.findElement(By.id("usernamereg-password"));
        password.sendKeys("tt");

        WebElement phoneNumber = driver.findElement(By.id("usernamereg-phone"));
        phoneNumber.sendKeys("fdd");

        Select month = new Select(driver.findElement(By.id("usernamereg-month")));
        month.selectByValue("3");

        WebElement day = driver.findElement(By.id("usernamereg-day"));
        day.sendKeys("f");

        WebElement year = driver.findElement(By.id("usernamereg-year"));
        year.sendKeys("f");

        WebElement continueButton = driver.findElement(By.id("reg-submit-button"));
        continueButton.click();

//        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDownDriver() {
        driver.quit();
    }
}
