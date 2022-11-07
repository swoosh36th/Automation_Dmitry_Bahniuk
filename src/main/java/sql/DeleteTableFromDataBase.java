package sql;

import pageObjects.baseObjects.BaseTest;

public class DeleteTableFromDataBase extends BaseTest {
    public static void main(String[] args) {
        TableDataBase tableDataBase = new TableDataBase();
        tableDataBase
                .connectToDataBase("jdbc:mysql://sql7.freesqldatabase.com/sql7549731?user=sql7549731&password=fTEH4PDQiX")
                .deleteTable("persondata");
    }
}
