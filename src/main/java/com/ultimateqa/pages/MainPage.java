package com.ultimateqa.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MainPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//li[@class='header__nav-item header__nav-sign-in']/a")
    WebElement signInLink;

    public void clickOnLoginLink() {
        Reporter.log("Clicking on Sign In Button " + signInLink.toString());
        clickOnElement(signInLink);
        CustomListeners.test.log(Status.PASS,"Click On Login Link");
    }
}
