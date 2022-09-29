package lecture9;

import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;
import testNgUtils.Retry;

public class lecture9_2Test {
    int count = 1;
    int timeout = 4;
    @Test(enabled = false, priority = 1)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(enabled = true, priority = 2)
    public void test2() {
        System.out.println("Test 2");
    }

    @Test(timeOut = 1000, description = "Test 3 from lecture 9", expectedExceptions = {ThreadTimeoutException.class}, priority = 3)
    public void test3() {
        pause(2);
        System.out.println("Test 3");
    }
    @Test(dependsOnMethods = "test3", alwaysRun = true, priority = 4)
    public void test4() {
        System.out.println("Test 4");
    }
    @Test(invocationCount = 3, threadPoolSize = 3, priority = 5)
    public void test5() {
        System.out.println("Test 5 and this is my repeat #" + count++);
    }
    @Test(timeOut = 1000, priority = 6, retryAnalyzer = Retry.class)
    public void test6() {
        timeout--;
        pause(timeout);
        System.out.println("Test 6 with timeout #" + timeout);
    }

    private void pause(long timeout) {
        try {
            Thread.sleep(timeout * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
