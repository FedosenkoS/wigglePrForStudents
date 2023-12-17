package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.START_LOGIN_URL1;

public class MainFactoryTest extends BasicFactoryTest {

  MainFactoryPage mainFactoryPage = new MainFactoryPage();
//    @Test (description = "Assert the main page is loaded and account icon is visible")
//    public void assertAccountIconIsDisplayed() {
//        boolean actualResult = mainFactoryPage.isAccountLinkDisplayed();
//        Assert.assertEquals(actualResult, true, "Account link isn't visible");
//    }
//
//    @Test (description = "Assert the login page is loaded", dependsOnMethods = "assertAccountIconIsDisplayed")
//    public void assertLoginPageOpened() {
//        mainFactoryPage.clickOnTrustButton();
//        mainFactoryPage.clickOnAccountLink();
//        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Login page isn't loaded properly");
//    }

    @BeforeMethod(description = "Start Page Sing In")
    public void SingInsetUp()
    {
        WebDriver driver = getDriver();
        driver.get(START_LOGIN_URL1);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }

    @Test(description = "validation of the\"Sing in\" form validation when entering password and email", dependsOnMethods = "validationRegisterPageNewCustomer")
    public void validationSinginPasswordEmail() throws InterruptedException {

        String PASSWORD_SIND_IN = "Ibm2021";
        String Email_SIND_IN = "svetunchuk2008@mail.ru";

        mainFactoryPage.sendKeysOnSinginEmailAdress(Email_SIND_IN);
        mainFactoryPage.sendKeysOnSinginPassword(PASSWORD_SIND_IN);
        mainFactoryPage.clickOnSinginSecurely();

        Assert.assertEquals(new LoginPage().isAccountContainerDisplayed(), true, "Login page isn't loaded properly");


    }

    @Test(description = "validation of the\"Sing in\" form validation when only password is entered")
    public void validationSinginPassword() {
        String PASSWORD_SIND_IN = "Ibm2022";

        mainFactoryPage.sendKeysOnSinginPassword(PASSWORD_SIND_IN);
        mainFactoryPage.clickOnSinginSecurely();

        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Account logged in");

    }


    @Test(description = "validation of the \"New customer\" form by a previously unregistered user", dependsOnMethods = "validationSinginPassword")
    public void validationRegisterPageNewCustomer() {

        String Email_New_Customer = "fedosenkos1.22@gmail.com";
        String PASSWORD_SIND_IN = "Ibm2021";

        mainFactoryPage.sendKeysOnSinginEmailAdress(Email_New_Customer);
        mainFactoryPage.sendKeysOnSinginPassword(PASSWORD_SIND_IN);
        mainFactoryPage.clickOnSinginSecurely();

        Assert.assertEquals(new LoginPage().isNewCustomerontainerDisplayed(), true, "Account logged in");



    }

}
