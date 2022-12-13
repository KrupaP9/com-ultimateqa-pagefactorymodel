package com.ultimateqa.testsuite;

import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.pages.LoginPage;
import com.ultimateqa.pages.MainPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    MainPage mainPage;
    //method to navigate to the login page
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
    }
    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully(){
        mainPage.clickOnLoginLink();
        String expectedWelcome = "Welcome Back!";
        String actualWelcome = loginPage.getTextFromWelcomeBack();
        Assert.assertEquals(actualWelcome,expectedWelcome,"Welcome not displayed");
    }
    //method to verify an error message when an invalid email or password is entered
    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessage() throws InterruptedException{
        mainPage.clickOnLoginLink();
        loginPage.sendTextToEmailField("johnsmith0123@gmail.com");
        loginPage.sendTextToPasswordField("password123");
        Thread.sleep(1000);
        loginPage.clickOnSignInLinkOnLoginPage();
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = loginPage.getTextFromInvalidEmailOrPasswordText();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error message not displayed");
    }
}
