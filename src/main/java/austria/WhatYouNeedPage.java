package austria;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class WhatYouNeedPage {

    private final String firstWarning = "Be above the age of 18.";
    private final String secondWarning = "If you are younger you can apply and we will contact you when you are 18.";
    private final String thirdWarning = "Drivers licence if you plan to use a scooter or car.";
    private final String fourthWarning = "Working permit for country of application.";
    private final String fifthWarning = "If you are a EEA citizen, you will need a valid passport or european ID.  Next a E-card to proof health insurance. And a Meldezettel (residence registration form). If you are a student you need to upload your enrollment cerificate. ";
    private final ElementsCollection driversWarningsList = $$x("//span/div[@class='what-you-need-step']//p");
    private final SelenideElement proceedButton = $x("//button[@id='next-relative']");


    public void warningsAreShown() {
        driversWarningsList.shouldBe(CollectionCondition.texts(firstWarning, secondWarning, thirdWarning, fourthWarning, fifthWarning));
    }

    public void clickProceedButton(){
        proceedButton.shouldBe(Condition.visible).click();
    }
}
