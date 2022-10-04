package lecture11;

import io.qameta.allure.*;
import lecture11.steps.loginSteps;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.ProductPage;

public class productTest extends BaseTest {
    @Parameters({"username", "password", "steps"})
    @Test
    @Description("Some detailed test description")
    @Step("Searching for '{keyword}' in Google")
    @Link("https://instagram.com")
    @Issue("COVID-19")
    @TmsLink("COVID-19")
    public void productTest(String username, String password, @Optional("0") String steps){
        if(steps.equals("0")){
        new loginSteps().login(username, password);
        new ProductPage()
                .verifyPageTitle();
        }
    }
}
