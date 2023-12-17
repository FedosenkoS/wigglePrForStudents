package com.stv.bdd.steps;

import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.stv.framework.core.drivers.Driver.driver;
import static com.stv.framework.core.lib.WigglePageURLs.*;

import java.util.concurrent.TimeUnit;


public class StartPage extends BasicFactoryTest {
    MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @Given("^Start page is opened by default$")
    public void setup() throws Throwable {
        WebDriver driver = getDriver();
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();}

    @When("^The user enters CYCLE into the search$")
    public void enterCycle() {
            String Word = "cycle";
            mainFactoryPage.serchWordinSearch(Word);
        }

        @Then("^A query appeared in the search$")
        public void searchCheck() {

        String expectedResult = "cycle";
        String actualResult = mainFactoryPage.seeWordinSearch();
                Assert.assertEquals(actualResult, expectedResult, "Word not entered");
        }

        @And("^Search results are displayed$")
        public void searchResults(){
        boolean actualResult = mainFactoryPage.isResultSearchDisplayed();
            Assert.assertTrue(actualResult);
        }

   @When("^User clears search$")
   public void clearSearch() {
        mainFactoryPage.wordClearSearch();
        }
        @Then("^Search is empty$")
        public void searchEmpty() {
        String expectedResult = "search";
        String actualResult = mainFactoryPage.isClearSearchDisplayed();
        Assert.assertEquals(actualResult, expectedResult, "Search is full");
            }
    @When("^User asks for help$")
    public void asksForHelp () {
        mainFactoryPage.goHelpPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Then("^The user went to the help page$")
    public void wentHelpPage () {

        org.testng.Assert.assertTrue(mainFactoryPage.isHelpPageDisplayed(), "Help page isn't loaded properly");
    }

    @When("^User enters (\\S+)$")
    public void enterWord(String string) {

        mainFactoryPage.sendKeysOnHelp(string);
    }

    @Then("^A request appeared while searching for help$")
    public void CheckingRequest() {
        org.testng.Assert.assertTrue(mainFactoryPage.WordinHelp(), "Word not entered");


    }

    @When("^Started a search$")
    public void startSearchHelp() {
        mainFactoryPage.clickGoHelp();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^Search results are displayed help$")
    public void SearchResultsDisplayedHelp() {
        org.testng.Assert.assertTrue(mainFactoryPage.SearchResultsHelp(), "Search failed");
    }


    }









