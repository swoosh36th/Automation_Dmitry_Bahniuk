package task_21;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import sql.TableDataBase;

public class task_21Test extends BaseTest {

    @BeforeTest
    public void preconditions() {
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .createTable(properties.getProperty("tablename"))
                .addDataToTable()
                .printAllTableData(properties.getProperty("tablename"));
    }

    @Test(testName = "Insert row with id, city test", priority = 1)
    public void insertTestOne() {
        String insertSql = "INSERT INTO persondata (id, city) VALUES (11, 'Molodechno')";
        String selectSql = "SELECT * FROM persondata WHERE city LIKE 'Molod%'";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .insert(insertSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertTrue(row.get("city").contains("Molod"));
                });
    }

    @Test(testName = "Insert row with age, lastname test", priority = 2)
    public void insertTestTwo() {
        String insertSql = "INSERT INTO persondata (age, lastname) VALUES (25, 'Petrov')";
        String selectSql = "SELECT * FROM persondata WHERE city LIKE 'Petrov'";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .insert(insertSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertTrue(row.get("lastname").contains("Petrov"));
                });
    }

    @Test(testName = "Insert row with null test", priority = 3)
    public void insertTestThree() {
        String insertSql = "INSERT INTO persondata (id, firstname) VALUES (20, 'Gena')";
        String selectSql = "SELECT * FROM persondata WHERE firstname='Gena'";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .insert(insertSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertTrue(row.get("firstname").contains("Gena"));
                });
    }

    @Test(testName = "Select with lastname Petrov and Goodman", priority = 4)
    public void selectTestOne() {
        String selectSql = "SELECT * FROM persondata WHERE (lastname='Petrov' OR lastname='Goodman')";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertTrue(row.get("lastname").contains("Good") || row.get("lastname").contains("Petr"));
                });
    }

    @Test(testName = "Select where age between 25 and 35 test", priority = 5)
    public void selectTestTwo() {
        String selectSql = "SELECT * FROM persondata WHERE age BETWEEN 25 AND 35";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertTrue(Integer.parseInt(row.get("age")) >=25 && Integer.parseInt(row.get("age")) <= 35);
                });
    }

    @Test(testName = "Select where lastname contains Ivan test", priority = 6)
    public void selectTestThree() {
        String selectSql = "SELECT * FROM persondata WHERE lastname LIKE 'Ivan%'";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertTrue(row.get("lastname").contains("Ivan"));
                });
    }

    @Test(testName = "Update firstname row test", priority = 7)
    public void updateTestOne() {
        String updateSql = "UPDATE persondata SET firstname='FirstName' WHERE firstname is null";
        String selectSql = "SELECT * FROM persondata WHERE NOT firstname is null";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .update(updateSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertFalse(row.get("firstname").isEmpty());
                });
    }

    @Test(testName = "Update city row test", priority = 8)
    public void updateTestTwo() {
        String updateSql = "UPDATE persondata SET city='London' WHERE age < 30";
        String selectSql = "SELECT * FROM persondata WHERE city='London' AND age < 30";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .update(updateSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertTrue(row.get("city").contains("London"));
                });
    }

    @Test(testName = "Update age row test", priority = 9)
    public void updateTestThree() {
        String updateSql = "UPDATE persondata SET age=11 WHERE lastname LIKE '%ov%'";
        String selectSql = "SELECT * FROM persondata WHERE age=11";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .update(updateSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertTrue(row.get("lastname").contains("ov"));
                });
    }

    @Test(testName = "Delete city Grodno test", priority = 10)
    public void deleteTestOne() {
        String deleteSql = "DELETE FROM persondata WHERE city='Grodno'";
        String selectSql = "SELECT * FROM persondata WHERE NOT city='Grodno'";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .delete(deleteSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertFalse(row.get("city").contains("Grodno"));
                });
    }

    @Test(testName = "Delete null firstname test", priority = 11)
    public void deleteTestTwo() {
        String deleteSql = "DELETE FROM persondata WHERE firstname is null";
        String selectSql = "SELECT * FROM persondata WHERE firstname is NOT null";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .delete(deleteSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertFalse(row.get("firstname").isEmpty());
                });
    }

    @Test(testName = "Delete lastname contains Ivan test", priority = 12)
    public void deleteTestThree() {
        String deleteSql = "DELETE FROM persondata WHERE lastname LIKE 'Ivan%'";
        String selectSql = "SELECT * FROM persondata WHERE NOT lastname LIKE 'Ivan%'";
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .delete(deleteSql);
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .select(selectSql)
                .forEach(row -> {
                    System.out.println(row);
                    Assert.assertFalse(row.get("city").contains("Ivan"));
                });
    }

    @AfterTest
    public void postconditions() {
        get(TableDataBase.class)
                .connectToDataBase(properties.getProperty("database-url"))
                .deleteTable(properties.getProperty("tablename"));
    }
}
