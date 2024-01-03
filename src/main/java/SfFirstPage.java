import com.codeborne.selenide.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
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
    private final ElementsCollection listOfLeadsNames = $$x("//a[@data-refid='recordId']");
    private final SelenideElement descendingDateSorting = $x("//th[@class='initialSortDesc sortable descending slds-is-sortable  slds-is-resizable slds-has-focus']");
    private final SelenideElement ascendingDateSorting = $x("//th[@class='initialSortDesc sortable ascending slds-is-sortable  slds-is-resizable slds-has-focus']");
    private final ElementsCollection leadCreationDate = $$x("//span[@class='slds-truncate uiOutputDateTime']");
    private final SelenideElement loadingIndicator = $x("//div[@class='slds-spinner_container slds-grid']");



    //SF login methods
    public void fillTheLoginField() {
        loginFieldSf.shouldBe(visible).sendKeys(BasePage.TEST_USER);
    }

    public void fillThePasswordField() {
        passwordFieldSf.shouldBe(visible).sendKeys(BasePage.TEST_PASSWORD);
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
        loadingIndicator.shouldBe(Condition.disappear);
        if(!listOfLeadsNames.get(0).getText().equals(leadName)){
            sortingButtons.get(7).click();
        }
        listOfLeadsNames.shouldBe(CollectionCondition.itemWithText(leadName));
    }

    public void checkLeadCreationDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateWithoutSeconds =  dtf.toString().substring(0,dtf.toString().length()-3);
        leadCreationDate.get(0).shouldBe(Condition.text(dateWithoutSeconds));
    }
}
