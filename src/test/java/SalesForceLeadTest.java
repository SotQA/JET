import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class SalesForceLeadTest {
    //Gent city is open
    SfFirstPage page = new SfFirstPage();

    @BeforeMethod
    public void setUp(){
        Configuration.headless = false;
        Configuration.browserSize = "2560x1440";
        open(BasePage.SALESFORCE_LOGIN_PAGE);
    }

    @org.junit.jupiter.api.Test
    @Test
    public void checkTheLeadIsCreated() throws InterruptedException {
        page.fillTheLoginField();
        page.fillThePasswordField();
        page.clickSubmitButton();
        page.clickShowNavigationMenuButton();
        page.navigationMenuListIsShown();
        page.getObjectNames();
        page.chooseTheObject("Lead");
        Thread.sleep(10000);
    }
}
