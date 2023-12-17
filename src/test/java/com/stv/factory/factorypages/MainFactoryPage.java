package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static com.stv.framework.core.drivers.Driver.driver;

public class MainFactoryPage extends FactoryPage {

    @FindBy(xpath = "//span[@class='MyAccountToggle_linkText__izUQJ MyAccountToggle_linkTextDesktopOnly__spsqM']")
    private WebElement accountLink;

    @FindBy(xpath = "//button[contains(text(),'Accept all')]")
    private WebElement trustButton;

//    public boolean isAccountLinkDisplayed(){
//        return accountLink.isDisplayed();
//    }
//
//    public void clickOnAccountLink(){
//        accountLink.click();
//    }
//
//    public void clickOnTrustButton(){
//        trustButton.click();
//    }


    //My TEST//

    @FindBy(xpath = "//input[@id='username']")
    private WebElement SinginEmailAdress;

    public void sendKeysOnSinginEmailAdress(String Email){
        SinginEmailAdress.sendKeys(Email);
    }


    @FindBy(xpath = "//input[@id='password']")
    private WebElement SinginPassword;

    public void sendKeysOnSinginPassword(String PASSWORD){
        SinginPassword.sendKeys(PASSWORD);
    }

    @FindBy(xpath = "//button[@class='c1939bbc3 cc78b8bf3 ce1155df5 c1d2ca6e3 c331afe93']")
    private WebElement SinginSecurely;

    public void clickOnSinginSecurely(){

        SinginSecurely.click();
    }



    @FindBy(xpath = "//*[@id=\"qa-dual-register\"]")
    private WebElement NewCustomerContinue;

    public void clickOnNewCustomerContinue(){
        NewCustomerContinue.click();
    }





    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }

    public void clickOnAccountLink(){
        accountLink.click();
    }

    public void clickOnTrustButton(){
        trustButton.click();
    }



}
