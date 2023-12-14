import com.codeborne.selenide.Configuration;
import elNino.ElNinoPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;


public class LeadCreationTest {

    //Generating a random String for the String fields
    String testData = RandomStringUtils.randomAlphanumeric(8);
    Random random = new Random();
    private int upperBound = 10;
    int phoneNumber = random.nextInt(10);
    ElNinoPage elNinoPage = new ElNinoPage();

    private static final List<String> LIST_OF_COUNTRIES = Arrays.asList("Austria", "Belgium", "Bulgaria", "Denmark", "France", "Germany", "Israel", "Italy", "Netherlands", "Poland", "Spain", "Switzerland", "United Kingdom");

    @BeforeMethod
    public void setUp() {
        Configuration.headless = false;
        Configuration.browserSize = "2560x1440";
        open(ElNinoPage.ELNINIO_URL);
    }

    @org.junit.jupiter.api.Test
    @Test
    public void createAustrianLeadFromElninoPage() {
        elNinoPage.clickChooseCountryButton();
        elNinoPage.countriesListIsShown();
        elNinoPage.chooseCountry("Austria");
        elNinoPage.clickApplyNowButton();
        elNinoPage.fillFirstNameField("Autotest " + testData);
        elNinoPage.fillLastNameField(testData);
        elNinoPage.fillEmailField(testData + "@gmail.com");
        elNinoPage.fillPhoneNumberField(random.nextInt());
        elNinoPage.chooseCity();
        elNinoPage.chooseAge();
        elNinoPage.chooseHoursOfWork();
        elNinoPage.chooseTypeOFShift();
        elNinoPage.chooseTypeOfVehicle();
        elNinoPage.checkTheBox();
        elNinoPage.clickRegisterButton();
    }
    @org.junit.jupiter.api.Test
    @Test
    public void createBelgiumLeadFromElninoPage() throws InterruptedException {
        elNinoPage.clickChooseCountryButton();
        elNinoPage.countriesListIsShown();
        Thread.sleep(500);
        elNinoPage.chooseCountry(LIST_OF_COUNTRIES.get(1));
        Thread.sleep(500);
        elNinoPage.clickApplyNowButton();
        elNinoPage.fillFirstNameField("Autotest " + testData);
        elNinoPage.fillLastNameField(testData);
        elNinoPage.fillEmailField(testData + "@gmail.com");
        elNinoPage.fillPhoneNumberField(phoneNumber);
    }
}
