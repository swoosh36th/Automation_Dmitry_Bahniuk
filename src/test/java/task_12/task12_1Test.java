package task_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class task12_1Test extends BaseTest {
    @Test
    public void test() {
        List<Integer> data = Arrays
                .asList(-79, 99, -83, -75, -78, -22, -57, 84, 11, 15);
        List<Integer> expectedData = Arrays
                .asList(11, 15, 22, 57, 75, 78, 79, 83, 84, 99);
        System.out.println(data);
        List<Integer> actualData = data
                .stream()
                .map(number -> {
                    if (number < 0) {
                        return Math.abs(number);
                    }
                    return number;
                })
                .sorted()
                .collect(Collectors.toList());
        System.out.println(actualData);
        Assert.assertEquals(actualData, expectedData);
    }
}

