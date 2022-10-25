package lecture10;

import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

public class lecture10_1Test extends BaseTest {
    @Test
    public void test(){
        System.out.println(System.getProperty("user.dir" + "/files/test.txt"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("env"));
    }
}
