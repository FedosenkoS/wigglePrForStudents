package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(xpath = "//span[@class='MyAccountToggle_linkText__izUQJ MyAccountToggle_linkTextDesktopOnly__spsqM']")
    private WebElement accountLink;

    @FindBy(xpath = "//button[contains(text(),'Accept all')]")
    private WebElement trustButton;

    public MainFactoryPage() {
    }

    public boolean isAccountLinkDisplayed(){
        return accountLink.isDisplayed();
    }
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

    @FindBy(xpath = "//button[@class='cf4ff3b5d c5faccce1 cfccd0b2a c901653c3 cd1bb01a0']")
    private WebElement SinginSecurely;

    public void clickOnSinginSecurely(){

        SinginSecurely.click();
    }



    @FindBy(xpath = "//*[@id=\"qa-dual-register\"]")
    private WebElement NewCustomerContinue;

    public void clickOnNewCustomerContinue(){
        NewCustomerContinue.click();
    }


    @FindBy(xpath = "//input[@id='autocomplete-1-input']")
    private WebElement SearchWord;

    public void serchWordinSearch(String Word){
        SearchWord.sendKeys(Word);
    }

    @FindBy(xpath = "//input[@id='autocomplete-6-input']")
    private WebElement SeeWord;

    public String seeWordinSearch(){
        return SeeWord.getAttribute("value"); }



    @FindBy(xpath = "//a[@href='/search?query=cycle']//div[@class='ListItems_itemWrapper__N82f7']//div[@class='ListItems_itemContent__QI7tk']//div[@class='ListItems_itemContentBody__hywPd']//mark[contains(text(),'cycle')]")
    private WebElement resultSearch;


    public boolean isResultSearchDisplayed(){
        return resultSearch.isDisplayed(); }

@FindBy(xpath = "//button[@aria-label='Clear button']//*[name()='svg']")
private WebElement ClearSearch;
    public void wordClearSearch(){
        ClearSearch.click();
    }

    @FindBy(xpath = "//*[@id=\"autocomplete-10-input\"]")
    private WebElement EmplySearch;

    public String  isClearSearchDisplayed(){
        return EmplySearch.getAttribute("enterkeyhint"); }

    @FindBy(xpath ="//a[@class='Link_link__s0GAk HeaderSecondaryBar_secondaryLink__Qqckd'][normalize-space()='Help']")
    private WebElement LinkHelp;
    public void  goHelpPage() {
        LinkHelp.click();}


    @FindBy(xpath = "//*[@id=\"eg-ss-search-field\"]/div[2]/div/input")
    private WebElement HelpSearch;

    public boolean isHelpPageDisplayed(){
        return HelpSearch.isDisplayed();
    }

    public void sendKeysOnHelp(String word) {
        HelpSearch.sendKeys(word);}

    @FindBy(xpath = "//*[@class=\"form-control eg-form-control eg-dropdown-menu-precursor ng-valid ng-touched ng-dirty ng-valid-parse ng-not-empty\"] ")
    private WebElement WordHelp;
    public boolean WordinHelp(){
        return WordHelp.isDisplayed();
        }

    @FindBy(xpath ="//*[@id=\"eg-ss-search-field\"]/div[2]/div/span/img")
    private WebElement StartHelp;
    public void  clickGoHelp() {
       StartHelp.click();}



    @FindBy(xpath ="//*[@id=\"eg-ss-search-results-list\"]/ul/li[1]/h3/div/span[1]")
    private WebElement ResualtHelp;
    public boolean SearchResultsHelp() {
        return ResualtHelp.isDisplayed();
    }

    }


