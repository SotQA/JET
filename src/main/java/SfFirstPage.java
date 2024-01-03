import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.WebDriverContainer;
import org.bouncycastle.oer.its.etsi102941.Url;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.currentFrameUrl;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SfFirstPage {


    //Login page to SF
    private final SelenideElement loginFieldSf = $x("//input[@type='email']");
    private final SelenideElement passwordFieldSf = $x("//input[@id='password']");
    private final SelenideElement submitButton = $x("//input[@id='Login']");

    //Salesforce Web elements
    private final SelenideElement homeButton = $x("//a[@title='Home']");
    private final SelenideElement showNavMenuButton = $x("//button[@title='Show Navigation Menu']");
    private final SelenideElement navigationMenuList = $x("//div[@id='navMenuList']");
    private final ElementsCollection objectsList = $$x("//ul[@role='group']/li[@role='presentation']");
    private final List<String> objectsNames = new ArrayList<>();
    private final SelenideElement selectListViewButton = $x("//button[@title='Select a List View: Leads']");
    private final SelenideElement searchInComboBox = $x("//input[@role='combobox']");
    private final SelenideElement firstResultInComboBox = $x("//li/a[@role='option']");
    private final static String AUSTRIAN_LEADS_URL = "https://scoober--par.sandbox.lightning.force.com/lightning/o/Lead/list?filterName=00B1x000009IULAEA4";
    private final ElementsCollection sortingButtons = $$x("//a[@class='toggle slds-th__action slds-text-link--reset ']");
    private final ElementsCollection listOfLeads = $$x("//tr");


    //SF login methods
    public void fillTheLoginField() {
        loginFieldSf.shouldBe(visible).sendKeys(Config.TEST_USER);
    }

    public void fillThePasswordField() {
        passwordFieldSf.shouldBe(visible).sendKeys(Config.TEST_PASSWORD);
    }

    public void clickSubmitButton() {
        submitButton.shouldBe(Condition.interactable).click();
    }

    //Methods in the SalesForce
    public void homeButtonIsShown() {
        homeButton.shouldBe(visible);
    }

    public void clickShowNavigationMenuButton() {
        showNavMenuButton.shouldBe(visible).click();
    }

    public void navigationMenuListIsShown() {
        navigationMenuList.shouldBe(visible);
    }

    public void getObjectNames() {
        objectsList.shouldBe(CollectionCondition.size(objectsNames.size()));
        for (int i = 0; i < objectsList.size(); i++) {
            String object = objectsList.get(i).text();
            objectsNames.add(object);
        }
    }

    public void chooseTheObject(String objectName) {
        for (int i = 0; i < objectsList.size(); i++) {
            SelenideElement element = objectsList.get(i);
            if (element.getText().equals(objectName)) {
                element.shouldBe(Condition.interactable).click();
            }
        }
    }

    public void clickToChooseListView(){
        selectListViewButton.shouldBe(visible).click();
    }

    public void fillComboBox(String searchValue){
        searchInComboBox.shouldBe(visible).sendKeys(searchValue);
    }

    public void chooseComboBoxResult(){
        firstResultInComboBox.shouldBe(visible).click();
        assert AUSTRIAN_LEADS_URL.equals(url());
    }

    public void sortLeadsByChosenButton(int buttonNumber){
        sortingButtons.shouldBe(CollectionCondition.size(12));
        sortingButtons.get(buttonNumber).click();
    }

    public void createdLeadIsShown(String leadName){
        listOfLeads.shouldBe(CollectionCondition.itemWithText(leadName));
    }
}
