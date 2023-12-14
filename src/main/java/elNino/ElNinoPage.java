package elNino;

import com.codeborne.selenide.*;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$$x;

public class ElNinoPage {
    Random random = new Random();
    public static final String ELNINIO_URL = "https://takeaway-recruitment-api.k.elnino-staging.com/it-en/courier";

    //Web elements on ElNino page
    private final SelenideElement selectCountryButton = $x("//div[@id='country_button']");
    private final ElementsCollection countriesList = $$x("//li[@class='country_list_item']");
    private final SelenideElement applyNowButton = $x("//a[@id='signup_form_button']");

    //ElNino page elements for registration
    private final SelenideElement firstNameField = $x("//input[@id='first_name2']");
    private final SelenideElement lastNameField = $x("//input[@id='last_name3']");
    private final SelenideElement emailField = $x("//input[@id='email4']");
    private final SelenideElement phoneNumberField = $x("//input[@id='phone_number5']");

    //Select city to work dropdown
    private final SelenideElement cityToWorkField = $x("//select[@id='city_driver_operates7']");
    private final ElementsCollection listOfCitiesToWork = $$x("//select[@id='city_driver_operates7']/option");

    //Age dropdown
    private final SelenideElement ageField = $x("//select[@id='age9']");
    private final ElementsCollection selectAge = $$x("//select[@id='age9']/option");

    //Hours of work dropdown
    private final SelenideElement amountOfHoursOfWorkField = $x("//select[@id='working_hours10']");
    private final ElementsCollection listOfHoursOfWork = $$x("//select[@id='working_hours10']/option");

    //Type of shifts dropdown

    private final SelenideElement typeOfShiftField = $x("//select[@id='picked_shift11']");
    private final ElementsCollection typeOfShiftList = $$x("//select[@id='picked_shift11']/option");

    //Type of vehicle to choose list
    private final ElementsCollection typesOfVehicles = $$x("//div[@class='form__group--flex block-select row']/label");

    //Checkboxes
    protected final SelenideElement whatsAppCheckBox = $x("//input[@id='whatsappconsent13']");
    protected final SelenideElement anonymDataCheckbox = $x("//input[@id='data_anonymization_consent8']");
    private final ElementsCollection checkboxes = $$x("//div[@class='checkbox']");

    //Apply now button
    private final SelenideElement registerButton = $x("//button[@class='button--small has-arrow is-block']");
    private final SelenideElement centerOfThePage = $x("//form");


    //Methods for ElNino page
    public void clickChooseCountryButton() {
        selectCountryButton.shouldBe(Condition.visible);
        selectCountryButton.click();
    }

    public void countriesListIsShown() {
        countriesList.should(CollectionCondition.size(13));
    }

    public void clickApplyNowButton() {
        applyNowButton.shouldBe(Condition.visible);
        applyNowButton.click();
    }

    public void chooseCountry(String country) {
        for (int i = 0; i < countriesList.size(); i++) {
            SelenideElement countryFromList = countriesList.get(i);
            if (countryFromList.shouldBe(Condition.visible).text().equalsIgnoreCase(country))
                countryFromList.click();
            break;
        }
    }

    public List<String> namesOfTheCities() {
        return listOfCitiesToWork.texts();
    }

    public List<String> listOfHoursOfWork() {
        return listOfHoursOfWork.texts();
    }

    public List<String> listOfVehicles() {
        return typesOfVehicles.texts();
    }

    public void fillFirstNameField(String firstName) {
        firstNameField.shouldBe(Condition.visible);
        firstNameField.sendKeys(firstName);
    }

    public void fillLastNameField(String lastName) {
        lastNameField.shouldBe(Condition.visible);
        lastNameField.sendKeys(lastName);
    }

    public void fillEmailField(String email) {
        emailField.shouldBe(Condition.visible);
        emailField.sendKeys(email);
    }

    public void fillPhoneNumberField(int phoneNumber) {
        phoneNumberField.shouldBe(Condition.visible).click();
        phoneNumberField.sendKeys(Integer.toString(phoneNumber));
    }

    public void chooseCity() {
        cityToWorkField.shouldBe(Condition.visible).selectOption(2);

//        listOfCitiesToWork.shouldBe(CollectionCondition.texts(namesOfTheCities()));
//        listOfCitiesToWork.get(4).click();
        Selenide.sleep(500);
    }

    public void chooseAge() {
        ageField.shouldBe(Condition.interactable).selectOption(1);
//        selectAge.get(1).click();
        Selenide.sleep(500);
    }

    public void chooseHoursOfWork() {
        int UPPERBOUND_HOURS_LIST = 5;
        amountOfHoursOfWorkField.shouldBe(Condition.visible).selectOption(2);
//        amountOfHoursOfWorkField.selectOption(random.nextInt(random.nextInt(listOfHoursOfWork.size())));
//        listOfHoursOfWork.shouldBe(CollectionCondition.texts(listOfHoursOfWork()));
//        listOfHoursOfWork.get(random.nextInt(UPPERBOUND_HOURS_LIST)).click();
    }

    public void chooseTypeOFShift() {
        typeOfShiftField.shouldBe(Condition.visible).selectOption(2);
//        typeOfShiftList.should(CollectionCondition.size(5));
//        int UPPERBOUND_SHIFTS = 5;
//        typeOfShiftList.get(2).click();
    }

    public void chooseTypeOfVehicle() {
        typesOfVehicles.get(1).scrollIntoView(true);
        typesOfVehicles.get(1).click();
        Selenide.sleep(500);
//        typesOfVehicles.shouldBe(CollectionCondition.texts(listOfVehicles()));
//        typesOfVehicles.get(1).click();
    }

    public void checkTheBox() {
        for (int i = 0; i < checkboxes.size(); i++) {
            SelenideElement checkbox = checkboxes.get(i);
            checkbox.shouldBe(Condition.visible);
            if (!checkbox.is(Condition.checked)) {
                checkbox.click();
            }
        }
    }

    public void clickRegisterButton() {
        registerButton.shouldBe(Condition.interactable).click();
    }

    public void chooseTheCountry(String countryName) {
        SelenideElement country;
        for (int i = 0; i < countriesList.size(); i++) {
            country = countriesList.get(i);
            switch (country.getText()) {

            }
        }
    }
}
