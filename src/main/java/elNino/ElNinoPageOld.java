package elNino;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ElNinoPageOld {
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
        phoneNumberField.sendKeys(Integer.toString(phoneNumber));
        System.out.println(phoneNumber);
    }

    public void chooseCity() {
        cityToWorkField.shouldBe(Condition.visible).selectOption(2);
    }

    public void chooseAge() {
        ageField.shouldBe(Condition.interactable).selectOption(1);
    }

    public void chooseHoursOfWork() {
        amountOfHoursOfWorkField.shouldBe(Condition.visible).selectOption(2);
    }

    public void chooseTypeOFShift() {
        typeOfShiftField.shouldBe(Condition.visible).selectOption(2);
    }

    public void chooseTypeOfVehicle() {
        typesOfVehicles.get(1).scrollIntoView(true);
        typesOfVehicles.get(1).click();
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

    //    public void chooseTheCountry(String countryName) {
//        SelenideElement country;
//        for (int i = 0; i < countriesList.size(); i++) {
//            country = countriesList.get(i);
//            switch (country.getText()) {
//            }
//        }
//    }
    public static int generatePhoneNumber(int maxLength) {
        Random random = new Random();
        int maxLimit = (int) Math.pow(10, maxLength) - 1;
        return random.nextInt(maxLimit + 1);
    }
}
