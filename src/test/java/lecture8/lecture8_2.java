package lecture8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicLoadingPage;
import pageObjects.herokuapp.InfiniteScrollPage;
import pageObjects.herokuapp.NavigationPage;

import static pageObjects.herokuapp.NavigationItem.DYNAMIC_LOADING;
import static pageObjects.herokuapp.NavigationItem.INFINITE_SCROLL;

public class lecture8_2 extends BaseTest {
    @BeforeMethod
    public void precondition(){
        new NavigationPage()
                .open();
    }
    @Test(enabled = false)
    public void dynamicLoadingTest(){
        new NavigationPage()
                .navigateTo(DYNAMIC_LOADING);
        String result = new DynamicLoadingPage()
                .clickOnExample1("Example 1")
                .clickOnStartBtn()
                .pageIsLoaded();
        System.out.println(result);
    }
    @Test(enabled = false)
    public void scrollPageTest(){
        new NavigationPage()
                .navigateTo(INFINITE_SCROLL);
        new InfiniteScrollPage()
                .infiniteScroll(10);
    }
}
