package com.obilet.scase.setup;

import com.obilet.scase.pages.FlightSearch;
import com.obilet.scase.pages.Membership;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.obilet.scase.resources.Constants.MemberConst.*;
import static com.obilet.scase.resources.Constants.globalUrl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SetUpTest {
    public WebDriver driver;
    private Membership Mmbr;
    private FlightSearch Fs;

    @BeforeEach
    @Description(value = setUpDescription)
    public void setUp() {
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(globalUrl);

        Mmbr = new Membership(driver);
        Fs = new FlightSearch(driver);
    }

    @AfterEach
    @Description(value = tearDownDescription)
    public void tearDown() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void creatingNewMembership() {
        Mmbr.membershipPageLoadedCorrectly();
        Mmbr.membershipCheckLoginModal();
        Mmbr.membershipCheckRegisterModal();
        Mmbr.membershipVerifyNewUser();
    }

    @Test
    @Order(2)
    public void searchFlightTicket() {
        Fs.searchFlightLoadedCorrectly();
        Fs.selectDepartureCityAndDate();
        Fs.searchAndListFlight();
        Fs.selectDepartureFlight();
        Fs.selectReturnFlight();
        Fs.checkPaymentControl();
    }
}
