package elNino;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FirstPage {
    public static final String FIRST_PAGE_URL = "https://takeaway-recruitment-api.k.elnino-staging.com/it-en/courier";
    private final SelenideElement selectCountryButton = $x("//div[@id='country_button']");
    private final ElementsCollection countriesList = $$x("//li[@class='country_list_item']");
    private final SelenideElement applyNowButton = $x("//a[@id='signup_form_button']");
    private final ElementsCollection languages = $$x("//li[@class='language_list_item']");
    private final SelenideElement cookieButton = $x("//button[@id='cookie_consent_button']");

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

    public void chooseLanguage() {
        selectCountryButton.click();
        languages.get(1).click();
//        for (int i = 0; i < languages.size(); i++) {
//            if(languages.get(i).text().equals("English")){
//                languages.get(i).click();
//            }
    }

    public void acceptCookies() {
            cookieButton.shouldBe(Condition.visible).click();
    }
}
