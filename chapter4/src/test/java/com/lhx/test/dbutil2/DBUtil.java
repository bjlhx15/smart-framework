package com.lhx.test.dbutil2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/demo";
    private static final String username = "root";
    private static final String password = "root";

    private static ThreadLocal<Connection> conContainer = new ThreadLocal<>();

    public static Connection getConnection() {
        Connection conn = conContainer.get();
        try {
            if (conn == null) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conContainer.set(conn);
        }
        return conn;
    }

    public static void colseConnection() {
        Connection conn = conContainer.get();
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            conContainer.remove();
        }
    }
}
