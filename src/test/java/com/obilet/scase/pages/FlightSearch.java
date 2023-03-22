package com.obilet.scase.pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static com.obilet.scase.resources.Constants.FlightConst.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlightSearch {
    WebDriver driver;
    By linkFlightMenu = By.cssSelector("a[data-event-action='Flight']");
    By linkFromFlightOpen = By.cssSelector("#origin-input");
    By linkFromFlightSearch = By.cssSelector("input[id='origin-input']");
    By linkToFlightOpen = By.cssSelector("#destination-input");
    By linkToFlightSearch = By.cssSelector("input[id='destination-input']");
    By departureDate = By.cssSelector("#departure-input");
    By departureDateCl = By.xpath("//button[@class='week in']//span[contains(text(),'15')]");
    /*
    Date date;
    { date = new Date(date.getTime() + (1000 * 60 * 60 * 24)); }
    By.xpath("//button[@class='week in']//span[contains(text(),date)]")
    */
    //Alt= By.CssSelector("html > body > main > div:nth-of-type(1) > div:nth-of-type(2) > form > div:nth-of-type(2) > div:nth-of-type(1) > div > ob-datepicker > div > div > div:nth-of-type(1) > div > table > tbody > tr:nth-of-type(5) > td:nth-of-type(5)")
    By oneWayFlight = By.cssSelector(".box.flight-check");
    By destinationDate = By.xpath("//input[@id='return-input']");
    By destinationDateCl = By.xpath("//button[@class='week in']//span[contains(text(),'22')]");
    By searchFlightButton = By.cssSelector("#search-button");
    By ulOutboundJourneys = By.cssSelector("ul[id='outbound-journeys']");
    By ulOutboundJourneyz = By.cssSelector("ul[id='outbound-journeys'] li");
    By warningCol = By.xpath("//*[text() = 'Promosyonlu']");
    By warningColReturn = By.xpath("//*[text() = 'Promosyonlu']");
    By infoButton = By.cssSelector("button.details");
    By flightCode = By.cssSelector("div[class^='code'] strong");
    By flightInfoClose = By.cssSelector("div[class='header '] button[class='close']");
    By flyContainer = By.cssSelector("ul[class='flys'] li");
    By ecoFlyHeader = By.cssSelector("div[class$='EF'] div[class='fly-title-container']");
    By ecoFlyContainer = By.cssSelector("div[class$='EF']");
    By ulReturnJourney = By.cssSelector("ul[id='return-journeys']");
    By returnContainer = By.cssSelector("div.top-green-arrow-container");
    By ulReturnJourneyList = By.cssSelector("ul[id='return-journeys'] li");
    By journeyTitle = By.cssSelector("label[class='journey-contact-info-label']");
    By infoReturnButton = By.xpath("//*[text() = 'Detaylı Bilgi']");
    By departureCodes = By.cssSelector("html > body > main > form > div:nth-of-type(1) > fieldset:nth-of-type(1) > div > div > table > tbody:nth-of-type(1) > tr:nth-of-type(2) > td > table > tbody > tr > td:nth-of-type(1) > table > tbody > tr:nth-of-type(1) > td > div > strong");
    By returnCodes = By.cssSelector("html > body > main > form > div:nth-of-type(1) > fieldset:nth-of-type(1) > div > div > table > tbody:nth-of-type(2) > tr:nth-of-type(3) > td > table > tbody > tr > td:nth-of-type(1) > table > tbody > tr:nth-of-type(1) > td > div > strong");
    public FlightSearch(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement Returner(By by) {
        return driver.findElement(by);
    }

    public void setDriverWait(By by) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    @Given("Click on the Flight Tab")
    @When("The flight ticket search page must be open.")
    @Then("There will be a display of the flight search page.")
    @DisplayName(value = searchFlightLoadedCorrectlyDesc)
    public void searchFlightLoadedCorrectly() {
        Returner(linkFlightMenu).click();
        assertEquals(searchFlightLoadCorrectlyTitle, driver.getTitle());
    }

    @Given("The city and date will be the selection.")
    @When("UI components display the selected values.")
    @Then("Actions are performed on the selected values.")
    @DisplayName(value = selectDepartureCityAndDateDesc)
    public void selectDepartureCityAndDate() {
        Returner(linkFromFlightOpen).click();
        Returner(linkFromFlightSearch).sendKeys(DepartureCity);
        Returner(linkToFlightOpen).click();
        Returner(linkToFlightSearch).sendKeys(DestinationCity);

        Returner(departureDate).click();
        Returner(departureDateCl).click();

        if(!Returner(oneWayFlight).isSelected()) Returner(oneWayFlight).click();
        else Returner(destinationDate).click();
        Returner(destinationDateCl).click();
    }

    @Given("The required flight information is expected to be complete.")
    @When("Search button is clicked, actions must be taken.")
    @Then("It is observed that flights are listed.")
    @DisplayName(value = searchAndListFlightDesc)
    public void searchAndListFlight() {
        Returner(searchFlightButton).click();
        setDriverWait(ulOutboundJourneys);
        assertTrue(Returner(ulOutboundJourneys).isDisplayed());
    }

    private String departureCodeStr = null;
    private String returnCodeStr = null;
    
    @Given("The selection is made when flights are observed to be loaded.")
    @When("The desired departure flight is selected according to the ranking.")
    @Then("The departure flight is selected.")
    @DisplayName(value = selectDepartureFlight)
    public void selectDepartureFlight() {
        List<WebElement> outboundJourney = driver.findElements(ulOutboundJourneyz);
        if (outboundJourney.size() > 0) {
            if (!Returner(warningCol).isDisplayed()) {
                outboundJourney.get(0).click();
            } else {
                Actions actions = new Actions(driver);
                actions.moveToElement(Returner(warningCol));
                actions.perform();
                Returner(warningCol).click();
                Returner(infoButton).click();
                //String text = outboundJourney.get(i).getAttribute("id");
            }
        }
        departureCodeStr = Returner(flightCode).getText();
        Returner(flightInfoClose).click();

        List<WebElement> flyCont = driver.findElements(flyContainer);
        if (flyCont.size()>0) if (Objects.equals(Returner(ecoFlyHeader).getText(), ecoFlyString)) {
            Returner(ecoFlyContainer).click();
        }
        setDriverWait(ulReturnJourney);
    }

    @Given("The selection is made when flights are observed to be loaded.")
    @When("The desired return flight is selected according to the ranking.")
    @Then("The return flight is selected.")
    @DisplayName(value = selectReturnFlight)
    public void selectReturnFlight() {
        List<WebElement> returnJourney = driver.findElements(ulReturnJourneyList);
        setDriverWait(warningColReturn);
        if (returnJourney.size() > 0) {
            if (!Returner(warningCol).isDisplayed()) {
                returnJourney.get(0).click();
            } else {
                Actions actions = new Actions(driver);
                actions.moveToElement(Returner(warningCol));
                actions.perform();
                
                Returner(warningColReturn).click();
                Returner(infoReturnButton).click();
            }
        }
        returnCodeStr = Returner(flightCode).getText();
        Returner(flightInfoClose).click();

        if (Returner(warningColReturn).isDisplayed()) Returner(warningColReturn).click();
        List<WebElement> flyCont = driver.findElements(flyContainer);
        if (flyCont.size()>0) {
            if (Objects.equals(Returner(ecoFlyHeader).getText(), ecoFlyString)) {
                Returner(returnContainer).click();
            }
        }
    }

    @Given("Payment will be verified upon successful opening of the page.")
    @When("Confirm that the round-trip flight on the payment page is the selected round-trip flight.")
    @DisplayName(value = paymentDescription)
    public void checkPaymentControl() {
        setDriverWait(journeyTitle);
        assertEquals(journeyTitleHeader,Returner(journeyTitle).getText());

        assertEquals(departureCodeStr,Returner(departureCodes).getText().split("- ")[1]);
        assertEquals(returnCodeStr,Returner(returnCodes).getText().split("- ")[1]);
    }
}
