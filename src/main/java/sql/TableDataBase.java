package sql;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableDataBase {
    Connection connection;
    Statement statement;

    @SneakyThrows
    public TableDataBase connectToDataBase(String url) {
        connection = DriverManager
                .getConnection(url);
        statement = connection.createStatement();
        return this;
    }

    @SneakyThrows
    public TableDataBase printAllTableData(String tableName) {
        print(select("SELECT * FROM " + tableName));
        return this;
    }

    @SneakyThrows
    public TableDataBase createTable(String tableName) {
        executeUpdate("CREATE TABLE " + tableName + " (id int, " +
                                                          "firstname varchar(255), " +
                                                          "lastname varchar(255), " +
                                                          "age int, " +
                                                          "city varchar(255))");
        return this;
    }

    @SneakyThrows
    public void deleteTable(String tableName) {
        executeUpdate("DROP TABLE " + tableName);
    }

    public TableDataBase addDataToTable() {
        insert("INSERT INTO persondata (id, firstname, lastname, age, city) " +
                   "VALUES (1, 'Jack', 'Petrov', 25, 'Minsk'), " +
                          "(2, 'Sam', 'Petrov', 18, 'Grodno'), " +
                          "(3, 'Vasya', 'Goodman', 33, 'NY'), " +
                          "(4, 'Greys', 'Sokolova', 27, 'LA'), " +
                          "(5, null, 'Ivanova', 18, 'Minsk'), " +
                          "(6, 'Alex', 'Goodman', 34, 'Brest'), " +
                          "(7, 'Ivan', 'Ivanov', 33, 'Minsk'), " +
                          "(8, 'Tolik', null, 48, 'Grodno')");
        return this;
    }

    @SneakyThrows
    public TableDataBase update(String sql) {
        executeUpdate(sql);
        return this;
    }

    @SneakyThrows
    public TableDataBase insert(String sql) {
        executeUpdate(sql);
        return this;
    }

    @SneakyThrows
    public TableDataBase delete(String sql) {
        executeUpdate(sql);
        return this;
    }

    @SneakyThrows
    private void executeUpdate(String sql) {
        statement.executeUpdate(sql);
    }

    @SneakyThrows
    public List<Map<String, String>> select(String sql) {
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        List<Map<String, String>> data = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, String> row = new HashMap<>();
            for (int index = 1; index <= resultSetMetaData.getColumnCount(); index++) {
                row.put(resultSetMetaData.getColumnName(index), resultSet.getString(index));
            }
            data.add(row);
        }
        return data;
    }

    public TableDataBase print(List<Map<String, String>> data) {
        System.out.println("===============================================");
        data.forEach(System.out::println);
        System.out.println("===============================================");
        return this;
    }
}
