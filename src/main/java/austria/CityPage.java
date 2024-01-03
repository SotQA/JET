package austria;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CityPage {

    //Web elements of Austrian cities
    private final SelenideElement cityOfApplicationDropDown = $x("//select[@id='city_driver_operates2']");
    private final ElementsCollection listOfCities = $$x("//select[@id='city_driver_operates2']/option");
    private final SelenideElement addressField = $x("//div[@id='addressField']");
    private final SelenideElement proceedButton = $x("//button[@id = 'next-relative']");


    //Methods

    public void clickCityDropdown(){
        cityOfApplicationDropDown.shouldBe(Condition.visible).click();
    }

    public void chooseCity(){
        listOfCities.shouldBe(CollectionCondition.size(13));
        listOfCities.get(2).shouldHave(Condition.exactText("Dornbirn")).click();
    }

    public void fillAddressField(String address){
        addressField.should(Condition.exist);
    }

    public void clickProceedButton(){
        proceedButton.shouldBe(Condition.visible).click();
    }
}
