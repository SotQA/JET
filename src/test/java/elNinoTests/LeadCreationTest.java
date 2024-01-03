package elNinoTests;

import austria.CityPage;
import austria.VehiclePage;
import austria.WhatYouNeedPage;
import com.codeborne.selenide.Configuration;
import austria.ElNinoPageNew;
import elNino.FirstPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;


public class LeadCreationTest {

    //Generating a random String for the String fields
    String testData = RandomStringUtils.randomAlphanumeric(8);
    int maxLength = 11;
    int phoneNumber = ElNinoPageNew.generatePhoneNumber(maxLength);
    ElNinoPageNew elNinoPageNew = new ElNinoPageNew();
    FirstPage firstPage = new FirstPage();
    CityPage cityPage = new CityPage();
    WhatYouNeedPage whatYouNeedPage = new WhatYouNeedPage();
    VehiclePage vehiclePage = new VehiclePage();
    private static final List<String> LIST_OF_COUNTRIES = Arrays.asList("Austria", "Belgium", "Bulgaria", "Denmark", "France", "Germany", "Israel", "Italy", "Netherlands", "Poland", "Spain", "Switzerland", "United Kingdom");

    @BeforeMethod
    @BeforeEach
    public void setUp() {
        Configuration.headless = false;
        Configuration.browserSize = "2560x1440";
        open(FirstPage.FIRST_PAGE_URL);
    }

    @org.junit.jupiter.api.Test
    @Test
    public void createAustrianLeadFromElninoPage() throws InterruptedException {
        firstPage.clickChooseCountryButton();
        firstPage.countriesListIsShown();
        firstPage.chooseCountry("Austria");
        firstPage.chooseLanguage();
        firstPage.clickApplyNowButton();
        firstPage.acceptCookies();
        cityPage.chooseCity();
        cityPage.fillAddressField(testData);
        cityPage.clickProceedButton();
        whatYouNeedPage.warningsAreShown();
        whatYouNeedPage.clickProceedButton();
        elNinoPageNew.fillFirstNameField("Autotest " + testData);
        elNinoPageNew.fillLastNameField(testData);
        elNinoPageNew.fillEmailField(testData + "@gmail.com");
        elNinoPageNew.fillPhoneNumberField(phoneNumber);
        whatYouNeedPage.clickProceedButton();
        vehiclePage.chooseAge();
        vehiclePage.chooseHours();
        vehiclePage.chooseTypeOfShift();
        vehiclePage.chooseVehicleType();
        vehiclePage.clickCheckBoxConsent();
        whatYouNeedPage.clickProceedButton();
        whatYouNeedPage.clickProceedButton();
    }
    @org.junit.jupiter.api.Test
    @Test
    public void createBelgiumLeadFromElninoPage() {
        firstPage.clickChooseCountryButton();
        firstPage.countriesListIsShown();
        firstPage.chooseCountry("Belgium");
        firstPage.clickApplyNowButton();
        elNinoPageNew.fillFirstNameField("Autotest " + testData);
        elNinoPageNew.fillLastNameField(testData);
        elNinoPageNew.fillEmailField(testData + "@gmail.com");
        elNinoPageNew.fillPhoneNumberField(phoneNumber);
        elNinoPageNew.chooseCity();
        elNinoPageNew.chooseAge();
        elNinoPageNew.chooseHoursOfWork();
        elNinoPageNew.chooseTypeOFShift();
        elNinoPageNew.chooseTypeOfVehicle();
        elNinoPageNew.checkTheBox();
        elNinoPageNew.clickRegisterButton();
    }

    @org.junit.jupiter.api.Test
    @Test
    public void createItalianLeadFromElninoPage(){
        firstPage.clickChooseCountryButton();
        firstPage.countriesListIsShown();
        firstPage.chooseCountry("Italy");
        firstPage.clickApplyNowButton();
        elNinoPageNew.fillFirstNameField("Autotest " + testData);
        elNinoPageNew.fillLastNameField(testData);
        elNinoPageNew.fillEmailField(testData + "@gmail.com");
//        elNinoPage.fillPhoneNumberField(random.nextInt() + 1);
        elNinoPageNew.fillPhoneNumberField(phoneNumber);
        elNinoPageNew.chooseCity();
        elNinoPageNew.chooseAge();
        elNinoPageNew.chooseHoursOfWork();
        elNinoPageNew.chooseTypeOFShift();
        elNinoPageNew.chooseTypeOfVehicle();
        elNinoPageNew.checkTheBox();
        elNinoPageNew.clickRegisterButton();
    }

}
