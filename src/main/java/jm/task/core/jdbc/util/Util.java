package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/user1";
    private static final String USER = "root";
    private static final String PASS = "root";
    //private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;


    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        Driver driver;

        try {
            driver = new FabricMySQLDriver();
        } catch (SQLException ex) {
            System.out.println("произошла ошибка при создании драйвера ");
        }

        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("connection ok...");

        } catch (SQLException ex) {
            System.out.println("error  connection" + ex);

        }
        return connection;

    }
}
