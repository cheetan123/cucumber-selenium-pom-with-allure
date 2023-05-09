package info.seleniumcucumber.pages;

import info.seleniumcucumber.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Properties;

public class LoginPage {

    private WebDriver driver;
    ConfigReader configReader = new ConfigReader();
    Properties prop = configReader.init_prop();

    // 1. By Locators: OR
    private By emailId = By.name(prop.getProperty("userid"));
    private By password = By.name(prop.getProperty("password"));
    private By signInButton = By.xpath(prop.getProperty("signInButton"));
    private By forgotPwdLink = By.xpath(prop.getProperty("forgotPwdLink"));

    // 2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    public void doLogin(String un, String pwd) {
        System.out.println("login with: " + un + " and " + pwd);
        driver.findElement(emailId).sendKeys(un);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();
//        return new HomePage(driver);
    }
}

