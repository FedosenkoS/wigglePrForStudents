package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginPage;
import com.stv.factory.factorypages.MainFactoryPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.lib.WigglePageURLs.START_LOGIN_URL1;
import static com.stv.framework.core.lib.WigglePageURLs.EMAIL_SIND_IN;
import static com.stv.framework.core.lib.WigglePageURLs.PASSWORD_SIND_IN;

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

//        String PASSWORD_SIND_IN = "Ibm2021";
//        String EMAIL_SIND_IN = "svetunchuk2008@mail.ru";

        mainFactoryPage.sendKeysOnSinginEmailAdress(EMAIL_SIND_IN);
        mainFactoryPage.sendKeysOnSinginPassword(PASSWORD_SIND_IN);
        mainFactoryPage.clickOnSinginSecurely();

        Assert.assertEquals(new LoginPage().isAccountContainerDisplayed(), true, "Login page isn't loaded properly");


    }

    @Test(description = "validation of the\"Sing in\" form validation when only password is entered", dataProvider = "testData")
    public void validationSinginPassword(String noValpassword) {
        //String PASSWORD_SIND_IN = "Ibm2022";

        mainFactoryPage.sendKeysOnSinginPassword(noValpassword);
        mainFactoryPage.clickOnSinginSecurely();

        Assert.assertEquals(new LoginPage().isLoginContainerDisplayed(), true, "Account logged in");

    }



    @Test(description = "validation of the \"New customer\" form by a previously unregistered user", dependsOnMethods = "validationSinginPassword", dataProvider = "testData2")
    public void validationRegisterPageNewCustomer(String email, String password) {

//        String Email_New_Customer = "fedosenkos1.22@gmail.com";
//        String PASSWORD_SIND_IN = "Ibm2021";

        mainFactoryPage.sendKeysOnSinginEmailAdress(email);
        mainFactoryPage.sendKeysOnSinginPassword(password);
        mainFactoryPage.clickOnSinginSecurely();

        Assert.assertEquals(new LoginPage().isNewCustomerontainerDisplayed(), true, "Account logged in");



    }
    @DataProvider()
    public Object[][] testData() {
        return new Object[][] {
                new Object[] {"Ibm2022"},

        };
    }
    @DataProvider()
    public Object[][] testData2() {
        return new Object[][] {
                new Object[] {"fedosenkos1.22@gmail.com", "Ibm2021"},

        };
    }
}
