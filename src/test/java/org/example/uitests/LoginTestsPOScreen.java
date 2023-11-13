package org.example.uitests;

import org.apache.commons.io.FileUtils;
import org.example.uitests.driver.WebDriverHolder;
import org.example.uitests.pages.login.LoginPage;
import org.example.uitests.pages.main.MainPage;
import org.example.uitests.utils.ConfigProvider;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class LoginTestsPOScreen extends BaseTest {
    String userName = ConfigProvider.getInstance().getProperty("login.tests.username");
    String userPassword = ConfigProvider.getInstance().getProperty("login.tests.password");

    @BeforeMethod
    public void beforeMethod() {
        goToPart("login");
    }

    @Test
    public void unsuccessfulLoginTest() {
        LoginPage loginPage = new LoginPage()
                .unsuccessfulLogin(userName, userPassword + "1");
//        makeScreenshot("unsuccessfulLoginTest");
//        Assert.assertEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
        // Навмисно робимо помилку
        Assert.assertNotEquals(loginPage.getErrorMessageText().trim(), "Your password is invalid!\n" + "×");
    }

    @Test
    public void successfulLoginTest() {
        MainPage mainPage = new LoginPage()
                .login(userName, userPassword);

        Assert.assertEquals(mainPage.getSuccessMessageText().trim(), "You logged into a secure area!\n" +
                "×");
    }

}
