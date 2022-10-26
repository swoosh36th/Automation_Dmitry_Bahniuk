package task_19;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.index.*;

public class task_19Test extends BaseTest {
    NavigationPage navigationPage;
    TextFieldPage textFieldPage;
    ButtonPage buttonPage;
    CheckboxPage checkboxPage;
    ImagePage imagePage;
    SelectElementPage selectElementPage;
    TablePage tablePage;
    TagAPage tagAPage;
    TagPPage tagPPage;


    @BeforeClass
    public void preconditions() {
        navigationPage = new NavigationPage();
        textFieldPage = new TextFieldPage();
        buttonPage = new ButtonPage();
        checkboxPage = new CheckboxPage();
        imagePage = new ImagePage();
        selectElementPage = new SelectElementPage();
        tablePage = new TablePage();
        tagAPage = new TagAPage();
        tagPPage = new TagPPage();
    }

    @BeforeMethod
    public void openHTML() {
        navigationPage
                .open();
    }

    @Test(testName = "Table data")
    public void tableTest() {
       tablePage
               .verifyTableDataFromFirstColumn();
    }

    @Test(testName = "Enter data in the field")
    public void textFieldTest() {
        textFieldPage
                .enterFirstName(properties.getProperty("firstname"))
                .enterLastName(properties.getProperty("lastname"))
                .clickSubmitBtn()
                .verifyEnterData();
    }

    @Test(testName = "Click button")
    public void buttonTest() {
        buttonPage
                .clickClickMeBtn()
                .verifyAlertMsg()
                .closeAlert();
    }

    @Test(testName = "Checkbox")
    public void checkboxTest() {
        checkboxPage
                .clickBikeCheckBox()
                .clickCarCheckBox()
                .clickBoatCheckBox()
                .clickSubmitBtn()
                .verifyBikeCheckboxIsSelect()
                .verifyCarCheckboxIsSelect()
                .verifyBoatCheckboxIsSelect();
    }

    @Test(testName = "Select element")
    public void selectElementTest() {
        selectElementPage
                .selectAudi()
                .clickSendBtn()
                .verifyAudiIsSelect();
    }

    @Test(testName = "Image")
    public void imageTest() {
        imagePage
                .verifyImageIsDisplayed();
    }

    @Test(testName = "Tag <p>")
    public void tagPTest() {
        tagPPage
                .verifyTextFromTagP();
    }

    @Test(testName = "Tag <a>")
    public void tagATest() {
        tagAPage
                .clickLink()
                .verifyOpenNewPage();
    }
}
