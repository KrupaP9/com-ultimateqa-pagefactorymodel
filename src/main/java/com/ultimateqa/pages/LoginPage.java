package com.ultimateqa.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField;
    @CacheLookup
    @FindBy(className = "page__heading")
    WebElement welcomeBackText;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signInLinkOnLoginPage;
    @CacheLookup
    @FindBy(className = "form-error__list-item")
    WebElement invalidEmailOrPasswordText;

    public void sendTextToEmailField(String text) {
        Reporter.log("Enter email"+text+ "to email field "+emailField.toString());
        sendTextToElement(emailField, text);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + text);
    }

    public void sendTextToPasswordField(String text) {
        Reporter.log("Enter password " + text + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, text);
       CustomListeners.test.log(Status.PASS,"Enter Password " + text);
    }

    public void clickOnSignInLinkOnLoginPage() {
        Reporter.log("Clicking on Login Button " + signInLinkOnLoginPage.toString());
        clickOnElement(signInLinkOnLoginPage);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
    }

    public String getTextFromWelcomeBack() {
        Reporter.log("Getting welcome back text " + welcomeBackText.toString());
        CustomListeners.test.log(Status.PASS,"Get Text From Welcome Back");
        return getTextFromElement(welcomeBackText);
    }

    public String getTextFromInvalidEmailOrPasswordText() {
        Reporter.log("Getting invalid email or password text " + invalidEmailOrPasswordText.toString());
        CustomListeners.test.log(Status.PASS,"Get Text From Invalid Message");
        return getTextFromElement(invalidEmailOrPasswordText);
    }
}
