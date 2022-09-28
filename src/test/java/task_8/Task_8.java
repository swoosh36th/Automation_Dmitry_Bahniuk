package task_8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.*;

import static pageObjects.herokuapp.NavigationItem.*;

public class Task_8 extends BaseTest {
    @BeforeMethod
    public void precondition() {
        new NavigationPage()
                .open();
    }

    @Test(enabled = false)
    public void contextMenuTest() {
        new NavigationPage()
                .navigateTo(CONTEXT_MENU);
        new ContextMenuPage()
                .clickContext()
                .verifyAlert("You selected a context menu");
    }

    @Test(enabled = false)
    public void dynamicControlsTest1() {
        new NavigationPage()
                .navigateTo(DYNAMIC_CONTROLS);
        new DynamicControlsPage()
                .clickCheckBox()
                .clickRemoveBtn()
                .waitForText()
                .verifyText1()
                .verifyCheckboxMissing();
    }

    @Test(enabled = false)
    public void dynamicControlsTest2() {
        new NavigationPage()
                .navigateTo(DYNAMIC_CONTROLS);
        new DynamicControlsPage()
                .verifyInputDisable();
    }

    @Test(enabled = false)
    public void dynamicControlsTest3() {
        new NavigationPage()
                .navigateTo(DYNAMIC_CONTROLS);
        new DynamicControlsPage()
                .clickEdBtn()
                .waitForText()
                .verifyText2()
                .verifyInputEnable();
    }

    @Test(enabled = false)
    public void framesTest() {
        new NavigationPage()
                .navigateTo(FRAMES);
        new FramesPage()
                .clickFrameLink("iFrame")
                .switchToFrame()
                .enterText("Hello World!!!")
                .unSwitchFrame()
                .clickTextBold();
    }

    @Test(enabled = false)
    public void fileUploadTest() {
        new NavigationPage()
                .navigateTo(FILE_UPLOAD);
        new FileUploadPage()
                .uploadFile()
                .clickUploadBtn()
                .verifyUploadFile();
    }

    @Test(enabled = false)
    public void addRemoveElementsTest1() {
        new NavigationPage()
                .navigateTo(ADD_REMOVE_ELEMENTS);
        new AddRemoveElementsPage()
                .clickAddElementButton()
                .verifyAddOneDeleteBtn();
    }

    @Test(enabled = false)
    public void addRemoveElementsTest2() {
        new NavigationPage()
                .navigateTo(ADD_REMOVE_ELEMENTS);
        new AddRemoveElementsPage()
                .addSixDeleteBtn()
                .verifyAddSixDeleteBtn();
    }

    @Test(enabled = false)
    public void addRemoveElementsTest3() {
        new NavigationPage()
                .navigateTo(ADD_REMOVE_ELEMENTS);
        new AddRemoveElementsPage()
                .addSixDeleteBtn()
                .removeDeleteBtn()
                .verifyDeleteBtnMissing();
    }

    @Test(enabled = false)
    public void dropDownListTest1() {
        new NavigationPage()
                .navigateTo(DROPDOWN_LIST);
        new DropdownListPage()
                .selectOption1ByValue()
                .verifySelectOption();
    }

    @Test
    public void dropDownListTest2() {
        new NavigationPage()
                .navigateTo(DROPDOWN_LIST);
        new DropdownListPage()
                .selectOption1ByName()
                .verifySelectOption();
    }

    @Test(enabled = false)
    public void dragAndDropTest1() {
        new NavigationPage()
                .navigateTo(DRAG_AND_DROP);
        new DragAndDropPage()
                .dragAndDropAtoB()
                .verifyAtoB();
    }

    @Test(enabled = false)
    public void dragAndDropTest2() {
        new NavigationPage()
                .navigateTo(DRAG_AND_DROP);
        new DragAndDropPage()
                .dragAndDropAtoB()
                .dragAndDropBtoA()
                .verifyBtoA();
    }
}


