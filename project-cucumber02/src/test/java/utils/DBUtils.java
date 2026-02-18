package utils;

import java.sql.*;

public class DBUtils {

    private static Connection connection;

    public static void connect() throws SQLException {
        connection = DriverManager.getConnection(
                ConfigReader.getProperty("dbUrl"),
                ConfigReader.getProperty("dbUsername"),
                ConfigReader.getProperty("dbPassword"));
    }

    public static ResultSet runQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public static void close() throws SQLException {
        if (connection != null)
            connection.close();
    }

}
