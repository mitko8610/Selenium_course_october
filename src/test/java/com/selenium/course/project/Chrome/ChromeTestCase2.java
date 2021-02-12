package com.selenium.course.project.Chrome;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.utils.CsvReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ChromeTestCase2 {

    WebDriver driver = null;

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @DataProvider(name="search-data-file")
    public static Object[][] dataProviderFromFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/search-data.csv");
    }

    @Test (dataProvider = "search-data-file")
    public void testCase1(String companyName) throws InterruptedException, IOException {
        driver.get("https://finance.yahoo.com/");
//Отваря се прозорец за приемане на политиката за бисквитки
        WebElement acceptButton = driver.findElement(By.xpath("//*[@class='btn primary']"));
        acceptButton.click(); //Приемаме политиката за бисквитки

        WebElement searchBox = driver.findElement(By.id("yfin-usr-qry"));
        searchBox.sendKeys(companyName);
        Thread.sleep(5000);

        WebElement list = driver.findElement(By.xpath("//li[contains(@class,'modules_linkItem__2NK9M modules_quoteItem__2x3Sc')]"));
        list.click();

        FileWriter write = new FileWriter("src/test/java/com/selenium/course/project/Chrome/company-dividend.csv");
        WebElement dividendAndYield = driver.findElement(By.xpath("//td[@data-test='DIVIDEND_AND_YIELD-value']"));
//        WebElement divCompanyName = driver.findElement(By.)
//        write.append(companyName);
        write.write(String.valueOf(dividendAndYield));

        Thread.sleep(5000);

//        WebElement signinButton = driver.findElement(By.id("header-signin-link"));
//        signinButton.click();
//
//        WebElement createAccountButton = driver.findElement(By.id("createacc"));
//        createAccountButton.click();
//
//        WebElement firstName = driver.findElement(By.id("usernamereg-firstName"));
//        firstName.sendKeys("project");
//
//        WebElement lastName = driver.findElement(By.id("usernamereg-lastName"));
//        lastName.sendKeys("test");
//
//        WebElement email = driver.findElement(By.id("usernamereg-yid"));
//        email.sendKeys("test");
//
//        WebElement password = driver.findElement(By.id("usernamereg-password"));
//        password.sendKeys("tt");
//
//        WebElement phoneNumber = driver.findElement(By.id("usernamereg-phone"));
//        phoneNumber.sendKeys("fdd");
//
//        Select month = new Select(driver.findElement(By.id("usernamereg-month")));
//        month.selectByValue("3");
//
//        WebElement day = driver.findElement(By.id("usernamereg-day"));
//        day.sendKeys("f");
//
//        WebElement year = driver.findElement(By.id("usernamereg-year"));
//        year.sendKeys("f");
//
//        WebElement continueButton = driver.findElement(By.id("reg-submit-button"));
//        continueButton.click();

//        Thread.sleep(10000);
    }

    @AfterTest
    public void tearDownDriver() {
        driver.quit();
    }
}
