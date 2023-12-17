package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends FactoryPage {
    @FindBy(xpath = "//*[contains(text(),'Please log in')]")
    private WebElement loginContainer;
    @FindBy(xpath = "//span[@class='MyAccountToggle_linkText__izUQJ MyAccountToggle_linkTextDesktopOnly__spsqM']")
    private WebElement accountContainer;
    public boolean isLoginContainerDisplayed(){
        return loginContainer.isDisplayed();
    }

    public boolean isAccountContainerDisplayed(){
        return accountContainer.isDisplayed();
    }

    @FindBy(xpath = "//span[@id='error-element-password']")
    private WebElement newCustomer;
    public boolean isNewCustomerontainerDisplayed(){
        return newCustomer.isDisplayed();
    }
}
