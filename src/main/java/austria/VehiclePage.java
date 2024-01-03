package austria;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class VehiclePage {
    private final ElementsCollection agesButtons = $$x("//input[@name='age']");
    private final SelenideElement hoursDropdown = $x("//select[@name='working_hours']");
    private final ElementsCollection hoursList = $$x("//select/option");

    private final ElementsCollection typesOfShifts = $$x("//label//input[@name='picked_shift']");
    private final ElementsCollection vehicleTypes = $$x("//input[@name='vehicle_type']");
    private final SelenideElement checkBoxConsent = $x("//div[@class='checkbox']");
    private final ElementsCollection collectionOfButtons = $$x("//div[@class='form__group--flex block-select row']/label");

    public void chooseAge() {
        collectionOfButtons.get(0).click();
//        agesButtons.get(0).click();
    }

    public void chooseHours() {
        collectionOfButtons.get(3).click();
//        hoursDropdown.click();
//        hoursList.get(1).click();
    }

    public void chooseTypeOfShift() {
        collectionOfButtons.get(9).click();
    }

    public void chooseVehicleType(){
        collectionOfButtons.get(13).click();
    }

    public void clickCheckBoxConsent(){
        checkBoxConsent.shouldBe(Condition.visible).click();
    }
}
