package task_12;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class task12_2Test extends BaseTest {
    @Test
    public void emailTransformationTest() {
        List<String> expectedData = Arrays
                .asList("fbach@gmail.com", "jdoe@gmail.com", "jsmith@gmail.com", "tconway@gmail.com");
        get(NavigationPage.class)
                .open()
                .navigateTo(NavigationItems.SORTABLE_DATA_TABLES);
        Map<String, List<String>> mapTableData = get(SortableDataTablesPage.class)
                .checkTableIsDisplayed()
                .clickTableColumn("Email")
                .getTableData();
        List<String> actualData = mapTableData
                .get("Email")
                .stream()
                .map(email -> {
                    if (email.contains("@gmail.com")) {
                        return email;
                    }
                    return email.split("@")[0] + "@gmail.com";
                })
                .collect(Collectors.toList());
        System.out.println(actualData);
        Assert.assertEquals(actualData, expectedData);
    }
}
