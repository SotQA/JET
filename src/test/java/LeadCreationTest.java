import austria.CityPage;
import austria.VehiclePage;
import austria.WhatYouNeedPage;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import austria.ElNinoPageNew;
import elNino.FirstPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
    SfFirstPage page = new SfFirstPage();
    BasePage basePage = new BasePage();
    private static final List<String> LIST_OF_COUNTRIES = Arrays.asList("Austria", "Belgium", "Bulgaria", "Denmark", "France", "Germany", "Israel", "Italy", "Netherlands", "Poland", "Spain", "Switzerland", "United Kingdom");

    @BeforeMethod
    @BeforeEach
    @Disabled
    public void setUp() {
        Configuration.headless = true;
        Configuration.browserSize = "2560x1440";
        open(FirstPage.FIRST_PAGE_URL);
    }

    @org.junit.jupiter.api.Test
    @Test
    @Disabled
    public void createAustrianLeadFromElninoPage() {
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
        //Lead is created, start checking if the Lead is in SalesForce
        open(BasePage.SALESFORCE_LOGIN_PAGE);
        page.fillTheLoginField();
        page.fillThePasswordField();
        page.clickSubmitButton();
        page.clickShowNavigationMenuButton();
        page.navigationMenuListIsShown();
        page.getObjectNames();
        page.chooseTheObject("Lead");
        page.clickToChooseListView();
        page.fillComboBox("Austria");
        page.chooseComboBoxResult();
        page.sortLeadsByChosenButton(7);
        page.createdLeadIsShown("Autotest " + testData + " " + testData);

    }

    @org.junit.jupiter.api.Test
    @Test
    @Disabled
    public void createBelgiumLeadFromElninoPage() {
        firstPage.clickChooseCountryButton();
        firstPage.countriesListIsShown();
        firstPage.chooseCountry("Belgium");
        firstPage.chooseLanguage();
        firstPage.clickApplyNowButton();
        firstPage.acceptCookies();
//        firstPage.clickChooseCountryButton();
//        firstPage.countriesListIsShown();
//        firstPage.chooseCountry("Belgium");
//        firstPage.clickApplyNowButton();
//        elNinoPageNew.fillFirstNameField("Autotest " + testData);
//        elNinoPageNew.fillLastNameField(testData);
//        elNinoPageNew.fillEmailField(testData + "@gmail.com");
//        elNinoPageNew.fillPhoneNumberField(phoneNumber);
//        elNinoPageNew.chooseCity();
//        elNinoPageNew.chooseAge();
//        elNinoPageNew.chooseHoursOfWork();
//        elNinoPageNew.chooseTypeOFShift();
//        elNinoPageNew.chooseTypeOfVehicle();
//        elNinoPageNew.checkTheBox();
//        elNinoPageNew.clickRegisterButton();
    }

    @org.junit.jupiter.api.Test
    @Test
    @Disabled
    public void createItalianLeadFromElninoPage() {
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
