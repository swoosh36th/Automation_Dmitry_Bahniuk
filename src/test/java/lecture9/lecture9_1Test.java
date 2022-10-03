package lecture9;

import org.testng.Reporter;
import org.testng.annotations.*;

public class lecture9_1Test {
    @BeforeTest(groups = "test9")
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @BeforeMethod(groups = "test9")
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @BeforeClass(groups = "test9")
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @BeforeSuite(groups = "test9")
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeGroups(groups = "test9")
    public void beforeGroups(){
        System.out.println("Before Groups");
    }
    @Test(groups = "test9")
    public void test1(){
        Reporter.log("Test1");
        System.out.println("Test1");
    }
    @Test(groups = "test9new")
    public void test2() {
        System.out.println("Test2");
    }
    @AfterTest(groups = "test9")
    public void afterTest(){
        System.out.println("After Test");
    }
    @AfterSuite(groups = "test9")
    public void afterSuite(){
        System.out.println("After Suite");
    }
    @AfterGroups(groups = "test9")
    public void afterGroups(){
        System.out.println("After Groups");
    }
    @AfterMethod(groups = "test9")
    public void afterMethod(){
        System.out.println("After Method");
    }
    @AfterClass(groups = "test9")
    public void afterClass(){
        System.out.println("After Class");
    }
}
