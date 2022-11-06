package pageObjects.index;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
public class TablePage extends BasePage {
    private final By table = By.xpath("//table");
    private final By headers = By.xpath("//th");

    private By getTableRow(String index) {
        log.debug("Get number of rows");
        return By.xpath("//tbody/tr[" + index + "]");
    }

    private final List<String> validData = new ArrayList<>() {{
        add("Alfreds Futterkiste");
        add("Centro comercial Moctezuma");
    }};

    public List<List<String>> getTableRowsData() {
        log.debug("Get table data as rows");
        int rowCount = findElements(getTableRow("..")).size();
        List<List<String>> data = new ArrayList<>();
        for (int row = 0; row < rowCount; row++) {
            List<String> columnData = new ArrayList<>();
            int columnCount = findElement(getTableRow(Integer.toString(row + 1)))
                    .findElements(By.xpath(".//td"))
                    .size();
            for (int column = 0; column < columnCount; column++) {
                columnData.add(findElement(getTableRow(Integer.toString(row + 1)))
                        .findElement(By.xpath(".//td[" + (column + 1) + "]"))
                        .getText());
            }
            data.add(columnData);
        }
        return data;
    }

    public Map<String, List<String>> getTableData() {
        log.debug("Get table data as columns");
        Map<String, List<String>> mapData = new HashMap<>();
        int headerCount = findElements(headers).size();
        List<List<String>> tableData = getTableRowsData();
        for (int header = 0; header < headerCount; header++) {
            List<String> columnData = new ArrayList<>();
            for (List<String> data : tableData) {
                columnData.add(data.get(header));
            }
            mapData.put(findElements(headers).get(header).getText(), columnData);
        }
        return mapData;
    }

    public TablePage verifyTableDataFromFirstColumn() {
        log.debug("Get table data from Company column");
        Map<String, List<String>> mapTableData = getTableData();
        List<String> companyData = mapTableData.get(properties.getProperty("firstcolumn"));
        Assert.assertEquals(companyData, validData);
        return this;
    }
}

