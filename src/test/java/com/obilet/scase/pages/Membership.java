package com.obilet.scase.pages;

import com.obilet.scase.resources.DCUser;
import com.obilet.scase.resources.UserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.obilet.scase.resources.Constants.MemberConst.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Membership {
    WebDriver driver;
    By linkSignIn = By.cssSelector("li[class='login'] a");
    By memberHeader = By.cssSelector("div[class$='login-header'] h2");
    By linkLoginToRegister = By.cssSelector("a[class$='login-to-register']");
    By registerHeader = By.cssSelector("div[class='header user-sign-up login-header'] h2");
    By inputEmail = By.cssSelector("input[aria-label$='Adresi']");
    By inputPassword = By.cssSelector("input[aria-label='Parola']");
    By signUpButton = By.cssSelector("button[class^='register']");
    By accountButton = By.cssSelector("html > body > header > div:nth-of-type(1) > div > ul > li:nth-of-type(2) > a");
    
    public Membership(WebDriver driver) {
        //PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebElement Returner(By by){
        return driver.findElement(by);
    }

    @Given("It is observed that the browser opens.")
    @When("If the URL is entered, the redirection starts.")
    @Then("The page is observed to open.")
    @DisplayName(value = loadCorrectlyDesc)
    public void membershipPageLoadedCorrectly(){
        if (driver.getTitle() != null) assertEquals(loadCorrectlyTitle, driver.getTitle());
    }

    @Given("Member Login, Member Modal, Sign Up button is visible")
    @When("It is seen that the Membership pop-up is opened and it is seen that the Sign Up button actions are performed.")
    @DisplayName(value = checkLoginDescription)
    public void membershipCheckLoginModal() {
        assertTrue(Returner(linkSignIn).isDisplayed());
        Returner(linkSignIn).click();

        assertEquals(checkLoginHeader,Returner(memberHeader).getText());

        assertTrue(Returner(linkLoginToRegister).isDisplayed());
        Returner(linkLoginToRegister).click();
    }

    @Given("Mail and password fields are entered correctly")
    @When("Click on the button to create the membership and take the necessary actions to complete it.")
    @Then("Indicates that the membership process was successful.")
    @DisplayName(value = checkRegisterDescription)
    public void membershipCheckRegisterModal(){
        assertEquals(checkRegisterHeader, Returner(registerHeader).getText());

        assertTrue(Returner(inputEmail).isDisplayed());

        DCUser Dcuser = UserUtil.generateUser();
        Returner(inputEmail).sendKeys(Dcuser.getEmail());
        Returner(inputPassword).sendKeys(Dcuser.getPassword());

        Returner(signUpButton).click();
    }

    @Given("This is the stage where the new user's information is verified.")
    @When("After the membership phase, the page is changed.")
    @Then("You will see a token indicating that you're logged in.")
    @DisplayName(value = verifyNewUserDesc)
    public void membershipVerifyNewUser(){
        assertTrue(Returner(accountButton).isDisplayed());
    }
}
